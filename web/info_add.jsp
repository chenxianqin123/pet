<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="app.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人信息更改</title>
    <link type="text/css" rel="stylesheet" href="css/info_add.css">
    <%--		返回上一页--%>
    <script>
        var jump = function () {
            // history.back(-1);//数据刷新
            history.go(-1);//表单数据不刷新
        }
    </script>
</head>
<body>
<div class="content">
    <!-- 标题 -->
    <div class="title">
        <span>个人信息</span>
    </div>
    <!-- 表单 -->
    <form action="${appPath}/InfoServlet?method=${requestScope.method == "add"?"add":"update"}" method="post"
          enctype="multipart/form-data">
        <div class="form">
            <!-- 左边部分 -->
            <div class="left">
                <table>
                    <tr>
                        <th>姓名：</th>
                        <td>
                            <input type="text" name="realname" value="${info.getRealname()}">
                        </td>
                    </tr>
                    <tr>
                        <th>性别：</th>
                        <td>
                            <c:if test="${empty info}">
                                <input type="radio" name="sex" value="男">男
                                <input type="radio" name="sex" value="女">女
                            </c:if>
                            <c:if test="${info.sex == '男'}">
                                <input type="radio" name="sex" value="男" checked>男
                                <input type="radio" name="sex" value="女">女
                            </c:if>
                            <c:if test="${info.sex == '女'}">
                                <input type="radio" name="sex" value="男">男
                                <input type="radio" name="sex" value="女" checked>女
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>出生日期：</th>
                        <td id="birthday">
                            <span><input name="year" type="text" value="">年</span>
                            <span><input name="month" type="text" value="">月</span>
                            <span><input name="day" type="text" value="">日</span>
                        </td>
                    </tr>
                    <tr>
                        <th>手机：</th>
                        <td>
                            <input name="telephone" type="text" value="${info.getTelephone()}">
                        </td>
                    </tr>
                    <tr>
                        <th>邮箱：</th>
                        <td>
                            <input name="email" type="text" value="${info.getEmail()}">
                        </td>
                    </tr>
                    <tr>
                        <th>默认地址：</th>
                        <td>
                            <input name="address1" type="text" value="${info.getAddress1()}">
                        </td>
                    </tr>
                    <tr>
                        <th>备用地址：</th>
                        <td>
                            <input name="address2" type="text" value="${info.getAddress2()}">
                        </td>
                    </tr>
                </table>
                <div>
                    <input id="save" type="submit" value="保存">
                    <input id="cancel" type="button" onclick="jump()" value="取消">
                </div>
            </div>
            <!-- 右边部分 -->
            <div class="right">
                <img src="images/info_image/head.jpg">
                <br>
                <a href="javascript:;" class="a-upload">
                    <input type="file" name="picture" id="img">
                </a>
            </div>
        </div>
    </form>
</div>
</body>
</html>