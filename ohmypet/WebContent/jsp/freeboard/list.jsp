<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <style type="text/css">
         a{text-decoration:none; color:#000000;}         
         a:hover{color:#ff0000;}                     
         
         nav ul{padding-top:10px;}                    
         nav ul li {
            display:inline;                       
            border-left:1px solid #999;           
            font:bold 15px Dotum;                     
            padding:0 30px;   
                
        }
         nav ul li:first-child{border-center:none;}          
    </style>
</head>
<body>
<div style="margin-top:130px">

<nav>
<ul class="text-left" style="margin-left:350px">
<li><a href="#" class="botton" id="all" >전체</a></li>
<li><a href="#" class="botton" id="dog" >멍뭉이</a></li>
<li><a href="#" class="botton" id="cat" >야옹이</a></li>
<li><a href="#" class="botton" id="honey">꿀팁</a></li>
</ul>
</nav>
<div class="container" style="margin-top:50px">
<table class = "table table-striped" >
   <thead>
   <tr>
      <th>번호</th>
      <th>분류</th>
      <th>제목</th>
      <th>글쓴이</th>
      <th>날짜</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="b" items="${list}">
    <tr>
       <td> ${b.no}</td>
       <td> ${b.categoryVal}</td>
       <td><a href="${pageContext.request.contextPath}/com/omp/freeboard/controller/selectbyno?no=${b.no}">${b.title}</a></td>
       <td> ${b.id}</td>
       <td> ${b.regDate}</td>
    </tr>
	</c:forEach>
    </tbody>  
</table>

<hr/>

<!--<a class="btn btn-default">검색</a>
  -->
<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/com/omp/freeboard/controller/freeinsertform">글쓰기</a>
<div class="text-center">
 <ul class = "pagination">
    <li><a rel ="next"  href="#" >1</a></li>
     <li><a rel ="next" href="#" >2</a></li>
     <li><a rel ="prev" href="#" >3</a></li>
     <li><a rel ="prev" href="#" >4</a></li>
     <li><a rel ="prev" href="#" >5</a></li>
   
   </ul>
</div>
</div>
</div>
</body>
</html>
