<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.model.Topic" %>
<%@ page import="com.bdqn.dao.TopicDao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/13
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中转页面</title>
</head>
<body>
<%
    int tid=new Integer(request.getParameter("tid"));
    TopicDao topicDao=new TopicDaoImpl();
    Topic topic=topicDao.findTopicByTid(tid);
    session.setAttribute("topic",topic);
    response.sendRedirect("fixtopic.jsp");
%>
</body>
</html>
