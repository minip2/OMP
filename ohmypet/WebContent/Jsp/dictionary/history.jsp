<%@page import="com.omp.dictionary.domain.DictionaryDM"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3><a href="/ohmypet/com/omp/dictionary/controller/dictionary?dogName=<c:out value="${dogName}" />">
        '<c:out value="${dogName}" />' 상세 정보</a></h3>
    <form action="/ohmypet/com/omp/dictionary/controller/edit">
    	<input type="hidden" value="${dogName}" name="dogName">
        <button type="submit">편집</button>
    </form>
        <h1><c:out value="${dogName}" /></h1><br>        
	<table>
		<tr>
			<th>버전</th>
			<th>날짜</th>
			<th>닉네임</th>
			<th>삭제</th>
		</tr>
	<c:forEach var="dictionary" items="${history}">
		<tr>
			<td>v<c:out value="${dictionary.version/10 + 1}"></c:out></td>
			<td><c:out value="${dictionary.modDate}"></c:out></td>
			<td><c:out value="${dictionary.nickname}"></c:out></td>
			<td>
				<form action="/ohmypet/com/omp/dictionary/controller/delete">
				    <input type="hidden" value="${dogName}" name="dogName">
					<input type="hidden" value="${dictionary.version}" name="version">
					<button>삭제</button>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>