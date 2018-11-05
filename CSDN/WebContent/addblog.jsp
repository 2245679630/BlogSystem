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

    <title>新建博文</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
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
     

	<div id="header">

		<div class="container"></div>
		<!-- end .container -->

	</div>
	<!-- end #header -->

	<div id="nav">

		<div class="container">
       <form action="UeditorServlet" name="upfile">
			<div>
			<div style="height: 50px; padding-top: 20px;display:inline;font-size:16px;">
					<span>请输入博文标题:</span> <input type="text" name="title">
				</div>
					
				<div style="display:inline;margin-left:20px;font-size:16px;">
					<span>博文类型：</span> <input type="radio" value="1" name="type">摄影
					<input type="radio" value="2" name="type">学习
						<input type="radio" value="3" name="type">生活
				</div>
					
			
 
    
    <script id="editor" type="text/plain" style="width:1024px;height:500px; center"></script>
   <input type="submit" value="编辑完成">
    </form>
</div> 
<script type="text/javascript">
 
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    /* function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    } */
 
 </script>
</body>
			

	<!-- start scripts -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.cycle.all.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/organictabs.jquery.js"></script>
	<script src="js/jquery.fancybox-1.3.4.pack.js"></script>
	<script src="js/css3-mediaqueries.js"></script>
	<script src="js/custom.js"></script>
	<!--[if IE]> <script src="js/selectivizr.js"></script> <![endif]-->

</html>