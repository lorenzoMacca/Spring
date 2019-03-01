var INDOR_SWIM_GET_ALL = '/swims';
var INDOR_SWIM_GET_ALL_MONTH_VIEW = '/swims/month_view';

var POOL_LENGTH_25_METER = "POOL_LENGTH_25_METER";
var POOL_LENGTH_31_METER = "POOL_LENGTH_31_METER";
var POOL_LENGTH_50_METER = "POOL_LENGTH_50_METER";

function addTabButtonFunktionalities(){
	$("#tabBtn0").unbind('click').click(function(){
		getAll(INDOR_SWIM_GET_ALL, updateViewGetAllSwimCB, null);
		$(tabBtn1).removeClass("active");
		$(tabBtn0).addClass("active");
	});
	$("#tabBtn1").unbind('click').click(function(){
		getAll(INDOR_SWIM_GET_ALL_MONTH_VIEW, updateViewGetAllSwimMonthViewCB, null);
		$(tabBtn0).removeClass("active");
		$(tabBtn1).addClass("active");
	});
}

function updateViewGetAllSwimMonthViewCB(data, dataForCallback){
	console.log("[WHERE] - updateViewGetAllSwimMonthViewCB");
	console.log(JSON.stringify(data));
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
	createAndFillTable(activityTable, columns, neededData);
	let minY = Math.min(dataForChart);
	let maxY = Math.max(dataForChart);
	minY -= 100;
	maxY += 100;
	dataForChart.unshift('Distance');
	addBasicBarChart('#chart', dataForChart, dataForChart[0], 0, maxY);
}


function updateViewGetAllSwimCB(data, dataForCallback){
	
	let columns = ['Date', 'Distance (m)', 'Duration (min)', 'Mov Duration (min)', 'Location'];
	let neededData = new Array(data.length);
	var dataForChart = new Array(data.length);
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
		let tmp = [tmpDate, tmpDistance, duration, movementDuration, data[i].swimmingPlace.name];
		neededData[i]=tmp;
	}
	createAndFillTable(activityTable, columns, neededData);
	dataForChart.reverse();
	dataForChart.unshift("Distance (m)");
	addBasicChart('#chart', dataForChart);
}

function addTabs(){
	var tabItems = ['All Activities', 'Month View'];
	createAndFillTabs(activityTabsId, tabItems);
	addTabButtonFunktionalities();
}

function switchToSwimActivities(){
    getAll(INDOR_SWIM_GET_ALL, updateViewGetAllSwimCB, null);
    addTabs();
    $("#welcomeMessageContainerId").hide();
    $(activityContainer).show();
}

$("#swimSectionMenuBtnId").click(function(){
    switchToSwimActivities();
});


