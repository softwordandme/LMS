<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>MenuList</title>
</head>
<body>
<div class="admin">
    <jsp:include   page="sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
            <form class="am-form-inline">
                <fieldset>
                    <legend class="am-text-center">菜单管理</legend>
                </fieldset>
            </form>
            <div style="float: right;margin-bottom: 10px;margin-right: 100px">
                <button type="button" onClick="location.href='addOne'" class="am-btn am-btn-primary">添加一级菜单</button>
            </div>
            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                <tr>
                    <th>菜单名称</th>
                    <th>地址</th>
                    <th>排序</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${parentMenuList}" var="parentMenuList">
                    <tr class="am-primary">
                        <td>${parentMenuList.menuName}</td>
                        <td>${parentMenuList.menuUrl}</td>
                        <td>${parentMenuList.menuNum}</td>
                        <td>
                            <c:if test="${parentMenuList.menuParentId==null}">
                                <a href="addTwo?menuParentId=${parentMenuList.menuId}">添加下级菜单</a>
                            </c:if>
                            <a href="addOne?id=${parentMenuList.menuId}">修改</a>
                            <a href="deleteMenu?id=${parentMenuList.menuId}" onclick="javascript:return deleteOne();">删除</a>
                        </td>
                    </tr>
                    <c:forEach items="${chMenuList}" var="chMenuList">
                        <c:if test="${chMenuList.menuParentId==parentMenuList.menuId}">
                            <tr class="am-active">
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${chMenuList.menuName}</td>
                                <td>${chMenuList.menuUrl}</td>
                                <td>${chMenuList.menuNum}</td>
                                <td>
                                    <a href="addOne?id=${chMenuList.menuId}">修改</a>
                                    <a href="deleteMenu?id=${chMenuList.menuId}" onclick="javascript:return deleteOne();">删除</a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
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