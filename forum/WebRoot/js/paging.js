(function(){
	
	//当前页
	var currentPageIndex = $("#pagination").attr("data");
	console.log(currentPageIndex);
	//总条数
	var pageNums = $("#pagination").attr("data-all");
	console.log(pageNums);
	
	if(currentPageIndex<3){
		var sel = parseInt(currentPageIndex)+1;
		$("#pagination li:nth-child("+sel+")").find("a").css("background-color","#337ab7").css("color","#fff");
	}else{
		$("#pagination li:nth-child(4)").find("a").css("background-color","#337ab7").css("color","#fff");
	}
	
	
	
	//点击页面按钮
	$("#pagination>li>a").click(function(){
		
		
		
		var flag = this.text.trim();
		
		if(flag=="«"){
			//上一页
			if(parseInt(currentPageIndex)>1){
				var num = parseInt(currentPageIndex)-1; 
				window.location.href ="/forum/topic/showTopic.action?pageIndex="+num;
			}
		}else if(flag=="»"){
			//下一页
			if(parseInt(currentPageIndex)<pageNums) {
				num = parseInt(currentPageIndex)+1; 
				window.location.href ="/forum/topic/showTopic.action?pageIndex="+num;
			}
		}else{
			//页数
			if(!isNaN(flag)){
				
				window.location.href ="/forum/topic/showTopic.action?pageIndex="+flag;
				
			}
		}		
	});
	
	
	
	
})();