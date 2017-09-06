<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br><br><br>
		<h1>로그인</h1>
		<p>${error}</p>
		<form action="/ohmypet/com.omp.common.controller/login">
		<table>
	
			<tr>
				<td>아이디:&nbsp;</td>
				<td><input type="text" name="id"  placeholder="아이디를 입력하세요 "/></td>
				<td><button>로그인</button></td>
			</tr>
		</form>
			<tr>
				<td>비밀번호:&nbsp;</td>
				<td><input type="password" name="password" placeholder="비밀번호를 입력하세요 " /></td>
			</tr>
			<tr>
				<td><form action="http://localhost:8000/ohmypet/jsp/css/join.jsp"><button>회원가입</button></form></td>
				<td><form action="#"><button>아이디찾기</button></form></td>
				<td><form action="#"><button>비밀번호찾기</button></form></td>
			</tr>
			
			
		</table>
	</div>
</body>
</html>