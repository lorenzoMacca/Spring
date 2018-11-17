var INDOR_SWIM_GET_ALL = '/training/swim/activities';

function updateViewGetAllSwimCB(data, dataForCallback){
	console.log("[WHERE] - updateViewGetAllSwimCB");
	console.log(JSON.stringify(data));
	var columns = ['Date', 'Time', 'distance'];
	var neededData = new Array(3);
	for (var i = 0; i < data.length; i++) {
		var tmp = [data[i].date, data[i].time, data[i].numberOfLaps];
		neededData[i]=tmp;
	}
	console.log(JSON.stringify(neededData));
	createAndFillTable(activityTable, columns, neededData);
}

$("#swimSectionMenuBtnId").click(function(){
	getAll(INDOR_SWIM_GET_ALL, updateViewGetAllSwimCB, null);
});