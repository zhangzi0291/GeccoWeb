<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" /> 
<title>MAP</title>
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
	<input type="text" id="text" value="长江科技园">
	<input type="text" id="lon" >
	<input type="text" id="lat" >

	<button onclick="searchByStationName()">do</button>
	<button onclick="getpoi()">get</button>
	<button onclick="getInfo()">getInfo</button>
</div>
<div class="container">
	<div id="map"></div> 
</div>
<script type="text/javascript"> 
	var map = new BMap.Map("map"); 
	// 创建地图实例
	var point = new BMap.Point(118.786137,32.090767); 
	// 创建点坐标 
	// 初始化地图，设置中心点坐标和地图级别 
	map.centerAndZoom(point, 15); 
	
	map.enableScrollWheelZoom()
	map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
	map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
	map.addControl(new BMap.MapTypeControl()); 
	map.setCurrentCity("南京"); 
	
	var localSearch = new BMap.LocalSearch(map);
	
 	function getInfoSuccess(data){
		for(i=0;i<data.length;i++){
			var rentinfo=data[i];
			//立刻执行函数
			(function () {
				var point = new BMap.Point(rentinfo.longitude , rentinfo.latitude);
				var houseIcon = new BMap.Icon("${pageContext.request.contextPath}/img/house.png", new BMap.Size(24, 24), {}); 
				var marker = new BMap.Marker(point,{icon: houseIcon}); 
				var opts = {    width : 300,     // 信息窗口宽度
						height: 200,     // 信息窗口高度
						title : rentinfo.mainTitle,  // 信息窗口标题
					} 
				var html = "<div>价格："+rentinfo.housePrice+" 元/月<div>"+
					"<div>房屋类型："+rentinfo.houseType+"<div>   "+
					"<div>地址："+rentinfo.address+"<div>       "+
					"<div>地市："+rentinfo.area1+" - "+rentinfo.area2+" - "+rentinfo.area3+"<div>       "+
					"<a target='_blank' href='"+rentinfo.url+".shtml' >点击跳转</a>"

	 			marker.addEventListener("click", function(){
					var infoWindow = new BMap.InfoWindow(html, opts);  // 创建信息窗口对象 
					map.openInfoWindow(infoWindow, point);      // 打开信息窗口 
				})
				map.addOverlay(marker); 
			})();
			
		}
		console.log("加载完成")
	}
	function getInfo(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/getInfo",
			data:"",
			success:function(data){
				alert(data)
			},
			error:function(){
				alert("error");
			}
		})
	}
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/getAll",
		success:getInfoSuccess
	})
</script>
</body>
</html>