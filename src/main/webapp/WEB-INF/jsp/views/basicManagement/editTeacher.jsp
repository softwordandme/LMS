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

<div class="header am-center">编辑Teacher</div>
<div class="content">
    <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addTeacherForm">
        <div class="am-form-group">
            <label for="departmentId" class="am-u-sm-2 am-text-right">部门</label>
            <div class="department am-u-sm-10" id="${teacher.departmentId}">
                <select  name="departmentId" id="departmentId">
                    <c:forEach items="${department}" var="list">
                        <option value="${list.departmentId}">${list.departmentName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="am-form-group">
            <label for="roleId" class="am-u-sm-2 am-text-right">角色</label>
            <div class="role am-u-sm-10"  id="${teacher.roleId}">
                <select   name="roleId" id="roleId">
                    <c:forEach items="${role}" var="li">
                        <c:if test="${li.roleName!='学生'}">
                            <option value="${li.roleId}">${li.roleName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

        </div>
        <div class="am-form-group">
            <label for="teacherName" class="am-u-sm-2 am-text-right">姓名</label>
            <div class="am-u-sm-10">
                <input type="text" name="teacherName" id="teacherName" value="${teacher.teacherName}"/>
            </div>

        </div>
        <div class="am-form-group">
            <label for="teacherNo" class="am-u-sm-2 am-text-right">工号</label>
            <div class="am-u-sm-10">
                <input type="text" name="teacherNo" id="teacherNo" value="${teacher.teacherNo}"/>
            </div>
        </div>
        <div class="am-form-group">
            <label for="teacherPassword" class="am-u-sm-2 am-text-right">密码</label>
            <div class=" am-u-sm-10">
                <input type="hidden"  name="teacherPassword" id="teacherPassword" value="${teacher.teacherPassword}"/>
                <button class="am-btn am-btn-danger" type="button" id="restPassword">重置</button>
        </div>
        </div>
        <div class="am-form-group">
            <label for="teacherSex" class="am-u-sm-2 am-text-right">性别</label>
            <input type="hidden"  id="teacherSexValue" value="${teacher.teacherSex}">
            <div class=" am-u-sm-10">
                <select name="teacherSex" id="teacherSex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>
        <div class="am-form-group">
            <label for="teacherStatus" class="am-u-sm-2 am-text-right">状态</label>
            <input type="hidden"  id="teacherStatusValue" value="${teacher.teacherStatus}">
            <div class=" am-u-sm-10">
                <select name="teacherStatus" id="teacherStatus" >
                    <option value="在职">在职</option>
                    <option value="离职">离职</option>
                </select>
            </div>
        </div>
        <input type="hidden" name="teacherId" class="teacherId" value="${teacher.teacherId}">
        <input type="hidden" id="YorNChangePas" name="YorNChangePas" value="0">
    </form>
    <div class="mid am-center">
        <button type="button" class="am-btn am-btn-primary" id="edit">保存修改</button>
        <a href="teacherManagement" class="am-btn am-btn-primary"> 返回</a>
    </div>
</div>
</body>
</html>