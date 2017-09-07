<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
		width:100%
	}
	th,td{
		padding: 8px;
  	    text-align: left;
   	    border-bottom: 1px solid #ddd;
	}
	
	/* #columns{
		/* column-count:3; */ 
        /*column-width:800px; 
        column-gap: 15px;  /* 컬럼과 컬럼 사이  */
        
       /*  border: 1px solid black; */
     /* }
      #columns figure{
        display: inline-block; /* 짤리는거 처리  */
      /*  border:1px solid rgba(0,0,0,0.2);
        margin:0;
        margin-bottom: 15px;
        padding:10px;
        box-shadow: 2px 2px 5px rgba(0,0,0,0.5);;
      }
      #columns figure img{
        width:320px;
        height:330px;
      }
      #columns figure figcaption{
        border-top:1px solid rgba(0,0,0,0.2);
        padding:10px;
        margin-top:11px;
        height: 80px;
      } */
      
      #columns{
        column-width:350px;
        column-gap: 15px;
      }
      #columns figure{
        display: inline-block;
        border:1px solid rgba(0,0,0,0.2);
        margin:0;
        margin-bottom: 15px;
        padding:10px;
        box-shadow: 2px 2px 5px rgba(0,0,0,0.5);;
      }
      #columns figure img{
        width:100%;
      }
      #columns figure figcaption{
        border-top:1px solid rgba(0,0,0,0.2);
        padding:10px;
        margin-top:11px;
      }
      
      
      
       a:link {color:grey;
              text-decoration:none; /*하이퍼링크의 밑줄 속성 제거 */
              border-botton-width: 1px;
              border-botton-style: dashed; /* border-botton : 밑줄 속성, style에 dashed로 주면 점선*/
              border-botton-color: #808080;
     }
     
     a:visited 
     {color:skyblue;
      border-bottom-style: solid;       
              border-botton-width: 1px;
              border-botton-color: skyblue;
     } */
      
      .center-style{
      	
      }
      div.board-margin{
      	margin: 30px;
      }
	
</style>


</head>
<body>
<c:import url="/jsp/common/top.jsp" />
<div>
	<button type="button"><a href="/ohmypet/jsp/photo/photowrite.jsp">글쓰기 </a></button>
</div>
 <div id="columns" class="board-margin"> 
 	<c:forEach var="list" items="${photolist}" >
      <figure>
        <img src="${list.file_path}">
        <figcaption>
	        <c:out value="${list.title}"/><br>
	        <a href="/ohmypet/com/omp/photo/detail?no=${list.no}" >
	        <c:out value="${list.content}"/></a>
        </figcaption>
      </figure>
  </c:forEach>
</div>
 
<div class="text-center">
   <ul class = "pagination">
     <li><a href="#">1</a></li>
     <li><a href="#">2</a></li>
     <li><a href="#">3</a></li>
     <li><a href="#">4</a></li>
     <li><a href="#">5</a></li>
   </ul>
</div>
</div>
</div>
</body>
</html>