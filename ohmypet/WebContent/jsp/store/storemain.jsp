<%@page import="com.omp.store.dao.ShBoardDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.omp.store.domain.ShBoardDM" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 	
ShBoardDM dm = new ShBoardDM();
ShBoardDAO dao = new ShBoardDAO();
List<ShBoardDM> list = dao.ShBoardList();

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



<a href = "/ohmypet/product/list"> <button type="button"> 상품관리 </button> </a>
<a href = "/ohmypet/jsp/shboardinsert.jsp"> <button type="button"> 게시글등록 </button> </a> <br>

<table>
	<tr>
		<th colspan = "4">게시글목록</th>
	</tr>	
<%
if(list != null){
	for(ShBoardDM s : list){
		int no = s.getNo();
		String title = s.getTitle();
		String photo = s.getPhotoPath();
		Date date = s.getRegDate();
%>
	<tr>
		<td><%=no%></td>
		<td><%=title%></td>
		<td><img src = '<%=photo%>'> </td>
		<td><%=date%></td>
	</tr>

	<%}%>	
<%}else{%>
	<%= msg%>
<%}%>
</table>

</body>
</html>