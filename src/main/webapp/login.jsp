<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="log" method="post">
    <div>
        <label>用户名</label> <input type="text" name="username">
    </div>
    <div>
        <label>密码</label> <input type="password" name="password">
    </div>
    <div>
        <label>记住密码</label> <input type="checkbox" name="remember" value="ok">
    </div>
    <div>
        <input type="submit" value="登录">
    </div>
</form>
</body>
</html>
