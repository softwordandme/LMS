$(function () {
    $(".content-page>.content .delStudent").on("click",function () {
        console.log($(this).attr("id"));
        delStudent($(this).attr("id"));
    });
    // 删除
    function delStudent(id){
        var result=confirm("确认删除?");
        if(result){
            //开始发送异步请求
            var url="delStudent";
            var param ={studentId:id};
            $.post(url, param, function(data) {
                if(data==="1"){
                    alert("删除成功!");
                    location.href="studentManagement";
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
    $(".editStudent").on("click",function () {
        editStudent($(this).attr("id"));

    });
    //编辑相关函数1
    function editStudent(id) {
        var url="editStudent";
        var param={studentId:id};
        $.post(url,param,function (data) {
            //.
            $(".content-page").html(data);
            //绑定保存修改
            $("#edit").on("click",function () {
                //是否为空的判断
                if($("#studentName").val().length<1||$("#studentNo").val().length<1){
                    alert("不能有空白项！");
                }else{
                    editStudentDo();
                }
            });
            //重置密码
            $("#restPassword").on("click",function () {
                $("#studentPassword").val("123456");
                $("#YorNChangePas").val("1");
                alert("重置成功！");
            });
        });
    }

    //保存编辑相应函数
    function  editStudentDo() {
        var result=confirm("确认修改?");
        if(result){
            var url="editStudentDo";
            var param=$("#addStudentForm").serialize();
            $.post(url,param,function (data) {
                if(data==="1"){
                    alert("修改成功!");
                    location.href="studentManagement";
                }else if(data=="2"){
                    alert("此学号已存在!");
                }else{
                    alert("修改失败!");
                }
            });
        }

    }
});
