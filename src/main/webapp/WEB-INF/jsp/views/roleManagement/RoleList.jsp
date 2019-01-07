<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>MenuList</title>
</head>
<body>
<div class="admin">
    <c:if test="${not empty message}">
        <div class="message_alert">${message}</div>
    </c:if>
    <jsp:include page="../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <legend class="am-text-center">角色管理</legend>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-4 am-u-lg-offset-6">
                    <input type="text" class="am-form-field am-round" id="search_all" placeholder="请输入需要搜索的工号，姓名，权限关键字">
                </div>
                <div class="am-u-sm-2">
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-2 am-u-lg-offset-10">
                    <button type="button" class="am-btn am-btn-primary am-margin-right-lg am-fl">
                        <a href="rolePower" style="display: inline-block;color: #fff;">角色管理</a>
                    </button>
                </div>
            </div>
            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th>工号</th>
                    <th>名字</th>
                    <th>角色</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="role_show">
                <c:forEach items="${teacherList}" var="list">
                    <tr data-teacherno="${list.teacherNo}">
                        <td class="role_teacher_no">${list.teacherNo}</td>
                        <td class="role_teacher_name">${list.teacherName}</td>
                        <td class="role_name">${list.roleId}</td>
                        <td class="role_true">
                            <a href="updateRole?teacherNo=${list.teacherNo}">修改</a>
                            <%--<button type="button" class="role_true_button am-btn am-btn-primary am-btn-default am-round"
                                    disabled="disabled">确认修改
                            </button>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>

</script>
</body>
</html>