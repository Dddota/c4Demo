<%@ page import="com.bdqn.model.User" %>
<%@ page import="com.bdqn.dao.UserDao" %>
<%@ page import="com.bdqn.dao.impl.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/13
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%%>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String pwd = request.getParameter("upwd");
    User user = new User();
    user.setUname(username);
    user.setUpwd(pwd);
    UserDao userdao = new UserDaoImpl();
    if (userdao.login(user)) {//登陆验证
        session.setAttribute("isLogin",user);
        response.sendRedirect("../jsp/topic/manager.jsp");
    } else{
        out.print("<script>alert('登陆失败');location.href='../index.jsp'</script>");
    }
%>
</body>

</html>
