$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
    
    $('#recipient-phone').mask('0000000000');
    $('.pos').click(function(){
        if($(this).hasClass('red')){
            $('.parkingFull').modal({});
            return;
        }
        $('#exampleModal').find('.modal-title').text($(this).attr("data-parkid")+" Booking");
        $('.parkingID').val($(this).attr("data-parkid")+" Booking");
        $('#exampleModal').modal({});
    });
    $('.logInLink').click(function(){
        $('#loginModal').modal({});
       
    });
 

    Date.prototype.addHours= function(h){
        this.setHours(this.getHours()+h);
        return this;
    }
    
//    $('#SubmitDetailsServlet').on('submit',function(e){
//    	e.preventDefault();
//    	var startDate = $("#recipient-inDate").val(),startTime = $("#recipient-intime").val();
//    	startDate = startDate.split("-");startTime=startTime.split(":");
//    	var givenDate = new Date(startDate[0],Number(startDate[1])-1,startDate[2],startTime[0],startTime[1]);
//    	var now = new Date();
//    	var oneHourLater = new Date().addHours(1);
//    	if(givenDate>now && givenDate<oneHourLater){
//    		$("#ResponseModal").modal({});
//    		$('#exampleModal').modal('hide');
//    		$(document).location.href = '${pageContext.request.contextPath}/SubmitDetailsServlet'
//    		return true;
//    	}else{
//    		alert("Error! Start Time should be one hour from now");
//    	}
//    })
    
});


$(".readonly").keydown(function(e){
    e.preventDefault();
});

function registerUser(){
	hideErr();
	var is_valid = validateRegisterForm();
	
	if(is_valid == true){
		console.log();
		document.location.href = '${pageContext.request.contextPath}/SubmitDetailsServlet'
//		$('#exampleModal').modal('hide');
//		$('#ResponseModal').modal({});
	}
}

function hideErr(){
	document.getElementById('err_recipient-name').style.display = "none";
	document.getElementById('err_recipient-email').style.display = "none";
	document.getElementById('err_recipient-email-valid').style.display = "none";
	document.getElementById('err_recipient-phone').style.display = "none";
	document.getElementById('err_recipient-car').style.display = "none";
	document.getElementById('err_recipient-inDate').style.display = "none";
	document.getElementById('err_recipient-intime').style.display = "none";
	document.getElementById('err_recipient-outDate').style.display = "none";
	document.getElementById('err_recipient-outtime').style.display = "none";
}

function validateRegisterForm(){
	var recipient_name = document.getElementById('recipient-name').value.trim();
	var recipient_email = document.getElementById('recipient-email').value.trim();
	var recipient_phone = document.getElementById('recipient-phone').value.trim();
	var recipient_car = document.getElementById('recipient-car').value.trim();

	var recipient_inDate = document.getElementById('recipient-inDate').value.trim();
	var recipient_intime = document.getElementById('recipient-intime').value.trim();
	var recipient_outDate = document.getElementById('recipient-outDate').value.trim();
	var recipient_outtime = document.getElementById('recipient-outtime').value.trim();

	if(recipient_name == ""){
		document.getElementById('err_recipient-name').style.display = "block";
		return false;
	}
	if(recipient_email == ""){
		document.getElementById('err_recipient-email').style.display = "block";
		return false;
	}
	if(ValidateEmail(recipient_email) == false){
		document.getElementById('err_recipient-email-valid').style.display = "block";
		return false;
	}
	if(recipient_phone == ""){
		document.getElementById('err_recipient-phone').style.display = "block";
		return false;
	}
	if(recipient_car == ""){
		document.getElementById('err_recipient-car').style.display = "block";
		return false;
	}
	if(recipient_inDate == ""){
		document.getElementById('err_recipient-inDate').style.display = "block";
		return false;
	}
	if(recipient_intime == ""){
		document.getElementById('err_recipient-intime').style.display = "block";
		return false;
	}
	if(recipient_outDate == ""){
		document.getElementById('err_recipient-outDate').style.display = "block";
		return false;
	}
	if(recipient_outtime == ""){
		document.getElementById('err_recipient-outtime').style.display = "block";
		return false;
	}
	
	return true;
	
}

function ValidateEmail(mail)   
{  
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))  
     {  
       return true;  
     }  
    return false;  
}
