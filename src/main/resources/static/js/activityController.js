var selectedItem = "-1";
var SWIM_ID = 1;
var SELECT_ACTIVITY = "1";
var SET_TIME_INFO   = "2";
var SET_PLACE       = "3";
var context = SELECT_ACTIVITY; 
var backgroundColorSelectItem = "#4d4dff";
var defaultColor = "white";

var activityObject = undefined;

//{
//	X "date":"2018-12-21",
//	X "time":"17:40",
//	  "description":"asd",
//	X "duration":"75",
//	  "numberOfLaps":"1000",
//	  "swimmingPlace":"2600",
//	  "pattern":"2596",
//	  "users": ["2593", "2593"],
//	  "session":"2604",
//	  "poolLength":"POOL_LENGTH_25_METER"
//}

function setActivityAttribute(propertyName, attr){
	activityObject[propertyName] = attr;
}

function initActivityObject(){
	activityObject = new Object();
}

function setColor(element, color){
	$(element).parent().css({"background-color": color});
}

function initModalView(){
	$('#selectActivityModalContent').show();
	$('#generalInformationActivity').hide();
	$('#placeInformationActivity').hide();
}

$(".clickableImg").on( "mouseenter", function( event ) {
	setColor(this, backgroundColorSelectItem);
});

$(".clickableImg").on( "mouseleave", function( event ) {
	if(selectedItem != this.id){
		setColor(this, defaultColor);
	}
});

$(".clickableImg").click(function(){
	$(".clickableImg").parent().css({"background-color": "white"});
	selectedItem = this.id;
	setColor(this, backgroundColorSelectItem);
	$("#newActivityNextButton").removeClass("disabled");
});

function selectActivityAndSwim(){
	context = SET_TIME_INFO;
	initActivityObject();
	$( "#selectActivityModalContent" ).fadeOut( function() {
		$("#exampleModalLabel").text("When did you do it?");
		$("#generalInformationActivity").show();
	});
}

function setTimeInfoAndSwim(){
	dataTime = $("#datetimepicker").val().split(" ");
	setActivityAttribute("date", dataTime[0]);
	setActivityAttribute("time", dataTime[1]);
	setActivityAttribute("duration", $("#inputDurationActivity").val());
	console.log(JSON.stringify(activityObject));
	context = SET_PLACE;
	$( "#generalInformationActivity" ).fadeOut( function() {
		$("#exampleModalLabel").text("Where did you do it?");
		$("#placeInformationActivity").show();
	});
}

$("#newActivityNextButton").click(function(){
	if(context == SELECT_ACTIVITY && selectedItem == SWIM_ID){
		selectActivityAndSwim(context == SET_TIME_INFO && selectedItem == SWIM_ID);
	}else if(context == SET_TIME_INFO && selectedItem == SWIM_ID){
		setTimeInfoAndSwim();
	}
	
});