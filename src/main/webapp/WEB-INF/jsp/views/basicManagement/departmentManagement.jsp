<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>学生评教管理</title>
    <link type="text/css" rel="stylesheet" href="css/departmentZtree.css" />
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
            <legend class="am-text-center">部门管理</legend>
            <div class="am-g">
                <div class="am-u-sm-2 am-u-lg-offset-9 am-u-end">
                    <button class="am-btn am-btn-primary"><a class="am-link-muted" style="color: white;" href="addDepartment?parentId=no">增加一级部门</a></button>
                </div>
            </div>
            <ul id="dataTree" class="ztree">

            </ul>
        </div>
    </div>
</div>

<script type="text/javascript" src="js/departmentTree.js" ></script>
</body>
</html>