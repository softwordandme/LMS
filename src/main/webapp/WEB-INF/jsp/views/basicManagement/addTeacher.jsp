<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>新增</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
    <script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">新增Teacher</div>
        <div class="content">
            <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addTeacherForm">
                <div class="am-form-group">
                    <label for="departmentId" class="am-u-sm-2 am-text-right">部门</label>
                    <div class=" am-u-sm-10">
                        <select  name="departmentId" id="departmentId">
                            <c:forEach items="${department}" var="list">
                                <option value="${list.departmentId}">${list.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="roleId" class="am-u-sm-2 am-text-right">角色</label>
                    <div class="am-u-sm-10">
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
                        <input type="text" name="teacherName" id="teacherName"/>
                    </div>

                </div>
                <div class="am-form-group">
                    <label for="teacherNo" class="am-u-sm-2 am-text-right">工号</label>
                    <div class="am-u-sm-10">
                        <input type="text" name="teacherNo" id="teacherNo"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="teacherPassword" class="am-u-sm-2 am-text-right">密码</label>
                    <div class=" am-u-sm-10">
                        <input type="text"  name="teacherPassword" id="teacherPassword"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="teacherSex" class="am-u-sm-2 am-text-right">性别</label>
                    <div class=" am-u-sm-10">
                        <select name="teacherSex" id="teacherSex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="teacherStatus" class="am-u-sm-2 am-text-right">状态</label>
                    <div class=" am-u-sm-10">
                        <select name="teacherStatus" id="teacherStatus" value="${teacher.teacherStatus}">
                            <option value="在职">在职</option>
                            <option value="离职">离职</option>
                        </select>
                    </div>
                </div>
            </form>
            <div class="mid am-center">
                <button type="button" class="am-btn am-btn-primary" id="add">增加</button>
                <a href="teacherManagement" class="am-btn am-btn-primary"> 返回</a>
                <button type="button" class="am-btn am-btn-primary" id="import">确认导入</button>
                <div class="am-form-group am-form-file  am-fr">
                    <button type="button" class="am-btn am-btn-danger am-btn-sm">
                        <i class="am-icon-cloud-upload"></i>选择导入文件</button>
                    <form id="importExcel">
                        <input id="doc-form-file" name="doc-form-file" type="file" accept=".xlsx" multiple>
                    </form>
                    <div id="file-list"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="loading" id="loading">
    <div class="loadTop">正在导入，请稍候...</div>
    <img src="images/loading.gif" width="128" height="128">
</div>
<script type="text/javascript" src="js/teacherDo.js" ></script>
</body>
</html>