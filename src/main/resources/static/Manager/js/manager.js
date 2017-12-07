function removeEmployee(){
	//var formObject = formToObject("#removeEmployeeForm");
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
	toSend["personId"] = $("#addEmployeePersonZipCode").val();
	toSend["ssn"] = $("#addEmployeeSSN").val();
	toSend["isManager"] = $("input[name='addEmployeeIsManager']:checked").val()=="yes";
	toSend["startDate"] = $("#addEmployeeStartDate").val();
	toSend["hourlyRate"] = $("#addEmployeeHourlyRate").val();
	jQuery.ajax({
		url: '/employee',
		type: 'POST',
		data:JSON.stringify(toSend),
		headers:{
			"Content-Type":"application/json"
		},
		success: function(response) {
		//BLAH
		console.log("success");
		}
	});
	console.log("Added\n");
}

function changeEmployee(){
	var toSend = {};
	toSend["ssn"] = $("#addEmployeeSSN").val();
	toSend["isManager"] = $("input[name='addEmployeeIsManager']:checked").val()=="yes";
	toSend["startDate"] = $("#addEmployeeStartDate").val();
	toSend["hourlyRate"] = $("#addEmployeeHourlyRate").val();
	jQuery.ajax({
		url: '/employee',
		type: 'PUT',
		headers:{
			"Content-Type":"application/json"
		},
		data: JSON.stringify(toSend),
		success: function(response) {
		//BLAH
		console.log("success");
		}
	});
	console.log("Added\n");
}


function getAllEmployees(){
	jQuery.ajax({
		url: '/employee',
		type: 'GET',
		success: function(response) {
			console.log(response);
			var responseObject = JSON.parse(response);
			TableFromJSON(responseObject,"getAllEmployeesResult");
		}
	});
}
