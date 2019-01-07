<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>更新角色权限</title>
    <link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
<div class="admin">
    <jsp:include   page="../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <form class="am-form-inline">
                <fieldset>
                    <legend class="am-text-center">添加修改角色权限</legend>
                </fieldset>
            </form>
            <div style="margin-left: 50px;margin-bottom: 10px">
                <button type="button" onClick="javascript:history.go(-1)" class="am-btn am-btn-primary">返回</button>
            </div>
            <form class="am-form" action="savePowerRole" method="post">
                <fieldset>
                    <legend>添加修改角色权限</legend>
                    <input type="hidden" name="roleId" value="${role.roleId}">
                    角色名：
                    <input name="roleName" value="${role.roleName}" type="text" class="am-form-field am-radius" />
                    <br>
                    权  限：
                    <input type="hidden" value="${role.rolePower}" name="rolePower" id="rolePower">
                    <div>
                        <ul id="treeDemo" class="ztree"></ul>
                    </div>
                    <button style="float: right;margin-right: 100px" type="submit" class="am-btn am-btn-primary">确定</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting, null);


    });

    var setting = {
        async: {
            enable: true,//采用异步加载
            dataFilter: ajaxDataFilter,    //预处理数据
            url : "menuTree",
            dataType : "json"
        },
        data : {
            key : {
                title : "menuName",
                name : "menuName"
            },
            simpleData : {
                enable : true,
                idKey : "menuId",
                pIdKey : "menuParentId",
                rootPid : ""
            }
        },
        view: {
            dblClickExpand: false,//双击节点时，是否自动展开父节点的标识
            showLine: true,//是否显示节点之间的连线
            selectedMulti: true //设置是否允许同时选中多个节点
        },
        check: {
            enable: true,
            chkStyle: "checkbox",
            chkboxType: { "Y": "ps", "N": "ss" }
        },
        callback: {
            onAsyncSuccess: zTreeOnAsyncSuccess,
            onCheck: zTreeOnCheck
        }
    }
    /* 获取返回的数据，进行预操作 */
    function ajaxDataFilter(treeId, parentNode, childNodes) {
        return childNodes;
    };
    
    function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
        var treeObj = $.fn.zTree.getZTreeObj(treeId);//ztree树的ID
        var rolePower = document.getElementById("rolePower").value;
        var roleList = rolePower.split(",");
        for(var i=0;i<roleList.length;i++){
            var node = treeObj.getNodeByParam("menuId",roleList[i]);//根据ID找到该节点
            node.checked = true;
            treeObj.updateNode(node);
        }

    }
    function zTreeOnCheck(event, treeId, treeNode) {
        var treeObj = $.fn.zTree.getZTreeObj(treeId);

        var checkedNodes = treeObj.getCheckedNodes();
        var n = "";
        for(var i=0;i<checkedNodes.length;i++){
            if(n!=null&&n!=""){
                n = n+","+checkedNodes[i].menuId;
            }else{
                n= checkedNodes[i].menuId;
            }
        }
        var rolePower = document.getElementById("rolePower");
        rolePower.value = n;

    }

</script>
</body>
</html>