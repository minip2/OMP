<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>동영상 등록</h2>
	<form action="${pageContext.request.contextPath}/com/omp/dictionary/controller/video"
	      method="post" enctype="multiPart/form-data">
		제목 : <input type="text" name="title">
		첨부파일 : <input type="file" name="attachFile">
		<button>등록완료</button>
	</form>
</body>
</html>