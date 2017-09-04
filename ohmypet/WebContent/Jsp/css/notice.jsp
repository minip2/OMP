<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.omp.css.dao.NoticeDAO"%>
 <%@page import="com.omp.css.domain.NoticeDM"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%--
 	NoticeDAO dao = new NoticeDAO();
 	List<NoticeDM> list = new ArrayList<>();
 		list = dao.selectNotice();
 --%>
 <%--
 	
	List<NoticeDM> notice = (List<NoticeDM>)request.getAttribute("notice"); //키값을 준다.
	
 --%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>오늘 나의 펫 공지사항</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		
		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
  <h2>고객센터</h2>
		  <ul class="breadcrumb">
		  <li><a href="http://localhost:8000/ohmypet/jsp/css/notice.jsp">고객센터</a></li>
		  <li><a href="http://localhost:8000/ohmypet/jsp/css/questionwrite.jsp">문의하기</a></li>
		  <li><a href="http://localhost:8000/ohmypet/Html/join/join.html">회원가입</a></li>
		  <li><a href="http://localhost:8000/ohmypet/jsp/css/login.jsp">로그인</a></li>
		  <li><a href="http://localhost:8000/ohmypet/jsp/css/noticewrite.jsp">공지게시</a></li>
		</ul>
  <br>
  <br>
  <p>오늘 나의 펫 공지사항입니다</p>
	<table class="table table-condensed">
    <thead>
      <tr>
        <th>글번호</th>
        <th>글쓴이</th>
        <th>제목</th>
        <th>날짜</th>
      </tr>
    </thead>
    <tbody>
   
      
  <%--   	  <c:out value="${notice[5].id}"/>
    	  <c:out value="${notice[5].title}"/>
    	  <c:out value="${notice[5].content}"/> --%>
		<c:set var="i" value= "0"/>
		   <c:forEach var="list" items="${notice}" begin="${i}" end="${i+3}">
		  	<tr>
		  	 <td><c:out value="${list.no}"/></td>
		   	 <td><c:out value="${list.id}"/></td>
		   	 <td><a href="http://localhost:8000/ohmypet/com.omp.css.controller/noticedetail?no=${list.no}"><c:out value="${list.title}"/></a></td>
		  	  <td><c:out value="${list.regDate}"/></td>
		 	 </tr>
		   </c:forEach>
		    	 
      
      <c:out value="${notice[2].title}"/>
      
    </tbody>
  </table>
</div>
<div class="container">
<ul class="pagination">
  <li><a href="http://localhost:8000/ohmypet/jsp/notice.jsp?i=${i+3}">1</a></li>
  <li><a href="http://localhost:8000/ohmypet/jsp/notice.jsp?i=${i+3}">2</a></li>
  <li><a href="http://localhost:8000/ohmypet/jsp/notice.jsp?i=${i+3}">3</a></li>
  <li><a href="http://localhost:8000/ohmypet/jsp/notice.jsp?i=${i+3}">4</a></li>
  <li><a href="http://localhost:8000/ohmypet/jsp/notice.jsp?i=${i+3}">5</a></li>
</ul>
</div>





<div class="container">

  <p>오늘 나의 펫 문의내역입니다</p>
	<table class="table table-condensed">
    <thead>
      <tr>
        <th>카테고리</th>
        <th>글쓴이</th>
        <th>제목</th>
        <th>날짜</th>
      </tr>
    </thead>
	
    <tbody>
     <c:forEach var="list" items="${question}" begin="0" end="5">
		  	<tr>
		  	 <td><c:out value="${list.category_val}"/></td>
		   	 <td><c:out value="${list.id}"/></td>
		   	 <td><a href="http://localhost:8000/ohmypet/com.omp.css.controller/questiondetail?no=${list.no}"><c:out value="${list.title}"/></a></td>
		  	 <td><c:out value="${list.question_date}"/></td>
		 	</tr>
	</c:forEach>
    </tbody>
  </table>
</div>
<div class="container">
<ul class="pagination">
  <li><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
</ul>
</div>
</body>
</html>