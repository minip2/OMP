<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="/ohmypet/css/style.css">
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
</script>
<style>
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
	
	
</style>
</head>
<body>
<div style="margin-top:30px">
<h1 color="blue">오늘 나의 펫</h1>
</div>
<div style="margin-top:50px">
<nav class="clearfix">
   	      <ul class="clearfix">
   	        <li><a href="#" class="botton" id="all" value="HOME">HOME</a></li>
			<li><a href="#" class="botton" id="dog" value="프로필">프로필</a></li>
			<li><a href="#" class="botton" id="cat" value="사진">사진</a></li>
			<li><a href="#" class="botton" id="honey" value="게시판">게시판</a></li>
			<li><a href="#" class="botton" id="honey" value="스토어">스토어</a></li>
			<li><a href="#" class="botton" id="honey" value="고객센터">고객센터</a></li>
   	      </ul>
   	      <a id="pull" href="#">Menu</a>
   	  </nav>

<%-- 제목, 컨텐트, 날짜, 파일패스, 아이디 --%>
<h2>사진게시판</h2>
<div class="container" style="margin-top:50px">
	<table>
  <tr>
    <th>제목</th>
    <th>컨텐트</th>
    <th>파일패스</th>
    <th>아이티</th>
    <th>날짜</th>
  </tr>
  <tr>
  <c:forEach var="list" items="${photolist}" >
  <tr>
    <td><c:out value="${list.no}"/></td>
    <td><c:out value="${list.id}"/></td>
    <!--   </a>-->
    <td><a href="/ohmypet/com/omp/photo/detail?no=${list.no}" ><c:out value="${list.title}"/></a></td>
    <td><c:out value="${list.reg_date}"/></td>
  </tr>
  </c:forEach>
</table>

<div class="text-center">
   <ul class = "pagination">
     <li><a href="#">1</a></li>
     <li><a href="#">2</a></li>
     <li><a href="#">3</a></li>
     <li><a href="#">4</a></li>
     <li><a href="#">5</a></li>
   </ul>
</div>
</div>
</div>
</body>
</html>