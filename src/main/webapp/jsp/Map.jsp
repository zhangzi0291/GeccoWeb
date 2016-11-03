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
	<style type="text/css"> html{height:100%} body{height:100%;margin:0px;padding:0px} #container{height:100%} </style>
</head>
<body>
	<div id="container"></div> 
<script type="text/javascript"> 
	var map = new BMap.Map("container"); 
	// 创建地图实例
	var point = new BMap.Point(118.80942, 32.04603); 
	// 创建点坐标 
	// 初始化地图，设置中心点坐标和地图级别 
	map.centerAndZoom(point, 15); 
	
	map.enableScrollWheelZoom()
	map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
	map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
	map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_TOP_LEFT }));   //右下角，打开
	
	function searchByStationName() {
	　　var keyword = document.getElementById("text_").value;
	　　localSearch.setSearchCompleteCallback(function (searchResult) {
	　　　　var poi = searchResult.getPoi(0);
	　　　　document.getElementById("result_").value = poi.point.lng + "," + poi.point.lat; //获取经度和纬度，将结果显示在文本框中
	　　　　map.centerAndZoom(poi.point, 13);
	　　});
	　　localSearch.search(keyword);
	}
</script>
</body>
</html>