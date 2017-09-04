<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form>
		<p>
		제목 : <c:out value="${dm.title}" />
		</p>
		<!-- 셀렉박스 -->
		<div>

		<c:out value="${dm.dog_val}" />
		
		</div>

		 <br>
		 <div>
			<c:out value="${dm.file_path}" /> 
			<img src="'${dm.file_path}'" width="200px" height = "150px">	
		 </div>
		 <p>
		 	<c:out value="${dm.content}" />
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
		 <a class="btn btn-default pull-right" href="/ohmypet/com/omp/photo/modprint?no=${dm.no} ">수정</a>
		<%--  <input type="button"
		 		onclick="location.href='/jsp/photoprint.jsp'">수정</button>--%>
	</form>
</body>
</html>