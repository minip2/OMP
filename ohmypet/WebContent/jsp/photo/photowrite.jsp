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
  <style type="text/css">
         a{text-decoration:none; color:#000000;}         
         a:hover{color:#ff0000;}                     
         
         nav ul{padding-top:10px;}                    
         nav ul li {
            display:inline;                       
            border-left:1px solid #999;           
            font:bold 15px Dotum;                     
            padding:0 30px;   
                
        }
         nav ul li:first-child{border-center:none;}   
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
<nav>
<ul class="text-center" style="margin-left:350px">
<li><a href="#" class="botton" id="all" value="전체">전체</a></li>
<li><a href="#" class="botton" id="dog" value="제품소개">제품소개</a></li>
<li><a href="#" class="botton" id="cat" value="후기">후기</a></li>
<li><a href="#" class="botton" id="honey" value="자랑">자랑</a></li>
</ul>
</nav>
	<form action="/ohmypet/com/omp/photo/controller/writer">	
		<div class="form-group">
    <label for="title">제목</label>
    <input type="text" name="title" class="form-control" id="title" placeholder="제목" value="${dm.title}">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">파일 업로드</label>
    <input type="file" id="exampleInputFile" value="가입" > 
    <input type="file" id="myfile1" name="myfile1" accept="a/jpg">
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> 입력을 기억합니다
    </label>
  </div>
  <button type="submit" class="btn btn-default">제출</button>
		
		
		<p>
		제목 : <textarea name="title"></textarea>
		</p>
		<!-- 셀렉박스 -->
		
		 <select name="category_val">
		 	<option>분류</option>
		 	<option>제품소개</option>
		 	<option>후기</option>
		 	<option>자랑</option>
		 </select>	
		 <select name="dog_val">
		 	<option value="-1"> 종류</option>
		 	<option value="1">말티즈</option>
		 	<option value="2">말라뮤트</option>
		 	<option value="3">골든이</option>
		 	<option value="4">웰시코기</option>
		 </select>
		 <br>
		 <div>
		 	<textarea name="file_path" rows="10" cols="100" placeholder="사진이 없어요">
		 		
		 	</textarea>
		 </div>
		 <p>
		 	<textarea name="content" rows="10" cols="100" placeholder="글을 쓰세요"></textarea>
		 </p>
		 <button type="file" value="사진올리기" onclick="alert('사진올라감');">사진올리기</button>
		 <br>
		 <div>
			 tag:
			 <textarea name="tag" row="1" cols=40" placeholder="태그를 입력해주세요(쉼표로 구분합니다.)"></textarea>
		 </div>
		 <div>
		 	id : <textarea name="id"></textarea>
		 	pw : <textarea name="password"></textarea>
		 </div>
		 <br>
		 <button type="submit">등록</button>
	</form>
</body>
</html>