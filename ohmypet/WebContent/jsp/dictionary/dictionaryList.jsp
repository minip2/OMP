<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div.list-group {
		position: fixed;
		top: 30%;
		right: 5%;
	}
</style>
</head>
<body>

<div class="list-group">
  <a href="#" class="list-group-item active">
       작은 메뉴창
  </a>
  <a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search" class="list-group-item">강아지 검색</a>
  <a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/commet" class="list-group-item disabled">강아지에게 한마디</a>
  <a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/video" class="list-group-item">강아지 동영상</a>
<%--  <a href="#" class="list-group-item">분양소 찾기</a>  --%>
</div>

<%-- 
<nav class="navbar navbar-default navbar-fixed-bottom">
  <div class="container">
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search">검색</a></li>
      <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/commet">강아지에게 한마디</a></li>
      <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/video">동영상</a></li> 
      <li>분양소 찾기</li>
    </ul>
  </div>
</nav>
--%>

</body>
</html>