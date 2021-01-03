<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="../app.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="${appPath}/management/css/message.css"/>
    <script>
        function display(message) {
            alert(message);
        }
    </script>
</head>

<body>
<div class="body">
    <div class="head">
        <span>全部订单</span>
    </div>
    <div id="menu">
        <div>订单编号</div>
        <div>买家</div>
        <div>商品</div>
        <div>购买时间</div>
        <div>反馈信息</div>
    </div>
    <div class="content">
        <c:forEach items="${requestScope.bean}" var="bean">
            <div id="message">
                <div class="class1">
                    <div>${bean.order_id}</div>
                </div>
                <div class="class2">
                    <div>${bean.user_name}</div>
                </div>
                <div class="class3">
                    <div>${bean.breed}</div>
                </div>
                <div class="class4">
                    <div style="margin-top: 15px">${bean.create_date}</div>
                </div>
                <div class="class5">
                    <div>
                        <button type="button" onclick="display('${bean.feedbackMessage}')">查看</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>
