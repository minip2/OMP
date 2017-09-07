<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title> 문의하기</title>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<style>
	
	h1.bg-primary, h2.bg-warning{
	display:inline-block;
	}
	textarea.a{
		width: 800px;
		height: 300px;
	}
	input.a{
	width: 300px;
	}
	a{
		color:black;
		text-decoration:none;
	}
	</style>

</head>
<body>


<%
	if(session.getAttribute("user") == null){
		request.setAttribute("error", "로그인이 필요한 항목입니다");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/css/login.jsp");
		rd.forward(request, response);
	}
%>
	<div class="container">
		<br><br><br><br><br><br>
		<h1 class="bg-primary">오늘 나의 펫</h1><br>
		<h2 class="bg-warning">문의하기</h2>
	</div>
	<br><br>
	
	<div class="container">
       
		<form action="/ohmypet/com/omp/css/controller/questioninsert">
		<table class="table table-bordered">
		
			<tr >
                <th >제목: </th>
                	<td><input class="a"  type="text" placeholder="제목을 입력하세요. " name="title"/>
                	  카테고리 <select name='category_val'>
 					 <option value='' selected>--&nbsp; 선택 &nbsp; --</option>
 					 <option value='배송문의' >배송문의</option>
 					 <option value='상품문의' >상품문의</option>
 					 <option value='회원서비스' >회원서비스</option>
 					 <option value='게시판' >게시판</option>
						</select></td>
               		
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea class="a" cols="10" placeholder="문의내용을 입력하세요. " name="question_content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type ="submit" onclick="alert('글 등록이 완료되었습니다.');">글쓰기</button>
                    <input type="reset" value="초기화"/>
                    <button type="button"><a href="/ohmypet/com/omp/css/controller/cssselect">고객센터</a></button>
                </td>
            </tr>
		</table>
		</form>
	</div>
</body>
</html>