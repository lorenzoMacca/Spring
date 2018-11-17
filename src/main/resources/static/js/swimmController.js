var INDOR_SWIM_GET_ALL = '/training/swim/activities';

function updateViewGetAllSwimCB(data, dataForCallback){
	console.log("[WHERE] - updateViewGetAllSwimCB");
	console.log(JSON.stringify(data));
}

$("#swimSectionMenuBtnId").click(function(){
	getAll(INDOR_SWIM_GET_ALL, updateViewGetAllSwimCB, null);
});