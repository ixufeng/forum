<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
   <link rel="stylesheet" type="text/css" href="/forum/css/userInfo.css"/>
   <!--引入CSS-->
	<link rel="stylesheet" type="text/css" href="css/webuploader.css">
	<!--引入JS-->
	<script type="text/javascript" src="js/webuploader.js"></script>
<title>用户资料</title>
</head>
<body>
	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
	<div id="main-body" class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
			<div class="panel panel-info">
				<div class="panel-heading">
					<strong>用户信息</strong>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><strong>头像</strong></td>
							<td><strong>头像预览</strong></td>
						</tr>
						<tr>
							<td>
								<div class="user">
									<div>									
										<img class="thumbnail" id="avatar_using" src="<s:property value='#session.user.userAvatar_lg'/>"  alt="头像"/>
										<button class="btn btn-default btn-sm " id="file_picker">更换头像</button>
									</div>
								</div>
							</td>
							<td>
								<div id="fileList" class="uploader-list user">
									
								</div>
							</td>
						</tr>
					</table>
					<form class="form-singin">
						<table class="table table-striped">
							<tr>
								<td>用户名</td>
								<td>xufeng</td>
							</tr>
							<tr>
								<td>网站</td>
								<td><input type="text" value="ixufeng.cn" class="form-control"></td>
							</tr>
							<tr>
								<td>QQ</td>
								<td><input type="text" value="1054993687" class="form-control"></td>
							</tr>
							<tr>
								<td>MSN</td>
								<td><input type="text" value="MSN" class="form-control"></td>
							</tr>
							<tr>
								<td>家乡</td>
								<td><input type="text" value="中国" class="form-control"></td>
							</tr>
							<tr>
								<td>公司</td>
								<td><input type="text" value="阿里云" class="form-control"></td>
							</tr>
							<tr>
								<td>自我介绍</td>
								<td><textarea class="form-control"></textarea></td>
							</tr>
						</table>
						<div>
							<button class="btn btn-default pull-right">保存</button>
						</div>
					</form>
				</div>
			</div>
			</div>
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas">
			 	<div class="panel panel-info">
			 		<div class="panel-heading">
			 			注意事项
			 		</div>
			 		<div class="panel-body">
			 			this id body
			 		</div>
			 	</div>
			 	<div class="panel panel-default">
			 		<div class="panel-heading">
			 			<strong>我的标签</strong>
			 			<button class="btn btn-link pull-right">修改</button>
			 		</div>
                    <div class="panel-body">
                        <span class="mark mark-blue"><span></span>提问达人</span>
						<span class="mark mark-orange"><span></span>提问达人</span>
						<span class="mark mark-info"><span></span>提问达人</span>
						<span class="mark mark-black"><span></span>提问达人</span>
                    </div>
                </div>
				<div class="panel panel-default">
			 		<div class="panel-heading"><strong>我的成就</strong></div>
                    <div class="panel-body">
                     	<table class="table">
                     		<tr>
                     			<td>帖子</td>
                     			<td>评论</td>
                     			<td>访问量</td>
                     		</tr>
                     		<tr></tr>
                     	</table>
                    </div>
                </div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="/forum/js/common.js"></script>
	<script type="text/javascript" src="/forum/js/ImgUpload.js"></script>
	
</body>
</html>