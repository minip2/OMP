<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 페이스북 공유하기 -->
<meta property="og:url"           content="OhmyPet" />
 <meta property="og:type"          content="website" />
 <meta property="og:title"         content="${dm.title}" />
 <meta property="og:description"   content="${dm.content}" />
 <meta property="og:image"         content="${dm.file_path}" />


<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> -->
  <style type="text/css">      

	.board_style{
		margin-left:auto;
		margin-right: auto; 
		padding:10px;
		width:700px;
		border: 1px solid #3498DB;
	}
	.idpw-board{
		margin-top:10px;
		margin-bottom:10px;
		 display:inline;
		 width: 70px;
	}
	
	.float-left-style{
		float: left;
	}
	
	.clear-left{
		clear: left;
	}
	div.id{
		text-align: right;
		margin-right: 20px;
	}
	
	button a{
		text-decoration: none;
		color: rgba(0,0,0,0.8);
	}
	button a:active :after{
		text-decoration: none;
		color: rgba(255,0,0,0.2);
	}
	button a:hover{
		text-decoration: none;
		color: black;
	}
	div.button-style{
		margin-top: 10px;
	}
	
	div.print-style-color{
		border:1px solid rgba(255,0,0,0.2);
	}
	
	div.padding{
		padding: 5px;
	}
	div.text-indent{
		text-indent:10px;
	}
	
	img.fcshare {
		border:1px solid rgba(255,0,0,0.2);

	}
    </style>
</head>
<body>

<div id="fb-root"></div>
<script >
	function sharing(){
		window.open("http://www.facebook.com/sharer/sharer.php?u=http://192.168.0.32:8000/ohmypet/com/omp/photo/detail?no=${dm.no}");		
	}

</script> 

<c:import url="/jsp/common/top.jsp" />
<div class="board_style">

<div style="margin-top:5px;margin-bottom:5px;text-align: center; height:500px;">
	<img src="${dm.file_path}" style="width:100%;"  />
</div>
<form action="/ohmypet/com/omp/photo/controller/writer">	
<div class="form-group"> 
	<div class="print-style-color text-indent float-left-style" style="width:100px; height: 24px;">
	<c:choose>
		<c:when test="${dm.category_val == 1 }">  <!-- 참과 거짓 -->
			강아지
		</c:when>
		<c:when test="${dm.category_val == 2 }">  <!-- 참과 거짓 -->
			고양이
		</c:when>
		<c:when test="${dm.category_val ne 1 and dm.category_val ne 2}">  
			펫
		</c:when>
	</c:choose>
	</div>
	<div class="id"> ${dm.id} </div>
	
	<p class="clear-left"></p>

    <label for="title" >제목</label>
    <div class="print-style-color text-indent padding">
      <c:out value="${dm.title}" />		
	</div>		
	 <p>
	 <label for="content">내용</label>
	 <div class="print-style-color text-indent padding" style="width:650; height: 300px;">
	 	<c:out value="${dm.content}" />
	 
	 </div>
	 </p>
	 <br>
	 <div>
		 <label for="tag" >tag</label>
		 <input type="text" name="tag" class="form-control" id="tag" placeholder="태그를 입력해주세요(쉼표로 구분합니다.)"/> 
	 </div>
	 <br>
  <div>
  <span style="boder:1px soild black;" onclick="sharing();">
	<img class="fcshare" src="${pageContext.request.contextPath}/jsp/photo/fcshare.png">
  </span>
	</div>			 	
		
 <br>
 <div class="button-style">
 <button type="button"><a href="/ohmypet/com/omp/photo/modform?no=${dm.no}">수정</a></button>
 <button type="button"><a href="/ohmypet/com/omp/photo/list">삭제</a></button>
 <button type="button"><a href="/ohmypet/com/omp/photo/list">목록</a></button>
 </div>
  </div>
	</form>
	</div>
</body>
</html>