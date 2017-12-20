<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/13
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../css/main.css" rel="stylesheet" type="text/css" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
</div>
<div id="container">
    <div class="sidebar ">
        <%@ include file="../topic/left.jsp"%>
    </div>
    <div class="main">
        添加主题
        <form action="control.jsp?opr=addtopic" method="post">
            主题：<input type="text" name="tname"><input type="submit" value="添加">
        </form>
    </div>
</div>

</body>
</html>
