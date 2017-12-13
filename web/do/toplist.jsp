<%@ page import="java.util.List" %>
<%@ page import="com.bdqn.model.Topic" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/13
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<html>
<head>
    <title></title>
</head>
<body>
<div id="header">

</div>
<div id="container">
    <div class="sidebar ">
        <%@ include file="../jsp/topic/left.jsp"%>
    </div>
    <div class="main">
        编辑主题
        <ul>
        <%
            List<Topic> list=(List)request.getAttribute("topiclist");
            for (Topic topic:list) {
                String topicname=topic.getTname();
                int topicid=topic.getTid();
        %><li><%=topicname%>&emsp; <a href="ts.jsp?tid=<%=topicid%>">修改</a>&emsp; <a href="control.jsp?opr=deltopic&tid=<%=topicid%>">删除</a></li>
            <%}%></ul>
    </div>
</div>
</body>
</html>
