function makeRoundTripReservation(){
	var toSend1 = {};
	toSend1["accountNumber"]    = $("#makeRoundTripReservationAccountNumber").val();
	toSend1["airline"]      = $("#makeRoundTripReservationFromAirline").val();
	toSend1["flightNumber"] = $("#makeRoundTripReservationFromNumber").val();
	toSend1["legNumber"]    = $("#makeRoundTripReservationFromLeg").val();
	toSend1["seatClass"]            = $("#makeRoundTripReservationFromClass").val();
	toSend1["seatNumber"]       = $("#makeRoundTripReservationFromSeatNumber").val();
	toSend1["meal"]             = $("#makeRoundTripReservationMeal").val();
	var toSend2 = {};
	toSend2["accountNumber"]    = $("#makeRoundTripReservationAccountNumber").val();
	toSend2["toAirline"]        = $("#makeRoundTripReservationToAirline").val();
	toSend2["toFlightNumber"]   = $("#makeRoundTripReservationToNumber").val();
	toSend2["toLegNumber"]      = $("#makeRoundTripReservationToLeg").val();
	toSend2["seatClass"]            = $("#makeRoundTripReservationToClass").val();
	toSend2["seatNumber"]       = $("#makeRoundTripReservationToSeatNumber").val();
	toSend2["meal"]             = $("#makeRoundTripReservationMeal").val();
	ajaxWrapperPOST('/home/rep/roundTrip', JSON.stringify(toSend1));
	ajaxWrapperPOST('/home/rep/roundTrip', JSON.stringify(toSend2));
	console.log("hi");
}

function makeOneWayTripReservation(){
	var toSend = {};
	toSend["accountNumber"]    = $("#makeOneWayTripReservationAccountNumber").val();
	toSend["airline"]      = $("#makeOneWayTripReservationAirline").val();
	toSend["flightNumber"] = $("#makeOneWayTripReservationNumber").val();
	toSend["legNumber"]    = $("#makeOneWayTripReservationLeg").val();
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
