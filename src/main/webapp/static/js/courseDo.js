$(function () {
    $("#add").on("click",function () {
        //是否为空的判断
        if($("#courseName").val().length<1||$("#teacherNo").val().length<1){
            alert("不能有空白项！")
        }else if ($("#teacherName").attr("sign") === "no") {
            alert("无此教师！")
        }else {
            addCourse();
        }
    });
    //增加
    function  addCourse() {
        var url="addCourseDo";
        var param=$("#addCourseForm").serialize();
        $.post(url,param,function (data) {
            if(data==="1"){
                alert("添加成功!");
                $("#addCourseForm")[0].reset();
            }else if(data==="0"){
                alert("添加失败");
            }
        })
    }
});

$(function () {
    $("#teacherNo").on("input propertychange",function () {
        $.ajax({
            url:"showTeacherName?teacherNo="+$(this).val(),
            type:"post",
            success:function (data) {
                if (data != null && data != ""){
                    $("#teacherName").html(data).attr("sign","true");
                } else {
                    $("#teacherName").html("无此教师").attr("sign","no");
                }
            }

        })
    })
});