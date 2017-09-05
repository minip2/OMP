<%@page import="com.omp.store.domain.ProductDM"%>
<%@page import="com.omp.store.dao.ProductDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<h2>상품관리</h2>

	<a href="${pageContext.request.contextPath}/store/main">
		<button type="button">돌아가기</button>
	</a>
	<a href="${pageContext.request.contextPath}/product/list">
		<button type="button">처음으로</button>
	</a>

	<br>

	<form action="${pageContext.request.contextPath}/store/add">


		<select name='categoryVal'>
			<option>분류선택</option>
			<option>간식</option>
			<option>장난감</option>
			<option>사료</option>
		</select> <input type="txet" placeholder="상품코드" name='productId' size="4">

		<input type="txet" placeholder="상품이름" name='productName' size="4">

		<input type="txet" placeholder="상품수량" name='quantity' size="4">

		<input type="txet" placeholder="상품가격" name='price' size="4">

		<button type="submit">등록하기</button>
	</form>


	<table>
			<form action = "${pageContext.request.contextPath}/product/search">
			<tr>
			<th colspan="5">상품목록</th>
			<th>
					<select name='option'>
						<option>검색옵션</option>
						<option>분류</option>
						<option>상품명</option>
			</th>
			<th><input type="txet" placeholder="" name='keyword' size="4">
			</th>
			<th>
				<button>검색</button>
			</th>
		</tr>
				</form>
		<tr>
			<td>카테고리</td>
			<td>상품코드</td>
			<td>상품이름</td>
			<td>상품수량</td>
			<td>상품가격</td>
		</tr>

		<c:forEach var="p" items="${list}">
			<tr>
				<td><c:out value="${p.categoryVal}" /></td>
				<td><c:out value="${p.productId}" /></td>
				<td><c:out value="${p.productName}" /></td>
				<td><c:out value="${p.quantity}" /></td>
				<td><c:out value="${p.price}" /></td>
				<td>
					<form action="${pageContext.request.contextPath}/product/del">
						<button type="submit" value="${p.productId}" name="productId">삭제하기</button>
					</form>
				</td>
				<td>
					<form action="${pageContext.request.contextPath}/product/mod">
						<input type="hidden" value="${p.categoryVal}" name="categoryVal">
						<input type="hidden" value="${p.productId}" name="productId">
						<input type="hidden" value="${p.productName}" name="productName">
						<input type="hidden" value="${p.quantity}" name="quantity">
						<input type="hidden" value="${p.price}" name="price">
						<button type="submit">수정하기</button>
					</form>
				</td>
				<td>
					<form action="${pageContext.request.contextPath}/jsp/store/shboardinsert.jsp">
						<input type="hidden" value="${p.categoryVal}" name="categoryVal">
						<input type="hidden" value="${p.productId}" name="productId">
						<input type="hidden" value="${p.productName}" name="productName">
						<input type="hidden" value="${p.quantity}" name="quantity">
						<input type="hidden" value="${p.price}" name="price">
						<button type="submit">게시글쓰기</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>