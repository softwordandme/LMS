<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/amazeui.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/loginCss.css" />
</head>
<body id="login_bg">
    <form class="am-form login_form" action="login/submit" id="login" method="post">
        <fieldset style="height: 100%">
            <div style="height: 40px" class="login_error_hint" id="login_error_hint"></div>
            <div style="height: 30px;margin-bottom: 100px;font-size: 36px" class="head">教师评教系统</div>
            <div style="height: 40px;width: 100%;text-align: center;margin: 16px">
                <input style="float: right;width: 70%" required type="text" class="am-round" id="userid" name="userid" placeholder="请输入学号或工号" title="请输入学号或工号">
                <label style="float: right;width: 30%" for="userid">账号:</label>
            </div>
            <div style="height: 40px;width: 100%;text-align: center;margin: 16px">
                <input style="float: right;width: 70%" required type="password" class="am-round" id="password" name="password" placeholder="请输入密码" title="请输入密码">
                <label style="float: right;width: 30%" for="password">密码:</label>
            </div>
            <div style="height: 40px;width:100%;margin: 16px">
                <div style="width: 24%;float: right;text-align: center">
                    <a href="#" id="refresh" style="font-size: 16px;">看不清?</a>
                </div>
                <div style="width: 24%;float: right" id="verify_img">
                    <img alt="验证码" src="defaultKaptcha" />
                </div>
                <div style="width: 4%;float: right;text-align: center" id="verify_show"></div>
                <div style="width: 24%;float: right;text-align: center">
                    <input required type="text" class="am-round" id="verify_input" placeholder="验证码">
                </div>
                <div style="width: 24%;float: right;text-align: center">
                    <label for="verify_input">验证码:</label>
                </div>
            </div>
            <div style="height: 40px;float: right">
                    <button class="am-btn am-btn-default am-round" id="login_submit" type="button" title="登陆">登陆</button>
                    <a class="am-btn am-btn-default am-round" href="index" title="返回首页">返回首页</a>
            </div>
        </fieldset>
    </form>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery-3.3.1.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/js.js"></script>
</body>
</html>