<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
td {
	border: 1px solid #444
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
	<h2>게시글 등록 페이지</h2>
	<a href="${pageContext.request.contextPath}/store/main">
		<button type="button">돌아가기</button> <br>
	</a>
	<c:choose>
		<c:when test="${param.categoryVal ne null}">
			<form action="${pageContext.request.contextPath}/shboard/insert" method = "post"  enctype ="multipart/form-data">
				<c:choose>
					<c:when test="${param.categoryVal eq 1000}">
상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option selected="selected">간식</option>
							<option>장난감</option>
							<option>사료</option>
						</select>
					</c:when>
					<c:when test="${param.categoryVal eq 2000}">
    상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option selected="selected">간식</option>
							<option>장난감</option>
							<option>사료</option>
						</select>
					</c:when>
					<c:when test="${param.categoryVal eq 3000}">
       상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option>간식</option>
							<option>장난감</option>
							<option selected="selected">사료</option>
						</select>
					</c:when>
					<c:otherwise>
		 상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option>간식</option>
							<option>장난감</option>
							<option>사료</option>
						</select>
					</c:otherwise>
				</c:choose>
				<BR>
				상품코드 <c:out value="${param.productId}"/> <BR> 
				상품명<input type="text" placeholder="상품명을 등록하세요" name='productName'value="${param.productName}"> <BR>
				총수량<input type="text" placeholder="상품수량을 입력하세요" name='quantity'	value="${param.quantity}"> <BR>
				판매가<input type="text"	placeholder="상품가격을 입력하세요" name='price' value="${param.price}"><br>
				제목<input type="text" placeholder="글제목을 입력하세요" name='title'>
				<br>상세내용<br>
				<textarea rows="5" cols="80" placeholder="이곳에 내용을 입력하세요" name="productDetail"></textarea>
				<BR> <BR>
				<input type="hidden" name="productId" value="${param.productId}">
				<input type="hidden" name="id" value="admin">
				<h5>상품사진을 등록하세요</h5>
				<input type="file" name = "img"> <BR> <BR>
				<button type="submit">등록하기</button>
			</form>
		</c:when>
		<c:when test="${pdm.categoryVal ne null}">
			<form action="${pageContext.request.contextPath}/shboard/insert" method = "post"  enctype ="multipart/form-data">
				<c:choose>
					<c:when test="${pdm.categoryVal eq 1000}">
상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option selected="selected">간식</option>
							<option>장난감</option>
							<option>사료</option>
						</select>
					</c:when>
					<c:when test="${pdm.categoryVal eq 2000}">
    상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option selected="selected">간식</option>
							<option>장난감</option>
							<option>사료</option>
						</select>
					</c:when>
					<c:when test="${pdm.categoryVal eq 3000}">
       상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option>간식</option>
							<option>장난감</option>
							<option selected="selected">사료</option>
						</select>
					</c:when>
					<c:otherwise>
		 상품분류<select name='categoryVal'>
							<option>상품분류</option>
							<option>간식</option>
							<option>장난감</option>
							<option>사료</option>
						</select>
					</c:otherwise>
				</c:choose>
				<BR>
				상품코드${pdm.productId} <BR> 
				상품명<input type="text" placeholder="상품명을 등록하세요" name='productName'value="${pdm.productName}"> <BR>
				총수량<input type="text" placeholder="상품수량을 입력하세요" name='quantity'	value="${pdm.quantity}"> <BR>
				판매가<input type="text"	placeholder="상품가격을 입력하세요" name='price' value="${pdm.price}"><br>
				제목<input type="text" placeholder="글제목을 입력하세요" name='title'>
				<br>상세내용<br>
				<textarea rows="5" cols="80" placeholder="이곳에 내용을 입력하세요" name="productDetail"></textarea>
				<BR> <BR>
				<input type="hidden" name="productId" value="${pdm.productId}">
				<input type="hidden" name="id" value="admin">
				<h5>상품사진을 등록하세요</h5>
				<input type="file" name = "img"> <BR> <BR>
				<button type="submit">등록하기</button>
			</form>
		</c:when>



			<c:otherwise>
				<form action="${pageContext.request.contextPath}/shboard/load">
					<c:out value="상품코드" />
					<select name='productId'>
						<c:forEach var="i" items="${list}">
							<option>
			 					${i.productId}
							</option>
						</c:forEach>
					</select>
					<button type="submit">불러오기</button>
				</form>
				<table>
					<tr colspan='3'>
						<th>상품표</th>
					</tr>
					<tr>
						<td>상품코드</td>
						<td>상품이름</td>
					</tr>
					<c:forEach var="i" items="${list}">
						<tr>
							<td>${i.productId}</td>
							<td>${i.productName}</td>
						</tr>
					</c:forEach>
				</table>

			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>