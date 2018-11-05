<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="csdn.model.aticle" %>
<%@ page import="java.util.List" %>
<%@ page import="csdn.dao.UserDao" %>
<%@ page import="csdn.dao.UserDaoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>news</title>  
<style type="text/css">  
.news {  
    width: 800px;  
    margin: 0 auto;  
}  
</style>  
</head>  
<body>  
<%
    int id = Integer.parseInt(request.getParameter("id"));
    UserDao dao = new UserDaoImpl();
    aticle a = dao.readmore(id);
    session.setAttribute("atrcleOne", a);
    
%>
    <div class="news">  
       <li><a onclick="history.go(-1)">返回</a></li> 
       <h3>${atrcleOne.title}</a></h3>
        <a href="" style="float:left">发布人:${atrcleOne.username}</a><span style="float:right">发布日期:${atrcleOne.pub_date}</span></br></br>
         <div border>
          <label>文章内容:</label></br>
       <p>${atrcleOne.content}</p>
       </div>
	 
    </div>  
</body>  
</html>