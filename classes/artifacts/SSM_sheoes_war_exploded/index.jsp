<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<jsp:forward page="/se"></jsp:forward>
</head>
<body>
<div id="div1">nnnnn</div>
<div id="div2">nnnnn</div>


<form action="login" method="post" id="f1">
	用户名：<input type="text" name="ename"><br>
	密码：<input type="text" name="password"><br>
	 <input type="submit" value="登录" id="dd">
</form>
<p>你好</p>
<a href="zhuce.jsp">注册</a>
<a href="wangji.jsp">忘记密码</a>
<script type="text/javascript">
	$(document).ready(function(){
		$("#div1").click(function(){
			
		});
	});
</script>
</body>
</html>