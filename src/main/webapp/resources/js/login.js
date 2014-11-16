$(function(){

	$('.show-password').click(function(event){
	    var key_attr = $('#password').attr('type');
	    if(key_attr != 'text') {
	        
	        $('.checkbox').addClass('show');
	        $('#password').attr('type', 'text');
	    } else {
	        $('.checkbox').removeClass('show');
	        $('#password').attr('type', 'password');
	    }
	});
	
	//TODO - login validation
	$("input,select,textarea").not(".login-submit").jqBootstrapValidation();
	$('#login').click(function(event){
		event.preventDefault();
		var user = {};
		user.email = $('#email').val().trim();
		user.password = $('#password').val().trim();
		console.table("user- ",user);
		$.ajax({
		    url : "./User/login",
		    type: "POST",
		    contentType: "application/json; charset=utf-8",
		    data : JSON.stringify(user),
		    async: false,
		    cache: false,
		    processData:false,
		    success: function(data, textStatus, jqXHR)
		    {
		        console.log("login successful");
		    },
		    error: function (jqXHR, textStatus, errorThrown)
		    {
		    	console.log("login failed jqXHR- ",jqXHR);
		    }
		});
	});
	
	$("input,select,textarea").not(".submit-registration").jqBootstrapValidation();
	$('#register').click(function(event){
		event.preventDefault();
		$('.login-form').hide();
		$('.register-form').show();
	});
	
	$('.submit-registration').click(function(event){
		event.preventDefault();
		var user = {};
		user.email = $('#email-id').val().trim();
		user.password = $('#rg-password').val().trim();
		user.firstName = $('#first-name').val().trim();
		user.lastName = $('#last-name').val().trim();
		user.address = $('#address').val().trim();
		
		console.table("user- ",user);
		$.ajax({
		    url : "rest/User/register",
		    type: "POST",
		    data : JSON.stringify(user),
		    success: function(data, textStatus, jqXHR)
		    {
		        console.log("registration successful");
		    },
		    error: function (jqXHR, textStatus, errorThrown)
		    {
		    	console.log("login failed jqXHR- ",jqXHR);
		    }
		});
	});
});