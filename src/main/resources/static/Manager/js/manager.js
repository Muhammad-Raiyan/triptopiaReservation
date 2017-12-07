//onClick functions

function removeEmployee(){
	var url = '/employee/delete/' + $("#removeEmployeeSSN").val();
	ajaxWrapperDELETE(url);
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
	toSend["ssn"] = $("#changeEmployeeSSN").val();
	toSend["isManager"] = $("input[name='changeEmployeeIsManager']:checked").val()=="yes";
	toSend["startDate"] = $("#changeEmployeeStartDate").val();
	toSend["hourlyRate"] = $("#changeEmployeeHourlyRate").val();
	ajaxWrapperPUT('/employee/update', JSON.stringify(toSend));
}

function getAllEmployees(){
	ajaxWrapperGET('/employee/allEmployees', "getAllEmployeesResult");
}

function getFlightListing(){
	ajaxWrapperGET('/employee/allFlights', "getFlightListingResult");
}

function viewEmployee(){
		ajaxWrapperGET('/employee/get/'+$("#viewEmployeeSSN").val(), "viewEmployeeResult");
}

function getReservationsByCustomerName(){
	var url = '/employee/reservationsByCustomerName/' + $("#getReservationsByCustomerNameFirst").val() + '/' + $("#getReservationsByCustomerNameLast").val();
	ajaxWrapperGET(url, "getReservationsByCustomerNameResult");
}

function getReservationsByFlightNumber(){
	var url = '/employee/reservationsByFlightNumber/' + $("#getReservationsByFlightNumberAirline").val() + '/' + $("#getReservationsByFlightNumberNumber").val();
	ajaxWrapperGET(url, "getReservationsByFlightResult");
}

function getSalesReport(){
	var url = '/employee/salesReport/' + $("#getSalesReportMonth").val();
	ajaxWrapperGET(url, "getSalesReportResult");
}

function getRevenueByFlight(){
	var url = '/employee/revenueByFlight/' + $("#getRevenueByFlightAirline").val() + '/' + $("#getRevenueByFlightNumber").val();
	ajaxWrapperGET(url, "getRevenueByFlightResult");
}

function getRevenueByDestinationCity(){
	var url = '/employee/revenueByDestinationCity/' + $("#getRevenueByDestinationCityCity").val();
	ajaxWrapperGET(url, "getRevenueByDestinationCityResult");
}

function getRevenueByCustomer(){
	var url = '/employee/revenueByCustomer/' + $("#getRevenueByCustomerAccountId").val();
	ajaxWrapperGET(url, "getRevenueByCustomerResult");
}

function getCustomerOfMaxRevenue(){
	var url = '/employee/customerOfMaxRevenue/';
	ajaxWrapperGET(url, "getCustomerOfMaxRevenueResult");
}

function getMostActiveFlights(){
	var url = '/employee/mostActiveFlights/';
	ajaxWrapperGET(url, "getMostActiveFlightsResult");
}

function getCustomersOnFlight(){
	var url = '/employee/customersOnFlight/' + $("#getCustomersOnFlightAirline").val() + '/' + $("#getCustomersOnFlightNumber").val() + '/' + $("#getCustomersOnFlightLeg").val();
	ajaxWrapperGET(url, "getCustomersOnFlightResult");
}

