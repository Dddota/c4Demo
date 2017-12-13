<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.model.Topic" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/13
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../css/main.css" rel="stylesheet" type="text/css" />
<html>
<head>
    <title>修改主题</title>
</head>
<body>

<div id="container">
    <div class="sidebar ">
        <%@ include file="../jsp/topic/left.jsp"%>
    </div>
<div class="main">
    修改主题
    <%
        Topic topic=(Topic)session.getAttribute("topic");
    %>
    <form action="control.jsp?opr=fixtopic" method="post">
        主题：<input type="text" name="tname"value="<%=topic.getTname()%>"><br/>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
