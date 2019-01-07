<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/8
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="css/classManagement.css" />
    <script type="text/javascript" src="plugins/jquery-3.3.1.js" ></script>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="header am-center">新增</div>
        <div class="content">
            <div class="mid am-center">
                <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="editQuotaForm">
                    <div class="am-form-group">
                        <div  class="am-u-sm-2 am-text-right">父级指标</div>
                        <div class=" am-u-sm-10">
                            <input type="text" value="${quotaParent.quotaName}" disabled/>
                        </div>
                    </div>
                    <input type="hidden" name="quotaParentId" id="quotaParentId" value="${quota.quotaParentId}">
                    <input type="hidden" name="quotaType" id="quotaType" value="${quota.quotaType}">
                    <input type="hidden" name="quotaId" id="quotaId" value="${quota.quotaId}">
                    <div class="am-form-group">
                        <label for="quotaName" class="am-u-sm-2 am-text-right">指标名称</label>
                        <div class=" am-u-sm-10">
                            <input type="text"  name="quotaName" id="quotaName" value="${quota.quotaName}"/>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="quotaWeight" class="am-u-sm-2 am-text-right">指标权重</label>
                        <div class=" am-u-sm-10">
                            <input type="text"  name="quotaWeight" id="quotaWeight" value="${quota.quotaWeight}"/>
                        </div>
                    </div>
                </form>
                <button type="button" class="am-btn am-btn-primary" id="edit">修改</button>
                <a class="am-btn am-btn-primary" href="quotaManagement">返回</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/quotaDo.js" ></script>
</body>
</html>
