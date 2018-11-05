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

<link rel="stylesheet" href="css/reset.css" type="text/css"
	media="screen" />

<!--[if ! lte IE 6]><!-->
<link rel="stylesheet" href="css/style3.css" type="text/css"
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
     UserDao dao = new UserDaoImpl();
      String query = request.getParameter("query");
      List<aticle> list = null;
     if(query!=null){
    	  list = dao.findAlltype(query);  
     }
     else{
    	  list = dao.findAll(1);
      }
      
      session.setAttribute("list", list);
     
    
 %>

	<div id="header">

		<div class="container"></div>
		<!-- end .container -->

	</div>
	<!-- end #header -->

	<div id="nav">

		<div class="container">

			<ul>
				<li class="active"><a href="index.jsp">首页</a></li>
				<li><a href="index.jsp">博文分类</a>
					<ul>
					
						<li><a href="photo.jsp">摄影</a></li>
						<li><a href="study.jsp">学习</a></li>
						<li><a href="life.jsp">生活</a></li>
						
					</ul></li>
				<li><a href="login.jsp">我的博客</a></li>
				<li><a href="login.jsp">登陆</a></li>
				<li><a href="sign.jsp">注册</a></li>
			</ul>

			<div id="search">
                <form action="index.jsp">
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
							发布于 <a href="#">${list.pub_date}</a> 作者：<a href="#">${list.username}
								</a>
						</p>

						<a href="readmore.jsp?id=${list.art_id}" class="button">Read More...</a>

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
							<li><a href="#">41 Comments</a> <span class="separator">|</span></li>
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