<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>deanEvaluation</title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
                <fieldset>
                    <legend class="am-text-center">评教选择</legend>
                    <div style="margin: auto;width: 600px">
                        <div style="margin: auto" class="am-form-group">
                            <span>学年:</span>
                            <span value="${term.termId}">${term.termName}</span>
                        </div>
                    </div>
                </fieldset>

            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th>所在院系</th>
                    <th>教师名称</th>
                    <th>进入评教</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${evaluationType.status == 1}">
                    <c:forEach items="${teacherList}" var="teacher">
                        <c:if test="${teacher.teacherNo != userId}">
                            <tr>
                                <td>${departmentName}</td>
                                <td>${teacher.teacherName}</td>
                                <c:set var="key" value="w${teacher.teacherNo}"/>
                                <c:if test="${sign[key] == 0}">
                                    <td>
                                        <a href="teacherStartEvaluation?teacherNo=${teacher.teacherNo}&&termId=${term.termId}">开始评教</a>
                                    </td>
                                </c:if>
                                <c:if test="${sign[key] == 1}">
                                    <td>
                                        <a href="#">已评</a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:if>
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