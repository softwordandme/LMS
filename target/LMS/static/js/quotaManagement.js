/**
 * 指标节点树
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
                title: "quotaName", //鼠标悬停显示的信息
                name: "quotaName" //网页上显示出节点的名称
            },
            simpleData: {
                enable: true,
                idKey: "quotaId", //修改默认的ID为自己的ID
                pIdKey: "quotaParentId",//修改默认父级ID为自己数据的父级ID
                rootPId: null     //根节点的ID
            }
        },
        callback:{
            onClick: onNodeClick
        }
    };
    $("#dataTree > li").css({background:"blue"});
    $("#retrieval").on("click",function () {
        loadData();
    });
    function loadData() {
        var quotaType=$("#selectType").val();
        //初始化数据
        $.post({
            url: "quotaList?quotaType="+quotaType,
            dataType: "json",
            success: function (data) {
                query(setting,data);
            }
        });


    }
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
    htmlStr += '<div class="icon_div"><a class="icon_edit" title="修改" href="editQuota?quotaId=' + treeNode.quotaId + '">修改</a></div>';
    if (treeNode.level <2 ) {
        htmlStr += '<div class="icon_div"><a class="icon_add" title="添加" href="addQuota?quotaParentId=' + treeNode.quotaId + '">添加</a></div>';
    }
    htmlStr += '<div class="icon_div"><a class="icon_del" title="删除" href="javascript:del(\'' + treeNode.quotaId+ '\')">删除</a></div>';
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
    var li_head = '<li class="head"><div class="diy">指标名称</div><div class="diy">指标类型</div><div class="diy">权重</div><div class="diy">操作</div></li>';
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
        spaceStr += "<span style='display: inline-block;color: #ff2520;font-size: 18px;margin-right: 10px' onclick='department_icn(1)' class='department_y_icn'>+</span>";
    }else {
        spaceStr += "<span style='display: inline-block;color: #ff2520;font-size: 18px;margin-right: 10px;width: 19px' onclick='department_icn(0)' class='department_y_icn'></span>";
    }
    switchObj.before(spaceStr);
    var editStr = '';
    //editStr += '<div style="display: inline-block;" class="diy">' + (treeNode.quotaId == null ? '&nbsp;&nbsp;' : treeNode.quotaId) + '</div>';
    //判断指标类型
    var qType="";
    switch (treeNode.quotaType){
        case 1:
            qType="学生";
            break;
        case 2:
            qType="教师";
            break;
        case 3:
            qType="系主任";
            break;
        default:
            break;
    }
    editStr += '<div style="display: inline-block;" class="diy">' + (qType== null ? '&nbsp;&nbsp;' : qType) + '</div>';
    editStr += '<div style="display: inline-block;" class="diy">' + (treeNode.quotaWeight == null ? '&nbsp;&nbsp;' : treeNode.quotaWeight) + '</div>';
    editStr += '<div class="diy">' + formatHandle(treeNode) + '</div>';
    aObj.append(editStr);
}

function department_icn(t) {
    console.log(t)
}

// 删除
function del(quotaId){
    var result=confirm("确认删除?(提示:所选项目的下属项目也会一并删除)");
    if(result){
        //开始发送异步请求
        var url="delQuota";
        var param ={quotaId:quotaId};
        $.post(url, param, function(data) {
            if(data==="1"){
                alert("删除成功!");
                location.href="quotaManagement";
            }else{
                alert("删除失败!");
            }
        });
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
$(function () {
    //选择文件的显示
    $('#doc-form-file').on('change', function() {
        var fileNames = '';
        $.each(this.files, function() {
            fileNames += '<span class="am-badge">' + this.name + '</span> ';
        });
        $('#file-list').html(fileNames);
        if($(this).val()!==""){
            $("#import").css({ opacity:1});
        }else{
            $("#import").css({ opacity:0});
        }
    });
    //点击导入
    $("#import").on("click",function () {
        $("#loading").css("display","block");
        importExcel($("#roleShow").val());
    });
    //导入Excel请求
    function importExcel(qType) {
        var url="importExcelQuota?qType="+qType;
        var param=new FormData($("#importExcel")[0]);
        console.log(param);
        $.ajax({
            url:url,
            type:"post",
            data:param,
            processData:false,
            contentType:false,
            success:function(data) {
                var top=null;
                if(data==="3"){
                    top="<div class='loadTop'>导入成功!</div>";
                    $("#loading").empty().append(top).fadeOut(2000).queue(function () {
                        location.href="quotaManagement";
                    });
                }else if(data==="0"){
                    top="<div class='loadTop'>您导入的文件不是Excel！</div>";
                    $("#loading").empty().append(top).fadeOut(2000);
                }else if(data==="2"){
                    top="<div class='loadTop'>您导入的文件为空！</div>";
                    $("#loading").empty().append(top).fadeOut(2000);
                } else{
                    top="<div class='loadTop'>导入失败！</div>";
                    $("#loading").empty().append(top).fadeOut(2000);
                }
            },error:function(data) {
                var top="<div class='loadTop'>文件的内容格式不对！</div>";
                $("#loading").empty().append(top).fadeOut(2000);
            }
        });
    }
});
