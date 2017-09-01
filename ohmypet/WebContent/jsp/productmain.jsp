<%@page import="com.omp.store.domain.ProductDM"%>
<%@page import="com.omp.store.dao.ProductDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 	

ProductDAO dao = new ProductDAO();
List<ProductDM> list = dao.ProductList();

String msg = "리스트가 없습니다.";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
img{
border: 1px solid #444;
width: 250px; 
height: 250px; 
} 
td{border: 1px solid #444;
   width: 13%;}
th{border: 1px solid #444;}
</style>
</head>
<body>
<h2>상품관리</h2>

<a href = "/ohmypet/store/main"> <button type="button"> 돌아가기 </button> </a>

<br>

<form action = "/ohmypet/store/add">


<select name = 'categoryVal'>
	 		<option>분류선택</option>
	 		<option>간식</option>
	 		<option>장난감</option>
	 		<option>사료</option>
</select>



<input type = "txet" placeholder = "상품코드" name = 'productId' size="4">

<input type = "txet" placeholder = "상품이름" name = 'productName' size="4">

<input type = "txet" placeholder = "상품수량" name='quantity' size="4">

<input type = "txet" placeholder = "상품가격" name = 'price' size="4">

<button type="submit">등록하기</button>
</form>




<table>
	<tr>
		<th colspan="5">상품목록</th>
		<th>
			<form>
			<select name = 'option'>
	 		<option>검색옵션</option>
	 		<option>분류</option>
	 		<option>상품명</option>
	 	</th>
	 	<th>
	 	<input type = "txet" placeholder = "" name = 'keyword' size="4">
	 	</th>
	 	<th>
	 	<button>검색</button>
	 	</form>
	 	</th>
	</tr>	
	<tr>
		<td>카테고리</td>
		<td>상품코드</td>
		<td>상품이름</td>
		<td>상품수량</td>
		<td>상품가격</td>
	</tr>	
<%
if(list != null){
	for(ProductDM dm : list){
		
		String productId = dm.getProductId();
		int categoryVal = dm.getCategoryVal();
		String productName = dm.getProductName();
		int quantity = dm.getQuantity();
		int price = dm.getPrice();
		int no = dm.getNo();

%>
	<tr>
		<td><%=categoryVal%></td>
		<td><%=productId%></td>
		<td><%=productName%> </td>
		<td><%=quantity%></td>
		<td><%=price%></td>
		
		<td>
			<form action="/ohmypet/product/del">
			<button type="submit" value="<%=productId%>" name="productId">삭제하기</button>
			</form>
		</td>
		<td><!-- <form action="/ohmypet/product/movemod"> -->
			<form action="/ohmypet/jsp/productmod2.jsp">
			<input type="hidden" value="<%=productId%>" name="productId" >
			<input type="hidden" value="<%=categoryVal%>" name="categoryVal" >
			<input type="hidden" value="<%=productName%>" name="productName" >
			<input type="hidden" value="<%=quantity%>" name="quantity" >
			<input type="hidden" value="<%=price%>" name="price" >
			<button type="submit">수정하기</button>
			</form>
		</td>
		</form>
		</td>
		<td><!-- <form action="/ohmypet/product/movemod"> -->
			<form action="/ohmypet/jsp/shboardinsert.jsp">
			<input type="hidden" value="<%=productId%>" name="productId" >
			<input type="hidden" value="<%=categoryVal%>" name="categoryVal" >
			<input type="hidden" value="<%=productName%>" name="productName" >
			<input type="hidden" value="<%=quantity%>" name="quantity" >
			<input type="hidden" value="<%=price%>" name="price" >
			<button type="submit">게시글쓰기</button>
			</form>
		</td>
		
	</tr>

	<%}%>	
<%}
else{%>
	<%=msg%>
<%}%> 
</table>
</body>
</html>