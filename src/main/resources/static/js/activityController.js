

var selectedItem = "-1";
var SWIM_ID = 1;
var SELECT_ACTIVITY = "1";
var SET_TIME_INFO   = "2";
var SET_PLACE       = "3";
var SET_SWIM_INFO   = "4";
var SET_USERS       = "5";
var SAVE_SWIM       = "6";
var context = SELECT_ACTIVITY; 
var backgroundColorSelectItem = "#4d4dff";
var defaultColor = "white";

var activityObject = undefined;
var users=new Array();//TODO: add current user!

//{
//	X "date":"2018-12-21",
//	X "time":"17:40",
//	X "description":"asd",
//	X "duration":"75",
//	X "numberOfLaps":"1000",
//	X "swimmingPlace":"2600",
//	- "pattern":"2596",
//	X "users": ["2593", "2593"],
//	- "session":"2604",
//	X "poolLength":"POOL_LENGTH_25_METER"
//}

function init(){
	selectedItem = "-1";
	context = SELECT_ACTIVITY; 
	activityObject = undefined;
	users=new Array();
}

function initUserList(){
	users = new Array();
	let currentUserId = $("#currentUserInfo").attr("data-id");
	users.push(currentUserId);
}

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
	$('#detailsSwimActivity').hide();
	$("#buddiesSwimActivity").hide();
    $("#summarySwimActivity").hide();
    init();
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
	setActivityAttribute("movementDuration", $("#inputMovementDurationActivity").val());
	context = SET_PLACE;
	$( "#generalInformationActivity" ).fadeOut( function() {
		$("#exampleModalLabel").text("Where did you do it?");
		$("#placeInformationActivity").show();
		//TODO: the following code are from openLayer and it's just a test. I have to understand how to import libs in js.
//		 new ol.Map({
//		        target: 'map',
//		        layers: [
//		          new ol.layer.Tile({
//		            source: new ol.source.OSM()
//		          })
//		        ],
//		        view: new ol.View({
//		          center: ol.proj.fromLonLat([7.6379748, 51.900642]),
//		          zoom: 17
//		        })
//		      });
	});
}

function setPlaceSwim(){
	setActivityAttribute("swimmingPlace", $('#selectSwimmingPlaceActivity').val());
	setActivityAttribute("poolLength", $('#selectLongLane').val());
	context = SET_SWIM_INFO;
	$( "#placeInformationActivity" ).fadeOut( function() {
		$("#exampleModalLabel").text("Enter details about your training");
		$("#detailsSwimActivity").show();
	});
	
}

function setDetails(){
	setActivityAttribute("numberOfLaps", $('#numberOfLapsSwimActivity').val());
	setActivityAttribute("description", $('#descriptionSwimActivity').val());
	context = SET_USERS;
	initUserList();
	$("#detailsSwimActivity" ).fadeOut( function() {
		$("#exampleModalLabel").text("Select your buddies");
		$("#buddiesSwimActivity").show();
	});
}

function setUser(){
	setActivityAttribute("users", users);
	console.log(JSON.stringify(activityObject));
	context = SAVE_SWIM;
    $("#buddiesSwimActivity" ).fadeOut( function() {
        $("#exampleModalLabel").text("Activity' summary");
        $("#newActivityNextButton").text("Save");
        $("#summarySwimActivity").show();
    });
}

function saveSwim(){
	AjaxSetUp.sendRequestAndHandleAnswer("/sessions/indorSwims/", "POST", activityObject, activityObject, saveSwimSuccessfulCallBack, saveSwimFailCallback);
}

$("#newActivityNextButton").click(function(){
	if(context == SELECT_ACTIVITY && selectedItem == SWIM_ID){
		selectActivityAndSwim(context == SET_TIME_INFO && selectedItem == SWIM_ID);
	}else if(context == SET_TIME_INFO && selectedItem == SWIM_ID){
		setTimeInfoAndSwim();
	}else if(context == SET_PLACE && selectedItem == SWIM_ID){
		setPlaceSwim();
	}else if(context == SET_SWIM_INFO && selectedItem == SWIM_ID){
		setDetails();
	}else if(context == SET_USERS && selectedItem == SWIM_ID){
		setUser();
	}else if(context == SAVE_SWIM && selectedItem == SWIM_ID){
		saveSwim();
	}
	
});

function addUser(id){
	let trovato=0;
	for(let i=0; i<users.length; i++){
		if(users[i] === id){
			trovato=1;
		}
	}
	if(trovato === 0){
		users.push(id);
	}
}

function removeUser(id){
	for(let i=0; i<users.length; i++){
		if(users[i] === id){
			users.splice(i, 1);//remove 1 element in position i
		}
	}
}

$(".addBuddyButton").click(function(){
	let userId = $(this).attr('data-id');
	if($(this).hasClass("btn-primary")){
		addUser(userId);
		$(this).removeClass("btn-primary");
		$(this).addClass("btn-warning");
		$(this).text("remove");
	}else if($(this).hasClass("btn-warning")){
		removeUser(userId);
		$(this).removeClass("btn-warning");
		$(this).addClass("btn-primary");
		$(this).text("Add buddy");
	}
});

function saveSwimSuccessfulCallBack(dataForCb, data, textStatus, xhr) {
	$("#selectActivityModal").modal('hide')
	notifySuccess("Swim activity on " + dataForCb["date"] + " saved.")
    switchToSwimActivities();
}

function saveSwimFailCallback(data, textStatus, xhr) {
	notifyFailure("Sorry :( but something went wrong.")
}