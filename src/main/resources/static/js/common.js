

function getAll(url, callback, dataForCallback){
	AjaxSetUp.sendGetRequest(url,dataForCallback, callback);
}

function createAndFillTable(parentId, columns, data, tableId, filter){
	var htmlColumns = "";
	columns.forEach(function(element) {
		htmlColumns += "<th scope='col'>"+ element +"</th>"
	});
	var htmlDate = "";
	for (var i = 0; i < data.length; i++) {
		htmlDate +="<tr class='myTrainingTrClickable' >";
		for (var j = 0; j < data[i].length; j++) {
			htmlDate += "<td>"+ data[i][j] +"</td>";
		}
		htmlDate +="</tr>";
	}
	var html = "";
	html +="<table id="+tableId+" class='table table-hover table-sm'>"
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
	
	$('.myTrainingTrClickable').unbind('click').click(function() {
		$('#myTrainingModalShowIndorSwimInfo').modal();
	});
	
	if(filter === true){
		$("#"+tableId).excelTableFilter();
	}
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

function getUserId(){
	return $('#currentUserInfo').attr('data-id');
}
