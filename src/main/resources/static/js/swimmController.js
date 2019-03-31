var INDOR_SWIM_GET_ALL = '/users/{userId}/indorSwims';
var INDOR_SWIM_GET_ALL_MONTH_VIEW = '/swims/month_view';

var POOL_LENGTH_25_METER = "POOL_LENGTH_25_METER";
var POOL_LENGTH_31_METER = "POOL_LENGTH_31_METER";
var POOL_LENGTH_50_METER = "POOL_LENGTH_50_METER";

var swimActivitiesC3Utilities = {
		distances : null,
		dates : null,
		titleCallBackFunc: function(index) {
			return swimActivitiesC3Utilities.dates[index];
		},
		valueCallBack: function(value, ratio, id, index){
			return value + "m";
		}
}


function addTabButtonFunktionalities(){
	$("#tabBtn0").unbind('click').click(function(){
		getAll(INDOR_SWIM_GET_ALL.replace('{userId}', getUserId()), updateViewGetAllSwimCB, null);
		$(tabBtn1).removeClass("active");
		$(tabBtn0).addClass("active");
	});
	$("#tabBtn1").unbind('click').click(function(){
		getAll(INDOR_SWIM_GET_ALL_MONTH_VIEW, updateViewGetAllSwimMonthViewCB, null);
		$(tabBtn0).removeClass("active");
		$(tabBtn1).addClass("active");
	});
}

function updateViewGetAllSwimMonthViewCB(dataForCallback, data){
	//console.log("[WHERE] - updateViewGetAllSwimMonthViewCB");
	//console.log(JSON.stringify(data));
	let columns = ['Date', 'Distance (m)'];
	let neededData = new Array(data.length);
	let dataForChart = new Array(data.length);
	for (var i = 0; i < data.length; i++) {
		let yearMonth = data[i].year + "-" + data[i].month;
		let distance = data[i].totalDistance;
		let tmp = [yearMonth, distance];
		neededData[i]=tmp;
		dataForChart[i] = distance;
		
	}
	createAndFillTable(activityTable, columns, neededData, "swimActivityMonthView", true);
	let minY = Math.min(dataForChart);
	let maxY = Math.max(dataForChart);
	minY -= 100;
	maxY += 100;
	dataForChart.unshift('Distance');
	addBasicBarChart('#chart', dataForChart, dataForChart[0], 0, maxY);
}


function updateViewGetAllSwimCB(dataForCallback, data){
	let columns = ['Date', 'Distance (m)', 'Duration (min)', 'Mov Duration (min)', 'Location'];
	let neededData = new Array(data.length);
	var dataForChart = new Array(data.length);
	var custom_categories = new Array(data.length);
	//dataForChart[0] = "Distance (m)";
	for (let i = 0; i < data.length; i++) {
		let tmpDate = "" + data[i].date + " " + data[i].time.substring(0,5);
		let poolLength = 0;
		if(data[i].poolLength == POOL_LENGTH_25_METER){
			poolLength = 25;
		}else if(data[i].poolLength == POOL_LENGTH_50_METER){
			poolLength = 50;
		}else if(data[i].poolLength ==POOL_LENGTH_31_METER){
			poolLength = 31;
		}
		let tmpDistance = parseInt(data[i].numberOfLaps) * poolLength;
		//duration
		let duration = data[i].duration;
		let minEvery100MeterDuration    = 100.0 * (duration/tmpDistance);
		duration += " - " + minEvery100MeterDuration.toFixed(2) + " min/100 m";
		//movement duration
		let movementDuration = data[i].movementDuration;
		if(movementDuration != undefined){
			let minEvery100MeterMovDuration = 100.0 * (movementDuration/tmpDistance);
			movementDuration += " - " + minEvery100MeterMovDuration.toFixed(2) + " min/100 m";
		}else{
			movementDuration = "NA";
		}
		
		dataForChart[i] = tmpDistance;
        custom_categories[i] = data[i].date;
		let tmp = [tmpDate, tmpDistance, duration, movementDuration, data[i].swimmingPlace.name];
		neededData[i]=tmp;
	}
	createAndFillTable(activityTable, columns, neededData, "swimActivity", true);
	dataForChart.reverse();
	dataForChart.unshift("Distance (m)");
	custom_categories.reverse();
	swimActivitiesC3Utilities.distances = dataForChart;
	swimActivitiesC3Utilities.dates = custom_categories;
	BasicChart()
		.withSelector('#chart')
		.withColumns(dataForChart)
		.withMinY(100)
		.activeLabel(true)
		.withTitleCallback(swimActivitiesC3Utilities.titleCallBackFunc)
		.activeZoom(true)
		.withValueCallback(swimActivitiesC3Utilities.valueCallBack)
		.generateChart();
}

function addTabs(){
	var tabItems = ['All Activities', 'Month View'];
	createAndFillTabs(activityTabsId, tabItems);
	addTabButtonFunktionalities();
}

function switchToSwimActivities(){
    getAll(INDOR_SWIM_GET_ALL.replace('{userId}', getUserId()), updateViewGetAllSwimCB, null);
    addTabs();
}

$("#swimSectionMenuBtnId").click(function(){
	let page = PageManager.getInstance();
	page.clearPage();
	page.showPage({
		showPage : switchToSwimActivities()
	});
    
});




