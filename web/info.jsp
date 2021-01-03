<%@ page import="pri.cxq.bean.Info" %>
<%@ page import="java.util.Date" %>
<%@ page import="pri.cxq.utils.DateUtils" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="app.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>我的信息</title>
    <link type="text/css" rel="stylesheet" href="css/info.css">
</head>
<body>
<div class="content">
    <!-- 标题 -->
    <div class="title">
        <span>我的信息</span>
        <span id="return"><a href="index.jsp">返回主页</a></span>
        <span id="update"><a href="info_add.jsp">修改</a></span>
        <span id="delete"><a href="${appPath}/QuitServlet?method=remove">注销</a></span>
    </div>
    <div class="message">
        <!-- 头像 -->
        <div class="left">
            <c:if test="${empty info.getPicture()}">
                <img src="images/info_image/head.jpg">
            </c:if>
            <c:if test="${not empty info.getPicture()}">
                <img src="${appPath}/images/info_image/${info.getPicture()}">
            </c:if>
        </div>
        <!-- 个人信息 -->
        <div class="right">
            <table>
                <tr>
                    <th>姓名：</th>
                    <td>${info.getRealname()}</td>
                </tr>
                <tr>
                    <th>性别：</th>
                    <td>${info.getSex()}</td>
                </tr>
                <tr>
                    <th>出生日期：</th>
                    <td>
                        <fmt:formatDate value="${info.getBirthday()}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <th>手机：</th>
                    <td>${info.getTelephone()}</td>
                </tr>
                <tr>
                    <th>邮箱：</th>
                    <td>${info.getEmail()}</td>
                </tr>
                <tr>
                    <th>默认地址：</th>
                    <td>${info.getAddress1()}</td>
                </tr>
                <tr>
                    <th>备用地址：</th>
                    <td>${info.getAddress2()}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>