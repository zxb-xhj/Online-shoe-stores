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
<div style="float: right;margin-top: 30px;">
	<div class="container-fluid" style="margin-right: 200px;"> 
	<div class="navbar-header">
	<a  class="btn btn-primary" style="margin-top: 9px;"  disabled="disabled"><span class="glyphicon glyphicon-shopping-cart"></span>购物车</a>
	<a href="${c }/adid" class="btn btn-primary" style="margin-top: 9px;">订单详情</a>
	</div>
	<form action="${c }/adsosou" class="navbar-form navbar-left" role="search">
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
	<li class="active"><a href="${c }/admin1">管理全部鞋子</a></li>
	<li><a href="${c }/adfoot">管理鞋子品牌</a></li>
	
</ul>
<div class="btn-group-vertical">
<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="width: 200px;"> 登录操作<span class="caret"></span>
    </button>
    <div class="dropdown-menu">
        <a style="width: 190px;margin: 5px;" class="btn btn-info" href="${c }/admin"><span class="glyphicon glyphicon-user"></span> 切换账号</a>
        <a style="width: 190px;margin-bottom: 5px;margin-left: 5px;margin-right: 5px;" class="btn btn-info" href="${c }/se">退出登录</a>
    </div>
</div>
</div>
		</div>
<div style="margin-left: 250px;float: left;margin-top: 80px;">
<div style="width: 100%;float: left;">
<form action="${c }/adinsertall" class="navbar-form navbar-left" role="search" style="width: 1400px;margin-right: 200px;" method="post">
  		<label for="firstname" >图片：</label>
        <div class="form-group">
    	<label class="sr-only" for="inputfile">文件输入</label>
    	<input type="file" id="inputfile" name="file">
  		</div>
  		<label for="firstname" >鞋名：</label>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="请输入鞋名" name="name">
        </div>
  		<label for="firstname" >价格：</label>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="请输入价格" name="price">
        </div>
  		<label for="firstname" >品牌名：</label>
        <div class="form-group">
            <select name="hid"  class="form-control">
            	<c:forEach items="${footwear }" var="f">
            	<option value="${f.id }">${f.name }</option>
            	</c:forEach>
            </select>
        </div>
        <div class="form-group">
        <input type="submit" class="btn btn-default" onclick="xinzeng()" value="新增" style="margin-left: 30px;">
        </div>
</form>
</div>
<c:forEach items="${shoes }" var="s">
<div style="float: left;">
<table class="table" style="width: 635px;">
<tr>
		<th class="col-md-3">图片</th>
		<th class="col-md-3">鞋名</th>
		<th class="col-md-2">单价</th>
		<th class="col-md-2">操作</th>
	</tr>
	<tr style="height: 130px;">
		<th><img style="width: 140px;height: 140px;" alt="图片无法找到" src="${c }/img/${s.name }.jpg"></th>
		<th>${s.name }</th>
		
		<th>${s.price }</th>
		<th>
		<a type="submit" class="btn btn-danger" href="${c }/addeletesid/${s.id}/${s.name}" onclick="shanchu()">删除</a><br>
		<a type="submit" class="btn btn-primary" href="${c }/adinsertsid/${s.id}">修改</a>
		</th>
	</tr>
</table>
</div>
</c:forEach>
</div>
</div>
<script type="text/javascript">
alert("${dd}");
function shanchu() {
	alert("删除成功");
}
function xinzeng() {
	alert("新增成功");
}
</script>
</body>
</html>