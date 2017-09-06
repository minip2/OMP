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
<table class="table table-condensed" >
<colgroup><col width="20%"><col width="*"></colgroup>  
			<tr>
                <th>작성자: </th>
                <td>${notice.id}</td>
            </tr>
			 <tr>
                <th>제목: </th>
                <td>${notice.title}</td>
            </tr>
            <tr>
                <th>내용: </th>
                <td>${notice.content}</td>
            </tr>
  </table>
                    <button><a href="/ohmypet/com.omp.css.controller/noticedetail?no=${notice.no-1}">이전글</a></button>
                    <button><a href="/ohmypet/com.omp.css.controller/noticedetail?no=${notice.no+1}">다음글</a></button>
                    <button><a href="/ohmypet/com.omp.css.controller/cssselect">고객센터홈</a></button>
                    <c:if test="${user.member_level==0}">
                    <button><a href="/ohmypet/com.omp.css.controller/noticeupdate?no=${notice.no}">수정</a></button>
                    <button><a href="/ohmypet/com.omp.css.controller/noticedelete?no=${notice.no}">삭제</a></button>
                	</c:if>
         
</div>
</body>
</html>