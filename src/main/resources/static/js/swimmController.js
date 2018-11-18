var INDOR_SWIM_GET_ALL = '/training/swim/activities';
var INDOR_SWIM_GET_ALL_MONTH_VIEW = '/training/swim/activities/month_view';

var POOL_LENGTH_25_METER = "POOL_LENGTH_25_METER";
var POOL_LENGTH_50_METER = "POOL_LENGTH_50_METER";

function addTabButtonFunktionalities(){
	$("#tabBtn0").unbind('click').click(function(){
		console.log("click0");
	});
	$("#tabBtn1").unbind('click').click(function(){
		console.log("click1");
	});
}


function updateViewGetAllSwimCB(data, dataForCallback){
	
	console.log("[WHERE] - updateViewGetAllSwimCB");
	console.log(JSON.stringify(data));
	var columns = ['Date', 'Distance (m)', 'Location'];
	var neededData = new Array(2);
	for (var i = 0; i < data.length; i++) {
		var tmpDate = "" + data[i].date + " " + data[i].time.substring(0,5);
		var poolLength = 0;
		if(data[i].poolLength == POOL_LENGTH_25_METER){
			poolLength = 25;
		}else if(data[i].poolLength == POOL_LENGTH_50_METER){
			poolLength = 50;
		}
		var tmpDistance = parseInt(data[i].numberOfLaps) * poolLength;
		var tmp = [tmpDate, tmpDistance, data[i].swimmingPlace.name];
		neededData[i]=tmp;
	}
	console.log(JSON.stringify(neededData));
	createAndFillTable(activityTable, columns, neededData);
	var tabItems = ['All Activities', 'Month View'];
	createAndFillTabs(activityTabsId, tabItems);
	addTabButtonFunktionalities();
}

$("#swimSectionMenuBtnId").click(function(){
	getAll(INDOR_SWIM_GET_ALL, updateViewGetAllSwimCB, null);
	$("#welcomeMessageContainerId").fadeOut();
	$(activityContainer).fadeIn("slow");
});


