<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" /> 
<title>Document</title>
<%@include file="jstool.jsp"%>	
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KNirOdmVyGq97BwA3gctRv2qatfYurGu"></script>
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

.container {
	height: 90%;
	width: 100%;
	position : absolute;
	bottom: 0px;
	right:auto;
	position: absolute;
}

#map {
	height: 100%;
	position: relative;
}
</style>
</head>
<body>
<div>
	<input type="text" id="text" >
	<input type="text" id="lon" >
	<input type="text" id="lat" >
	<button onclick="searchByStationName()">do</button>
</div>
<div class="container">
	<div id="map"></div> 
</div>
<script type="text/javascript"> 
	var map = new BMap.Map("map"); 
	// 创建地图实例
	var point = new BMap.Point(118.80942, 32.04603); 
	// 创建点坐标 
	// 初始化地图，设置中心点坐标和地图级别 
	map.centerAndZoom(point, 20); 
	
	map.enableScrollWheelZoom()
	map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
// 	map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
	map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_TOP_RIGHT }));   //右下角，打开
	
	var localSearch = new BMap.LocalSearch(map);
// 	localSearch.enableAutoViewport(); //允许自动调节窗体大小
	
	function searchByStationName() {
		var keyword =  $("#text").val();
		localSearch.setSearchCompleteCallback(function(searchResult) {
			var poi = searchResult.getPoi(0);
		 $("#lon").val(poi.point.lng);
		 $("#lat").val(poi.point.lat);
					 //获取经度和纬度，将结果显示在文本框中
			map.centerAndZoom(poi.point, 13);
		});
		localSearch.search(keyword);
	}
</script>
</body>
</html>