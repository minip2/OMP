<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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
	input.a{
		width: 750px;
		height: 300px;
		
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
<h1>공지사항 확인하기</h1>

<br><br><br>
<form action="/ohmypet/com.omp.css.controller/questionanswersave">

<table class="table table-condensed" >
<%-- <colgroup><col width="20%"><col width="*"></colgroup>   --%>
			
			<tr>
				<col width="20%"><col width="*">
                <th>작성자 : </th>
                <td>${question.id}</td>
            </tr>
			 <tr>
				<col width="20%"><col width="*">
                <th>제목 : </th>
                <td>${question.title}></td>
            </tr>
            <tr>
            	<col width="20%"><col width="*">
                <th>문의내용: </th>
               <td>${question.question_content}</td>
            </tr>
            <tr>
            	<col width="20%"><col width="*">
                <th>답변내용: </th>
                <td><textarea rows="15" cols="100" name="answer_content" >${question.answer_content}</textarea></td>
            </tr>
 
  </table>
                    <button name="no" value="${question.no}">수정</button>
</form>
                
</div>
</body>
</html>