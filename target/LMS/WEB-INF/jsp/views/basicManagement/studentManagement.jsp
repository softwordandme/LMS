<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>学生管理</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
    <script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">学生管理</div>
        <div class="am-g am-g-fixed">
            <div class="am-input-group am-u-sm-5">
                <div class="am-input-group-label">搜索</div>
                <input type="text"  class="am-form-field"  id="searchMessage" placeholder="请输入您要查找的内容"/>
            </div>
            <div class="am-u-sm-2">
                <a href="addStudent" class="am-btn am-btn-primary">新增</a>
            </div>
        </div>
        <div class="content">
            <table class="am-table am-table-centered am-table-bordered">
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>班级Num</td>
                    <td>部门</td>
                    <td colspan="2">操作</td>
                </tr>
                <c:forEach items="${student}" var="list">
                    <tr>
                        <td>${list.studentNo}</td>
                        <td>${list.studentName}</td>
                        <td>${list.studentSex}</td>
                        <td>${list.clazzNum}</td>
                        <td>
                            <c:forEach items="${departmentList}" var="list1">
                                <c:if test="${list1.departmentId==list.departmentId}">
                                    ${list1.departmentName}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td><button type="button" class="editStudent am-round am-btn am-btn-warning" id="${list.studentId}">编辑</button></td>
                        <td><button type="button" class="delStudent am-round am-btn am-btn-danger" id="${list.studentId}">删除</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/studentManagement.js" ></script>
</body>
</html>