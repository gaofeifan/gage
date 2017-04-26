<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="<c:url value="/static/css/bootstrap.css"/>" rel="stylesheet"
	type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value="/static/js/jquery.min.js"/>"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="<c:url value="/static/css/style.css"/>" rel="stylesheet"
	type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- start menu -->
<link href="<c:url value="/static/css/memenu.css"/>" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript"
	src="<c:url value="/static/js/memenu.js"/>"></script>
<script src="<c:url value="/static/js/simpleCart.min.js"/>">
	
</script>
<!-- slide -->
<script src="<c:url value="/static/js/responsiveslides.min.js"/>"></script>
<script src="<c:url value="/static/js/angular.min.js"/>"></script>
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="col-sm-4 world"></div>
				<div class="col-sm-4 logo">
					<a href="index.html"></a>
				</div>

				<div class="col-sm-4 header-left">
					<p class="log">
						<a href="http://localhost:8080/gage/customer/login">登录</a> 
					</p>
					<div class="cart box_1">
						<p>
							<a href="http://localhost:8080/gage/order/index" class="simpleCart_empty">订单管理</a>
						</p>

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span>&nbsp;</span>
				</div>
				<div class="col-sm-8 h_menu4">
					<ul class="memenu skyblue">
						<li class=" grid"><a href="http://localhost:8080/gage/goods/index">主页</a></li>
						<li><a href="http://localhost:8080/gage/shoppingCart/index">我的购物车</a></li>
						<li class="grid"><a href="http://localhost:8080/gage/order/index">我的订单</a></li>

					</ul>
				</div>


			</div>
		</div>
	</div>

	</div>
	<!--content-->
	<div class="content" ng-app="declare">
		<div class="container">
			<div class="content-top">
				<h1>商品列表</h1>
				<div class="content-top1" ng-controller="declareController">
					<div class="col-md-3 col-md2" ng-repeat="x in sumGoods">
						<div class="col-md1 simpleCart_shelfItem">
							<a href="javascript:;"> <img class="img-responsive"
								src="<c:url value="/static/images/pi.png"/>" alt="" />
							</a>
							<h3>
								<a href="#">{{x.goodsName}}</a>
							</h3>
							<div class="price">
								<h5 class="item_price">￥{{x.goodsCurrentPrice}}</h5>
								<a href="javascript:;" id="{{x.id}}"  ng-click="saveCustomerShoppingCart($event,x.id)" class="item_add">加入购物车</a>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div class="container">
						<div class="row clearfix">
							<div class="col-md-12 column">
								<ul class="pagination">
									<li><a href="javascript:;" ng-click="page(1)">首页</a></li>
									<li><a href="javascript:;" ng-click="page($event,currentPage-1)">上一页</a></li>
									<li><a href="javascript:;" ng-click="page($event,currentPage)">当前页</a></li>
									<li><a href="javascript:;" ng-click="page($event,currentPage+1)">下一页</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!--//content-->
	<!--footer-->
	<div class="footer"></div>
	<!--//footer-->

	<script>
		var app = angular.module('declare', []);

		app.controller('declareController', function($scope, $http) {
			$http({
				method : 'GET',
				url : 'http://localhost:8080/gage/goods/selectByInfo'
			}).then(function successCallback(response) {
				console.log(response.data.data);
				$scope.sumGoods = response.data.data.list;
				$scope.currentPage = response.data.data.pageNo;
			}, function errorCallback(response) {
				alert("服务器报错");
			});
			
			 $scope.page = function($event,pages) {
			        $http({
						method : 'GET',
						url : 'http://localhost:8080/gage/goods/selectByInfo',
						params:{pageNo:pages}
					}).then(function successCallback(response) {
						$scope.sumGoods = response.data.data.list;
						$scope.currentPage = response.data.data.pageNo;
						//console.log(response.data.data.list);
					}, function errorCallback(response) {
						alert("服务器报错");
					});
			 }
			 
			 $scope.saveCustomerShoppingCart = function($event,obj){
				 $http({
						method : 'POST',
						url : 'http://localhost:8080/gage/shoppingCart/saveCustomerShoppingCart',
						params:{goodsId:obj,goodsNum:1}
					}).then(function successCallback(response) {
						console.log(response);
						alert(response.data.msg);
					}, function errorCallback(response) {
						alert("服务器报错");
					});
			 }

		});
	</script>
</body>
</html>