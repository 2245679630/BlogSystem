<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="csdn.dao.UserDao" %>
<%@ page import="csdn.dao.UserDaoImpl" %>
<%@ page import="csdn.model.aticle" %>
<%@ page import="csdn.model.User" %>
<%@ page import="csdn.model.article_type" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<title>IDEA</title>
<style>
  #first{
     font-family:"微软雅黑"；
     font-size:1000px;
     background:-webkit-linear-gradient(top,#ff0000,#0000ff 50%,#abcdef 51%,#00ff00);
     -webkit-background-clip:text;
     -webkit-text-fill-color:transparent;
     text-transform:uppercase;
     }
     
  }

</style>
<link rel="stylesheet" href="css/reset.css" type="text/css"
	media="screen" />

<!--[if ! lte IE 6]><!-->
<link rel="stylesheet" href="css/style4.css" type="text/css"
	media="screen" />
<!--<![endif]-->

<!--[if gt IE 6]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<![endif]-->

<!--[if IE 7]>
	<link rel="stylesheet" href="css/ie7.css" type="text/css" media="screen" />
	<![endif]-->

<!--[if lte IE 6]>
	<link rel="stylesheet" href="http://universal-ie6-css.googlecode.com/files/ie6.1.1.css" media="screen, projection">
	<![endif]-->

<link rel="stylesheet" href="css/fancybox.css" type="text/css"
	media="screen" />
</head>
<body>
  <%
  User user = (User) request.getSession().getAttribute("user");
  int i=user.getId();
  String s = user.getUsername();
  UserDao dao = new UserDaoImpl();
   String query = request.getParameter("query");
   List<aticle> list = null;
  if(query!=null){
 	  list = dao.findAlltype(query);  
  }
  else{
 	 
 	  list = dao.findself_type(3, s);
   }
   
   session.setAttribute("list", list);
    
 %>
   
	<div id="header">

		<div class="container"></div>
		<!-- end .container -->
        <div id = first ">欢迎你：${sessionScope.user.username}</div>
	</div>
	<!-- end #header -->

	<div id="nav">

		<div class="container">

			<ul>
				<li class="active"><a href="indexblog.jsp">首页</a></li>
				<li><a href="#">博文分类</a>
					<ul>
					
						<li><a href="selftype1.jsp">摄影</a></li>
						<li><a href="type2.jsp">学习</a></li>
						<li><a href="type3.jsp">生活</a></li>
						
					</ul></li>
				<li><a href="info_self.jsp">个人设置</a></li>
				
				<li><a href="addblog.jsp">新建博文</a></li>
				<li><a href="index.jsp">退出</a></li>
			</ul>

			<div id="search">
                <form action="blog.jsp">
          <input name="query" id="query" class="input_text" value="请输入关键字词" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字词'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字词'}" type="text">
          <input name="Submit" class="input_submit" value="搜索" type="submit">
                </form>
                
				<!-- <input type="text" class="input" value="" name="query" id="query" placeholder="请输入关键字...">
				<a href="index.jsp"><input type="submit" class="submit" value="查找"></a> -->

			</div>
			<!-- end #search -->

		</div>
		<!-- end .container -->

	</div>
	<!-- end #nav -->

	<div id="nav-shadow"></div>


	<div class="copyrights">
	
	</div>
	<div id="content">

		<div class="container">

			<div id="main">

            <c:forEach var="list" items="${sessionScope.list}">
				<div class="entry">
                 

					<div class="entry-header">

						<h2 class="title">
							<a href="single-post.html">${list.title}</a>
						</h2>

						<p class="meta">
							发布于 <a href="#">${list.pub_date}</a> 作者：<a href="#">${sessionScope.user.username}
								</a>
						</p>

						<a href="readmore.jsp?id=${list.art_id}" class="button">Read More...</a>
						 <button id="btnDel" type="button" class="button" data-toggle="modal" data-target="#DeleteForm" onclick="">
        <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
          <a href="/CSDN/delete?id=${list.art_id}" onclick="return confirm('确定要删除吗?')" class="del">删除</a>
         </button> 

					</div>
					<!-- end .entry-header -->

					<div class="entry-content">

						<a href="single-post.html"><img
							src="img/12.jpg" width="240" height="140"
							alt="" class="entry-image" /></a>

						<p>
							<%-- ${list.content} --%>
						</p>

						<hr />

						<ul class="entry-links">
							
							<li><a href="#">博文类型 ：${list.type}</a> <span class="separator">|</span></li>
							<li><a href="update.jsp?id=${list.art_id}">修改博文</a> <span class="separator">|</span></li>
							<li><a href="#">0 Tweets</a></li>
						</ul>

					</div>
					<!-- end .entry-content -->
           
				</div>
				</c:forEach>
				<!-- end .entry -->

			
				<!-- end .entry -->

				
				<!-- end .entry -->
				<ul class="pagination">
					<li class="prev"><a href="#">Prev</a></li>
					<li><a href="#">1</a></li>
					<li class="active"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#">Next</a></li>
				</ul>

			</div>
			<!-- end #main -->



			<div class="clear"></div>

		</div>
		<!-- end .container -->

	</div>
	<!-- end #content -->



	<div id="footer-bottom">

		<div class="container">

			<p class="align-left">CSDN</p>



		</div>
		<!-- end .container -->

	</div>
	<!-- end #footer-bottom -->

	<!-- start scripts -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.cycle.all.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/organictabs.jquery.js"></script>
	<script src="js/jquery.fancybox-1.3.4.pack.js"></script>
	<script src="js/css3-mediaqueries.js"></script>
	<script src="js/custom.js"></script>
	<!--[if IE]> <script src="js/selectivizr.js"></script> <![endif]-->
	<!-- end scripts -->
</body>
</html>