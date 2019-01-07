<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>新增</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
    <script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">新增课程</div>
        <div class="content">
            <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addCourseForm">
                <div class="am-form-group">
                    <label for="courseName" class="am-u-sm-2 am-text-right">课程名称</label>
                    <div class=" am-u-sm-10">
                        <input type="text"  name="courseName" id="courseName"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="teacherNo" class="am-u-sm-2 am-text-right">教师工号</label>
                    <div class="am-u-sm-10">
                        <input type="text" name="teacherNo" id="teacherNo"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label class="am-u-sm-2 am-text-right">教师姓名</label>
                    <div class="am-u-sm-10">
                        <div id="teacherName" sign="true"></div>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="courseTerm" class="am-u-sm-2 am-text-right">课程学期</label>
                    <div class="am-u-sm-10">
                        <select class="am-form-field" id="courseTerm" name="termId">
                            <c:forEach items="${termNames}" var="t">
                                <c:if test="${t.status == 1}">
                                    <option selected="selected" value="${t.termId}">${t.termName}</option>
                                </c:if>
                                <c:if test="${t.status == 0}">
                                    <option value="${t.termId}">${t.termName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>

                </div>
            </form>
            <div class="mid am-center">
                <button type="button" class="am-btn am-btn-primary" id="add">增加</button>
                <a href="courseManagement" class="am-btn am-btn-primary"> 返回</a>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/courseDo.js" ></script>
</body>
</html>