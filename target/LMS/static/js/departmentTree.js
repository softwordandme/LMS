/**
 * 部门节点树
 */
$(function () {

    var setting = {
        view: {
            showLine: false,
            showIcon: true,
            addDiyDom: addDiyDom,
            dblClickExpand: false
        },
        data: {
            key: {
                title: "departmentName", //鼠标悬停显示的信息
                name: "departmentName" //网页上显示出节点的名称
            },
            simpleData: {
                enable: true,
                idKey: "departmentId", //修改默认的ID为自己的ID
                pIdKey: "parentId",//修改默认父级ID为自己数据的父级ID
                rootPId: null     //根节点的ID
            }
        },
        callback:{
            onClick: onNodeClick
        }
    };
    //初始化数据
    $.post({
        url: "departmentManagementList",
        dataType: "json",
        success: function (data) {
            query(setting,data);
        }
    });

    $("#dataTree > li").css({background:"blue"});


});


/**
 * ztree点击展开
 */
function onNodeClick(e,treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    zTree.expandNode(treeNode);
}


/**
 * 根据权限展示功能按钮
 * @param treeNode
 * @returns {string}
 */
function formatHandle(treeNode) {
    var htmlStr = '';
    htmlStr += '<div class="icon_div"><a class="icon_edit" title="修改" href="updateDepartment?departmentId=' + treeNode.departmentId + '">修改</a></div>';
    if (treeNode.level <2 ) {
        htmlStr += '<div class="icon_div"><a class="icon_add" title="添加子部门" href="addDepartment?parentId=' + treeNode.departmentId + '">添加</a></div>';
    }
    htmlStr += '<div class="icon_div"><a class="icon_del" title="删除" href="javascript:del(\'' + treeNode.departmentId+ '\')">删除</a></div>';
    return htmlStr;
}

/**
 * 部门管理，查询数据
 */
function query(setting,data) {
    var zTreeNodes = data;
    var dataTree = $("#dataTree");
    //初始化树
    $.fn.zTree.init(dataTree, setting, zTreeNodes);
    //添加表头
    var li_head = ' <li class="head"><a><div class="diy">部门名称</div><div class="diy">部门编号</div><div class="diy">操作</div></a></li>';
    var rows = dataTree.find('li');
    if (rows.length > 0) {
        rows.eq(0).before(li_head)
    } else {
        dataTree.append(li_head);
        dataTree.append('<li ><div style="text-align: center;line-height: 30px;" >无符合条件数据</div></li>')
    }

}


/**
 * 自定义DOM节点
 */
function addDiyDom(treeId, treeNode) {
    var spaceWidth = 15;
    var liObj = $("#" + treeNode.tId);
    var aObj = $("#" + treeNode.tId + "_a");
    var switchObj = $("#" + treeNode.tId + "_switch");
    var icoObj = $("#" + treeNode.tId + "_ico");
    var spanObj = $("#" + treeNode.tId + "_span");
    aObj.attr('title', '');
    aObj.append('<div class="diy swich"></div>');
    var div = $(liObj).find('div').eq(0);
    switchObj.remove();
    spanObj.remove();
    icoObj.remove();
    div.append(switchObj);
    div.append(spanObj);
    var spaceStr = "<span style='height:1px;display: inline-block;width:" + (spaceWidth * treeNode.level)+  "px'></span>";

    if(treeNode.children !== undefined ){
        spaceStr += "<span style='display: inline-block;color: #ff2520;font-size: 18px;margin-right: 10px' class='department_y_icn'>+</span>";
    }else {
        spaceStr += "<span style='display: inline-block;color: #ff2520;font-size: 18px;margin-right: 10px;width: 19px' class='department_y_icn'></span>";
    }
    switchObj.before(spaceStr);
    var editStr = '';
    editStr += '<div style="display: inline-block;" class="diy">' + (treeNode.departmentId == null ? '&nbsp;&nbsp;' : treeNode.departmentId) + '</div>';
    editStr += '<div class="diy">' + formatHandle(treeNode) + '</div>';
    aObj.append(editStr);
}


function del(departmentId) {
    if (confirm("是否确认删除？(提示:所选项目的下属项目也会一并删除)" + departmentId)) {
        $.post({
            url: "delDepartmentDo?departmentId=" + departmentId,
            success: function (d) {
                $(location).attr("href", "departmentManagement");
            }
        })
    }
}



/**
 * 修改部门信息
 */
$(function () {
    $("#updateDepartmentDo").on("click",function () {
        $.post({
            url: "updateDepartmentDo?cDepartmentId="+$("#cDepartmentId").val()+"&cDepartmentName="+$("#cDepartmentName").val(),
            success: function (date) {
                alert("修改成功!");
                $(location).attr("href", "departmentManagement");
            }
        })
    })
});