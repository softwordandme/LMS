<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>教师管理</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
    <script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">教师管理</div>
        <div class="am-g am-g-fixed">
            <div class="am-input-group am-u-sm-5">
                <div class="am-input-group-label">搜索</div>
                <input type="text"  class="am-form-field"  id="searchMessage" placeholder="请输入您要查找的内容"/>
            </div>
            <div class="am-u-sm-2">
                <a href="addTeacher" class="am-btn am-btn-primary">新增</a>
            </div>
        </div>
        <div class="content">
            <table class="am-table am-table-centered am-table-bordered">
                <tr>
                    <td>编号</td>
                    <td>部门</td>
                    <td>角色</td>
                    <td>姓名</td>
                    <td>工号</td>
                    <td>性别</td>
                    <td>状态</td>
                    <td colspan="2">操作</td>
                </tr>
                <c:forEach items="${teacher}" var="list">
                    <tr>
                        <td>${list.teacherId}</td>
                        <td>
                            <c:forEach items="${departmentList}" var="list1">
                                <c:if test="${list1.departmentId==list.departmentId}">
                                    ${list1.departmentName}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${role}" var="list2">
                                <c:if test="${list2.roleId==list.roleId}">
                                    ${list2.roleName}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>${list.teacherName}</td>
                        <td>${list.teacherNo}</td>
                        <td>${list.teacherSex}</td>
                        <td>${list.teacherStatus}</td>
                        <td><button type="button" class="editTeacher am-round am-btn am-btn-warning" id="${list.teacherNo}">编辑</button></td>
                        <c:choose>
                            <c:when test="${list.roleId == 4}">
                                <td><button type="button" class="am-round am-btn am-btn-danger" id="no_del">这个不能删!</button></td>
                            </c:when>
                            <c:otherwise>
                                <td><button type="button" class="delTeacher am-round am-btn am-btn-danger" id="${list.teacherNo}">删除</button></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/teacherManagement.js" ></script>
</body>
</html>