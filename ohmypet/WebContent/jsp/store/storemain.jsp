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
.adminbutton{
float: right;
}
img{
border: 1px solid #444;
width: 250px; 
height: 250px; 
} 
td{
border: 1px solid #444;
margin-left: auto;
margin-right: auto;
margin-top: 50px;
	/*width: 58%;*/
	}
th{
border: 1px solid #444;
margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	width: 58%;}
.store_board{
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	width: 58%;	
	column-count: 3;
}
.clearfix li{
	display: inline;
	/* padding-bottom:5px; */
	float:right;
	
}
.clearfix a{
	color: #408080;
	display: inline-block;
	width: 100px;
	text-align: center;
	text-decoration: none;
	line-height: 40px;
	text-shadow: 1px 1px 0px #ffffff;
	clear: right;
	}
.adminbutton{
}
.list{
float: right;
}
</style>
</head>
<body>
<c:import url="/jsp/common/top.jsp"/>
<nav class = "clearfix">
<ul>
	<li> <a href = "/ohmypet/store/main"> 전체 </a> </li>
	<li> <a href = "/ohmypet/store/main/category?no=1000">간식 </a> </li>
	<li> <a href = "/ohmypet/store/main/category?no=2000">장난감 </a> </li>
	<li> <a href = "/ohmypet/store/main/category?no=3000">사료 </a> </li>
</ul>
</nav>
<c:if test="${user.member_level == 0}">
<div class = "adminbutton">
<a href = "${pageContext.request.contextPath}/product/list"> <button type="button"> 상품관리 </button> </a>
<a href = "${pageContext.request.contextPath}/product/idlist"> <button type="button"> 게시글등록 </button> </a> <br>
</div>
</c:if>

<div class="store_board">
<c:forEach var="i" items="${list}">
<table>
		<tr><td>
		<a href = "${pageContext.request.contextPath}/shboard/detail?no=${i.no}">
		<img src = "${pageContext.request.contextPath}/store/download?path=${i.photoPath}&sname=${i.sname}&dname=${i.dname}" width="50px" height="50px">
		</a>
		</td></tr>
		
		<tr><td>
		${i.title}
		</td></tr>
		
		<tr><td>
		${i.price}${"원"}
		</td></tr>
		
		<tr><td>
		${i.regDate}
		</td></tr>
</table>
</c:forEach>
</div>

</body>
</html>