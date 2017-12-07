//onClick functions
function defaultSuccess(response, textStatus){
	console.log("Success: " + textStatus + "\n" + JSON.stringify(response, null, 2));
}
function defaultFailure(response, textStatus){
	console.log("Failure: " + textStatus + "\n" + JSON.stringify(response, null, 2));
}
function ajaxWrapperDELETE(inUrl){
	jQuery.ajax({
		url: inUrl,
		type: 'DELETE',
		success: defaultSuccess,
		error: defaultFailure
	});
}
function ajaxWrapperGET(inUrl, successFunction){
	jQuery.ajax({
		url: inUrl,
		type: 'GET',
		success: successFunction,
		error: defaultFailure
	});
}
function ajaxWrapperPOST(inUrl, inData){
	jQuery.ajax({
		url: inUrl,
		type: 'POST',
		data: inData,
		headers:{
			"Content-Type":"application/json"
		},
		success: defaultSuccess,
		error: defaultFailure
	});
}
function ajaxWrapperPUT(inUrl, inData){
	jQuery.ajax({
		url: inUrl,
		type: 'PUT',
		data: inData,
		headers:{
			"Content-Type":"application/json"
		},
		success: defaultSuccess,
		error: defaultFailure
	});
}

function removeEmployee(){
	ajaxWrapperDELETE('/employee/delete/'+$("#removeEmployeeSSN").val());
}

function addEmployee(){
	var toSend = {};
	toSend["personId"] = $("#addEmployeePersonZipCode").val();
	toSend["ssn"] = $("#addEmployeeSSN").val();
	toSend["isManager"] = $("input[name='addEmployeeIsManager']:checked").val()=="yes";
	toSend["startDate"] = $("#addEmployeeStartDate").val();
	toSend["hourlyRate"] = $("#addEmployeeHourlyRate").val();
	ajaxWrapperPOST('/employee/insert', JSON.stringify(toSend));
}

function changeEmployee(){
	var toSend = {};
	toSend["ssn"] = $("#addEmployeeSSN").val();
	toSend["isManager"] = $("input[name='addEmployeeIsManager']:checked").val()=="yes";
	toSend["startDate"] = $("#addEmployeeStartDate").val();
	toSend["hourlyRate"] = $("#addEmployeeHourlyRate").val();
	ajaxWrapperPUT('/employee/update', JSON.stringify(toSend));
}

function getAllEmployees(){
	ajaxWrapperGET('/employee/allEmployees', function(response) {
		console.log("Success: " + JSON.stringify(response, null, 2));
		TableFromJSON(response,"getAllEmployeesResult");
	});
}

function getFlightListing(){
	ajaxWrapperGET('/employee/allFlights', function(response) {
		console.log(JSON.stringify(response));
		TableFromJSON(response,"getFlightListingResult");
	});
}

function viewEmployee(){
	ajaxWrapperGET('/employee/get/'+$("#viewEmployeeSSN").val(), function(response) {
		console.log("Success: " + JSON.stringify(response, null, 2));
		TableFromJSON([response],"viewEmployeeResult");
	});
}

var tmp = 'reservationsByFlight';
