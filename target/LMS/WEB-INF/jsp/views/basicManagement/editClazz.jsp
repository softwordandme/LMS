<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>编辑</title>
    <%--<link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />--%>
    <%--<link type="text/css" rel="stylesheet" href="css/classManagement.css" />--%>
    <%--<script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>--%>
</head>
<body>

        <div class="header am-center">编辑Clazz</div>
        <div class="content">
            <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addClazzForm">
                <div class="am-form-group">
                    <label for="clazzNum" class="am-u-sm-2 am-text-right">班级编号</label>
                    <div class=" am-u-sm-10">
                        <input type="text"  name="clazzNum" id="clazzNum" value="${clazz.clazzNum}"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="clazzName" class="am-u-sm-2 am-text-right">班级名称</label>
                    <div class="am-u-sm-10">
                        <input type="text" name="clazzName" readonly="readonly" id="clazzName" value="${clazz.clazzName}"/>
                    </div>

                </div>
                <input type="hidden" name="courseId" id="courseId" value="${clazz.courseId}"/>
                <input type="hidden" name="courseName" id="courseName" value="${clazz.courseName}"/>
                <div class="am-form-group">
                    <label for="selectCourse" class="am-u-sm-2 am-text-right">课程</label>
                    <div class="am-u-sm-10">
                        <select id="selectCourse">
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
                        <input type="hidden" id="showDepartmentId"  value="${clazz.department}"/>
                        <select name="department" id="department">
                            <c:forEach items="${department}" var="list">
                                <option value="${list.departmentId}">${list.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <input type="hidden" name="id" class="id" value="${clazz.id}">
            </form>
            <div class="mid am-center">
                <button type="button" class="am-btn am-btn-primary" id="edit">保存修改</button>
                <a href="classManagement" class="am-btn am-btn-primary"> 返回</a>
            </div>
        </div>




</body>
</html>