<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
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
<style>
	tr.a{
	
	}
	
	
</style>
</head>
<body>


<div class="container">
<br>
<br>
<br>
<br>
<br>
<h1>문의내역</h1>

<br><br><br>
<table class="table table-condensed" >
<colgroup><col width="20%"><col width="*"></colgroup>  
			<tr>
                <th>작성자: </th>
                <td>${question.id}</td>
               
            </tr>
            <tr>
            	<th>문의날짜: </th>
                <td><fmt:formatDate value="${question.question_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>


            </tr>
			 <tr>
                <th>제목: </th>
                <td>${question.title}</td>
            </tr>
            <tr>
                <th>내용: </th>
                <td>${question.question_content}</td>
            </tr>
            <tr>
                <th>답변내용: </th>
                <td>${question.answer_content}</td>
            </tr>
  </table>
                    <button><a href="http://localhost:8000/ohmypet/com.omp.css.controller/questiondetail?no=${question.no-1}">이전글</a></button>
                    <button><a href="http://localhost:8000/ohmypet/com.omp.css.controller/questiondetail?no=${question.no+1}">다음글</a></button>
                    <button><a href="http://localhost:8000/ohmypet/com.omp.css.controller/questionupdate?no=${question.no}">수정하기</a></button>
                    <button><a href="http://localhost:8000/ohmypet/com.omp.css.controller/questiondelete?no=${question.no}">삭제하기</a></button>
                    <button><a href="http://localhost:8000/ohmypet/com.omp.css.controller/questionanswer?no=${question.no}">답변하기</a></button>
                
         
</div>
</body>
</html>