<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>商品展示页面</title>
<link rel="stylesheet" href="<c:url value="/static/css/base.css"/>">
<link rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
<script src="<c:url value="/static/js/angular.min.js"/>"></script>
<script src="<c:url value="/static/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/angular.pagination.js"/>"></script>
<script>
var app = angular.module('declare', []);

app.controller('declareController', function($scope, $http) {
	$scope.sumGoods = ["1","2","3","4","5","6","7","8","9","11","12","13"];
	$http({
		method: 'GET',
		url: 'http://localhost:8080/gage/cb/select.do?id=1'
	}).then(function successCallback(response) {
			$scope.names = "333332";
			console.log(response.data);
		}, function errorCallback(response) {
			// 请求失败执行代码
	});
  
});
</script>
</head>

<body>  
<div ng-app="declare" ng-controller="declareController">
	{{names}}
	<div class="content">
    	<div class="rqtj" >
        	<h2>商品<b>展示</b></h2>
            <ul class="clearfix">
            	<li  ng-repeat="x in sumGoods"><a href=""><img src="<c:url value="/static/images/baoba.jpg"/>" alt=""/></a>
                	<p><a href="">美丽无上限 不到五十元{{x}}</a></p>
                    <div class="border">
                    	<p>$49.00 <b>$189.00</b></p>
                    </div>
                    <p class="bottom">1885人以购买</p>
                </li>
            </ul>
        </div>
    </div>
    </div>
    
    
    <div class="page">
        <ul>
       		<li><a href="#">上一页</a></li>
        	<li><a href="#">首页</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">…</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">下一页</a></li>
        </ul>
    </div>
</body>
</html>
