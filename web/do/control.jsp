<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.model.Topic" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bdqn.service.TopicService" %>
<%@ page import="com.bdqn.service.impl.TopicServiceImpl" %>
<%@ page import="com.bdqn.utils.Page" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/13
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String opr=request.getParameter("opr");//opr即为操作类型
    TopicService topicdao=new TopicServiceImpl();
    int num=0;
/*    if (opr.equals("edittopiclist")){//编辑主题
        List<Topic> topiclist=topicdao.getAllTopic();
        request.setAttribute("topiclist",topiclist);
        request.getRequestDispatcher("toplist.jsp").forward(request,response);
    }
    else*/
    if (opr.equals("addtopic")){//添加主题
        String tname=request.getParameter("tname");
        Topic topic=new Topic();
        topic.settName(tname);
        topicdao.addTopic(topic);
        request.getRequestDispatcher("control.jsp?opr=searchtopic").forward(request,response);
    }
    else if(opr.equals("deltopic")){//删除主题
        int tid=Integer.parseInt(request.getParameter("tid"));
        num=topicdao.delTopicByTid(tid);
        if (num>0){
            out.print("<script>alert('删除成功');location.href='control.jsp?opr=searchtopic'</script>");
        }
        else {
            out.print("<script>alert('删除失败');location.href='control.jsp?opr=searchtopic'</script>");}
    }
    else if(opr.equals("fixtopic")){//修改主题
        String tname=request.getParameter("tname");
        Topic topic=(Topic)session.getAttribute("topic");
        topic.settName(tname);
        num=topicdao.updateTopic(topic);
        if (num>0){
            out.print("<script>alert('修改成功');location.href='control.jsp?opr=searchtopic'</script>");
        }
        else out.print("<script>alert('修改失败');location.href='control.jsp?opr=searchtopic'</script>");
        /*request.getRequestDispatcher("control.jsp?opr=edittopiclist").forward(request,response);*/
    }
    else if(opr.equals("searchtopic")){
        String str=request.getParameter("tsearch");
        List<Topic> topicList= null;
        if (str==null){
            str="";
        }
        String currentPageNumstr=request.getParameter("currentPageNum");
        int currentPageNum=1;
        if (currentPageNumstr!=null){
            currentPageNum=Integer.parseInt(currentPageNumstr);//有可能会报错，需增加try/catch,判断数字
        }

        Page p = new Page();
        topicList =topicdao.getTopicLikeName(str);
        request.setAttribute("topiclist",topicList);
        request.getRequestDispatcher("toplist.jsp").forward(request,response);
    }
    else if(opr.equals("pagejump")){
        int pagenum= Integer.parseInt(request.getParameter("pagenum"));







    }
    else if(opr.equals("addtopic")){

    }

%>
</body>

</html>
