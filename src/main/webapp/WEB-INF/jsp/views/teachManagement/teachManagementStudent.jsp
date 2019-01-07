<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>学生评教管理</title>
</head>
<body>
<div class="admin">
    <jsp:include page="../sidebar.jsp" flush="true"/>
    <div class="content-page">
        <div class="content">
            <legend class="am-text-center">学生评教管理</legend>
            <div class="am-g">
                <div class="am-u-sm-2 am-u-lg-offset-3">
                    <label for="doc-select-1">学年选择:</label>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-8 am-u-lg-offset-3 am-form-inline am-u-end">
                    <div style="margin: auto" class="am-form-group am-fl">
                        <select class="am-form-field" id="doc-select-1" name="year">
                            <option value="null">请选择学年</option>
                            <option value="2016-2017学年">2016-2017学年</option>
                            <option value="2017-2018学年">2017-2018学年</option>
                        </select>
                        <span class="am-form-caret"></span>
                    </div>
                    <div class="am-form-group" style="line-height: 37px;">
                        <label class="am-radio-inline">
                            <input type="radio" value="第一学期" name="docInlineRadio"> 第一学期
                        </label>
                        <label class="am-radio-inline">
                            <input type="radio" value="第二学期" name="docInlineRadio"> 第二学期
                        </label>
                    </div>
                        <input type="button" value="检索">
                </div>
            </div>
            <table class="am-table am-table-bordered am-table-radius am-table-striped">
                <thead>
                    <tr>
                        <td>学号</td>
                        <td>姓名</td>
                        <td>班级</td>
                        <td>评教状态</td>
                        <td>操作</td>
                    </tr>
                    <tr>
                        <td style="width: 180px">
                            <div><input class="am-form-field" type="text" placeholder="学号筛选"></div>
                        </td>
                        <td style="width: 180px">
                            <div><input class="am-form-field" type="text" placeholder="姓名筛选"></div>
                        </td>
                        <td>
                            <select class="am-form-field" name="班级">
                                <option value="null">请选择班级</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>
                        </td>
                        <td>
                            <select class="am-form-field" name="班级">
                                <option value="null">评教状态选择</option>
                                <option value="1">未完成</option>
                                <option value="2">完成</option>
                            </select>
                        </td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>







        </div>
    </div>
</div>

</body>
</html>