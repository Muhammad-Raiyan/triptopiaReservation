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
