<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3><a href="/ohmypet/com/omp/dictionary/controller/edit?dogName=<c:out value="${dogName}" />">
    '<c:out value="${dogName}" />' 편집</a></h3>
    <form action="/ohmypet/com/omp/dictionary/controller/history">
    	<input type="hidden" value="${dogName}" name="dogName">
        <button>
           	 역사보기
        </button>
    </form>
    <h1><c:out value="${dogName}" /></h1>
    <form action="/ohmypet/com/omp/dictionary/controller/dictionary">
        <input type="hidden" value="${dogName}" name="dogName">
    	<input type="hidden" value="${dog.dogVal}" name="dogVal">
  	    <textarea rows="20" cols="50" name="detail"><c:out value="${dog.detail}" /></textarea>
        <button>
        	수정 완료
        </button>
    </form>
</body>
</html>