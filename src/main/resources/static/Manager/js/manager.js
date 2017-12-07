function removeEmployee(){
	var formObject = formToObject("#removeEmployeeForm");
	jQuery.ajax({
		url: '/employee/'+$("#removeEmployeeSSN").val(),
		type: 'DELETE',
		success: function(response) {
		//BLAH
		console.log("success");
		}
	});
	console.log("Remove\n");
}
//TODO decisions to be made
function addEmployee(){
	//var formObject = formToObject("#addEmployeeForm");
	var toSend = {};
	toSend["firstName"] = $("#addEmployeePersonFirstName").val();
	toSend["lastName"] = $("#addEmployeePersonLastName").val();
	toSend["address"] = $("#addEmployeePersonAddress").val();
	toSend["city"] = $("#addEmployeePersonCity").val();
	toSend["state"] = $("#addEmployeePersonState").val();
	toSend["zipCode"] = $("#addEmployeePersonZipCode").val();
	toSend["ssn"] = $("#addEmployeeSSN").val();
	toSend["isManager"] = $("input[name='addEmployeeIsManager']:checked").val()=="yes";
	toSend["startDate"] = $("#addEmployeeStartDate").val();
	toSend["hourlyRate"] = $("#addEmployeeHourlyRate").val();
	jQuery.ajax({
		url: '/employee',
		type: 'POST',
		data:toSend,
		success: function(response) {
		//BLAH
		console.log("success");
		}
	});
	console.log("Added\n");
}
//TODO broken on server 12/06 8pm
function changeEmployee(){
	var formObject = formToObject("#addEmployeeForm");
	jQuery.ajax({
		url: '/employee/'+$("#removeEmployeeSSN").val(),
		type: 'PUT',
		data:formObject,
		success: function(response) {
		//BLAH
		console.log("success");
		}
	});
	console.log("Added\n");
}
