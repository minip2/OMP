<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3><a href="dictionaryComment.html">'푸들' 에게 한마디</a></h3>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>작성자</th>
            <th>날짜</th>
        </tr>
        <tr>
            <td>1</td>
            <td>푸들</td>
            <td>너무예뻐요</td>
            <td>aaa</td>
            <td>08.19 11:12:35</td>
        </tr>
    </table>
    <br>
       <span><a>1</a></span>
       <span><a>&gt;</a></span>
    <br>
    <form>
       <input type="text" placeholder="댓글을 입력하세요">
           <button type="submit">
               <a href="dictionaryComment.html">댓글 쓰기
               </a>
           </button>
    </form>
    
    <c:import url="/jsp/dictionary/dictionaryList.jsp" />
</body>
</html>