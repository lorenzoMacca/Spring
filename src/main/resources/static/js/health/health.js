/**
 * This module is used to manage the health view.
 * 
 *  Author: Lorenzo Cozza
 */

var Health = {	
	getInstance : __getInstance	
}

function __getInstance(){
	return {
		VERSION : 'HEALTH_001',
		PARENT_ID : '#healthContent',
		MODAL_ID : '#healthBodyMeasurementModal',
		URL_SAVE_BODY_MEASUREMENT : "/users/health/body_measurements",
		healthId : null,
		version : __version,
		initHealthView : __initHealthView,
		initBehaviour : __initBehaviour,
		addBodyMeasurementTable : __addBodyMeasurementTable,
		getAllBodyMeasuremntByUserId : __getAllBodyMeasuremntByUserId, 
		loadBodyMEasurement : __loadBodyMEasurement,
		saveBodyMEasurement : __saveBodyMEasurement,
		saveBodyMeasurementSuccessCallback : __saveBodyMeasurementSuccessCallback,
		saveBodyMeasurementFailureCallback : __saveBodyMeasurementFailureCallback 
	}
}

function __version(){
	return this.VERSION;
}

function __getAllBodyMeasuremntByUserId(userId){
	getAll(
	        GET_HEALTH_BODY_MEASUREMENT_BY_USER_ID.replace('{userId}', userId),
	        health.addBodyMeasurementTable,
			{
	        	tableParentId:"#bodyMeasurementTableContent",
	        	healthObj: health
	        }
		);
}

function __loadBodyMEasurement(){
	//add sub-div to set all spaces
	health.initHealthView();
	//get user id
    let userId = getUserId();
    //load date for the current user and create a table
	this.getAllBodyMeasuremntByUserId(userId);
}

function __initHealthView(){
    $(HEALTH_ELEMENT_ID).append("<div id='bodyMeasurementAddButton'>" +
									"<button id='addBodyMeasurementButtonId' class='btn btn-success'>Add new body measurement</button>" +
		                      "</div>");
    $(HEALTH_ELEMENT_ID).append("<div id='bodyMeasurementTableContent'></div>");

    this.initBehaviour();
}

function __initBehaviour() {
	$('#addBodyMeasurementButtonId').unbind('click').click(function(){
		$('#healthBodyMeasurementModal').modal('show');
	});
}

function __addBodyMeasurementTable(dataForCallback, dataHealth) {
	dataForCallback.healthObj.healthId = ""+dataHealth.id;
	let data = dataHealth.bodyMeasurements;
    let parentId = dataForCallback["tableParentId"];
    //create structure for the table
    let columns = ['Date', 'Weight (kg)', 'Upper arm (cm)', 'Chest (cm)', 'Waist (cm)', 'Hips (cm)', 'Thigh (cm)'];
    let neededData = new Array(data.length);
    for (let i = 0; i < data.length; i++) {
        let date = data[i].date;
        let weight = data[i].weight;
        let upperArm = data[i].upperArm;
        let chest = data[i].chest;
        let waist = data[i].waist;
        let hips = data[i].hips;
        let thigh = data[i].thigh;
        neededData[i] = [date, weight, upperArm, chest, waist, hips, thigh];
    }
    createAndFillTable(parentId, columns, neededData, "bodyMeasurementsTableId", true);
}

function __saveBodyMeasurementSuccessCallback(dataForCb, data, textStatus, xhr){
	$(dataForCb['modalId']).modal('hide');
	notifySuccess("Body measurement saved.");
	dataForCb['health'].getAllBodyMeasuremntByUserId(getUserId());
	
}

function __saveBodyMeasurementFailureCallback(){
	notifyFailure("Sorry :( but something went wrong.");
}


function __saveBodyMEasurement(parent){
	let bodyMeasurementJsonObject = inputFieldsValueToJson(parent);
	bodyMeasurementJsonObject["healthId"] = this.healthId;
	AjaxSetUp.sendRequestAndHandleAnswer(
			this.URL_SAVE_BODY_MEASUREMENT,
			"POST",
			bodyMeasurementJsonObject,
			{
				modalId : this.MODAL_ID,
				health  : this
			},
			this.saveBodyMeasurementSuccessCallback,
			this.saveBodyMeasurementFailureCallback
			);
}