$(function () {
    var selectCourse=$("#selectCourse");
    $("#courseId").val(selectCourse.val());
    $("#courseName").val(selectCourse.find("option:selected").text());
    selectCourse.on("change",function () {
        $("#courseId").val(selectCourse.val());
        $("#courseName").val(selectCourse.find("option:selected").text());
    });
    $("#add").on("click",function () {
        //是否为空的判断
        if($("#clazzNum").val().length<1||$("#clazzName").val().length<1){
            alert("班级编号或名称不能为空！")
        }else{
            addClazz();
        }
    });
    //增加
    function  addClazz() {
        var url="addClazzDo";
        var param=$("#addClazzForm").serialize();
        console.log(param);
        $.post(url,param,function (data) {
            if(data==="1"){
                alert("添加成功!");
                $("#addClazzForm")[0].reset();
            }else if(data==="0"){
                alert("添加失败(可能该班级已有该课程！");
            }
        })
    }

});