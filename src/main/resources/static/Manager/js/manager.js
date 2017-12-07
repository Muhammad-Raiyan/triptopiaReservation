function removeEmployee(){
	var formObject = formToObject("#removeEmployeeForm");

	jQuery.ajax({
		url: '/employee/123456789',
		type: 'DELETE',
		success: function(response) {
		//BLAH
		console.log("success");
		}
	});
	console.log("Remove\n");
}
