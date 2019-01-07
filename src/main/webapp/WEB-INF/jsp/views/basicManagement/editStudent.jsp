<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>编辑</title>
</head>
<body>

        <div class="header am-center">编辑</div>
        <div class="content">
            <form class="am-form am-form-horizontal am-center am-g am-g-fixed" id="addStudentForm">
                <div class="am-form-group">
                    <label for="studentNo" class="am-u-sm-2 am-text-right">学号</label>
                    <input type="hidden" name="studentId" value="${student.studentId}">
                    <div class=" am-u-sm-10">
                        <input type="text" name="studentNo" id="studentNo" value="${student.studentNo}"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="studentName" class="am-u-sm-2 am-text-right">姓名</label>
                    <div class="am-u-sm-10">
                        <input type="text" name="studentName" id="studentName" value="${student.studentName}"/>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="studentPassword" class="am-u-sm-2 am-text-right">密码</label>
                    <div class="am-u-sm-10">
                        <input type="hidden" name="studentPassword" id="studentPassword" value="${student.studentPassword}"/>
                        <button type="button" class="am-btn am-btn-danger" id="restPassword">重置</button>
                    </div>

                </div>
                <div class="am-form-group">
                    <label for="studentSex" class="am-u-sm-2 am-text-right">性别</label>
                    <div class="am-u-sm-10">
                        <select name="studentSex" id="studentSex"  value="${student.studentSex}">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <div class="am-form-group">
                    <label  class="am-u-sm-2 am-text-right">班级Num</label>
                    <div class=" am-u-sm-10">
                        <select name="clazzNum" id="clazzNum">
                            <c:forEach items="${clazzNumList}" var = "c">
                                <c:if test="${student.clazzNum == c}">
                                    <option value="${c}" selected="selected">${c}</option>
                                </c:if>
                                <c:if test="${student.clazzNum != c}">
                                    <option value="${c}" >${c}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <input type="hidden"  name="roleId" id="roleId" value="${student.roleId}"/>
                <div class="am-form-group">
                    <label for="departmentId" class="am-u-sm-2 am-text-right">部门</label>
                    <div class=" am-u-sm-10">
                        <select name="departmentId" id="departmentId">
                            <c:forEach items="${department}" var = "de">
                                <c:if test="${student.departmentId == de.departmentId}">
                                    <option value="${de.departmentId}" selected="selected">${de.departmentName}</option>
                                </c:if>
                                <c:if test="${student.departmentId != de.departmentId}">
                                    <option value="${de.departmentId}" >${de.departmentName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <input type="hidden" id="YorNChangePas" name="YorNChangePas" value="0">
            </form>
            <div class="mid am-center">
                <button type="button" class="am-btn am-btn-primary" id="edit">保存修改</button>
                <a href="studentManagement" class="am-btn am-btn-primary"> 返回</a>
            </div>
        </div>
</body>
</html>