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
.store_board{
	margin-left: auto;
	margin-right: auto;
	width: 60%;
	/* text-align: center; */
}
</style>
</head>
<body>
<c:import url="/jsp/common/top.jsp"/>
<div class="store_board">
<h2>제품 상세 페이지</h2>
<form action="/ohmypet/shboard/complete">
<table>
	<tr>
		<th>사진</th>	
		<th><img src = "${pageContext.request.contextPath}/store/download?path=${sdm.photoPath}&sname=${sdm.sname}&dname=${sdm.dname}" width="50px" height="50px" ></th>	
	</tr>
	<tr>
		<th>가격</th>	
		<th><input type ='text' rows="5" cols="5" name="price" value="${sdm.price}" ></th>		
	</tr>
	<tr>
		<th>제목</th>	
		<th><input type ='text' rows="5" cols="5" name="title" value="${sdm.title}" ></th>	
	</tr>
	
</table>
<hr>
<table>
<tr>
		<th>상세</th>	
		<th><input type ='textarea' rows="5" cols="5" name="productDetail" value="${sdm.productDetail}" > </th>	
	</tr>
</table>
<hr>

<input type="hidden" name="no" value="${sdm.no}">
<button>완료하기</button>
</form>





</div>
</body>
</html>