<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <legend style="padding-left: 40%">修改密码</legend>
            <form action="" method="post" style="padding-left: 20%">
                <div class="am-container">
                    <div class="am-g">
                        <div class="am-u-sm-5">
                            旧 密 码 :
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5">
                            <input type="text" class="am-form-field" id="oldPassword" placeholder="输入旧密码">
                        </div>
                    </div>

                    <div class="am-g">
                        <div class="am-u-sm-5">
                            <div>新 密 码 :</div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5">
                            <input type="text" class="am-form-field" id="newPassword" placeholder="输入新密码">
                        </div>
                    </div>

                    <div class="am-g">
                        <div class="am-u-sm-5">
                            <div>确认密码:</div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5">
                            <input type="text" class="am-form-field" id="newPasswordTrue" placeholder="确认新密码">
                        </div>
                        <div class="am-u-sm-7 am-padding-xs am-text-warning" id="newPasswordTrue_warning">
                        </div>
                    </div>
                </div>

                <div style="margin-left: 20%">
                    <button type="button" class="am-btn am-btn-warning" id="changPassword_submit">提交</button>
                    <a href="javascript:history.back(-1)" class="am-btn am-btn-default">返回</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>