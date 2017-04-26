<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>购物车-shop</title>
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
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="<c:url value="/static/js/simpleCart.min.js"/>">
	
</script>
<script src="<c:url value="/static/js/angular.min.js"/>"></script>
<!-- slide -->
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
						<a href="http://localhost:8080/gage/order/index"
							class="simpleCart_empty">订单管理</a>
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
						<li class=" grid"><a
							href="http://localhost:8080/gage/goods/index">主页</a></li>
						<li><a
							href="http://localhost:8080/gage/shoppingCart/index">我的购物车</a>

						</li>
						<li class="grid"><a href="http://localhost:8080/gage/order/index">我的订单</a></li>

					</ul>
				</div>


			</div>
		</div>
	</div>

	</div>
	<!---->
	<div class="container" ng-app="chechoutApp">
		<div class="check-out" ng-controller="checkController">
			<h1>购物车</h1>
			<table>
				<tr>
					<th>商品项目</th>
					<th>数量</th>
					<th>单价</th>
					<th>详情</th>
					<th>操作</th> 
				</tr>
				<tr ng-repeat="x in sumGoods.shopGoods">
					<td class="ring-in"><a href="#" class="at-in"><img
							src="<c:url value="/static/images/ce.jpg"/>"
							class="img-responsive" alt=""></a>
						<div class="sed">
							<h5>{{x.goodsName}}</h5>
							<p>{{x.goodsDetails}}</p>

						</div>
						<div class="clearfix"></div></td>
					<td class="check"><input type="text" ng-value="{{x.goodsNum}}"
						ng-model="currentValue" id="input_{{x.id}}_{{x.shopGoods.id}}"
						ng-blur="goodsAll($event,sumGoods.id,x.id,currentValue,x.goodsNum)" />
					<td>￥{{x.goodsCurrentPrice}}</td>
					<td>{{x.goodsDetails}}</td>
					<td>
					<a href="javascript:;" ng-click="delShoppingCart(x.id)">删除</a>
					</td>
				</tr>
			</table>
			<a href="javascript:;" ng-click="toBuy()" class=" to-buy">去下单</a>总金额：￥{{totalPrice}}
			<div class="clearfix"></div>
			<br/>
			<div class="container" >
			<div class="row clearfix">
				<div class="col-md-12 column" >
					<h3>地址添加</h3>
					<br>
					<form role="form">
						<div class="form-group">
							<label for="exampleInputEmail1">收件人</label><input type="text"
								class="form-control" id="addressNameId" ng-model="orderAddress.name" set-Focus="" style="width: 150px" />
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">联系电话：</label><input type="tel"
								class="form-control" id="phoneId" ng-model="orderAddress.phone"
								style="width: 150px" />
						</div>
						<div class="form-group">
							<label for="exampleInputFile">收件人地址</label><input type="text"
								class="form-control" id="addressId" ng-model="orderAddress.addressDesc"
								style="width: 300px" />
						</div>
						<button type="submit" class="btn btn-default" ng-click="saveAddress($event)">提交</button>
					</form>
				</div>
			</div>
		</div>
		</div>
	</div>
	<!--footer-->
	<div class="footer">
		
	</div>
	<script type="text/javascript">
	var addressId = "";
	var shoppingCartId = "";
	var goodslength = 0;
		var app = angular.module('chechoutApp', []);
		app.directive('setFocus', function(){
	          return function(scope, element){
	            element[0].focus();
	          };
	    });
		app.controller('checkController',function($scope, $http) {
			$http({
				method : 'GET',
				url : 'http://localhost:8080/gage/shoppingCart/selectCustomerShoppingCartAll'
				}).then(function successCallback(response) {
				$scope.sumGoods = response.data.data;
				console.log(response.data);
				shoppingCartId = response.data.data.id;
				var goodsList = response.data.data.shopGoods;
				var len = goodsList.length;
				goodslength = len;
				var value = 0.00;
				for(var i = 0 ;i < len ;i++){
					value +=goodsList[i].goodsCurrentPrice*goodsList[i].goodsNum;
				}
				$scope.totalPrice = value;
				}, function errorCallback(response) {
								// 请求失败执行代码
				});
				$scope.goodsAll = function($event, shopCartId,
						goodsId, currentValue, goodsNum) {
					if (currentValue == undefined) {
						return;
					} else {
					if (goodsNum == currentValue) {
						return;
					}
					$http(
							{
								method : 'POST',
								url : 'http://localhost:8080/gage/shoppingCart/updateCustomerShoppingCart',
								params : {
									goodsId : goodsId,
									goodsNum : currentValue
								}
							}).then(
							function successCallback(response) {
								console.log(response.data.code);
								if(response.data.code == 200){
									$http({
										method : 'GET',
										url : 'http://localhost:8080/gage/shoppingCart/selectCustomerShoppingCartAll'
										}).then(function successCallback(response) {
										var goodsList = response.data.data.shopGoods;
										var len = goodsList.length;
										var value = 0.00;
										for(var i = 0 ;i < len ;i++){
											value +=goodsList[i].goodsCurrentPrice*goodsList[i].goodsNum;
										}
										$scope.totalPrice = value;
										}, function errorCallback(response) {
														// 请求失败执行代码
										});
								}
								
							},
							function errorCallback(response) {
								// 请求失败执行代码
							});
				}
			}
				
				
				$scope.saveAddress = function($event) {
					var o = confirm("您确定要提交吗?");
					if(!o){
						return ;
					}else{ 
						$http(
								{
									method : 'POST',
									url : 'http://localhost:8080/gage/order/address/saveOrderAddress',
									params : {name:$scope.orderAddress.name,phone:$scope.orderAddress.phone,addressDesc:$scope.orderAddress.addressDesc,shoppingCartId:shoppingCartId}
								}).then(
								function successCallback(response) {
									// 如果连接成功，延时返回给调用者  
									console.log(response.data.data);
									addressId = response.data.data;
									//alert(addressId);
									if(addressId!=""){
										alert("可以去下单了");
									}
								},
								function errorCallback(response) {
									alert('连接服务器出错！');
								});
					}
				}
				
				$scope.delShoppingCart = function(goodsId){
					$http({
						method : 'GET',
						url : 'http://localhost:8080/gage/shoppingCart/deleteCartItem',
						params : {goodsId:goodsId}
						}).then(function successCallback(response) {
							console.log(response);
							if(response.status == 200){//删除成功后重新刷新数据
								$http({
									method : 'GET',
									url : 'http://localhost:8080/gage/shoppingCart/selectCustomerShoppingCartAll'
									}).then(function successCallback(response) {
									$scope.sumGoods = response.data.data;
									console.log(response.data);
									shoppingCartId = response.data.data.id;
									var goodsList = response.data.data.shopGoods;
									var len = goodsList.length;
									goodslength = len;
									var value = 0.00;
									for(var i = 0 ;i < len ;i++){
										value +=goodsList[i].goodsCurrentPrice*goodsList[i].goodsNum;
									}
									$scope.totalPrice = value;
									}, function errorCallback(response) {
													// 请求失败执行代码
									});
							}
						}, function errorCallback(response) {
										// 请求失败执行代码
						});
				}
				
				//去下单事件
				$scope.toBuy = function(){
					if(goodslength == 0){
						alert("购物车无商品，请添加到商品到购物车后再下单");
						location="http://localhost:8080/gage/goods/index";
						return ;
					}
					if(addressId==""){
						alert("请先添加地址");
						return ;
					}
					$http({
						method : 'POST',
						url : 'http://localhost:8080/gage/order/saveOrderBasic',
						params:{orderAddressId:addressId}
						}).then(function successCallback(response) {
							console.log(response);
						}, function errorCallback(response) {
										// 请求失败执行代码
						});
					
					
					
					
				}
				
				
				
				

		});

				
	</script>
	<!--//footer-->
</body>
</html>