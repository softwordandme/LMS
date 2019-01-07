$(function () {
    $(".content-page>.content .delCourse").on("click",function () {
        delCourse($(this).attr("id"));
    });
    // 删除
    function delCourse(id){
        var result=confirm("确认删除?");
        if(result){
            //开始发送异步请求
            var url="delCourse";
            var param ={courseId:id};
            $.post(url, param, function(data) {
                if(data==="1"){
                    alert("删除成功!");
                    location.href="courseManagement";
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
    $(".editCourse").on("click",function () {
        editCourse($(this).attr("id"));
    });
    //编辑相关函数1
    function editCourse(id) {
        var url="editCourse";
        var param={courseId:id};
        $.post(url,param,function (data) {
            //.刷新页面内容
            $(".content-page").html(data);
            //显示教师名称
            findTeacherName();
            //实时查询教师名称
            $("#teacherNo").on("input propertychange",function () {
                findTeacherName();
            });
            //绑定保存修改
            $("#edit").on("click",function () {
                //是否为空的判断
                if($("#courseName").val().length<1||$("#teacherNo").val().length<1){
                    alert("不能有空白项！")
                }else if ($("#teacherName").val() === "无此教师") {
                    alert("无此教师！")
                }else {
                    editCourseDo();
                }
            });
        });
    }

    //保存编辑相应函数
    function  editCourseDo() {
        var result=confirm("确认修改?");
        if(result){
            var url="editCourseDo";
            var param=$("#addCourseForm").serialize();
            $.post(url,param,function (data) {
                if(data==="1"){
                    alert("修改成功!");
                    location.href="courseManagement";
                }else{
                    alert("修改失败!");
                }
            });
        }

    }

    function findTeacherName() {
        $.ajax({
            url:"showTeacherName?teacherNo="+$("#teacherNo").val(),
            type:"post",
            success:function (data) {
                if (data != null && data != ""){
                    $("#teacherName").val(data);
                } else {
                    $("#teacherName").val("无此教师");
                }
            }

        });
    }

});
