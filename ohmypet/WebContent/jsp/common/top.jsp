<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="/ohmypet/css/style.css">
 <!-- jquery 적용위해 추가 -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
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
   	  });
   	 
   	   $( document ).ready( function() {
           var jbOffset = $( '.clearfix' ).offset();
           $( window ).scroll( function() {
             if ( $( document ).scrollTop() > jbOffset.top ) {
               $( '.clearfix' ).addClass( 'jbFixed' );
             }
             else {
               $( '.clearfix' ).removeClass( 'jbFixed' );
             }
           });
         });
</script>
<style>
	h1 {
    text-align: center;
    font-size: 60px;
    color : #3498DB;
	}      
	body {
        margin: 0;
        padding: 0px;
      }
      
      .jbTitle {
        text-align: center;
      }
      .jbMenu {
        text-align: center;
        background-color: yellow;
        padding: 10px 0px;
        width: 100%;
      }
      .jbContent {
        height: 2000px;
      }
      .jbFixed {
        position: fixed;
        top: 0px;
      }
button.id{
float: right;
}
</style>
</head>
<body>
<div>
		<c:choose>
			<c:when test="${empty user}">
				<form action="/ohmypet/jsp/css/join.jsp">
					<button class="id">회원가입</button>
				</form>
				<form action="/ohmypet/jsp/css/login.jsp">
					<button class="id">로그인</button>
				</form>
			</c:when>


			<c:otherwise>
				<form action="/ohmypet/com/omp/common/controller/logout">
					<button class="id">로그아웃</button>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
<div style="margin-top:30px">
<h1 >오늘 나의 펫</h1>
</div>
<div style="margin-top:30px; margin-bottom:20px;">
<nav class="clearfix">
   	      <ul >
   	        <li><a href="/ohmypet/jsp/common/main.jsp"  id="all" value="HOME">HOME</a></li>
			<li><a href="#"  id="dog" value="프로필">프로필</a></li>
			<li><a href="/ohmypet/jsp/photo/photolist.jsp" class="botton" id="cat" value="사진">사진</a></li>
			<li><a href="#"  id="honey" value="게시판">게시판</a></li>
			<li><a href="/ohmypet/store/main">스토어</a></li>
			<li><a href="#" id="honey" value="고객센터">고객센터</a></li>
   	      </ul>
   	      <a id="pull" href="#">Menu</a>
   	  </nav>
</body>
</html>