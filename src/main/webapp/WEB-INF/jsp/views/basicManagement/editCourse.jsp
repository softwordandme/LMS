<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>编辑</title>
</head>
<body>
    <div class="header am-center">编辑课程</div>
    <div class="content">
        <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addCourseForm">
            <div class="am-form-group">
                <label for="courseName" class="am-u-sm-2 am-text-right">课程名称</label>
                <div class="department am-u-sm-10">
                    <input type="text" id="courseName" name="courseName" value="${course.courseName}"/>
                </div>
            </div>
            <div class="am-form-group">
                <label for="teacherNo" class="am-u-sm-2 am-text-right">教师工号</label>
                <div class="am-u-sm-10">
                    <input type="text" name="teacherNo" id="teacherNo" value="${course.teacherNo}"/>
                </div>
            </div>
            <div class="am-form-group">
                <label for="teacherName" class="am-u-sm-2 am-text-right">教师名称</label>
                <div class="am-u-sm-10">
                    <input type="text"  id="teacherName" disabled/>
                </div>
            </div>
            <div class="am-form-group">
                <label for="termId" class="am-u-sm-2 am-text-right">课程学期</label>
                <div class="am-u-sm-10">
                    <select name="termId" id="termId">
                        <c:forEach items="${termNames}" var="tn">
                            <c:if test="${tn.termId==course.termId}">
                                <option value="${tn.termId}" selected="selected">${tn.termName}</option>
                            </c:if>
                            <c:if test="${tn.termId!=course.termId}">
                                <option value="${tn.termId}">${tn.termName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <input type="hidden" name="courseId" class="courseId" value="${course.courseId}">
        </form>
        <div class="mid am-center">
            <button type="button" class="am-btn am-btn-primary" id="edit">保存修改</button>
            <a href="courseManagement" class="am-btn am-btn-primary"> 返回</a>
        </div>
    </div>

</body>
</html>