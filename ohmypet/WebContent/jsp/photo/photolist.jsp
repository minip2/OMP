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
      
      /*  a:link {color:grey;
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
      
	
</style>


</head>
<body>
<c:import url="/jsp/common/top.jsp" />

<%-- 제목, 컨텐트, 날짜, 파일패스, 아이디 --%>
<%-- <h2>사진게시판</h2>
<div class="container" style="margin-top:50px">
	<table>
  <tr>
    <th>제목</th>
    <th>컨텐트</th>
    <th>파일패스</th>
    <th>아이티</th>
    <th>날짜</th>
  </tr>
  <tr>
  <c:forEach var="list" items="${photolist}" >
  <tr>
    <td><c:out value="${list.no}"/></td>
    <td><c:out value="${list.id}"/></td>
    <!--   </a>-->
    <td><a href="/ohmypet/com/omp/photo/detail?no=${list.no}" ><c:out value="${list.title}"/></a></td>
    <td><c:out value="${list.reg_date}"/></td>
  </tr>
  </c:forEach>
</table> --%>
<c:forEach var="list" items="${photolist}" >
  <tr>
    <td><c:out value="${list.no}"/></td>
    <td><c:out value="${list.id}"/></td>
    <!--   </a>-->
    <td><a href="/ohmypet/com/omp/photo/detail?no=${list.no}" ><c:out value="${list.title}"/></a></td>
    <td><c:out value="${list.reg_date}"/></td>
  </tr>
  </c:forEach>
 <div id="columns">
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/cinderella.jpg">
        <figcaption>Cinderella wearing European fashion of the mid-1860’s</figcaption>
      </figure>
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/rapunzel.jpg">
        <figcaption>Rapunzel, clothed in 1820’s period fashion</figcaption>
      </figure>
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/belle.jpg">
        <figcaption>Belle, based on 1770’s French court fashion</figcaption>
      </figure>
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/mulan_2.jpg">
        <figcaption>Mulan, based on the Ming Dynasty period</figcaption>
      </figure>
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/sleeping-beauty.jpg">
        <figcaption>Sleeping Beauty, based on European fashions in 1485</figcaption>
      </figure>
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/pocahontas_2.jpg">
        <figcaption>Pocahontas based on 17th century Powhatan costume</figcaption>
      </figure>
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/snow-white.jpg">
        <figcaption>Snow White, based on 16th century German fashion</figcaption>
      </figure>    
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/ariel.jpg">
        <figcaption>Ariel wearing an evening gown of the 1890’s</figcaption>
      </figure>
 
      <figure>
        <img src="//s3-us-west-2.amazonaws.com/s.cdpn.io/4273/tiana.jpg">
        <figcaption>Tiana wearing the <i>robe de style</i> of the 1920’s</figcaption>
      </figure>   
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