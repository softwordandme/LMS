<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/indexCss.css">
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="assets/css/core.css" />
    <link type="text/css" rel="stylesheet" href="assets/css/menu.css" />
    <link type="text/css" rel="stylesheet" href="assets/css/index.css" />
    <link type="text/css" rel="stylesheet" href="assets/css/admin.css" />
    <link type="text/css" rel="stylesheet" href="assets/css/component.css" />
</head>

<%--侧边栏页面--%>


<body>
<%--<div class="admin">--%>
    <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <!-- User -->
            <div class="user-box am-hide-sm-only">
                <h3>
                    <c:if test="${userName!=null}">
                        欢迎${userName}<a href="#" id="log_off">注销</a>
                    </c:if>
                    <c:if test="${userName==null}">
                        游客，请 <a href="login">登录</a>
                    </c:if></h3>
                <h5 id="new_date">0000年00月00日 00:00:00</h5><%--test--%>
                <ul class="list-inline">
                    <li>
                        <a href="#">
                            <i class="fa fa-cog" aria-hidden="true"></i>
                        </a>
                    </li>

                    <li>
                        <a href="#" class="text-custom">
                            <i class="fa fa-cog" aria-hidden="true"></i>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- End User -->
            <!-- 侧边菜单栏-->
            <ul class="am-list admin-sidebar-list">
                <li><a href="index"><span class="am-icon-home"></span> 首页</a></li>
                <c:forEach items="${menuList}" var="parent">
                    <c:if test="${parent.menuParentId==null}">
                        <li class="admin-parent">
                            <a class="am-cf am-collapsed" data-am-collapse="{target: '.${parent.menuId}'}"><span class="am-icon-table"></span>${parent.menuName}<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                        </li>
                        <c:forEach items="${menuList}" var="chi">
                            <c:if test="${chi.menuParentId==parent.menuId}">
                                <ul class="am-list am-collapse admin-sidebar-sub ${chi.menuParentId}">
                                    <li class="am_nav"><a href="${chi.menuUrl}" class="am-cf">${chi.menuName}</a></li>
                                </ul>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
<%--</div>--%>
    <!-- 侧边菜单栏 end -->



<script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="assets/js/blockUI.js" ></script>
<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="js/js.js" ></script>

</body>