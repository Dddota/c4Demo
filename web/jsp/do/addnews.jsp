<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/20
  Time: 23:57
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
        添加新闻
        <form action="control.jsp?opr=addnews" method="post">
            标题：<input type="text" name="nname"><br>
            主题：<select>
                    <option><%%></option>
                    </select><br>
            内容：<textarea name="ncontext" style="width: 600px;height: 400px">
        </textarea>


            <input type="submit" value="添加">
        </form>
    </div>
</div>

</body>
</html>