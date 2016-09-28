
$(function () {  
	 //点击图片更换验证码
    $("#image-code").click(function(){
	      $(this).attr("src","/forum/imageCode?timestamp="+new Date().getTime());
	 });
});


$(function(){
	
	// $("#btn-submit").attr("disabled","disabled");
	var fname = false;
	var fpass = false;
	var frepass = false;
	var femail = false;
	
	
	$("#userName").blur(function(){
		var userName = $(this).val();
		//调用后台的查重机制
		fname = checkName(userName);
		isButtonAbled(fname,femail,fpass,frepass);
	});
	
	$("#inputEmail").blur(function(){
		var userEmail = $(this).val();
		//检验
		femail = checkEmail(userEmail);
		isButtonAbled(fname,femail,fpass,frepass);
	});
	$("#password").blur(function(){
		var pass = $(this).val();
		if(pass.length<6){
			//密码长度过短
			$("#password-remind").removeClass("remind-success");
			$("#password-remind").html("密码长度过短");
			$("#password-remind").addClass("remind-error");
			fpass = false;
			isButtonAbled(fname,femail,fpass,frepass);
		}else if(pass.length>18){
			//密码过长
			$("#password-remind").removeClass("remind-success");
			$("#password-remind").html("密码长度过长");
			$("#password-remind").addClass("remind-error");
			fpass = false;
			isButtonAbled(fname,femail,fpass,frepass);
		}else{
			$("#password-remind").html("SUCCESS");
			$("#password-remind").addClass("remind-success");
			fpass = true;
			isButtonAbled(fname,femail,fpass,frepass);
		}
	});
	
	$("#repassword").blur(function(){
		var pass = $("#password").val();
		var	repass = $(this).val();
		if(pass!=repass){
			$("#repassword-remind").removeClass("remind-success");
			$("#repassword-remind").html("两次密码不一致");
			$("#repassword-remind").addClass("remind-error");
			frepass = false;
			isButtonAbled(fname,femail,fpass,frepass);
		}else{
			$("#repassword-remind").html("CUCCESS");
			$("#repassword-remind").addClass("remind-success");
			frepass = true;
			isButtonAbled(fname,femail,fpass,frepass);
		}
	});
	
});

//检查所有
function isButtonAbled(name,email,pass,repass){
	
	if(name&&email&&pass&&repass){
		$("#btn-submit").removeAttr("disabled");
		btnAnimate();
	}else{
		$("#btn-submit").attr("disabled","true");
		
	}
	
	
}

//检查用户名是否重复或者违法
function checkName(name){
	var flag = false; 
	$.ajax({
		url:"register/CheckUser_checkName",
		dataType:"text",
		type:"get",
		async:false,
		data:{"userName":name},
		success:function(data,textState){
			
			$("#userName-remind").html(data);
			$("#userName-remind").addClass("remind-error");
			if(data == "SUCCESS"){
				flag = true;
				console.log("ceshi");
				$("#userName-remind").removeClass("remind-error");
				$("#userName-remind").addClass("remind-success");
			}
		},
		error:function(msg){
			console.log(msg);
		}		
	});
	return flag;
}

function checkEmail(email){
	var flag = false;
	$.ajax({
		url:"register/CheckUser_checkEmail",
		dataType:"text",
		type:"post",
		async:false,
		data:{"userEmail":email},
		success:function(data,textState){
			$("#userEmail-remind").html(data);
			$("#userEmail-remind").removeClass("remind-success");
			$("#userEmail-remind").addClass("remind-error");
			if(data == "SUCCESS"){
				flag = true;
				$("#userEmail-remind").addClass("remind-success");
			}
		},
		error:function(msg){
			console.log(msg);
		}		
	});
	return flag;
}

//点击注册的特效
function btnAnimate(){
	
	$("#progress").css("display","block");
	$("#progress-detail").animate({"width":"100%"},500);
}



