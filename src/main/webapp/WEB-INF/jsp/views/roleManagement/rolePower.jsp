<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>角色操作</title>
</head>
<body>
<div class="admin">
    <jsp:include   page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
            <form class="am-form-inline">
                <fieldset>
                    <legend class="am-text-center">角色管理</legend>
                </fieldset>
            </form>
            <div style="float: right;margin-bottom: 10px;margin-right: 100px">
                <button type="button" onClick="location.href='updataRolePower'" class="am-btn am-btn-primary">添加角色</button>
            </div>
            <div style="margin-left: 50px;margin-bottom: 10px">
                <button type="button" onClick="javascript:history.go(-1)" class="am-btn am-btn-primary">返回</button>
            </div>
            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th>角色名</th>
                    <th>角色能访问的页面</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${roleList}" var="roleList">
                        <tr>
                            <td>${roleList.roleName}</td>
                            <td>${roleList.powerName}</td>
                            <td>
                                <a href="updataRolePower?roleId=${roleList.roleId}">修改</a>
                                <a href="deleteRole?roleId=${roleList.roleId}" onclick="javascript:return deleteOne();">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script>
    function deleteOne() {
        var msg = "您真的确定要删除吗?\n请确认！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    }
</script>
</body>
</html>