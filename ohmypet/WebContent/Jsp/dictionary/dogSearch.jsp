<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
	div.search-title {
		margin:50px;
		position:relative;
	}
	h3.searchTitle {
		font-size: 30px;
	}
	a.result {
		font-size: 50px;
		color: rgb(198, 77, 25);
	}
	body { padding-bottom: 70px; }
</style>
</head>
<body>
	<c:import url="/jsp/common/top.jsp" />

	<nav class="navbar navbar-default navbar-static-top">
	  <div class="container">
        <ul class="nav navbar-nav">
          <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                          색상 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="color" />&keyword=<c:out value="갈색" />">갈색</a></li>
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="color" />&keyword=<c:out value="흰색" />">흰색</a></li>
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="color" />&keyword=<c:out value="검정색" />">검정색</a></li>
            </ul>
          </li>
          <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                         크기 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="dog_size" />&keyword=<c:out value="대형" />">대형</a></li>
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="dog_size" />&keyword=<c:out value="중형" />">중형</a></li>
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="dog_size" />&keyword=<c:out value="소형" />">소형</a></li>
            </ul>
          </li>
          <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                         원산지 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="origin" />&keyword=<c:out value="한국" />">한국</a></li>
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="origin" />&keyword=<c:out value="프랑스" />">프랑스</a></li>
              <li><a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search?groupName=<c:out value="origin" />&keyword=<c:out value="이탈리아" />">이탈리아</a></li>
            </ul>
          </li>
        </ul>
    
        <form action="${pageContext.request.contextPath}/com/omp/dictionary/controller/search"
              class="navbar-form navbar-right" role="search">
          <select name="groupName">
            <option value="dog_name">이름</option>
            <option value="origin">원산지</option>
            <option value="dog_size">크기</option>
            <option value="color">색상</option>
          </select>
          <input type="text" placeholder="검색어" name="keyword">
          <button type="submit">검색</button>
        </form>
        
      </div>
	</nav>
	
    <div class = "search-title">
	<h3 class = "searchTitle"><a class="dogSearch" href="${pageContext.request.contextPath}/com/omp/dictionary/controller/search">강아지 검색</a></h3>
	</div>

	<h4> 검색결과</h4>
	    <c:forEach var="dogName" items="${dogList}">
	    	<a class="result" href="${pageContext.request.contextPath}/com/omp/dictionary/controller/dictionary?dogName=<c:out value="${dogName}" />"> <c:out value="${dogName}" /></a>
	    	<br>
	    </c:forEach>
	    
	<c:import url="/jsp/dictionary/dictionaryList.jsp" />
	
</body>
</html>