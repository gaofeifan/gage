<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>订单管理-shop</title>
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
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="<c:url value="/static/css/memenu.css"/>" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value="/static/js/memenu.js"/>"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="<c:url value="/static/js/simpleCart.min.js"/>"> </script>
<script src="<c:url value="/static/js/angular.min.js"/>"></script>
<!-- slide -->
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-sm-4 world">
				</div>
				<div class="col-sm-4 logo">
					<a href="index.html"></a>	
				</div>
		
			<div class="col-sm-4 header-left">		
					<p class="log"><a href="http://localhost:8080/gage/customer/login"  >登录</a>
						</p>
					<div class="cart box_1">
						<p><a href="http://localhost:8080/gage/shoppingCart/index" class="simpleCart_empty">我的购物车</a></p>

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span>&nbsp;</span>
				</div>
		 <div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="http://localhost:8080/gage/goods/index">主页</a></li>	
				      <li><a  href="http://localhost:8080/gage/shoppingCart/index">我的购物车</a>
				      	
					</li>
				    <li class="grid"><a  href="http://localhost:8080/gage/order/index">我的订单</a></li>
			
			  </ul> 
			</div>
				
		
		</div>
	</div>
</div>

<!---->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			
			<div class="btn-group" style="margin-bottom: 5px;margin-top: 25px">
				 <button class="btn btn-default" type="button">导出</button>
			</div>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							产品
						</th>
						<th>
							交付时间
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
			<ul class="pagination">
				<li>
					 <a href="#">Prev</a>
				</li>
				<li>
					 <a href="#">1</a>
				</li>
				<li>
					 <a href="#">2</a>
				</li>
				<li>
					 <a href="#">3</a>
				</li>
				<li>
					 <a href="#">4</a>
				</li>
				<li>
					 <a href="#">5</a>
				</li>
				<li>
					 <a href="#">Next</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<!--footer-->
<div class="footer">
</div>
<script type="text/javascript">
var app = angular.module('orderAddressApp', []);

app.controller('orderAddressController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/gage/shoppingCart/selectCustomerShoppingCartAll'
	}).then(function successCallback(response) {
		$scope.sumGoods = response.data.data;
		console.log(response.data.data);
	}, function errorCallback(response) {
		// 请求失败执行代码
	});

});
	
</script>
<!--//footer-->
</body>
</html>