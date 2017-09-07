<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
	<img src="${dm.file_path}" style="width:100%;"  />
</div>
<input type="hidden" name="no" value="${dm.no}" />
<input type="hidden" name="update" value="update" />
</form>
		<!-- 셀렉박스 -->
<form action="/ohmypet/com/omp/photo/mod">	
<div class="form-group">
	 <select name="category_val">
		 	<option value="-1">분류</option>
		 	<option value="1">강아지</option>
		 	<option value="2">고양이</option>
		 	<option value="3">펫</option>
		 </select>	
		 <br>
    <label for="title" >제목</label>
    <input type="hidden" name="file_sys_name" value="${file_sys_name}" />
    <input type="hidden" name="file_path" value="${file_path}" />
    <input type="hidden" name="no" value="${dm.no}" />
    <input type="text" name="title" class="form-control" id="title" style="width:100%;" placeholder="제목을 입력해주세요." value="${dm.title}">		
		
		 <p>
		 <label for="content">내용</label>
		 	<textarea name="content" id="content" rows="10" cols="93" placeholder="글을 쓰세요"></textarea>
		 </p>
		 <br>
		 <div class="idpw-board" >
		 <!-- style="width:30%; float: left;"  -->
		 	<input type="text" name="id"  placeholder="아이디" value="${dm.id}" />
		 	<input type="password" name="password"  placeholder="비밀번호" value="${dm.password}" />
		 </div>
		 <br>
		 <div class="button-style">
		 <button type="submit">수정완료</button>
		 <button type="button"><a href="/ohmypet/com/omp/photo/list">취소</a></button>
		 </div>
		  </div>
	</form>
	</div>
</body>
</html>