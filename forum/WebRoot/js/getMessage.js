
(function(){
	var userId = $("#userId");
	
	if(userId){
		var id = userId.val();
		
		//获取用户的消息
		$.ajax({
			
			url:"message/getMessageNum",		
			dataType:"text",
			type:"get",		
			data:{"id":id},
			beforeSend:function(){
				
			},
			success:function(data){
				
				$("#newMessageNum").html(data);
				
			},
			error:function(){
				
			}
		});
		
		
	}
	
})();