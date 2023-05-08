<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品牌鞋店</title>
<%
pageContext.setAttribute("c", request.getContextPath());
%>
<script type="text/javascript" src="${c }/static/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${c }/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<link href="${c }/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>

<div style="height: 80px;background-color:#D0D0D0;position:fixed;width: 100%;">
<div style="float: left;width: 500px;margin-left: 50px;">
<h1>品牌鞋店</h1>
</div>
<div style="float: right;;;margin-top: 30px;">
	<div class="container-fluid" style="margin-right: 200px;"> 
	<div class="navbar-header">
	</div>
	<a href="${c }/se"></a>
	</div>
</div>
		
</div>
<div style="margin-top: 100px;float: left;">
<form action="${c }/adselectall" style="width: 200px;margin-left: 700px;margin-top: 200px;" method="post">
	<h2 style="margin-left: 15px;">管理员登录</h2>
		<input type="text" name="name" style="border-radius:5px;">
		<input type="text" name="pwd" style="margin-top: 10px;margin-bottom: 10px;border-radius:5px;">
		<input class="btn btn-primary" type="submit" value="登录" style="border-radius:8px;width: 180px;"><br>
	</form>
</div>
<script type="text/javascript">
alert("${dd}");
</script>
</body>
</html>