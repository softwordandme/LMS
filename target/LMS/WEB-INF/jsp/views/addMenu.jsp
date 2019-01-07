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
                    <legend class="am-text-center">添加菜单</legend>
                </fieldset>
            </form>
            <div style="margin-left: 50px;margin-bottom: 10px">
                <button type="button" onClick="javascript:history.go(-1)" class="am-btn am-btn-primary">返回</button>
            </div>
            <form class="am-form" action="saveMenu" method="post">
                <fieldset>
                    <legend>添加菜单</legend>
                    <input type="hidden" name="menuId" value="${menu.menuId}">
                    菜单名：
                    <input name="menuName" value="${menu.menuName}" type="text" class="am-form-field am-radius" placeholder="请输入菜单名" required/>
                    上级菜单：
                    <input class="am-form-field" name="pname" value="${menu.pname}" type="text" placeholder="为一级菜单，没有上级菜单" disabled>
                    <input type="hidden" name="menuParentId" value="${menu.menuParentId}">
                    地址：
                    <input name="menuUrl" value="${menu.menuUrl}" type="text" class="am-form-field am-radius" placeholder="菜单地址"/>
                    排序：
                    <input name="menuNum" value="${menu.menuNum}" type="number" class="am-form-field am-radius" placeholder="请输入排序编码" required/>
                    <br>
                    <button style="float: right;margin-right: 100px" type="submit" class="am-btn am-btn-primary">确定</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<script>
    var menuPower = document.getElementById("menuPower").value;
    if(menuPower!=null&&menuPower!=""){
        document.getElementsByName("menuPower")[menuPower].checked = true;
    }
</script>
</body>
</html>