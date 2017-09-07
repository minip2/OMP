<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<style>

div{
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	width: 58%;	
}
</style>
</head>
<body>
	<c:import url="/jsp/common/top.jsp" />
	 	

	<div>
	최신글<br>
	
	</div>
	<div>
	사진<br>
	<c:forEach var="i" begin="0" end="2" items="${list}">
	<a href ="${pageContext.request.contextPath}/shboard/detail?no=${i.no}"><img src = "${pageContext.request.contextPath}/store/download?path=${i.photoPath}&sname=${i.sname}&dname=${i.dname}" width="200px" height="200px"></a>
	</c:forEach>
	</div>
	
	<div>
	스토어<br>
	<c:forEach var="i" begin="0" end="2" items="${list}">
	<a href ="${pageContext.request.contextPath}/shboard/detail?no=${i.no}"><img src = "${pageContext.request.contextPath}/store/download?path=${i.photoPath}&sname=${i.sname}&dname=${i.dname}" width="200px" height="200px"></a>
	</c:forEach>
	</div>
</body>


</html>