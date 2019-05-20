<%--
  Created by IntelliJ IDEA.
  User: Google
  Date: 2019/4/23
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">查询</a>
<form action="account/saveAccount" method="post">
    name:<input type="text" name="name"/><br/>
    money:<input type="text" name="money"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
