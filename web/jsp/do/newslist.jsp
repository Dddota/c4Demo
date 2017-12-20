<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/21
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                Page p=(Page)request.getAttribute("p");
                int currentPageNum=p.getCurrentPageNum();
                int pageSize=p.getPageSize();
                int totalCount=p.getTotalCount();
                int totalPageNum=p.getTotalPageNum();
            %>
            <a href="control.jsp?opr=searchtopic&currentPageNum=1">首页</a>
            <a href="control.jsp?opr=searchtopic&currentPageNum=<%=currentPageNum-1%>">上一页</a>
            <a href="control.jsp?opr=searchtopic&currentPageNum=<%=currentPageNum+1%>">下一页</a>
            <a href="control.jsp?opr=searchtopic&currentPageNum=<%=totalPageNum%>">尾页</a>
            <form method="post" action="control.jsp?opr=searchtopic">
                页数<%=currentPageNum%>/<%=totalPageNum%> <input type="text" name="pagenum"  style="width:2em"><input type="submit" value="跳转">
            </form>

            <div>
            </div>
        </div>
</body>
</html>
