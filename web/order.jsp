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
        function addMessage(order_id) {
            var message = prompt("反馈信息", "一切正常");
            if (message != null) {
                window.location = "${appPath}/FeedbackServlet?method=addMessage&order_id=" + order_id + "&message=" + message;
            }
        }
    </script>
</head>
<body>
<div class="body">
    <div class="head">
        <span>我的订单</span>
    </div>
    <div class="content">
        <c:forEach items="${requestScope.op}" var="op">
            <div id="message">
                <div class="class1">
                    <img id="img" src="images/pet_image/${op.value.picture}"/>
                </div>
                <div class="class2">
                    <div>品种：${op.value.breed}</div>
                    <div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${op.value.description}</div>
                </div>
                <div class="class3">
                    价格：${op.value.price}
                </div>
                <div class="class4">
                    <div>
                            ${op.key.formatDate}
                    </div>
                </div>
                <div class="class5">
                    <button style="margin: 80px" type="button" onclick="addMessage(${op.key.order_id})">追加信息</button>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>
