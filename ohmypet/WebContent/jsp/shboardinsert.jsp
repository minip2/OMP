<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
 String productId = request.getParameter("productId");
 String productName = request.getParameter("productName");
 String quantity = request.getParameter("quantity");
 String price = request.getParameter("price");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 td {
 border: 1px solid #444
 }
</style>
</head>
<body>

<h2>게시글 등록 페이지</h2>

<form  action = "/ohmypet/shboard/insert">

<%if(request.getParameter("categoryVal")!=null){
	switch(request.getParameter("categoryVal")) { 

	case "1000" : %>
상품분류<select name = 'categoryVal'>
	 		<option>상품분류</option>
	 		<option selected="selected">간식</option>
	 		<option>장난감</option>
	 		<option>사료</option>
</select>
    <%break;
    case "2000" : %>
    상품분류<select name = 'categoryVal'>
	 		<option>상품분류</option>
	 		<option selected="selected">간식</option>
	 		<option>장난감</option>
	 		<option>사료</option>
</select>
	<%break;
    case "3000" : %>
       상품분류<select name = 'categoryVal'>
	 		<option>상품분류</option>
	 		<option>간식</option>
	 		<option>장난감</option>
	 		<option selected="selected">사료</option>
	 		</select>
	 		<%break;
	default :%>
		 상품분류<select name = 'categoryVal'>
	 		<option>상품분류</option>
	 		<option>간식</option>
	 		<option>장난감</option>
	 		<option>사료</option>
	 		</select>
	 		<%break;
	}%>
	<BR>
상품명<input type = "txet" placeholder = "상품명을 등록하세요" name = 'productName' value="<%= productName%>">
<BR>
총수량<input type = "txet" placeholder = "상품수량을 입력하세요" name='quantity' value="<%= quantity%>">
<BR>
판매가<input type = "txet" placeholder = "상품가격을 입력하세요" name = 'price' value="<%= price%>">
<BR> 
<BR>
<h5>상품사진을 등록하세요</h5><input type = "file" placeholder>
<% } else{%>
	상품분류<select name = 'categoryVal'>
	<option>상품분류</option>
	<option>간식</option>
	<option>장난감</option>
	<option>사료</option>
	</select> 
	<BR>
상품명<input type = "txet" placeholder = "상품명을 등록하세요" name = 'productName' >
<BR>
총수량<input type = "txet" placeholder = "상품수량을 입력하세요" name='quantity' >
<BR>
판매가<input type = "txet" placeholder = "상품가격을 입력하세요" name = 'price' >
<BR> 
<BR>
<h5>상품사진을 등록하세요</h5><input type = "file" placeholder>
 <%}%>

<BR>
<BR>
<button type="submit">등록하기</button>
<BR>
</form>

</body>
</html>