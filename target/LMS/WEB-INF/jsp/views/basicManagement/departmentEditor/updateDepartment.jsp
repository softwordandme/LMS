<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>修改部门</title>
</head>
<body>
<div class="admin">
    <jsp:include   page="../../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <form class="am-form-inline">
                <fieldset>
                    <legend class="am-text-center">修改部门信息</legend>
                </fieldset>
            </form>
            <div style="margin-left: 50px;margin-bottom: 10px">
                <button type="button" onClick="javascript:history.go(-1)" class="am-btn am-btn-primary">返回</button>
            </div>
            <form class="am-form" id="updateDepartment_form">
                <input type="hidden" name="cDepartmentId" id="cDepartmentId" value="${cDepartmentId}">
                部门名：
                <input name="cDepartmentName" id="cDepartmentName" value="${cDepartmentName}" type="text" class="am-form-field am-radius"/>
                <br>
                <button style="float: right;margin-right: 100px" type="button" id="updateDepartmentDo" class="am-btn am-btn-primary">确定</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>