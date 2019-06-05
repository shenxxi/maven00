<%--
  Created by IntelliJ IDEA.
  User: SX
  Date: 2019/6/2
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addUser" method="get">
    <div>
        <label>用户名</label> <input type="text" name="username">
    </div>
    <div>
        <label>密码</label> <input type="password" name="password">
    </div>

    <!-- <div>
        <label>验证</label> <input type="password" name="rePassword">
        <img  src="/user_manage/code" id="code">
    </div> -->
    <div>
        <input type="submit" value="添加">
    </div>
</form>
</body>
</html>
