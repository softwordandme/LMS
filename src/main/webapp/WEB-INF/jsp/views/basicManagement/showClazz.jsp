<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>学生管理_班级显示</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
    <script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">班级表</div>
        <div class="am-g am-g-fixed">
            <div class="am-input-group am-u-sm-5">
                <input type="text"  class="am-form-field"  id="searchMessage" placeholder="请输入您要查找的内容"/>
                <div class="am-input-group-label">搜索</div>
            </div>
        </div>
        <div class="content">
            <table class="am-table am-table-centered am-table-bordered">
                <tr>
                    <td>班级编号</td>
                    <td>班级名称</td>
                    <td>部门编号</td>
                    <td colspan="2">操作</td>
                </tr>
                <c:forEach items="${clazz}" var="list">
                    <tr>
                        <td>${list.clazzNum}</td>
                        <td>${list.clazzName}</td>
                        <td>${list.department}</td>
                        <td><button type="button" class="editClazz am-round am-btn am-btn-warning" id="${list.id}">查看</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/classManagement.js" ></script>
</body>
</html>