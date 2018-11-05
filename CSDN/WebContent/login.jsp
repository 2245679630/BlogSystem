<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome To CSDN -- Please Login first</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Out Strip Sign In Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
<!-- //css files -->
<!-- web-fonts -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Satisfy" rel="stylesheet">
<!-- //web-fonts -->
</head>
<body>
<div data-vide-bg="video/video2">
	<div class="center-container">
		<!--header-->
		<div class="header-w3l">
			<h1>Welcome To CSDN</h1>
		</div>
		<!--//header-->
		<!--main-->
		<div class="main-content-agile">
			<div class="wthree-pro">
				<h2>Login</h2>
			</div>
			<div class="sub-main-w3">	
				<form action="loginServlet" method="post">
					
					<div class="icon1">
						<i>username</i>
						<input placeholder=" " name="username" type="text" required="">
					</div>
					
					<div class="icon2">
						<i>Password</i>
						<input  placeholder=" " name="Password" type="password" required="">
					</div>
					
					<div class="rem-w3">
						<span class="check-w3"><a href="sign.jsp" class="two-w3ls" ><i class="fa fa-google-plus" aria-hidden="true"></i>注册</a></span>
						<a href="#" >忘记 密码?</a>
						<div class="clear"></div>
					</div>
				
					<div class="navbar-right social-icons"> 
				
						<input class="form-control btn btn-primary" id="submit" value="登录" type="submit">

						<div class="clear"></div>
           </div>
				</form>
			</div>
		</div>
		<!--//main-->
		<!--footer-->
		<div class="footer">
		
		</div>
		<!--//footer-->
	</div>
</div>
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script src="js/jquery.vide.min.js"></script>
<!-- //js -->
</body>
</html>