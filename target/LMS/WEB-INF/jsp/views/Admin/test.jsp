<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 神
  Date: 2018/12/7
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<html>
<head>
    <title>test</title>
</head>
<body>
    <div>看起来不怎么样！</div>
    <c:forEach items="${test}" var="tt">
        <div>${tt.studentNo}</div><br>
        <div>${tt.studentName}</div>
        <div>123</div>
    </c:forEach>
</body>
</html>
