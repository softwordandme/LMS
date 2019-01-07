<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>增加部门</title>
</head>
<body>
<div class="admin">
    <jsp:include   page="../../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <form class="am-form-inline">
                <fieldset>
                    <legend class="am-text-center">添加下属部门</legend>
                </fieldset>

            </form>
            <div style="margin-left: 50px;margin-bottom: 10px">
                <button type="button" onClick="javascript:history.go(-1)" class="am-btn am-btn-primary">返回</button>
            </div>
            <form class="am-form" action="addDepartmentDo" method="post">
                <c:if test="${parentNameByParentId != null}">
                    上级部门：
                    <input name="parentDepartmentName" value="${parentNameByParentId}" type="text" class="am-form-field am-radius" disabled/>
                </c:if>
                部门名：
                <input name="departmentName" value="" type="text" class="am-form-field am-radius" placeholder="请输入部门名"
                       required/>

                <input name="parentId" value="${parentId}" type="hidden"/>

                <br>
                <button style="float: right;margin-right: 100px" type="submit" class="am-btn am-btn-primary">确定</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>