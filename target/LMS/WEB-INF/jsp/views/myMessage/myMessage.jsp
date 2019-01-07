<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset=UTF-8">
    <title>我的信息</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/loginCss.css" />
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content" style="margin-top: 10%">
            <legend class="am-text-center">个人信息</legend>
            <form action="" method="post">
                <div class="am-container">
                    <div class="am-g">
                        <c:choose>
                            <c:when test="${roleType == 1}">
                                <legend style="margin: 50px"><div class="am-u-sm-5">姓名：${userName}</div>
                                    <div class="am-u-sm-5">学号：${userId}</div></legend>
                                <legend style="margin: 50px"><div class="am-u-sm-5">性别：${userSex}</div>
                                    <div class="am-u-sm-5">班级：${userClazz}</div></legend>
                                <legend style="margin: 50px"><div class="am-u-sm-5">部门：${userDepartment}</div>
                                    <div class="am-u-sm-5">权限：${roleName}</div></legend>
                            </c:when>
                            <c:when test="${roleType == 4}">
                                <legend style="margin: 50px"><div class="am-u-sm-5">姓名：${userName}</div>
                            </c:when>
                            <c:otherwise>
                                <legend style="margin: 50px"><div class="am-u-sm-5">姓名：${userName}</div>
                                    <div class="am-u-sm-5">工号：${userId}</div></legend>
                                <legend style="margin: 50px"><div class="am-u-sm-5">性别：${userSex}</div>
                                    <div class="am-u-sm-5">状态：${teacherStatus}</div></legend>

                                <legend style="margin: 50px"><div class="am-u-sm-5">部门：${userDepartment}</div>
                                    <div class="am-u-sm-5">权限：${roleName}</div></legend>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <a href="changPassword" style="margin-left: 40%" class="am-btn am-btn-warning">修改密码</a>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
<script type="text/javascript" src="assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
</body>