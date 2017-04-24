<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>购物车-shop</title>
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
					<p class="log"><a href="account.html"  >登录</a>
						<span>|</span><a  href="account.html"  >注册</a></p>
					<div class="cart box_1">
						<a href="http://localhost:8080/gage/order/address/orderAddress" class="simpleCart_empty">地址管理</a>
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
				      <li><a  href="http://localhost:8080/gage/shoppingCart/initShoppingCart">我的购物车</a>
				      	
					</li>
				    <li class="grid"><a  href="#">我的订单</a></li>
			
			  </ul> 
			</div>
				
		
		</div>
	</div>
</div>

</div>
<!---->
<div class="container" ng-app = "chechoutApp">
	<div class="check-out" ng-controller="checkController">
		<h1>购物车</h1>
    	    <table >
		  <tr>
			<th>商品项目</th>
			<th>数量</th>		
			<th>单价</th>
			<th>详情</th>
			<th>总价格</th>
		  </tr>
		  <tr ng-repeat="x in sumGoods">
			<td class="ring-in"><a href="single.html" class="at-in"><img src="<c:url value="/static/images/ce.jpg"/>" class="img-responsive" alt=""></a>
			<div class="sed">
				<h5>Sed ut perspiciatis unde</h5>
				<p>(At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium) </p>
			
			</div>
			<div class="clearfix"> </div></td>
			<td class="check"><input type="text" value="{{x.goodsNum}}"  onblur="if (this.value == '') {this.value ='';}"/></td>		
			<td>{{x.shopGoods.goodsCurrentPrice}}</td>
			<td>FREE SHIPPING</td>
			<td>{{x.shopGoods.goodsCurrentPrice*x.goodsNum}}</td>
		  </tr>
	</table>
	<a href="#" class=" to-buy">去下单</a>
	<div class="clearfix"> </div>
    </div>
</div>
<!--footer-->
<div class="footer">
</div>
<script type="text/javascript">
var app = angular.module('chechoutApp', []);

app.controller('checkController', function($scope, $http) {
	//$scope.sumGoods = ["1","2","3","4","5","6","7","8","9","11","12","13"];
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