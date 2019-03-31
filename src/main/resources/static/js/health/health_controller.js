var GET_HEALTH_BY_USER_ID = "/users/{userId}/health";
var GET_HEALTH_BODY_MEASUREMENT_BY_USER_ID = "/users/{userId}/health/body_measurements";

var HEALTH_ELEMENT_ID = '#healthContent';

//instance for the entire life cycle
var health = Health.getInstance();


$('#bodyMeasurementButton').click(function(){
	let page = PageManager.getInstance();
	page.clearPage();
	page.showPage({
		showPage : switchToHealthBodyMEasurement()
	});
});

function switchToHealthBodyMEasurement(){
	loadBodyMeasurement();
}

function loadBodyMeasurement() {
	health.loadBodyMEasurement();
}

$('#bodyMEasurementSaveButton').click(function(){
	health.saveBodyMEasurement('#healthBodyMeasurementModal');
});
