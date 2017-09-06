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
    <h3><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/dictionary?dogName=<c:out value="${dogName}" />">
        '<c:out value="${dogName}" />' 상세 정보</a></h3>
    <form action="${pageContext.request.contextPath}/com/omp/dictionary/controller/dictionaryEdit">
    	<input type="hidden" value="${dogName}" name="dogName">
        <button type="submit">편집</button>
    </form>
    <form action="${pageContext.request.contextPath}/com/omp/dictionary/controller/history">
    	<input type="hidden" value="${dogName}" name="dogName">
        <button>
                  역사보기
        </button>
    </form>
    <h1><c:out value="${dogName}" /></h1><br>
	원산지 : <c:out value="${dog.origin}" /><br>
	크기 : <c:out value="${dog.dogSize}" /><br>
	색상 : <c:out value="${dog.color}" /><br>
	버전 : v<c:out value="${dog.version/10+1}" /><br>
	설명 : <c:out value="${dog.detail}" /><br>
</body>
</html>