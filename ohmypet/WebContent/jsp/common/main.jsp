<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<!-- <style type="text/css">
         a{text-decoration:none; color:#000000;}         
         a:hover{color:#ff0000;}                     
         
 
         table{
		border-collapse: collapse;
		width:100%
		}
		th,td{
			padding: 8px;
	  	    text-align: left;
	   	    border-bottom: 1px solid #ddd;
		}
		h1 {
	    text-align: center;
	    color : #3498DB;
		}
	
		 .container {
	      max-width: 100%;
	    }
	    section {
	      float: left;
	      margin: 1.51515151%;   /*  10px ÷ 660px = .01515151 */
	      width: 63.63636363%;   /* 420px ÷ 660px = .63636363 */
	    }
	    aside {
	      float: right;
	      margin: 1.51515151%;   /*  10px ÷ 660px = .01515151 */
	      width: 30.30303030%;   /* 200px ÷ 660px = .30303030 */
	    }
    </style> -->
    
    <script>
   	      $(function(){
   	      	var pull=$('#pull');
   	      	    menu=$('nav ul');
   	      	    menuHeight=menu.height();   	      
   	      $(pull).on('click', function(e){
   	      	e.preventDefault();
   	      	menu.slideToggle();   	      	
   	      });
   	      $(window).resize(function(){
   	      	var w=$(window).width();
   	      	if(w>600 && menu.is(':hidden'))
   	      		{menu.removeAttr('style');}
   	      });
   	  });\
   	   </script>
</head>
<body>
	<header> 
		<hgroup>
			<div class="container" style="margin-top:30px">
			<h1 color="blue">오늘 나의 펫</h1>
			</div>
		</hgroup> 
		<div style="margin-top:30px">
			<nav class="clearfix">
			<ul class="clearfix" >
			<li><a href="#" class="botton" id="all" value="전체">전체</a></li>
			<li><a href="#" class="botton" id="dog" value="제품소개">제품소개</a></li>
			<li><a href="#" class="botton" id="cat" value="후기">후기</a></li>
			<li><a href="#" class="botton" id="honey" value="자랑">자랑</a></li>
			</ul>
			</nav>
	</header>
	
	<div>
		<section> <article>A couple of days ago I returned
		from my trip to the U.S.</article> <article>We had traveled on
		business to Phoenix, AZ.</article> <article>Although there were no
		arrangements to do any flying, I had decided to bring a flight suit
		with me. I figured, you never know… </article> </section>
		


		<aside> How I Flew a Huey in Arizona </aside>
	</div>
	<footer> HTML5 </footer>
</body>


</html>