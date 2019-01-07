<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>查看评教</title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
            <form class="am-form-inline" action="seeMyEvaluationByTime" method="post">
                <fieldset>
                    <legend class="am-text-center">查看评教</legend>
                    <div style="margin: auto;width: 600px">
                        <div style="margin: auto" class="am-form-group">
                            <div style="margin: auto;width: 600px">
                                <div style="margin: auto" class="am-form-group">
                                    <div class="am-u-sm-65 am-text-xl - 24px"  name="sTermId">时间:${term.termName}</div>
                                </div>
                            </div>
                            <span class="am-form-caret"></span>
                        </div>
                        <input type="hidden" value="${userId}" name="teacherNo">
                    </div>
                </fieldset>
            </form>

            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th>课程名称</th>
                    <th>班级</th>
                    <th>评教完成度</th>
                    <th>分数</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${clazzes}" var="clazzes">
                    <tr>
                        <c:forEach items="${courses}" var="courses">
                            <c:if test="${clazzes.courseId == courses.courseId}">
                                <td>${courses.courseName}</td>
                                <td>${clazzes.clazzNum}</td>

                                <c:set var="degrees" value="w${courses.courseId}w${clazzes.clazzNum}"/>
                                <td>${degree[degrees]}</td>

                                <c:forEach items="${evaluationList}" var="e">
                                    <c:if test="${e.courseId == courses.courseId && e.clazzNum == clazzes.clazzNum}">
                                        <td>${e.score}</td>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript" src="js/clazzDo.js" ></script>
    <script type="text/javascript" src="js/classManagement.js" ></script>
</body>
</html>