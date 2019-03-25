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
		version : __version,
		initHealthView : __initHealthView,
		initBehaviour : __initBehaviour,
		addBodyMeasurementTable : __addBodyMeasurementTable 
	}
}

function __version(){
	return this.VERSION;
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

function __addBodyMeasurementTable(dataForCallback, data) {
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