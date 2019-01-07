/**
 * 评教节点树
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
    //初始化数据
    $.post({
        url: "evaluationQuotaLoad?roleId="+$("#roleId").val() ,
        dataType: "json",
        success: function (data) {
            query(setting,data);
            //全部展开
            var dataTree = $.fn.zTree.getZTreeObj("dataTree");
            setTimeout(function(){
                dataTree.expandAll("true");
            },200);//延迟加载
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
    return htmlStr;
}

/**
 * 指标管理，查询数据
 */
function query(setting,data) {
    var zTreeNodes = data;
    var dataTree = $("#dataTree");
    //初始化树
    $.fn.zTree.init(dataTree, setting, zTreeNodes);
    //添加表头
    var li_head = ' <li class="head"><a><div class="diy"></div></a></li>';
    var rows = dataTree.find('li');
    if (rows.length > 0) {
        rows.eq(0).before(li_head)
    } else {
        dataTree.append(li_head);
        dataTree.append('<li ><div style="text-align: center;line-height: 30px;" >无符合条件数据</div></li>')
    }

}

var nnum = 0;
var nnum_re = 0;
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
    if(treeNode.children === undefined ){
        spaceStr += "<span style='display: inline-block;color: #ff2520;font-size: 18px;margin-right: 10px' class='department_y_icn'>-</span>";
    }
    switchObj.before(spaceStr);
    var editStr = '';
    if(treeNode.children == undefined ){
        nnum_re++;
        editStr += '<div style="display: inline-block;font-weight: bold;" class="diy inp"><input class="inpp"  parentId="thisP_'+treeNode.quotaParentId+'" score="'+treeNode.quotaWeight+'" value="'+treeNode.quotaId+'" type="radio" name="parentId_'+treeNode.quotaParentId+'" style="display: inline-block;" class="diy"></input></div>';
        editStr += '<div class="diy">' + formatHandle(treeNode) + '</div>';
    }else {
        editStr += '<div style="display: inline-block;font-weight: bold;" class="diy" id="thisP_'+treeNode.quotaId+'" score="'+treeNode.quotaWeight+'"></div>';
        editStr += '<div class="diy">' + formatHandle(treeNode) + '</div>';
    }
    aObj.append(editStr);
}


    function resultDo(userId,teaacherNo,termId,courseId){
        nnum = nnum_re;
        var num = 0;
        var allScore = 0;
        $("#dataTree  .inp > input:checked").each(function () {
            num++;
            var parentId = "#"+$(this).attr("parentId");
            var parentScore = $(parentId).attr("score");
            var selfScore = $(this).attr("score");
            var result = parentScore*selfScore;
            allScore += result;
        });
        if (nnum/4 != num){
            alert("请完成每一个评价！！！")
        } else {
            var url = "evaluationScoreDo";
            var param = {evaluationJudgesId:userId,evaluationPlayerId:teaacherNo,score:allScore*10,termId:termId,courseId:courseId};
            $.post(url,param,function (data) {
                if (data === "true") {
                    alert("评教完成!!!");
                    location.href="studentEvaluation"
                }

            })
        }
    }









