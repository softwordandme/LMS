$(function () {
    $(".content-page>.content .delClazz").on("click",function () {
        console.log($(this).attr("id"));
        delClazz($(this).attr("id"));
    });
    // 删除
    function delClazz(id){
        var result=confirm("确认删除?");
        if(result){
            //开始发送异步请求
            var url="delClazz";
            var param ={id:id};
            $.post(url, param, function(data) {
                if(data=="1"){
                    alert("删除成功!");
                    location.href="classManagement";
                }else{
                    alert("删除失败!");
                }
            });
        }
    }
    //过滤
    $("#searchMessage").on("input",function () {
        if($(this).val().length!==0){
            $(".content tr:gt(0)").not(":contains("+$(this).val()+")").hide();
            $(".content tr:gt(0):contains("+$(this).val()+")")
                .show()
                .addClass("am-primary");

        }else {
            $(".content tr:gt(0)").removeClass("am-primary");
            $(".content tr:hidden").show();
        }

    });
    //编辑跳转
    $(".editClazz").on("click",function () {
        editClazz($(this).attr("id"));
    });
    //编辑相关函数1
    function editClazz(id) {
        var url="editClazz";
        var param={id:id};
        $.post(url,param,function (data) {
            //显示编辑表格
            $(".content-page").html(data);
            //实时加载班级编号对应的班级名
            findClazzNameByClazzNum();
            //显示课程
            var selectCourse=$("#selectCourse");
            selectCourse.val($("#courseId").val());
            //改变课程选项
            selectCourse.on("change",function () {
                $("#courseId").val(selectCourse.val());
                $("#courseName").val(selectCourse.find("option:selected").text());
            });
            //绑定保存修改
            $("#edit").on("click",function () {
                //是否为空的判断
                if($("#clazzNum").val().length<1||$("#clazzName").val().length<1){
                    alert("班级编号或名称不能为空！")
                }else{
                    editClazzDo();
                }
            });
            //显示部门
            $("#department").val($("#showDepartmentId").val());
        });
    }

    //保存编辑相应函数
    function  editClazzDo() {
        var result=confirm("确认修改?");
        if(result){
            var url="editClazzDo";
            var param=$("#addClazzForm").serialize();
            $.post(url,param,function (data) {
                if(data==="1"){
                    alert("修改成功!");
                    location.href="classManagement";
                }else{
                    alert("修改失败!（内容无变化或者可能该班级已有该课程！）");
                }
            });
        }

    }
});
$(function () {
    findClazzNameByClazzNum();
});
//实时加载班级编号对应的班级名，实现
function findClazzNameByClazzNum(){
    $("#clazzNum").on("input propertychange",function () {
        $.post({
            url:"findClazzNameByClazzNum?clazzNum="+$(this).val(),
            success:function (data) {
                if (data != null && data != "") {
                    $("#clazzName").val(data).attr("readonly","readonly");
                }else {
                    $("#clazzName").val("").removeAttr("readonly");
                }
            }
        })
    })
}
