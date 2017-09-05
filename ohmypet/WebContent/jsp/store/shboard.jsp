<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
img {
	border: 1px solid #444;
	width: 250px;
	height: 250px;
}

td {
	border: 1px solid #444;
	width: 13%;
}

th {
	border: 1px solid #444;
}
</style>
</head>
<body>
<h2>제품 상세 페이지</h2>
<table>
	<tr>
		<th>사진</th>	
		<th><img src = "<c:out value="${sdm.photoPath }"/>" width="50px" height="50px" ></th>	
	</tr>
	<tr>
		<th>가격</th>	
		<th><c:out value="${sdm.price }원 "/></th>	
	</tr>
	<tr>
		<th>제목</th>	
		<th><c:out value="${sdm.title }"/></th>	
	</tr>
	
</table>
<hr>
<table>
<tr>
		<th>상세</th>	
		<th><c:out value="${sdm.productDetail }"/></th>	
	</tr>
</table>
<hr>
<form action="/ohmypet/shboard/del">
<input type="hidden" name="no" value="${sdm.no}">
<button>삭제하기</button>
</form>
<form action="/ohmypet/shboard/mod">
<input type="hidden" name="price" value="${sdm.price}">
<input type="hidden" name="title" value="${sdm.title}">
<input type="hidden" name="no" value="${sdm.no}">
<input type="hidden" name="productDetail" value="${sdm.productDetail}">
<button>수정하기</button>
</form>
<form action ="/ohmypet/store/main">
<button>목록보기</button>
</form>


</body>
</html>