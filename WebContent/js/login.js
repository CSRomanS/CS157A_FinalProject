$(function (){
	
    $("#signUp").click(function() {
        $("#dowebok").addClass("right-panel-active");
    });
    $("#signIn").click(function() {
        $("#dowebok").removeClass("right-panel-active");
    });
	// validate
	$(".register").validate({
		rules:{
			
			username:{
				required: true,
			},
			firstName:{
				required: true,
			},
			lastName:{
				required: true,
			},
			password:{
				required: true,
				rangelength:[8,20],
			},
			second_pwd:{
				required: true,
				rangelength:[8,20],
				equalTo:"#pwd",
			},
			email:{
				required: true,
				email:true,
			},
			birth:{
				required: true,
				dateISO:true,
			},
			phone:{
				required: true,
				minlength:10,
			},
		},
		messages:{
			username:'Please enter username',
			firstName:'Please enter first name',
			lastName:'Please enter last name',
			password:{
				required:'Password cannot be empty',
				rangelength:"Password length should between 8-20",
			},
			second_pwd:{
				required:'Password cannot be empty',
				rangelength:"Password length should between 8-20",
				equalTo:'The two passwords do not match',
			},
			email:{
				required:'Please enter email address',
				email:'Please enter a correct email address',
			},
			birth:{
				required: 'Please enter birthday',
				dateISO:'Please enter correct birthday',
			},
			phone:{
				required:"Phone number cannot be empty",
				minlength:"The phone number should be 10 digits",
			}
		}
	});
	$(".sign").validate({
		rules:{
			username:{
				required: true,
			},
			password:{
				required: true,
				rangelength:[8,20],
			},
		},
		messages:{
			username:'Please enter username',
			password:{
				required:'Password cannot be empty',
				rangelength:"Length should be 8-20",
			},
		},
	});
});