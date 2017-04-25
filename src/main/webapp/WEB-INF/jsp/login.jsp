<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Account</title>
<link href="<c:url value="/static/css/bootstrap.css"/>" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value="/static/js/jquery.min.js"/>"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<link href="<c:url value="/static/css/memenu.css"/>" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value="/static/js/memenu.js"/>"></script>
<script src="<c:url value="/static/js/simpleCart.min.js"/>"> </script>
<!-- slide -->
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="col-md-4 header-left">		
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-md-2 number">
					<span></span>
				</div>
		  <div class="col-md-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="http://localhost:8080/gage/goods/index">主页</a></li>	
				      <li><a  href="#">联系方式</a>
				      	<div class="mepanel">
						</div>
					</li>
				    <li class="grid"><a  href="#">公司介绍</a>
			    </li>
			  </ul> 
			</div>
		<div class="clearfix"> </div>
	<!---->		
		</div>
	</div>
</div>
<!--//header-->
<div class="account">
	<div class="container">
		<h1>用户登录</h1>
		<div class="account_grid">
			   <div class="col-md-6 login-right">
				<form>

					<span>用户名</span>
					<input type="text"> 
				
					<span>密　码</span>
					<input type="text"> 
					<div class="word-in">
				  		<a class="forgot" href="#"></a>
				 		 <input type="submit" value="Login">
				  	</div>
			    </form>
			   </div>	
			    <div class="col-md-6 login-left">
			  	 <img alt="" src="<c:url value="/static/images/aaa.jpg"/>"/>
			   </div>
			   <div class="clearfix"> </div>
			 </div>
	</div>
</div>

<!--footer-->
<div class="footer">
						
</div>

<!--//footer-->
</body>
</html>