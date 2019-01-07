$(function () {
    $("#add").on("click",function () {
        //是否为空的判断
        if($("#teacherName").val().length<1||$("#teacherNo").val().length<1||$("#teacherPassword").val().length<1){
            alert("不能有空白项！");
        }else{
            addTeacher();
        }
    });
    //增加
    function  addTeacher() {
        var url="addTeacherDo";
        var param=$("#addTeacherForm").serialize();
        $.post(url,param,function (data) {
            if(data==="1"){
                alert("添加成功!");
                $("#addTeacherForm")[0].reset();
            }else if(data=="2"){
                alert("此工号已存在!");
            }else{
                alert("添加失败");
            }
        })
    }

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
        importExcel();
    });
    //导入Excel请求
    function importExcel() {
        var url="importExcelTeacher";
        var param=new FormData($("#importExcel")[0]);
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
                    $("#loading").empty().append(top).fadeOut(2000);
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