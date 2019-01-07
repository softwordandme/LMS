<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评教时间管理</title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <fieldset>
                <legend class="am-text-center">评教时间管理</legend>
            </fieldset>
            <div style="float: right">
                <a class="am-btn am-btn-warning" href="ToAddETM">新增评教</a>
            </div>
            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th style="width: 15%;text-align: center">学年学期</th>
                    <th style="width: 20%;text-align: center">开始时间</th>
                    <th style="width: 20%;text-align: center">结束时间</th>
                    <th style="width: 15%;text-align: center">角色</th>
                    <th style="width: 30%;text-align: center">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${evaluationTimesList}" var="termTime">
                    <tr>
                        <td>${termTime.termName}</td>
                        <td>${termTime.evaluationStart}</td>
                        <td>${termTime.evaluationEnd}</td>
                        <td>${termTime.roleName}</td>
                        <td>
                            <a onclick="start()" class="am-btn am-btn-secondary" href="StartETM?evaluationTimeId=${termTime.evaluationTimeId}">开启</a>
                            <a class="am-btn am-btn-warning" href="ToUpdateETM?evaluationTimeId=${termTime.evaluationTimeId}">修改</a>
                            <a class="am-btn am-btn-danger" href="DeleteETM?evaluationTimeId=${termTime.evaluationTimeId}">删除</a>
                            <a onclick="stop()" class="am-btn am-btn-danger" href="StopETM?evaluationTimeId=${termTime.evaluationTimeId}">关闭</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <ul class="am-pagination am-pagination-centered">
                <li class="am-disabled"><a href="#">&laquo;</a></li>
                <li class="am-active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&raquo;</a></li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
    function start() {
        alert("开启成功！")
    }
    function stop() {
        alert("关闭成功！")
    }
</script>
</body>
</html>