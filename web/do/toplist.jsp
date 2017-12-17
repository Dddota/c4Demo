<%@ page import="java.util.List" %>
<%@ page import="com.bdqn.model.Topic" %>
<%@ page import="com.bdqn.utils.Page" %><%--
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
        <form method="post" action="control.jsp?opr=searchtopic">
        主题：<input type="search" name="tsearch"><input type="submit"value="搜索">
        </form>
        <ul>
        <%
            List<Topic> list=(List)request.getAttribute("topiclist");
            for (Topic topic:list) {
                String topicname=topic.gettName();
                int topicid=topic.gettId();
        %><li><%=topicname%>&emsp; <a href="ts.jsp?tid=<%=topicid%>">修改</a>&emsp; <a href="control.jsp?opr=deltopic&tid=<%=topicid%>">删除</a></li>
            <%}%></ul>
        <div>
            <%





            %>
            <a href="#">首页</a>
            <a href="#">上一页</a>
            <a href="#">下一页</a>
            <a href="#">尾页</a>
            <form method="post" action="control.jsp?opr=pagejump">
                页数 <input type="text" name="pagenum"  style="width:2em"><input type="submit" value="跳转">
            </form>

            <div>
    </div>
</div>
</body>
</html>
