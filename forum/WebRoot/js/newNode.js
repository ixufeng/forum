


function selectTheme(th){
	var themeId = $(th).val();
	
	$("#panel-node").slideUp();
	if(themeId!=-1){
		$.ajax({
			
			url:"/forum/ajax/newNode_getNode",	
			dataType:"json",
			type:"post",		
			data:{"themeId":themeId},
			
			success:function(data,TextState){
				//显示所得的内容
				var html = "";
				for(var i =0;i<data.length;i++){
					html +="<span class='mark mark-orange'><span></span>";
					html +=data[i].name;  
					html +="</span>";
			
				}
			
				$("#node-body").html(html);
				$("#panel-node").slideDown();
			},
			error:function(msg,textState){
				//给出提示
				console.log(msg);
				
			}	
		});
	}
	
}