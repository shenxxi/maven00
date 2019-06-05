<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/29
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action='showUser' method='get'>
    <div>
        <input type='text' name='condition'><input type='submit' value='查询'>
    </div>
</form>--%>
<a href="add">添加</a>
<table border="1">
    <thead>
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><a href="del?id=${user.id}">删除</a><a href="selectUser?id=${user.id}">修改</a></td>
        </tr>
        </c:forEach>

    </tbody>
</table>

</body>
</html>
