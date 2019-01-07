<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>课程管理</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
    <script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">课程管理</div>
        <div class="am-g am-g-fixed">
            <div class="am-input-group am-u-sm-5">
                <div class="am-input-group-label">搜索</div>
                <input type="text"  class="am-form-field"  id="searchMessage" placeholder="请输入您要查找的内容"/>
            </div>
            <div class="am-u-sm-2">
                <a href="addCourse" class="am-btn am-btn-primary">新增</a>
            </div>
        </div>
        <div class="content">
            <table class="am-table am-table-centered am-table-bordered">
                <tr>
                    <td>课程编号</td>
                    <td>课程名称</td>
                    <td>任课教师</td>
                    <td>教师工号</td>
                    <td>课程学期</td>
                    <td colspan="2">操作</td>
                </tr>
                <c:forEach items="${course}" var="list">
                    <tr>
                        <td>${list.courseId}</td>
                        <td>${list.courseName}</td>
                        <td>
                                <c:forEach items="${teacherList}" var="tList">
                                    <c:if test="${tList.teacherNo==list.teacherNo}">
                                        ${tList.teacherName}
                                    </c:if>
                                </c:forEach>
                        </td>
                        <td>${list.teacherNo}</td>
                        <td>
                            <c:forEach items="${terms}" var = "t">
                                <c:if test="${t.termId == list.termId}">
                                    ${t.termName}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <button type="button" class="editCourse am-round am-btn am-btn-warning" id="${list.courseId}">编辑</button>
                        </td>
                        <td>
                            <button type="button" class="delCourse am-round am-btn am-btn-danger" id="${list.courseId}">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/courseManagement.js" ></script>
</body>
</html>