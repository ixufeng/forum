(function(){

	//选择发表的节点名称
	$(".node").click(function(){

		var node_id = $(this).find('input').val();
		$("#chooseNodeId").val(node_id);
		$("#dropdownMenu1").text($(this).text());
	});
	
	//定义全局的markdown转化工具
	var converter = new showdown.Converter();
	
	//预览主题
	$("#preshow").click(function(){		
		
		var text = $("#content").val();	
		var html = converter.makeHtml(text);
		html = html.replace(/script/gi,"s cript");
		$("#show_con").removeClass("hidden").css("margin-top","20px");
		$("#show_content").html(html);
		
	});
	
	//发送主题
	$("#sendtopic").click(function(){
		
		var content = $("#content").val();
		var title = $("#topicTitle").val();
		if(title.trim()==""){
			//默认必须含有标题
					
			return;
			
		}
		var html = converter.makeHtml(content);
		$("#sendcontent").val(html);
		$("#sendbutton").click();
	});
	
	
})();


