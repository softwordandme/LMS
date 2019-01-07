<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>更新角色权限</title>
</head>
<body>
<div class="admin">
    <jsp:include   page="../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <form class="am-form-inline">
                <fieldset>
                    <legend class="am-text-center">修改角色</legend>
                </fieldset>
            </form>
            <div style="margin-left: 50px;margin-bottom: 10px">
                <button type="button" onClick="javascript:history.go(-1)" class="am-btn am-btn-primary">返回</button>
            </div>
            <form class="am-form" action="saveRole" method="post">
                <fieldset>
                    <legend>修改角色</legend>
                    教师工号:
                    <input type="text" name="teacherNo" value="${teacher.teacherNo}">
                    教师名：
                    <input name="teacherName" value="${teacher.teacherName}" type="text" class="am-form-field am-radius" placeholder="请输入角色名" required/>
                    <input type="hidden" id="roleId" value="${teacher.roleId}">
                    <br>
                    角  色：
                    <div class="am-form-group">
                        <c:forEach items="${roleList}" var="role">
                            <label class="am-checkbox-inline">
                                <input type="checkbox" name="roleId" value="${role.roleId}"> ${role.roleName}
                            </label>
                        </c:forEach>
                    </div>
                    <button style="float: right;margin-right: 100px" type="submit" class="am-btn am-btn-primary">确定</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<script>

    var teacherRoleId = document.getElementById("roleId");
    var roleId = document.getElementsByName("roleId")
    var troleId = teacherRoleId.value.split(",");
    for(var i=0;i<troleId.length;i++){
        for(var j=0;j<roleId.length;j++){
            if (troleId[i]==roleId[j].value){
                roleId[j].checked=true;
            }
        }
    }

    // var menuPower = document.getElementById("menuPower").value;
    // if(menuPower!=null&&menuPower!=""){
    //     document.getElementsByName("menuPower")[menuPower].checked = true;
    // }

</script>

</body>
</html>