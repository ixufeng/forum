(function(){
	
	
	// 初始化Web Uploader
	var uploader = WebUploader.create({

    // 选完文件后，是否自动上传。
    auto: false,

    // swf文件路径
    swf: 'js/Uploader.swf',
    method: 'post',
    // 文件接收服务端。
    server: '/forum/userInfo/ImageUpload_topic',

    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#file-pick',

    // 只允许选择图片文件。
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    	}
	});
	var uploadFileNums = 0;
	
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
		
		//删除之前的所有文件
		 
		var $list = $("#fileList");
	
	    var $li = $(
	
	            '<div id="' + file.id + '" class="file-item pull-left" width="60">' +
	                '<img class="thumbnail">' +
	                '<span class="del">删除</span>' +
	            '</div>'
	            ),
	       	$img = $li.find('img');

	    // $list为容器jQuery实例
	    $list.append( $li );

    // 创建缩略图
    // 如果为非图片文件，可以不用调用此方法。
    // thumbnailWidth x thumbnailHeight 为 100 x 100
    uploader.makeThumb( file, function( error, src ) {
        if ( error ) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }

        $img.attr( 'src', src );
    	}, 60, 60 );
	});

	


	
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress .progress-bar');

	    // 避免重复创建
	    if ( !$percent.length ) {
	        $percent = $('<div class="progress progress-striped active">' +
	          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	          '</div>' +
	        '</div>').appendTo( $li ).find('.progress-bar');
	    }

	    $li.find('p.state').text('上传中');

	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	
	
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).addClass('upload-state-done');
	    
	    //删掉预览图片
	    $("#fileList").find("div").remove();
	    $("#fileList").append("<span>上传成功！</span>");
	    
	});

	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');
	
	    // 避免重复创建
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }
	    $error.text('上传失败');
	});
	  
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress').remove();
		uploadFileNums++;
		//所有的文件都上传结束
		console.log(uploader.getFiles());
		var files = uploader.getFiles();
		if(files==null||files.length==uploadFileNums){
			console.log(uploader.getFiles());
			 //图片上传完成，开始发送帖子    
		    var content = $("#content").val();
			
			var html = converter.makeHtml(content);
			$("#sendcontent").val(html);
			$("#sendbutton").click();
		    
		}

	});
	
	
	//删除选择的图片
	$("#fileList").on("click",".del",function(){
		var fileId = $(this).parent().attr("id");
		//从文件列表中删除此文件
		uploader.removeFile(fileId);
		//删除文件的显示
		$(this).parent().remove();
		
	});
	

	//发送主题
	$("#sendtopic").click(function(){

		var title = $("#topicTitle").val();
		if(title.trim()==""){
			//默认必须含有标题	,带处理				
			return;
			
		}
		//先上传图片
		if(uploader.getFiles().length>0){
			//携带图片的上传
			uploader.upload();
		}else{
			//直接上传帖子
			 //图片上传完成，开始发送帖子    
		    var content = $("#content").val();			
			var html = converter.makeHtml(content);
			$("#sendcontent").val(html);
			$("#sendbutton").click();
		}
		
				
	});
	
	
		
	
})();	

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






