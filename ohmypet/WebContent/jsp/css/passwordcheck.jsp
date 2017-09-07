<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		  <li><a href="#">오늘 나의 펫</a></li>
		  <li><a href="/ohmypet/com/omp/css/controller/cssselect">고객센터</a></li>
		  <li><a href="/ohmypet/jsp/css/questionwrite.jsp">문의하기</a></li>
		<c:choose>
			<c:when test="${empty user}">
				<li><a href ="/ohmypet/jsp/css/login.jsp">로그인</a></li>
			    <li><a href="/ohmypet/jsp/css/join.jsp">회원가입</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/ohmypet/jsp/css/passwordcheck.jsp">개인정보 변경</a>
				<li><a href ="/ohmypet/com/omp/common/controller/logout">로그아웃</a></li>
				<h3>${user.nick_name}님 접속 </h3>
			</c:otherwise>
		</c:choose>
		</ul>
</div>
<div class="container">
<form action="/ohmypet/com/omp/common/controller/memberinfoselect">
	<table class="table table-bordered" >
		<br><br><br><br><br>
		<h3>${user.id}님</h3>
		<h4>개인정보 보호를 위해 비밀번호를 다시 입력해주십시오.</h3>
		<th>비밀번호 확인</th>
		<td ><input type="password" name="password">&nbsp;&nbsp;
			 <button>확인</button>
		</td>
	
	</table>
</form>
</div>
</body>
</html>