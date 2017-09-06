<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
    List<String> dog = (List<String>)request.getAttribute("dog");
    String keyword = (String)request.getAttribute("keyword");
%>
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
</head>
<body>
<h2><a class="dogSearch" href="/ohmypet/Html/dictionary/dogSearch.html">검색</a></h2>
    <form action="dogSearch">
    <ul class="nav nav-pills">
      <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                     색상 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
            <li>갈색</li>
            <li>흰색</li>
            <li>검정색</li>
        </ul>
      </li>
      <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                     크기 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
            <li>대형</li>
            <li>중형</li>
            <li>소형</li>
        </ul>
      </li>
      <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                     원산지 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
            <li>한국</li>
            <li>영국</li>
            <li>이탈리아</li>
        </ul>
      </li>
    </ul>
    </form>
    
    <form action="/dogSearch">
        <select name="groupName">
            <option value="dogName">이름</option>
            <option value="origin">원산지</option>
            <option value="dogSize">크기</option>
            <option value="color">색상</option>
        </select>
        <input type="text" placeholder="검색어" name="keyword">
        <button type="submit">검색</button>
        <br>
    </form>
    <t3>'<%= keyword %>' 검색 결과...</t3>
    <br>
        <% for (String dogName : dog) { %>
            <%= dogName %>   <br>
        <% } %>
    <ul>
        <li><a href="dogSearch.html">검색</a></li>
        <li><a href="dictionaryComment.html">강아지에게 한마디</a></li>
        <li>동영상</li>
        <li>분양소 찾기</li>
    </ul>
</body>
</html>