<%@page import="com.omp.store.dao.ShBoardDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.omp.store.domain.ShBoardDM" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
td{border: 1px solid #444;}
th{border: 1px solid #444;}
</style>
</head>
<body>
<h2>스토어</h2>
<ul>
	<li> <a href = "store_main.html"> 전체 </a> </li>
	<li> <a href = "store_meal.html">사료 </a> </li>
	<li> <a href = "store_snack.html">간식 </a> </li>
	<li> <a href = "store_toy.html">장난감 </a> </li>
</ul>


<a href = "${pageContext.request.contextPath}/product/list"> <button type="button"> 상품관리 </button> </a>
<a href = "${pageContext.request.contextPath}/product/idlist"> <button type="button"> 게시글등록 </button> </a> <br>

<table>
	<tr>
		<th colspan = '5'>게시글목록</th>
	</tr>	
	<tr>
		<td>글번호</td>
		<td>사진</td>
		<td>글제목</td>
		<td>가격</td>
		<td>등록일시</td>
	</tr>
	<c:forEach var="i" items="${list}">
	<tr>
		<td>${i.no}</td>
		<td><a href = "${pageContext.request.contextPath}/shboard/detail?no=${i.no}">
		<img src = "${pageContext.request.contextPath}/store/download?path=${i.photoPath}&sname=${i.sname}&dname=${i.dname}" width="50px" height="50px">
		</a></td>
		<td> ${i.title}</td>
		<td>${i.price}${"원"}</td>
		<td>${i.regDate}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>