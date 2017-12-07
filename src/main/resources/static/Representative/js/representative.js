function makeRoundTripReservation(){
	var toSend = {};
	toSend["accountNumber"]    = $("#makeRoundTripReservationAccountNumber").val();
	toSend["fromAirline"]      = $("#makeRoundTripReservationFromAirline").val();
	toSend["fromFlightNumber"] = $("#makeRoundTripReservationFromNumber").val();
	toSend["fromLegNumber"]    = $("#makeRoundTripReservationFromLeg").val();
	toSend["toAirline"]        = $("#makeRoundTripReservationToAirline").val();
	toSend["toFlightNumber"]   = $("#makeRoundTripReservationToNumber").val();
	toSend["toLegNumber"]      = $("#makeRoundTripReservationToLeg").val();
	toSend["class"]            = $("#makeRoundTripReservationClass").val();
	toSend["seatNumber"]       = $("#makeRoundTripReservationSeatNumber").val();
	toSend["meal"]             = $("#makeRoundTripReservationMeal").val();
	ajaxWrapperPOST('/home/rep/roundTrip', JSON.stringify(toSend));
}

function makeOneWayTripReservation(){
	var toSend = {};
	toSend["accountNumber"]    = $("#makeOneWayTripReservationAccountNumber").val();
	toSend["fromAirline"]      = $("#makeOneWayTripReservationAirline").val();
	toSend["fromFlightNumber"] = $("#makeOneWayTripReservationNumber").val();
	toSend["fromLegNumber"]    = $("#makeOneWayTripReservationLeg").val();
	toSend["class"]            = $("#makeOneWayTripReservationClass").val();
	toSend["seatNumber"]       = $("#makeOneWayTripReservationSeatNumber").val();
	toSend["meal"]             = $("#makeOneWayTripReservationMeal").val();
	ajaxWrapperPOST('/home/rep/oneWay', JSON.stringify(toSend));
}

function addCustomer(){
	var toSend = {};
	toSend["firstName"] = $("#addCustomerPersonFirstName").val();
	toSend["lastName"] = $("#addCustomerPersonLastName").val();
	toSend["address"] = $("#addCustomerPersonAddress").val();
	toSend["city"] = $("#addCustomerPersonCity").val();
	toSend["state"] = $("#addCustomerPersonState").val();
	toSend["zipCode"] = $("#addCustomerPersonZipCode").val();
	toSend["phoneNo"] = $("#addCustomerphoneNo").val();
	toSend["creditCard"] = $("#addCustomerCreditCard").val();
	toSend["date"] = $("#addCustomerDate").val();
	toSend["email"] = $("#addCustomerEmail").val();
	ajaxWrapperPOST('/home/rep/addCustomer', JSON.stringify(toSend));
}
