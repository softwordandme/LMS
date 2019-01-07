$(function () {

    $("#add").on("click",function () {
        addQuota();
    });
    //增加
    function   addQuota() {
        var url="addQuotaDo";
        var param=$("#addQuotaForm").serialize();
        $.post(url,param,function (data) {
            if(data==="1"){
                alert("添加成功!");
                location.href="quotaManagement";
            }else if(data==="0"){
                alert("添加失败");
            }
        })
    }
    $("#edit").on("click",function () {
        editQuotaDo();
    });
    //保存编辑相应函数
    function  editQuotaDo() {
        var result=confirm("确认修改?");
        if(result){
            var url="editQuotaDo";
            var param=$("#editQuotaForm").serialize();
            $.post(url,param,function (data) {
                if(data==="1"){
                    alert("修改成功!");
                    location.href="quotaManagement";
                }else{
                    alert("修改失败!");
                }
            });
        }

    }
});