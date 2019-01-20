var selectedItem = "-1";
var SWIM_ID = 1;
var SELECT_ACTIVITY = "1";
var SET_TIME_INFO = "1";
var context = SELECT_ACTIVITY; 
var backgroundColorSelectItem = "#4d4dff";
var defaultColor = "white";

var activityObject = undefined;

//{
//	X "date":"2018-12-21",
//	  "time":"17:40",
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
	$('#generalInformationActivity').hide();
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

$("#newActivityNextButton").click(function(){
	if(context == SELECT_ACTIVITY && selectedItem == SWIM_ID){
		context = SET_TIME_INFO;
		initActivityObject();
		$( "#selectActivityModalContent" ).fadeOut( function() {
			$("#exampleModalLabel").text("When did you do it?");
			$("#generalInformationActivity").show();
		});
	}
	
});