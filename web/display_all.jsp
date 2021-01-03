<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="app.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <!-- 图标 css文件 -->
    <link rel="stylesheet" type="text/css" href="css/font-awesome.css"/>
    <link type="text/css" rel="stylesheet" href="css/pages.css"/>
    <script>
        /**
         * 加入购物车操作
         */
        function addCar(id) {
            window.location = "${appPath}/CarServlet?method=add&pet_id=" + id;
        }

        /**
         * 购买操作
         */
        function buy(id) {
            window.location = "${appPath}/OrderServlet?method=add&pet_id=" + id;
        }

        /**
         * 下架操作
         */
        function remove(id) {
            window.location = "${appPath}/PetServlet?method=remove&pet_id=" + id;
        }
    </script>
</head>
<body>
<div class="body">
    <div class="head">
        <c:if test="${requestScope.sort == \"all\"}">
            <span>全部信息</span>
        </c:if>
        <c:if test="${requestScope.sort == \"dog\"}">
            <span>狗狗信息</span>
        </c:if>
        <c:if test="${requestScope.sort == \"cat\"}">
            <span>猫咪信息</span>
        </c:if>
        <%--        普通用户查看--%>
        <c:if test="${empty sessionScope.management}">
            <c:if test="${requestScope.method == \"ranking\"}">
                <span>已按价格排序</span>
            </c:if>
            <c:if test="${requestScope.method == \"default\"}">
                <span><a href="DisplayAllServlet?sort=${requestScope.sort}&method=ranking">按价格排序</a></span>
            </c:if>
        </c:if>
        <%--        管理员查看--%>
        <c:if test="${not empty sessionScope.management}">
            <span><a href="${appPath}/DisplayAllServlet">刷新</a></span>
        </c:if>
    </div>
    <div class="content">
        <c:forEach items="${requestScope.pageBean.lists}" var="pet">
            <div id="message">
                <div class="class1">
                    <img id="img" src="images/pet_image/${pet.picture}"/>
                </div>
                <div class="class2">
                    <div>品种：${pet.breed}</div>
                    <div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${pet.description}</div>
                </div>
                <div class="class3">
                    数量：${pet.number}
                </div>
                <div class="class4">
                    价格:${pet.price}
                </div>
                <div class="class5">
                        <%--普通用户--%>
                    <c:if test="${not empty sessionScope.management}">
                        <button style="margin-top: 75px" type="button" onclick="remove(${pet.pet_id})">下架</button>
                    </c:if>
                        <%--管理员--%>
                    <c:if test="${empty sessionScope.management}">
                        <button type="button" onclick="addCar(${pet.pet_id})">加入购物车</button>
                        <button type="button" onclick="buy(${pet.pet_id})">立即购买</button>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="tail">
        <div class="tail-content">
            <span><a href="javascript:firstPage()">首页</a></span>
            <span><a href="javascript:beforePage()">上一页</a></span>
            <span>共${requestScope.pageBean.totalPages}页</span>
            <span>总共${requestScope.pageBean.totalRows}条记录</span>
            <span>第${requestScope.pageBean.currentPage}页</span>
            <span><a href="javascript:afterPage()">下一页</a></span>
            <span><a href="javascript:lastPage()">尾页</a></span>
        </div>
        <script>
            function firstPage() {
                window.location = "${appPath}/DisplayAllServlet?pageSize=${requestScope.pageBean.pageSize}&currentPageStr=1&method=${requestScope.method}&sort=${requestScope.sort}&researchText=${requestScope.researchText}";
            }

            function lastPage() {
                window.location = "${appPath}/DisplayAllServlet?pageSize=${requestScope.pageBean.pageSize}&currentPageStr=${requestScope.pageBean.totalPages}&method=${requestScope.method}&sort=${requestScope.sort}&researchText=${requestScope.researchText}";
            }

            function beforePage() {
                window.location = "${appPath}/DisplayAllServlet?pageSize=${requestScope.pageBean.pageSize}&currentPageStr=${requestScope.pageBean.beforePage}&method=${requestScope.method}&sort=${requestScope.sort}&researchText=${requestScope.researchText}";
            }

            function afterPage() {
                window.location = "${appPath}/DisplayAllServlet?pageSize=${requestScope.pageBean.pageSize}&currentPageStr=${requestScope.pageBean.afterPage}&method=${requestScope.method}&sort=${requestScope.sort}&researchText=${requestScope.researchText}";
            }
        </script>
    </div>
</div>
</body>
</html>
