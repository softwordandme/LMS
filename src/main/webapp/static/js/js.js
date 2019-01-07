//侧边栏菜单鼠标悬浮效果
$(function ($) {
    $(".admin-parent > ul > li").hover(function () {
        $(this).css({"background":"#99fdff"})
    },function () {
        $(this).css({"background":"#fff"})
    })
});

//时间显示
$(function ($) {
    var year;
    var mo;
    var day;
    var ss;
    var ff;
    var mm;
    function date_update() {
        var date = new Date();
        year = date.getFullYear();
        mo = date.getMonth()+1;
        day =date.getDate();
        ss = date.getHours();
        ff = date.getMinutes();
        mm = date.getSeconds();
    }
    var new_date = $("#new_date");
    setInterval(function () {
        date_update();
        new_date.text(year+"年"+mo+"月"+day+"日"+" "+ss+":"+ff+":"+mm);
    },1000)

});
/*登陆验证码*/
var verify = 0;
var verify_img = $("#verify_img");
var verify_input = $("#verify_input");
var login_error_hint = $("#login_error_hint");
$(function ($) {
    /*刷新验证码*/
  $("#refresh").on("click",function () {
      verify_input.val(null);
      $("#verify_show").html("");
      verify_img.html("<img alt=\"验证码\" src=\"defaultKaptcha\" />")
  });

  /*验证码验证输入框调整*/
    $("#verify_input").focus(function () {
        fn_verify($(this),$("#verify_show"));
    }).on("input propertychange",function () {
        fn_verify($(this),$("#verify_show"));
    })
});

/*验证码验证函数*/
function fn_verify(price_pa,verify_shwo){
    $.ajax({
        type:"get",
        url:"imgvrifyControllerDefaultKaptcha?parameter="+price_pa.val(),
        success:function (data) {
            if (data == "true") {
                verify_shwo.html("√");
                verify = 1;
            } else {
                verify_shwo.html("x");
                verify = 0;
            }
        }
    })
}

/*登陆*/
$(function ($) {
   $("#login_submit").on("click",function () {
       if($("#userid").val()===""||!$("#userid").val()){
           verify_input.val(null);
           verify = 0;
           $("#verify_show").html("");
           verify_img.html("<img alt=\"验证码\" src=\"defaultKaptcha\" />");
           login_error_hint.html("账号不能为空!");
       }if($("#password").val()===""||!$("#password").val()){
           verify_input.val(null);
           verify = 0;
           $("#verify_show").html("");
           verify_img.html("<img alt=\"验证码\" src=\"defaultKaptcha\" />");
           login_error_hint.html("密码不能为空!");
       }else{
           if (verify===1){
               $.ajax({
                   type:"post",
                   url:"submit?userid="+$("#userid").val()+"&password="+$("#password").val(),
                   success:function (data) {
                       if(data==="true"){
                           $(location).attr("href","index");
                       }else{
                           verify_input.val(null);
                           verify = 0;
                           $("#verify_show").html("");
                           verify_img.html("<img alt=\"验证码\" src=\"defaultKaptcha\" />");
                           login_error_hint.html("账号或密码错误!");
                       }
                   }
               })
           }else{
               verify_input.val(null);
               verify = 0;
               verify_img.html("<img alt=\"验证码\" src=\"defaultKaptcha\" />");
               login_error_hint.html("验证码错误!");
           }
       }
   })

});

/*login背景变化*/
$(function ($) {
    var one_bg = 55;
    var two_bg = 45;
    var jie = 0;
    var login_bg = setInterval(function () {
        if(jie === 0) {
            $("#login_bg").css({background: "radial-gradient(#e860ff " + two_bg + "%,white " + one_bg + "%)"});
            two_bg = two_bg - 1;
            one_bg = 100 - two_bg;
            if(one_bg >=140){
                clearInterval(login_bg);
            }
        }
    },100);
});

/*主页提示登陆*/
$(function ($) {
    $("#log_off").on("click",function () {
        $.get({
            url:"log_off",
            success:function (date) {
                if(date==="true"){
                    $(location).attr("href","login");
                }else{
                    alert("未知错误");
                    $(location).attr("href","login");
                }
            }
        })
    })
});

/*修改密码*/
var count = 0;
$(function ($) {
    var newPassword = $("#newPassword");
    var newPasswordTrue = $("#newPasswordTrue");
    judgeTwoPasswordTrue(newPassword,newPasswordTrue);
    judgeTwoPasswordTrue(newPasswordTrue,newPassword);

       $("#changPassword_submit").on("click",function () {
           if($("#newPassword").val()===""||$("#newPassword").val()===null){
               alert("新密码不能为空!!!");
           }else  if(count===1){
               $.ajax({
                   url:"changPasswordDo?oldPassword="+$("#oldPassword").val()+"&newPassword="+$("#newPassword").val(),
                   type:"post",
                   success:function (date) {
                       if(date==="inc"){
                           alert("旧密码错误！");
                       }else if(date === "true"){
                           alert("密码修改成功!");
                           $(location).attr("href","index");
                       }else {
                           alert("密码修改失败！！！");
                       }
                   }
               });
           }else{
               alert("两次输入的新密码不一致！！")
           }
       })
});

/*确认两次输入的密码是否一致*/
function judgeTwoPasswordTrue(one,two) {
    one.on("input propertychange",function () {
        if ($(this).val() === two.val()) {
            $("#newPasswordTrue_warning").html("两次输入新密码一致！");
            count = 1;
        } else {
            $("#newPasswordTrue_warning").html("两次输入新密码不一致！");
            count = 0;
        }
    })
}

/*角色管理的过滤*/
$(function ($) {
    $("#search_all").on("input propertychange",function () {
        if($(this).val()!=="") {
            $("#role_show > tr").hide();
            $("#role_show td").removeClass("am-danger").filter(":contains(" + $(this).val() + ")").addClass("am-danger").parents().show();
        }else{
            $("#role_show td").removeClass("am-danger").parents().show();
        }
    });
});





