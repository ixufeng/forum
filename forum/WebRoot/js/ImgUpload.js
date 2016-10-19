(function(){
	
	
	// 初始化Web Uploader
	var uploader = WebUploader.create({

    // 选完文件后，是否自动上传。
    auto: false,

    // swf文件路径
    swf: 'js/Uploader.swf',
    method: 'post',
    // 文件接收服务端。
    server: '/forum/userInfo/ImageUpload_avatar',

    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#file_picker',

    // 只允许选择图片文件。
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    	}
	});

	
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
		 $("#fileList").find("span").remove();
		//删除之前的所有文件
		 
		var $files = uploader.getFiles();
		
		for(var i =0;i<$files.length;i++){
			
			if($files[i]!==file){
				uploader.removeFile($files[i]);
			}	
		}

		var $list = $("#fileList");
		$("#fileList").find("div").remove();
	
	
	    var $li = $(
	
	            '<div id="' + file.id + '" class="file-item" width="60">' +
	                '<img class="thumbnail">' +
	                '<button  class="btn btn-default btn-sm">' +"确认修改" +  '</button>'+              
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
	});
	
	
	//手动触发文件的上传
	$("#fileList").bind("click","button",function(){
		uploader.upload();		
	});
	
	
})();	

	
