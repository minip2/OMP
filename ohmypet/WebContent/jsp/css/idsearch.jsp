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
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<br><br><br>
		<h1>아이디 찾기</h1>
		
		<form action="/ohmypet/com/omp/common/controller/idsearch">
		<table class="table table-bordered">
	
			<tr>
				<td style="height: 23px; width: 318px;">이름:&nbsp;&nbsp;&nbsp;
				<input type="text" name="name"  placeholder="이름을 입력하세요 "/></td>
				<td rowspan="2"  style="vertical-align: center;"><button>아이디찾기</button></td>
			</tr>
			
			<tr>
				<td>email:&nbsp;
				<input type="text" name="email" placeholder="email을 입력해주세요 " /></td>
				<td>
					<c:out value="${msg}"/>
				</td>
			</tr>
			
		
			
			
		</form>
			
				<tr>
				<form action="#"><button>오늘 나의 펫</button></form>
				<form action="/ohmypet/jsp/css/join.jsp"><button>회원가입</button></form>
				<form action="/ohmtpet/jsp/css/passwordsearch.jsp"><button>비밀번호찾기</button></form><tr>
			
			
		</table>
			
	</div>
</body>
</html>