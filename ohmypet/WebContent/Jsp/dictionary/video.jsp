<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	<c:import url="/jsp/common/top.jsp" />

    <h3>동영상</h3>
	<form action="${pageContext.request.contextPath}/com/omp/dictionary/controller/regVideo">
        <button>등록</button>
	</form>
	
<c:out value="" />

<div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <c:if test="${videoList != null}">
      <c:forEach var="video" items="${videoList}">
        <video width="500px" controls>
  	       <%-- <source src="${pageContext.request.contextPath}/com/omp/dictionary/util/download?path=${video.videoPath}&sname=${video.videoSystemName}&dname=${video.videoOrgName}" /> --%>
  	       <source src="http://localhost:8000/ohmypet/data/dictionary/upload<c:out value="${video.videoPath}" />/<c:out value="${video.videoSystemName}" />" >
  	    </video>  
        <div class="caption">
          <h3><c:out value="${video.no}" />.<c:out value="${video.title}" /></h3>
          <%-- <p>설명</p>  --%>
          <p>
            <a href="${pageContext.request.contextPath}/com/omp/dictionary/util/download?path=<c:out value="${video.videoPath}" />&sname=<c:out value="${video.videoSystemName}" />&dname=<c:out value="${video.videoOrgName}" />" class="btn btn-primary" role="button">다운로드</a>
            <a href="${pageContext.request.contextPath}/com/omp/dictionary/controller/videoDelete?no=<c:out value="${video.no}" />" class="btn btn-default" role="button">삭제</a>
          </p>
        </div>
      </c:forEach>
      </c:if>
    </div>
  </div>
</div>

	<c:import url="/jsp/dictionary/dictionaryList.jsp" />
	
</body>
</html>