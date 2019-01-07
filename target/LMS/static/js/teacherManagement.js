$(function () {
    $(".content-page>.content .delTeacher").on("click",function () {
        delTeacher($(this).attr("id"));
    });
    // 删除
    function delTeacher(id){
        var result=confirm("确认删除?");
        if(result){
            //开始发送异步请求
            var url="delTeacher";
            var param ={teacherNo:id};
            $.post(url, param, function(data) {
                if(data=="1"){
                    alert("删除成功!");
                    location.href="teacherManagement";
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
    $(".editTeacher").on("click",function () {
        editTeacher($(this).attr("id"));
    });
    //编辑相关函数1
    function editTeacher(id) {
        var url="editTeacher";
        var param={teacherNo:id};
        $.post(url,param,function (data) {
            //显示编辑内容.
            $(".content-page").html(data);
            //绑定保存修改
            $("#edit").on("click",function () {
                //是否为空的判断
                if($("#teacherName").val().length<1||$("#teacherNo").val().length<1||$("#teacherPassword").val().length<1){
                    alert("不能有空白项！");
                }else{
                    editTeacherDo();
                }
            });
            //显示部门
            $("#departmentId").val($(".department").attr("id"));
            //显示角色
            $("#roleId").val($(".role").attr("id"));
            //显示性别
            $("#teacherSex").val($("#teacherSexValue").val());
            //现在在职状态
            $("#teacherStatus").val($("#teacherStatusValue").val());
            //重置密码
            $("#restPassword").on("click",function () {
                $("#teacherPassword").val("123456");
                $("#YorNChangePas").val("1");
                alert("重置成功！")
            });
        });
    }

    //保存编辑相应函数
    function  editTeacherDo() {
        var result=confirm("确认修改?");
        if(result){
            var url="editTeacherDo";
            var param=$("#addTeacherForm").serialize();
            $.post(url,param,function (data) {
                if(data==="1"){
                    alert("修改成功!");
                    location.href="teacherManagement";
                }else if(data=="2"){
                    alert("此工号已存在!");
                }else{
                    alert("修改失败!");
                }
            });
        }

    }
});
$(function () {
    $("#no_del").on("click",function () {
        alert("就算你点了也删不掉!!!")
    })
});
