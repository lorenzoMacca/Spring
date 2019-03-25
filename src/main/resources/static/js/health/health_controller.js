var GET_HEALTH_BY_USER_ID = "/users/{userId}/health";
var GET_HEALTH_BODY_MEASUREMENT_BY_USER_ID = "/users/{userId}/health/body_measurements";

var HEALTH_ELEMENT_ID = '#healthContent';


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
	//get health manager instance
    let health = Health.getInstance();
	//add sub-div to set all spaces
	health.initHealthView();
	//get user id
    let userId = getUserId();
    //load date for the current user and create a table
	getAll(
        GET_HEALTH_BODY_MEASUREMENT_BY_USER_ID.replace('{userId}', userId),
        health.addBodyMeasurementTable,
		{tableParentId:"#bodyMeasurementTableContent"}
	);
}
