//初始化回复框 //flag 是用来区别是回复主贴还是回复评论
var _at = "";
function initReplyBox(th,flag){
	replyboxReset();
	if(flag==1){
		//获取主贴的id
		var mainId = $("#mainTopic_id").val();
		_at ="@"+$(th).attr("data") +":";
		
		//将id传递给replyBox
		$("#mainTopicId").val(mainId);
	}
	//获取回复帖子的id或者是一个回复的id
	var replyId = $(th).parent().find("input").val();
	
	//将id传递给replyBox
	$("#topicId").val(replyId);
	$("#message-text").val(_at);
}

/**
 * 发送回复信息
 * @returns
 */
function sendReply(){
	$(this).css("disabled","disabled");
	//获取到了回复帖子的id
	var topicId = $("#topicId").val();
	var mainTopicId = $("#mainTopicId").val();
	
	if(topicId==null){
		//暂时不做处理
		return;
	}
	var replyContent = $("#message-text").val();
	if(replyContent==null||replyContent.trim()==""){
		//回复内容为空		
		changeReplyAlert("alert alert-danger","回复内容不能为空哦！！");
		return;
		
	}
	
	
	//ajax发送回复内容
	$.ajax({
		url:"topic/replyTopic",		
		dataType:"text",
		type:"get",		
		data:{"topicId":topicId,"replyContent":replyContent,"mainTopicId":mainTopicId},
		beforeSend:function(){
			//显示动画
		},
		success:function(data,TextState){
			//结束动画
			changeReplyAlert("alert alert-success","回复成功！");
			
			//自动关闭评论框
			
			window.setTimeout("$('#reply-box-close').click();replyboxReset();",500);
		},
		error:function(msg){
			//结束动画
			console.log(msg);
		}	
		
	});
}



/**
 * 回复alert提示框
 * @param className
 * @param tip
 * @returns
 */
function changeReplyAlert(className,tip){
	$("#reply-alert").addClass(className).css("display","block");
	$("#reply-alert").find("span").html(tip);
	$("#reply-alert").find("strong").html("TIPS:&nbsp;&nbsp;");
}
/**
 * 回复框的重置
 * @returns
 */
function replyboxReset(){
	_at = "";
	$("#reply-alert").css("display","none");
	$("#message-text").val("");
	
}

