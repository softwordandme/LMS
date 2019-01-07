<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>查看系主任的评价</title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
            <fieldset>
                <legend class="am-text-center">查看评教</legend>
                <div style="margin: auto;width: 600px">
                    <div style="margin: auto" class="am-form-group">
                        <div class="am-u-sm-65 am-text-xl - 24px"  name="sTermId">时间:${term.termName}</div>
                    </div>
                </div>
            </fieldset>
            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th>部门</th>
                    <th>评价人</th>
                    <th>职务</th>
                    <th>状态</th>
                    <th>分数</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teacherList}" var="teacherList">
                    <c:if test="${userId != teacherList.teacherNo}">
                        <tr>
                            <td>${departmentName}</td>
                            <td>${teacherList.teacherName}</td>
                            <c:forEach items="${roleList}" var="roleList">
                                <c:if test="${roleList.roleId == teacherList.roleId}">
                                    <td>${roleList.roleName}</td>
                                </c:if>
                            </c:forEach>
                            <c:set var="teacherNo" value="w${teacherList.teacherNo}"/>
                            <td>${teacherSign[teacherNo]}</td>
                            <td>${teacherScore[teacherNo]}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>