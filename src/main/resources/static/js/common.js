function executeAjaxCall(url, map, callback, dataForCallback){
	var dataToServer = "";
	for (var [key, value] of map) {
		  dataToServer += key + "=" + value + "&"
		}
	$.ajax({
		url: url + "?" + dataToServer,
	    data: dataToServer
	 }).then(function(data) {
		 callback(data, dataForCallback);
	 });
};

function getAll(url, callback, dataForCallback){
	executeAjaxCall(url, new Map(), callback, dataForCallback);
}
