var items;
$(document).ready(function() {
$("input#searchByCustomerAccountNumber").autocomplete({
	
source: function(request, response) {
$.ajax({
// basePath is used for defining contecxt-path of the url.
url:  "searchByCustomerAccountNumber",
dataType: "json",
// data to be sent to the server:
data: {
term : request.term,
// for passing extra parameter:
param1 : "param1 Value",
param2 : "param2 Value"
},
/*
A Success function to be called if the request succeeds.The function gets
passed two arguments-
The data returned from the server, a string describing the status:
*/
success: function(data,type) {
console.log( data);
items = data;
response(items);
},
//if the request fails,A error function to be called.
error: function(data,type){
console.log( type);
}
});
}
});
 
});


$(document).ready(function() {
	$("input#searchByCustomerName").autocomplete({
		
	source: function(request, response) {
	$.ajax({
	// basePath is used for defining contecxt-path of the url.
	url:  "searchByCustomerName",
	dataType: "json",
	// data to be sent to the server:
	data: {
	term : request.term,
	// for passing extra parameter:
	param1 : "param1 Value",
	param2 : "param2 Value"
	},
	/*
	A Success function to be called if the request succeeds.The function gets
	passed two arguments-
	The data returned from the server, a string describing the status:
	*/
	success: function(data,type) {
	console.log( data);
	items = data;
	response(items);
	},
	//if the request fails,A error function to be called.
	error: function(data,type){
	console.log( type);
	}
	});
	}
	});
	 
	});


// supplier autocoplete


$(document).ready(function() {
	$("input#searchBySupplierAccountNumber").autocomplete({
		
	source: function(request, response) {
	$.ajax({
	// basePath is used for defining contecxt-path of the url.
	url:  "searchBySupplierAccountNumber",
	dataType: "json",
	// data to be sent to the server:
	data: {
	term : request.term,
	// for passing extra parameter:
	param1 : "param1 Value",
	param2 : "param2 Value"
	},
	/*
	A Success function to be called if the request succeeds.The function gets
	passed two arguments-
	The data returned from the server, a string describing the status:
	*/
	success: function(data,type) {
	console.log( data);
	items = data;
	response(items);
	},
	//if the request fails,A error function to be called.
	error: function(data,type){
	console.log( type);
	}
	});
	}
	});
	 
	});


	$(document).ready(function() {
		$("input#searchBySupplierName").autocomplete({
			
		source: function(request, response) {
		$.ajax({
		// basePath is used for defining contecxt-path of the url.
		url:  "searchBySupplierName",
		dataType: "json",
		// data to be sent to the server:
		data: {
		term : request.term,
		// for passing extra parameter:
		param1 : "param1 Value",
		param2 : "param2 Value"
		},
		/*
		A Success function to be called if the request succeeds.The function gets
		passed two arguments-
		The data returned from the server, a string describing the status:
		*/
		success: function(data,type) {
		console.log( data);
		items = data;
		response(items);
		},
		//if the request fails,A error function to be called.
		error: function(data,type){
		console.log( type);
		}
		});
		}
		});
		 
		});



