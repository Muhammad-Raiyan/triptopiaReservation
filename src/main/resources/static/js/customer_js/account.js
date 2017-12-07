jQuery(document).ready(function($) {
	'use strict';
	$("#accordianRestOfThePage").hide();
});

function loggedIn(){
	$("#accordianRestOfThePage").show();
}

function getCurrentReservations(){
	ajaxWrapperGET('/home/customer/getCurrentReservations/'+$("#accountNo").val(), "getCurrentReservationsResult");
}

function getAllReservations(){
	ajaxWrapperGET('/home/customer/getAllReservations/'+$("#accountNo").val(), "getAllReservationsResult");
}

function getRecommendedFlights(){
	var url = '/home/rep/recommendedFlights/' + $("#accountNo").val();
	ajaxWrapperGET(url, "getRecommendedFlightsResult");
}
