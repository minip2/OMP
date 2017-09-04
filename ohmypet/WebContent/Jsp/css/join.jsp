<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
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
		<form action="/03_html/01_basic/notice.html">
		<div class = "container">
		<h1 class="bg-primary">오늘 나의 펫</h1><br>
		<h2 class="bg-warning">회원가입</h2><br><br>
	 		ID : <input type="text" name="id" placeholder="아이디를 입력하세요">
	 		<button class= type="button">id중복체크</button>
	 		<br>
	 		<br>
	 		password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
	 		<input  type="password" name="password" maxlength="8">
	 		<br>
	 		<br>
	 		
	 		password 확인 : 
	 		<input type="password" name="passwordsame" maxlength="8">
	 		<br>
	 		<br>
	 		<!-- radio 속성은 여러개 중에서 하나만 선택하게 하기 위해서는
	 			 name 속성의 값을 같게 설정해야한다.	
	 		 -->
	 		이름 : <input class='c' type = "text" >
	 	
	 		성별 :
	 		<input type="radio" name = "gender" id= "ra1" checked> <label for="ra1">남</label>
	 		<input type="radio" name = "gender" id= "ra2"> <label for="ra2">여</label>
	 		<br>
	 		<br>
	 		닉네임 : <input type = "text" >&nbsp;<button type="button">닉네임중복체크</button>
	 		<br>
	 		<br>
	 		H.P : <select name='phbrand'>
 					 <option value='' selected>--&nbsp; 선택 &nbsp; --</option>
 					 <option value='LGU+' >LGU+</option>
 					 <option value='SK' >SK</option>
 					 <option value='KT' >KT</option>
						</select>
						<input class="a" type="text">-<input class="a" type="text">-<input class="a" type="text">
	 		<br>
	 		<br>
	 		<!-- 
	 		file : 
	 		<input type="file">
	 		<br>
	 			date:
	 			<input type="date" value="2017-07-01" min ="2017-01-01" max ="2018-12-31">
	 		 -->
	 		 Email : <input type="email"> @
	 		<select name='email'>
 					 <option value='' selected>--&nbsp; 선택 &nbsp; --</option>
 					 <option value='naver.com' >naver.com</option>
 					 <option value='daum.net' >daum.net</option>
 					 <option value='nate.com' >nate.com</option>
						</select>&nbsp;<input type="button" value="메일 확인" onclick="alert('메일을 확인해 주세요');">
	 		<br>
	 		<br>
	 		스토어를 이용하시겠습니까? :
	 		<input type="radio" name = "store" id= "ra1" checked> <label for="ra1">예</label>
	 		<input type="radio" name = "store" id= "ra2"> <label for="ra2">아니오</label>
	 		<br>
	 		<br>
	 		주소 : <input class="b" type="text" placeholder="스토어를 이용하시려면 주소를 입력해주세요.">
	 		<br>
	 		<br>
	 		<button type="submit" onclick="alert('회원가입을 완료하였습니다. 환영합니다.');">가입</button>
	 		<input type="submit" value="고객센터 홈 " />
			<br>
			<br><br><br>
			
	 		
	 		
	 		</div>
	 </form>
	</body>
</html>