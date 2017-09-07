<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<style>
	input.a{
	width : 50px;
	}
	input.c{
	width : 100px;
	}
	input.b{
	width : 300px;
	height: 100px;
	}
	h1.bg-primary, h2.bg-warning{
	display:inline-block;
	}
	a{
		color:black;
		text-decoration:none;
	}
	c:out{
		color: tomato;
	}
		</style>
		
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
	<br><br><br>
		<div class = "container">
		<h1 class="bg-primary">오늘 나의 펫</h1><br>
		
		
		
		<h2 class="bg-warning">개인정보 수정</h2><br><br>
		
	 		ID :
	 		<c:out value="${member.id}"/>
	 		
	 		
	 		<br><br>

		<form action="/ohmypet/com/omp/common/controller/nick_nameoverlapnick">
					<input type="hidden" value="${member.id}">
	 		닉네임 : <input type = "text" placeholder="닉네임을 입력하세요" name="nick_name" value="${member.nick_name}">&nbsp;
	 			
	 			<button type="submit">닉네임중복체크</button><br>
	 			
	 			<c:out value="${nick_msg}"/>
	 			
		</form>

		<form action="/ohmypet/com/omp/common/controller/membershipupdate">
	 		<br>
	 		<br>
	 		<input type="hidden" name = "id" value="${member.id}">
	 		<input type="hidden" name = "nick_name" value="${member.nick_name}">
	 		password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
	 		<input   type="password" placeholder="비밀번호를 입력하세요" name="password" maxlength="8">
	 		<br>
	 		<br>
	 		
	 		password 확인 : 
	 		<input type="password" placeholder="비밀번호를 입력하세요" name="passwordsame" maxlength="8">
	 		
	 	

	 		<br>
	 		<br>
	 		<!-- radio 속성은 여러개 중에서 하나만 선택하게 하기 위해서는
	 			 name 속성의 값을 같게 설정해야한다.	
	 		 -->
	 		이름 : <input class='c' value="${member.name}" name="name" type = "text" >
	 	
	 		성별 :
	 		<input type="radio" value="man" name = "gender" id= "ra1" checked> <label for="ra1">남</label>
	 		<input type="radio" value="woman" name = "gender" id= "ra2"> <label for="ra2">여</label>
	 		<br>
	 		
	 		<br>
	 		H.P : <select name='phbrand'>
 					 <option value='' selected>--&nbsp; 선택 &nbsp; --</option>
 					 <option value='LGU+' >LGU+</option>
 					 <option value='SK' >SK</option>
 					 <option value='KT' >KT</option>
						</select>
						<input class="a" type="text" name="phon1" >-<input class="a" type="text" name="phon2" >-<input class="a" type="text" name="phon3" >
	 		<br>
	 		<br>
	 		<!-- 
	 		file : 
	 		<input type="file">
	 		<br>
	 			date:
	 			<input type="date" value="2017-07-01" min ="2017-01-01" max ="2018-12-31">
	 		 -->
	 		 Email : <input type="text" placeholder="e-mail"  name="email" value="${member.email}"> @
	 		<select name='domain'>
 					 <option value='' selected>--&nbsp; 선택 &nbsp; --</option>
 					 <option value='naver.com' >naver.com</option>
 					 <option value='daum.net' >daum.net</option>
 					 <option value='nate.com' >nate.com</option>
						</select>&nbsp;<input type="button" value="메일 확인" onclick="alert('메일을 확인해 주세요');">
	 		<br>
	 		<br>
	 		스토어를 이용하시겠습니까? :
	 		<input type="radio" name = "store" value="yes" id= "ra1" checked> <label for="ra1">예</label>
	 		<input type="radio" name = "store" value="no" id= "ra2"> <label for="ra2">아니오</label>
	 		<br>
	 		<br>
	 		주소 : <input class="b" type="text" name="address"  value="${member.address}">
	 		<br>
	 		<br>
	 		<button type="submit" onclick="alert('개인정보가 수정되었습니다.');">정보변경하기</button>
	
			
	 		
	 		
	 		</div>
	 	</form>
	 	<br>
	 	<form action="/ohmypet/com/omp/css/controller/cssselect"><div class="container"><input type="submit" value="고객센터홈 " /></div></form>
	 	
	 
	 



</body>
</html>