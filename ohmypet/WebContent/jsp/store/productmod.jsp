<%@page import="com.omp.store.domain.ProductDM"%>
<%@page import="com.omp.store.dao.ProductDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
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
	<h2>상품관리</h2>

	<a href="${pageContext.request.contextPath}/store/main">
		<button type="button">돌아가기</button>
	</a>

	<br>

	<form action="${pageContext.request.contextPath}/store/add">


		<select name='categoryVal'>
			<option>분류선택</option>
			<option>간식</option>
			<option>장난감</option>
			<option>사료</option>
		</select> <input type="text" placeholder="상품코드" name='productId' size="4">

		<input type="text" placeholder="상품이름" name='productName' size="4">

		<input type="text" placeholder="상품수량" name='quantity' size="4">

		<input type="text" placeholder="상품가격" name='price' size="4">

		<button type="submit">등록하기</button>
	</form>


	<table class="table table-hover">
		<tr>
			<form action="${pageContext.request.contextPath}/product/search">
				<th colspan="5">상품목록</th>
			<th><select name='option'>
					<option>검색옵션</option>
					<option>분류</option>
					<option>상품명</option>
			</select></th>
			<th><input type="txet" placeholder="" name='keyword' size="4">
			</th>
			<th>
				<button>검색</button>
			</th>
			</form>
		</tr>
		<tr>
			<td>카테고리</td>
			<td>상품코드</td>
			<td>상품이름</td>
			<td>상품수량</td>
			<td>상품가격</td>
		</tr>
		<tr>

			<c:forEach var="p" items="${list}">
				<c:choose>
						<c:when test="${p.productId == param.productId}">
							<form action="${pageContext.request.contextPath}/product/complete">
							<td><c:choose>
									<c:when test="${1000 == param.categoryVal}">
										<select name='categoryVal'>
											<option>상품분류</option>
											<option selected="selected">간식</option>
											<option>장난감</option>
											<option>사료</option>
										</select>
									</c:when>
									<c:when test="${2000 == param.categoryVal}">
										<select name='categoryVal'>
											<option>상품분류</option>
											<option>간식</option>
											<option selected="selected">장난감</option>
											<option>사료</option>
										</select>
									</c:when>
									<c:when test="${3000 == param.categoryVal}">
										<select name='categoryVal'>
											<option>상품분류</option>
											<option>간식</option>
											<option>장난감</option>
											<option selected="selected">사료</option>
										</select>
									</c:when>
									<c:otherwise>
										<select name='categoryVal'>
											<option>상품분류</option>
											<option>간식</option>
											<option>장난감</option>
											<option>사료</option>
										</select>
									</c:otherwise>
								</c:choose></td>


							<td>${p.productId}</td>
							<td><input type="text" name='productName'
								value="${param.productName}" size="8"></td>
							<td><input type="text" name='quantity'
								value="${param.quantity}" size="8"></td>
							<td><input type="text" name='price' value="${param.price}"
								size="8"></td>
							<input type="hidden" value="${param.productId}" name="productId">
							<td>
								<button type="submit">완료하기</button>
							</td>
					</form>
						</c:when>
					<c:otherwise>
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
									<input type="hidden" value="${p.productId}" name="productId">
									<input type="hidden" value="${p.categoryVal}"
										name="categoryVal"> <input type="hidden"
										value="${p.productName}" name="productName"> <input
										type="hidden" value="${p.quantity}" name="quantity"> <input
										type="hidden" value="${p.price}" name="price">
									<button type="submit">수정하기</button>
								</form>
							</td>
							<td>
								<form
						action="${pageContext.request.contextPath}/jsp/store/shboardinsert.jsp">
						<input type="hidden" value="${p.categoryVal}" name="categoryVal">
						<input type="hidden" value="${p.productId}" name="productId">
						<input type="hidden" value="${p.productName}" name="productName">
						<input type="hidden" value="${p.quantity}" name="quantity">
						<input type="hidden" value="${p.price}" name="price">
						<button type="submit">게시글쓰기</button>
								</form>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	</table>
	</div>
</body>
</html>