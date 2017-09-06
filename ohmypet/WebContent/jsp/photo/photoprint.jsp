<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.writeboard {
		border: 3px solid tomato;
		margin-top: 1em;
		width: 700px;
		margin-left: auto;
		margin-right: auto;
	}


</style>


</head>
<body>
	<c:import url="/jsp/common/top.jsp" />
	<form >
	<div class="writeboard">
		<p>
		<img src="${pageContext.request.contextPath}/data/photo/gold.jpg" width=512 height=384></img>
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
	
		 <a class="btn btn-default pull-right" href="/ohmypet/com/omp/photo/modprint?no=${dm.no} ">수정</a>
		<%--  <input type="button"
		 		onclick="location.href='/jsp/photoprint.jsp'">수정</button>--%>
	</div>
	</form>
</body>
</html>