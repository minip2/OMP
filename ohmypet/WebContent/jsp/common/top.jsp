<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
        padding: 0;
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
	
</style>
</head>
<body>
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
			<li><a href="#"  id="honey" value="스토어">스토어</a></li>
			<li><a href="#" id="honey" value="고객센터">고객센터</a></li>
   	      </ul>
   	      <a id="pull" href="#">Menu</a>
</nav>
</div>
</body>
</html>