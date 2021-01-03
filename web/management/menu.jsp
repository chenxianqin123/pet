<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="../app.jsp"%>
<html lang="en">
<head>
    <title>后台管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<%
    session.setAttribute("management",true);
%>

<body>
<div id="loading">
    <div></div>
    <div></div>
    <span></span>
</div>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand"><a href="index.jsp"><img src="images/menu_image/logo-dark.png" alt="Klorofil Logo"
                                                    class="img-responsive logo"></a></div>
        <div class="container-fluid">
            <div class="navbar-btn" style="padding: 0; padding-top: 10px;">
                <button type="button" class="btn-toggle-fullwidth btn-toggle-mx"><img src="images/menu_image/left.png"
                                                                                      height="40px" alt=""></button>
            </div>
        </div>
    </nav>
    <!-- END NAVBAR -->
    <!--_________________________________________________________________________________________-->
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <!--                    <li><a href="DisplayAllServlet?method=default&sort=all" target="_blank"-->
                    <!--                           class="iframe_link active"><span>全部信息</span></a></li>-->
                    <li><a href="javascript:;" class="nav-togg"> <span>管理数据</span> </a>
                        <div>
                            <ul>
                                <li><a href="${appPath}/DisplayAllServlet?method=default&sort=all" target="_blank"
                                       class="iframe_link"><span>全部信息</span></a></li>
                                <li><a href="pet_info.jsp" target="_blank"
                                       class="iframe_link"><span>上传信息</span></a></li>
                            </ul>
                        </div>
                    <li><a href="${appPath}/FeedbackServlet?method=check" target="_blank" class="iframe_link"><span>用户反馈</span></a></li>
                    <!--                    <li><a href="OrderServlet?method=check" target="_blank" class="iframe_link"> <span>我的订单</span></a>-->
                    </li>
                    <li><a href="../index.jsp" class="nav-togg"> <span>返回主页</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="main">
        <div class="main-content" style="height: 100%;">
            <iframe src="${appPath}/DisplayAllServlet" class="iframe_mx uicss-cn"></iframe>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script src="js/klorofil-common.js"></script>

</body>
</html>