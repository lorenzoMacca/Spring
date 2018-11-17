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

function createAndFillTable(parentId, columns, data){
	var htmlColumns = "";
	columns.forEach(function(element) {
		htmlColumns += "<th scope='col'>"+ element +"</th>"
	});
	var htmlDate = "";
	for (var i = 0; i < data.length; i++) {
		htmlDate +="<tr>";
		for (var j = 0; j < data[i].length; j++) {
			htmlDate += "<td>"+ data[i][j] +"</td>";
		}
		htmlDate +="</tr>";
	}
	var html = "";
	html +="<table class='table table-hover'>"
		     +"<thead>"
		        +"<tr>"
		           + htmlColumns
		        +"</tr>"
		     +"</thead>"
		     +"<tbody>"
	html += htmlDate;
	html +="</tbody>"
		  +"</table>"
	$(parentId).html(html);
}