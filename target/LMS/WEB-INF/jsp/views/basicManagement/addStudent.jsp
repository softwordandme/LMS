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
        <div class="header am-center">新增Student</div>
        <div class="content">
            <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addStudentForm">
                <div class="am-form-group">
                    <label for="studentNo" class="am-u-sm-2 am-text-right">学号</label>
                    <div class=" am-u-sm-10">
                        <input type="text" name="studentNo" id="studentNo"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="studentName" class="am-u-sm-2 am-text-right">姓名</label>
                    <div class="am-u-sm-10">
                        <input type="text" name="studentName" id="studentName"/>
                    </div>
                </div>
                <input type="hidden" name="studentPassword" id="studentPassword" value="123456"/>
                <div class="am-form-group">
                    <label for="studentSex" class="am-u-sm-2 am-text-right">性别</label>
                    <div class="am-u-sm-10">
                        <select name="studentSex" id="studentSex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="clazzNum" class="am-u-sm-2 am-text-right">班级</label>
                    <div class="am-u-sm-10">
                        <select name="clazzNum" id="clazzNum">
                            <c:forEach items = "${clazzNumList}" var="c">
                                <option value="${c}">${c}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <input type="hidden"  name="roleId" id="roleId" value="1"/>
                <div class="am-form-group">
                    <label for="departmentId" class="am-u-sm-2 am-text-right">部门</label>
                    <div class=" am-u-sm-10">
                        <select name="departmentId" id="departmentId">
                            <c:forEach items = "${department}" var="d">
                                <option value="${d.departmentId}">${d.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </form>
            <div class="mid am-center">
                <button type="button" class="am-btn am-btn-primary" id="add">增加</button>
                <a href="studentManagement" class="am-btn am-btn-primary"> 返回</a>
                <button type="button" class="am-btn am-btn-primary" id="import">确认导入</button>
                <div class="am-form-group am-form-file  am-fr">
                    <button type="button" class="am-btn am-btn-danger am-btn-sm">
                        <i class="am-icon-cloud-upload"></i>选择导入文件</button>
                    <form id="importExcel">
                        <input id="doc-form-file" name="doc-form-file" type="file" accept=".xls,.xlsx" multiple>
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
<script type="text/javascript" src="js/studentDo.js" ></script>
</body>
</html>