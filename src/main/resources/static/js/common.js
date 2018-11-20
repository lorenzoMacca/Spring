$(activityContainer).fadeOut();


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

function createAndFillTabs(parentId, items){
	var html = "<ul class='nav nav-pills'>";
	for (var i = 0; i < items.length; i++) {
		html += "<li class='nav-item'>";
			if(i==0){
				html += "<a id='tabBtn"+i+"' class='nav-link active' href='#'>"+ items[i] +"</a>";
			}else{
				html += "<a id='tabBtn"+i+"' class='nav-link' href='#'>"+ items[i] +"</a>";
			}
		    
		html += "</li>";
	};
	html += "</ul>";
	$(parentId).html(html);
}

function addBasicChart(selector, column){
	var chart = c3.generate({
	    bindto: selector,
	    data: {
	    columns: [column]
	    }
	});
}

function addBasicBarChart(selector, column, serieName){
	var chart = c3.generate({
	    bindto: selector,
	    data: {
	      columns: [
	          column
	      ],
	      axes: {
	        data2: 'y2'
	      },
	      types: {
	    	 Distance: 'bar' // ADD
	      }
	    },
	    axis: {
	      y: {
	        label: {
	          text: 'Y Label',
	          position: 'outer-middle'
	        }
	      },
	      y2: {
	        show: true,
	        label: {
	          text: 'Y2 Label',
	          position: 'outer-middle'
	        }
	      }
	    }
	});
}

