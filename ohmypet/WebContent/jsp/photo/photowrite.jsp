<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> -->
  <style type="text/css">      
         table{
		border-collapse: collapse;
		width:100%
	}
	th,td{
		padding: 8px;
  	    text-align: left;
   	    border-bottom: 1px solid #ddd;
	}   
	
	.board_style{
		margin-left:auto;
		margin-right: auto; 
		padding:10px;
		width:700px;
		border: 1px solid #3498DB;
	}
	.idpw-board{
		margin-top:10px;
		margin-bottom:10px;
		 display:inline;
		 width: 70px;
	}
	
	button a{
		text-decoration: none;
		color: rgba(0,0,0,0.8);
	}
	button a:active :after{
		text-decoration: none;
		color: rgba(255,0,0,0.2);
	}
	button a:hover{
		text-decoration: none;
		color: black;
	}
	div.button-style{
		margin-top: 10px;
	}
    </style>
</head>
<body>
<c:import url="/jsp/common/top.jsp" />
<div class="board_style">

 <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/com/omp/photo/photoupload">
<input type="file" name="filename1" size=20 style="float:left;">
<input type="submit" value="업로드" >
<div style="margin-top:5px;margin-bottom:5px;text-align: center; height:500px;">
	<img src="${file_path}" style="width:100%; height: 100%"  />
</div>
</form>
		<!-- 셀렉박스 -->
<form action="/ohmypet/com/omp/photo/controller/writer">	
<div class="form-group">
	 <select name="category_val">
		 	<option value="-1">분류</option>
		 	<option value="1">강아지</option>
		 	<option value="2">고양이</option>
		 	<option value="3">펫</option>
		 </select>	
		 <select name="dog_val">
		 	<option value="-1"> 종류</option>
		 	<option value="1">말티즈</option>
		 	<option value="2">말라뮤트</option>
		 	<option value="3">골든이</option>
		 	<option value="4">웰시코기</option>
		 </select>
		 <br>
    <label for="title" >제목</label>
    <input type="hidden" name="file_sys_name" value="${file_sys_name}" />
    <input type="hidden" name="file_path" value="${file_path}" />
    <input type="text" name="title" class="form-control" id="title" style="width:100%;" placeholder="제목을 입력해주세요." value="${dm.title}">		
		
		 <p>
		 <label for="content">내용</label>
		 	<textarea name="content" id="content" rows="10" cols="93" placeholder="글을 쓰세요"></textarea>
		 </p>
		 <br>
		 <div>
			 <label for="tag" >tag</label>
			 <input type="text" name="tag" class="form-control" id="tag" placeholder="태그를 입력해주세요(쉼표로 구분합니다.)"/> 
		 </div>
		 <br>
		 <div class="idpw-board" >
		 <!-- style="width:30%; float: left;"  -->
		 	<input type="text" name="id"  placeholder="아이디" />
		 	<input type="password" name="password"  placeholder="비밀번호" />
		 </div>
		 <br>
		 <div class="button-style">
		 <button type="submit">등록</button>
		 <button type="button"><a href="/ohmypet/com/omp/photo/list">취소</a></button>
		 </div>
		  </div>
	</form>
	</div>
</body>
</html>