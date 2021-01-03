<%@ page import="pri.cxq.bean.Car" %>
<%@ page import="pri.cxq.bean.Pet" %>
<%@ page import="java.util.Map" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="app.jsp" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link type="text/css" rel="stylesheet" href="css/car_order.css"/>
	<script>
		/**
		 * 购买操作
		 */
		function addCar(car_id,pet_id){
			window.location = "${appPath}/OrderServlet?method=car_add&car_id="+car_id+"&pet_id="+pet_id;
		}
		/**
		 * 取消操作
		 */
		function buy(id) {
			window.location = "${appPath}/CarServlet?method=remove&car_id="+id;
		}
	</script>
</head>
<body>
<div class="body">
	<div class="head">
		<span>我的购物车</span>
		<span><a href="CarServlet?method=check">刷新</a></span>
	</div>
	<div class="content">
		<c:forEach items="${requestScope.cp}" var="cp">
			<div id="message">
				<div class="class1">
					<img id="img" src="images/pet_image/${cp.value.picture}"/>
				</div>
				<div class="class2">
					<div>品种：${cp.value.breed}</div>
					<div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${cp.value.description}</div>
				</div>
				<div class="class3">
					价格：${cp.value.price}
				</div>
				<div class="class4">
					<div>
						${cp.key.formatDate}
					</div>
				</div>
				<div class="class5">
					<button type="button" onclick="addCar(${cp.key.car_id},${cp.value.pet_id})">立即支付</button>
					<button type="button" onclick="buy(${cp.key.car_id})">取消收藏</button>
				</div>
			</div>
		</c:forEach>
	</div>

</div>
</body>
</html>
