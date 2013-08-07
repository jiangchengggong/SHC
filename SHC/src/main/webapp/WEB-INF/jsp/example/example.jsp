<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="${jspath}/jquery-2.0.3.min.js"></script>
<title>example</title>
</head>
<script type="text/javascript">
function getUser(id){
	$.post(
			"${webcontext}/page/getUser",
			{"id":id},
			function(data){
				
				$("#userName").html(data.account);
			}
	);
}
</script>
<body>
	开发几个简单的测试样例：
	<ul>
		<li><a href="#" onclick="javascript:getUser('ddd');">ajax获取用户数据</a></li>
		<li><a href="${webcontext}/page/toRegisterPage" >注册上传头像</a></li>
		<li><a href="${webcontext}/page/toUpload" >mvc上传</a>
		</li>

	</ul>
	userName:<span id="userName"></span>
</body>

</html>