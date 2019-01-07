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
        <div class="header am-center">新增Clazz</div>
        <div class="content">
            <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addClazzForm">
                <div class="am-form-group">
                    <label for="clazzNum" class="am-u-sm-2 am-text-right">班级编号</label>
                    <div class=" am-u-sm-10">
                        <input type="text"  name="clazzNum" id="clazzNum"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="clazzName" class="am-u-sm-2 am-text-right">班级名称</label>
                    <div class="am-u-sm-10">
                        <input type="text" name="clazzName" id="clazzName"/>
                    </div>

                </div>
                <input type="hidden" name="courseId" id="courseId"/>
                <input type="hidden" name="courseName" id="courseName"/>
                <div class="am-form-group">
                    <label for="selectCourse" class="am-u-sm-2 am-text-right">课程</label>
                    <div class="am-u-sm-10">
                        <select id="selectCourse" name="courseId">
                            <c:forEach items="${course}" var="list">
                                <option value="${list.courseId}">${list.courseName}
                                    -<c:forEach items="${teacherList}" var="teacherList">
                                        <c:if test="${teacherList.teacherNo == list.teacherNo}">${teacherList.teacherName}</c:if>
                                    </c:forEach>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="department" class="am-u-sm-2 am-text-right">部门</label>
                    <div class="am-u-sm-10">
                        <select name="department" id="department">
                            <c:forEach items="${department}" var="list">
                                <option value="${list.departmentId}">${list.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

            </form>
            <div class="mid am-center">
                <button type="button" class="am-btn am-btn-primary" id="add">增加</button>
                <a href="classManagement" class="am-btn am-btn-primary"> 返回</a>
        </div>
</div>
</div>
<script type="text/javascript" src="js/clazzDo.js" ></script>
<script type="text/javascript" src="js/classManagement.js" ></script>
</body>
</html>