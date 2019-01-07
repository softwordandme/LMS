<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系主任评教</title>
    <link type="text/css" rel="stylesheet" href="css/evaluationZtree.css" />
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
            <legend class="am-text-center">教学评价表</legend>
            <div class="am-g">
                <div class="am-u-sm-6 am-text-xl - 24px">教师:${teacher.teacherName}</div>
                <div class="am-u-sm-65 am-text-xl - 24px">时间:${term.termName}</div>
            </div>
            <form>
                <input type="hidden" id="roleId" value="${roleType}">
                <ul id="dataTree" class="ztree">
                </ul>
                <div><button type="button" onclick="resultDo(${userId},${teacher.teacherNo},${term.termId})">确认提交</button></div>
                <div><button type="button">取消</button></div>
            </form>

        </div>
    </div>
</div>

<script type="text/javascript" src="js/teacherEvaluationJs.js" ></script>
</body>
</html>