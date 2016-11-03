<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<%@include file="jstool.jsp"%>
<style type="text/css">
	
</style>
</head>
<body>

	<button id="bt">do</button>
</body>
<script type="text/javascript">
	$("#bt").on("click",function(){
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
	})
</script>
</html>