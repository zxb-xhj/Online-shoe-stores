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
	<a href="${c }/sp" class="btn btn-primary" style="margin-top: 9px;"><span class="glyphicon glyphicon-shopping-cart"></span>购物车 ${i }</a>
	<a href="${c }/id" class="btn btn-primary" style="margin-top: 9px;">订单详情</a>
	</div>
	<form action="${c }/sosou" class="navbar-form navbar-left" role="search" method="post">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="请输入鞋名" name="name">
		</div>
		<button type="submit" class="btn btn-default">搜索</button>
	</form>
	</div>
</div>
		</div>
		<div style="float: left;margin-top: 10px;">
		<div class="btn-group" style="float: left;margin-top: 70px;margin-right: 50px;height: 2000px;position:fixed;">
		<ul class="nav nav-pills nav-stacked" style="width: 200px;">
	<li class="active"><a href="${c }/se">展示全部鞋子</a></li>
	<c:forEach items="${footwear }" var="f">
	<li><a href="${c }/ft/${f.id}">${f.name }</a></li>
	</c:forEach>
	
</ul><a style="width: 200px;" class="btn btn-info" href="${c }/admin">管理员登录</a>
</div>
		</div>
<div style="margin-left: 250px;float: left;margin-top: 80px;">
<c:forEach items="${shopping }" var="s">
<div style="float: left;">
<table class="table" style="width: 635px;">
	<tr>
		<th class="col-md-3">图片</th>
		<th class="col-md-3">鞋名</th>
		<th class="col-md-1">码数</th>
		<th class="col-md-1">单价</th>
		<th class="col-md-2">操作</th>
	</tr>
	<tr style="height: 150px;">
		<th><img style="width: 140px;height: 140px;" alt="图片无法找到" src="${c }/img/${s.name }.jpg"></th>
		<th>${s.name }</th>
		<th>
			${s.code }
		</th>
		<th>${s.price }</th>
		<th><a class="btn btn-danger" href="${c }/deleteid/${s.id }"><span class="glyphicon glyphicon-trash"></span> 删除</a></th>
	</tr>
</table>
</div>
</c:forEach>
</div>
<div style="width: 1280px;background-color:#F0F0F0;float: left;height: 60px;margin-left: 250px;position:fixed;margin-top: 667px;border-radius:10px;">
<div style="float: left;margin-left: 60px;"><h3>共${i }件物品</h3></div>
<div style="float: left;margin-left: 60px;width: 320px;height:68px;overflow: auto;">
<div style="margin: 5px;">
<c:forEach items="${shopping }" var="s">
<p>${s.name }&ensp;${s.code }&ensp;${s.price }</p>
</c:forEach>
</div>
</div>
<div style="float: left;margin-left: 80px;">
	<h2>总价格：${price }元</h2>
</div>
<div style="float: right;;margin-right: 70px;margin-top: 15px;">
	<a href="${c }/tijiao" class="btn btn-primary" onclick="tijiao()">提交订单</a>
</div>
</div>
<script type="text/javascript">
function tijiao() {
	alert("提交成功");
}
	
</script>
</body>
</html>