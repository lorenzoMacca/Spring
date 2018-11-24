var INDOR_SWIM_GET_ALL = '/swims';
var INDOR_SWIM_GET_ALL_MONTH_VIEW = '/swims/month_view';

var POOL_LENGTH_25_METER = "POOL_LENGTH_25_METER";
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
	var columns = ['Date', 'Distance (m)'];
	var neededData = new Array(data.length);
	var dataForChart = new Array(data.length);
	for (var i = 0; i < data.length; i++) {
		var yearMonth = data[i].year + "-" + data[i].month;
		var distance = data[i].totalDistance;
		var tmp = [yearMonth, distance];
		neededData[i]=tmp;
		dataForChart[i] = distance;
		
	}
	createAndFillTable(activityTable, columns, neededData);
	dataForChart.unshift('Distance');
	addBasicBarChart('#chart', dataForChart, dataForChart[0]);
}


function updateViewGetAllSwimCB(data, dataForCallback){
	
	console.log("[WHERE] - updateViewGetAllSwimCB");
	console.log(JSON.stringify(data));
	var columns = ['Date', 'Distance (m)', 'Location'];
	var neededData = new Array(data.length);
	var dataForChart = new Array(data.length);
	//dataForChart[0] = "Distance (m)";
	for (var i = 0; i < data.length; i++) {
		var tmpDate = "" + data[i].date + " " + data[i].time.substring(0,5);
		var poolLength = 0;
		if(data[i].poolLength == POOL_LENGTH_25_METER){
			poolLength = 25;
		}else if(data[i].poolLength == POOL_LENGTH_50_METER){
			poolLength = 50;
		}
		var tmpDistance = parseInt(data[i].numberOfLaps) * poolLength;
		dataForChart[i] = tmpDistance;
		var tmp = [tmpDate, tmpDistance, data[i].swimmingPlace.name];
		neededData[i]=tmp;
	}
	console.log(JSON.stringify(neededData));
	createAndFillTable(activityTable, columns, neededData);
	//dataForChart.push("Distance (m)");
	dataForChart.reverse();
	dataForChart.unshift("Distance (m)");
	addBasicChart('#chart', dataForChart);
}

function addTabs(){
	var tabItems = ['All Activities', 'Month View'];
	createAndFillTabs(activityTabsId, tabItems);
	addTabButtonFunktionalities();
}

$("#swimSectionMenuBtnId").click(function(){
	getAll(INDOR_SWIM_GET_ALL, updateViewGetAllSwimCB, null);
	addTabs();
	$("#welcomeMessageContainerId").fadeOut();
	$(activityContainer).fadeIn("slow");
});


