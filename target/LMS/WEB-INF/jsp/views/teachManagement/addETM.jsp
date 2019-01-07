<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评教时间管理</title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>

    <div class="content-page">
        <div class="content">
            <fieldset><legend class="am-text-center">评教时间管理——新增</legend></fieldset>
            <form action="addETM" method="post" style="padding-left: 30%">
                <div class="am-container">
                    <div class="am-g"><div class="am-u-sm-5"><div>学年学期:</div></div></div>
                    <div class="am-g">
                        <div class="am-u-sm-5">
                            <select readonly="readonly" class="am-form-field" id="termId" name="termId">
                                    <option selected="selected"  value="${term.termId}">${term.termName}</option>
                            </select>
                        </div>
                    </div>

                    <div class="am-g"><div class="am-u-sm-5"><div>选择开始评教时间:</div></div></div>
                    <div class="am-g"><div class="am-u-sm-5"><input required name="evaluationStartin" type="date"></div></div>

                    <div class="am-g"><div class="am-u-sm-5"><div>选择结束评教时间:</div></div></div>
                    <div class="am-g"><div class="am-u-sm-5"><input required name="evaluationEndin" type="date"></div></div>
                </div>
                <div class="am-g"><div class="am-u-sm-5"><div>评教类型选择:</div></div></div>
                <div class="am-g">
                    <div class="am-u-sm-5">
                        <select class="am-form-field" id="roleId" name="roleId">
                            <option value="null">请选择角色，将增加对应角色的评教</option>
                            <c:forEach items="${roleList}" var="m">
                                <option value="${m.roleId}">${m.roleName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div style="margin-left: 30%">
                    <button type="submit" class="am-btn am-btn-warning" id="addETM_submit">提交</button>
                    <a href="javascript:history.back(-1)" class="am-btn am-btn-default">返回</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>