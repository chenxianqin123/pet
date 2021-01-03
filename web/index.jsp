<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="app.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>宠物商城</title>
    <!-- 图标 css文件 -->
    <link rel="stylesheet" type="text/css" href="css/font-awesome.css"/>
    <!-- 主页面 css文件 -->
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<!-- 顶部 -->
<div class="head-top">
    <div class="w-max">
        <!-- 左边信息 -->
        <div class="head-t1">
            <p>
                <a href="index.jsp"><i class="fa fa-home"></i>宠物乐园</a>
            </p>
            <p>送至</p>
            <p>重庆<i class="fa fa-angle-down"></i></p>
            <p><a target="_blank" href="http://www.epet.com/zhengpin/main.html?do=newgoods"><i
                    class="fa fa-handshake-o"></i>诚信有保障</a></p>
        </div>
        <%-- 显示用户名--%>
        <c:if test="${not empty sessionScope.user}">
            <p id="username">${sessionScope.user.user_name},欢迎您</p>

        </c:if>
        <!-- 右边信息 -->
        <ul class="head-t2">
            <c:if test="${empty sessionScope.user}">
                <li><a href="login.html" target="_self">[登陆]</a></li>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
                <li><a href="${appPath}/QuitServlet?method=quit">[退出]</a></li>
                <li><a href="${appPath}/InfoServlet?method=isExist"><i class="fa fa-star"></i>我的信息</a></li>
                <li><a href="menu.jsp"><i class="fa fa-shopping-cart"></i>购物大厅</a></li>
                <li><a href="${appPath}/ManageServlet"><i class="fa fa-user"></i>我是管理员</a></li>
            </c:if>
        </ul>
    </div>
    <div style="line-height: 35px; right: 50px;"><a> </a></div>
</div>
<!-- 页面导航部分 -->
<div class="head-body">
    <!-- 标题 -->
    <div class="head-body-title">
        <div class="w-max">
            <!-- logo -->
            <div class="logo">
                <a href="index.jsp">
                    <img src="images/index_image/logo.jpg"/>
                </a>
            </div>
            <!-- 搜索框 -->
            <form class="form" action="">
                <div>
                    <input name="" type="text" maxlength="100" placeholder="大型犬"/>
                    <button type="submit" value="true">搜索</button>
                </div>
                <div class="keywards">
                    <lable>热门搜索：</lable>
                    <a href="#">狗狗</a>
                    <span>|</span>
                    <a href="#">猫咪</a>
                    <span>|</span>
                    <a href="#">阿拉斯加</a>
                    <span>|</span>
                    <a href="#">柴犬</a>
                    <span>|</span>
                    <a href="#">英短</a>
                </div>
            </form>
            <!-- 购物车 -->
            <div class="go-buy fr">
                <a class="c666" href="menu.jsp"><i
                        style="color: #459D36; font-size: 40px; margin-right: 10px;"
                        class="fa fa-shopping-cart"></i>购物车</a>
            </div>
        </div>
    </div>
    <!-- 菜单 -->
    <div class="head-menu-list">
        <div class="w-max">
            <ul class="menus">
                <li><i class="fa fa-paper-plane"></i>首页</li>
                <li><i class="fa fa-paper-plane"></i>狗狗</li>
                <li><i class="fa fa-paper-plane"></i>猫咪</li>
                <li><i class="fa fa-paper-plane"></i>血统</li>
                <li><i class="fa fa-paper-plane"></i>门店</li>
                <li><i class="fa fa-paper-plane"></i>百科</li>
            </ul>
        </div>
    </div>

    <!-- 轮播 -->
    <div class="head-bottom">
        <div class="w-max">
            <!-- 轮播左边部分 -->
            <div class="wheel-left">
                <div><a href="javascript:;"><img
                        src="https://img2.epetbar.com/nowater/2019-09/10/18/4bca3d080f8d1f38eb742903fd5eb816.jpg"
                        alt=""></a></div>
                <div><a href="javascript:;"><img
                        src="https://img2.epetbar.com/nowater/2019-04/10/14/4ce4896824469d8704012768bbaf9b1e.png"
                        alt=""></a></div>
                <div><a href="javascript:;"><img
                        src="https://img2.epetbar.com/nowater/2018-05/02/11/daec91842077d2a1bfd284338be45707.png"
                        alt=""></a></div>
            </div>
            <div class="container">
                <div class="carousel">
                    <iframe style="width: 800px;height: 400px;border: none;position: relative; right: 40px; top: 20px;" src="banner.html"></iframe>
                </div>
            </div>

            <!-- 轮播右边部分 -->
            <div class="wheel-right">
                <div><a href="javascript:;"><img
                        src="https://img2.epetbar.com/nowater/2019-09/10/18/4bca3d080f8d1f38eb742903fd5eb816.jpg"
                        alt=""></a></div>
                <div><a href="javascript:;"><img
                        src="https://img2.epetbar.com/nowater/2019-04/10/14/4ce4896824469d8704012768bbaf9b1e.png"
                        alt=""></a></div>
                <div><a href="javascript:;"><img
                        src="https://img2.epetbar.com/nowater/2018-05/02/11/daec91842077d2a1bfd284338be45707.png"
                        alt=""></a></div>
            </div>
        </div>
    </div>
</div>
<!-- 页面内容区域部分 -->
<div class="content">
    <div class="w-max">
        <!-- 上 -->
        <div class="content-top">
            <div>
                <i class="fa fa-shopping-bag"></i>购宠大厅
            </div>
        </div>
        <!-- 中 -->
        <div class="content-middle">
            <!-- 左边部分 -->
            <div class="content-middle-left">
                <img src="images/index_image/pet.jpg" alt="">
            </div>
            <!-- 右边部分 -->
            <div class="content-middle-right">
                <ul>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201607/10173400/508a5e87-f7b4-4957-a59d-06bedd86ebc8-medium.jpg"
                                 alt="">
                        </div>
                        <div>博美 可爱乖巧</div>
                        <div>￥1290.00</div>
                    </a></li>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201607/10172301/82b1892b-fc66-4742-89aa-7b7b9b89ef5e-medium.jpg"
                                 alt="">
                        </div>
                        <div>边牧 聪明勇敢</div>
                        <div>￥1100.00</div>
                    </a></li>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201803/10230900/cd60c957-c82e-4262-9545-f39d29db8b34-medium.jpg"
                                 alt="">
                        </div>
                        <div>柴犬 微笑天使</div>
                        <div>￥798.00</div>
                    </a></li>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201407/10107103/44146cf5-cf3a-4d66-ba95-701cad23c9d9-medium.jpg"
                                 alt="">
                        </div>
                        <div>阿拉斯加 傻狗一个</div>
                        <div>免费</div>
                    </a></li>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201905/10446200/e5a033f8-9e71-497d-8c3e-8c87059eb0f1-medium.jpg"
                                 alt="">
                        </div>
                        <div>英短银渐层 爱睡</div>
                        <div>￥2000.00</div>
                    </a></li>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201905/10446000/780fc58a-2a90-4f07-a5f7-46a39d617276-medium.jpg"
                                 alt="">
                        </div>
                        <div>英短蓝猫 爱主人</div>
                        <div>￥1180.00</div>
                    </a></li>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201904/10433600/84bebdfb-846b-4d7c-ba32-ae199b3902a1-medium.jpg"
                                 alt="">
                        </div>
                        <div>缅因猫 肤白貌美</div>
                        <div>￥1675.00</div>
                    </a></li>
                    <li><a href="menu.jsp">
                        <div>
                            <img src="http://www.baobeita.com/upload/image/product/201904/10429800/df01ae56-0c6b-4f5e-af4f-977484c24475-medium.jpg"
                                 alt="">
                        </div>
                        <div>布偶猫 高贵冷艳</div>
                        <div>￥2000.00</div>
                    </a></li>
                </ul>
            </div>
        </div>
        <!-- 下 -->
        <div class="content-bottom">
            <ul>
                <li><img
                        src="http://img2.epetbar.com/nowater/brand_logo/2018-01/17/15/dcdd9aa566992eae9360447c5da128c5.jpg?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
                <li><img
                        src="http://img2.epetbar.com/brand/brandLogo/upload_file_1562131788.jpg?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
                <li><img
                        src="http://img2.epetbar.com/brand/brandLogo/upload_file_1545041192.jpg?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
                <li><img
                        src="http://img2.epetbar.com/brand/brandLogo/upload_file_1547004718.jpg?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
                <li><img
                        src="http://img2.epetbar.com/brand/brandLogo/upload_file_1547015305.jpg?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
                <li><img
                        src="http://img2.epetbar.com/brand/brandLogo/upload_file_1562639814.jpg?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
                <li><img
                        src="http://img2.epetbar.com/brand/brandLogo/purchase_suppliers_file_1536301115.png?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
                <li><img
                        src="http://img2.epetbar.com/brand/brandLogo/upload_file_1550045070.jpg?x-oss-process=style/fill&$1=100&$2=48"
                        alt=""></li>
            </ul>
        </div>
    </div>
</div>

<!-- <!-- 页面尾部信息部分 -->
<div class="tail">
    <div class="w-max">
        <!-- 第一个部分 -->
        <div class="tail-fisrt">
            <ul type="none">
                <li><a href=""><i class="fa fa-paper-plane"></i>正品保障</a></li>
                <li><a href=""><i class="fa fa-paper-plane"></i>品类丰富</a></li>
                <li><a href=""><i class="fa fa-paper-plane"></i>优质服务</a></li>
                <li><a href=""><i class="fa fa-paper-plane"></i>科学养宠</a></li>
                <li><a href=""><i class="fa fa-paper-plane"></i>E宠公益</a></li>
                <li><a href=""><i class="fa fa-paper-plane"></i>十年同心</a></li>
            </ul>
        </div>
        <!-- 第二个部分 -->
        <div class="tail-second">
            <div class="tail-second-1">
                <img src="https://static.epetbar.com/www/newFooter/dog_phone.gif" alt="">
                <div>
                    <h4>售后电话：</h4>
                    <p>4008889200「免长途费」</p>
                    <p>023-68851700</p>
                    <p>服务时间：09:00--18:30（周一到周日）</p>
                </div>
            </div>
            <div class="tail-second-2">
                <h4>购物指南</h4>
                <ul type="none">
                    <li><a href="">新人优惠</a></li>
                    <li><a href="">购物问题</a></li>
                    <li><a href="">支付问题</a></li>
                </ul>
            </div>
            <div class="tail-second-3">
                <h4>售后服务</h4>
                <ul type="none">
                    <li><a href="">退换货政策</a></li>
                    <li><a href="">退款说明</a></li>
                    <li><a href="">售后问题</a></li>
                </ul>
            </div>
            <div class="tail-second-4">
                <h6>扫描下载APP下单更优惠</h6>
                <img src="https://static.epetbar.com/www/images/dw2.png?v=10" alt="">
            </div>
            <div class="tail-second-5">
                <h6>扫描关注E宠商城微信</h6>
                <img src="https://static.epetbar.com/www/images/app-code.jpg?v=10" alt="">
            </div>
        </div>
        <!-- 第三个部分 -->
        <div class="tail-third">
            <a href=""><img src="https://static.epetbar.com/www/newFooter/12315.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/360.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/chengxin.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/shiming.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/tx.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/jybz.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/cqgs.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/baiq.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/wsls.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/sfqy.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/yxqy.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/bhdw.png" alt=""></a>
            <a href=""><img src="https://static.epetbar.com/www/newFooter/sjws.png" alt=""></a>
        </div>
        <!-- 第四个部分 -->
        <div class="tail-forth">
            <div>
                <p>
                    <a href="">渝ICP备10002905号-1</a>&nbsp;&nbsp;
                    <a href="">渝ICP备10002905号-3</a>&nbsp;&nbsp;
                    <a href="">营业执照</a>&nbsp;&nbsp;
                    <a href="">兽药经营许可证</a>&nbsp;&nbsp;
                    <a href="">增值电信业务经营许可证：渝B2-20140042 Copyright © 2007-2020 epet.com</a>&nbsp;&nbsp;
                    <a href="">陈氏受宠集团</a>&nbsp;&nbsp;
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
