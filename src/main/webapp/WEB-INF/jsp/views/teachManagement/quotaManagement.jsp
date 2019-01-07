<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/8
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/quotaZtree.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">指标管理</div>
        <div class="am-g am-g-fixed">
            <div class="am-u-sm-2">
                <a href="addQuota?quotaParentId=" class="am-btn am-btn-primary">新增一级指标</a>
            </div>
            <div class="am-form-group am-form-file  am-fr">
                <button type="button" class="am-btn am-btn-danger am-btn-sm">
                    <i class="am-icon-cloud-upload"></i>选择导入文件</button>
                <form id="importExcel">
                    <input id="doc-form-file" name="doc-form-file" type="file" accept=".xlsx" multiple>
                </form>
                <div id="file-list"></div>
            </div>
            <div class="am-form-group am-fr">
                <label for="roleShow">导入指标类型</label>
                <select id="roleShow">
                    <c:forEach items="${roleList}" var="list">
                        <c:if test="${list.roleName!='管理员'}">
                            <option value="${list.roleId}">${list.roleName}用</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="am-form-group am-fl">
                <label for="selectType">检索指标类型</label>
                <select id="selectType">
                    <c:forEach items="${roleList}" var="list">
                        <c:if test="${list.roleName!='管理员'}">
                            <option value="${list.roleId}">${list.roleName}评教用</option>
                        </c:if>
                    </c:forEach>
                </select>
                <button type="button" class="am-btn am-btn-primary" id="retrieval">检索</button>
            </div>
            <button type="button" class="am-btn am-btn-primary am-fr" id="import">确认导入</button>
        </div>
        <div class="content">
            <ul id="dataTree" class="ztree">
            </ul>
        </div>
    </div>
</div>
<div class="loading" id="loading">
    <div class="loadTop">正在导入，请稍候...</div>
    <img src="images/loading.gif" width="128" height="128">
</div>
<script type="text/javascript" src="js/quotaManagement.js"></script>
</body>
</html>
