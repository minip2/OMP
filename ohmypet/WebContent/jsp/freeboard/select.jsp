<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세페이지</title>
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
<li><a href="#" class="botton" id="all" value="전체">전체</a></li>
<li><a href="#" class="botton" id="dog" value="멍뭉이">멍뭉이</a></li>
<li><a href="#" class="botton" id="cat" value="야옹이">야옹이</a></li>
<li><a href="#" class="botton" id="honey" value="꿀팁">꿀팁</a></li>
</ul>
</nav>
<div class="container" style="margin-top:50px">
<form method = "post" action = "${pageContext.request.contextPath}com/omp/freeboard/controller/freeselectbyno">
<table>
<tr>
<th>제목</th>
<td>${board.title}</td>
</tr>
<tr>
<th>날짜</th>
<td>${board.regDate}</td>
</tr>
<tr>
<th>글쓴이 </th>
<td>${board.id}</td>
</tr>
</table>

<img src="나쁜남자.jpg" style="width:304px;height:228px;"><br><br>
<input type="text" class="form-control" name="title"><br>

<a class="btn btn-default" name = "delete" href="${pageContext.request.contextPath}/com/omp/freeboard/controller/freedelete?no=${board.no}">삭제</a>
<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/com/omp/freeboard/controller/freeinsert">글쓰기</a>
<button  class="btn btn-default pull-right" value="댓글">댓글</button>
</form>
</div>
</body>
</html>
