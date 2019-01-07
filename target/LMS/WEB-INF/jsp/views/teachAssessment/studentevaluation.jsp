<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>studentEvaluation</title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <form class="am-form-inline" action="student" method="post">
                <fieldset>
                    <legend class="am-text-center">学生评教选择</legend>
                    <div style="margin: auto;width: 600px">
                        <div style="margin: auto" class="am-form-group">
                                <div class="am-u-sm-65 am-text-xl - 24px"  name="sTermId">时间:${term.termName}</div>
                        </div>
                    </div>
                </fieldset>
            </form>

            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th>课程名称</th>
                    <th>教师</th>
                    <th>评教</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${evaluationType.status == 1}">
                    <c:forEach items="${courseList}" var="courseList">
                        <tr>
                            <td>${courseList.courseName}</td>
                            <c:forEach items="${teachers}" var="tt">
                                <c:if test="${tt.teacherNo == courseList.teacherNo}">
                                    <td>${tt.teacherName}</td>
                                </c:if>
                            </c:forEach>

                            <c:set var="degrees" value="w${courseList.courseId}w${clazzNum}"/>
                            <c:choose>
                                <c:when test="${sign[degrees] == 0}">
                                    <td onl="${sign[degrees]}">
                                        <a href="startEvaluation?courseId=${courseList.courseId}">开始评教</a>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td onl="${sign[degrees]}"><a class="am-link-muted" disabled="true">已评</a></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${evaluationType.status == 0}">
                    <tr>
                        <td colspan="3" class="">当前评教未开启！！！</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>