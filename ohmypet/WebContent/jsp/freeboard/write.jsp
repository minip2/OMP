<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글등록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 <style> 
    table td{
            display:inline;                       
            border-left:1px solid #999;           
            font:bold 15px Dotum;                     
            padding:0 10px;                     
        }
  </style>  
</head>
<body>
<c:import url="/jsp/common/top.jsp"/>
<div style="margin-top:80px">
<div class="container">
<form method = "post" 
  enctype="multipart/form-data"
action = "${pageContext.request.contextPath}/com/omp/freeboard/controller/freeinsert">
 <table width="300" border="0" cellspacing="2" cellpadding="0">
            <tr class="txt01">
                <td height="25">&nbsp;&nbsp;글 작성하기</td>
            </tr>
        </table>
 <div style="margin-top:30px">       
<input type="text" class="form-control" placeholder="제목" name="title"><br>

<select name="guel">
      <option>글꼴</option>
      <option value = "궁서체">궁서체</option>
      <option value = "돋움체">돋움체</option>
      <option value = "맑은고딕">맑은 고딕</option>
 </select>
<select name="size">
      <option>글씨크기</option>
      <option value = "1">1</option>
      <option value = "2">2</option>
      <option value = "3">3</option>
      <option value = "4">4</option>
      <option value = "5">5</option>
      <option value = "6">6</option>
      <option value = "7">7</option>
 </select>
<select name="category_val">
      <option value = "1">분류</option>
      <option value = "2">멍뭉이</option>
      <option value = "3">고양이</option>
      <option value = "4">꿀팁</option>
 </select><br><br>
<textarea class="form-control" rows="20" maxlength="500" value="text" name="content"></textarea><br>

<!-- 파일업로드  -->
<div class="form-group">
    <label for="exampleInputFile">파일 업로드</label><br>
    <input type="file" name="filePath" value="파일">
</div><br>

<input type="text" placeholder="글쓴이" value="글쓴이" name="name">
<input type="text" placeholder="비밀번호" value="비밀번호" name="pw"><br><br>

<input type="checkbox" id="ck1" value="댓글허용" > <label for="ck1">댓글허용</label>
<input type="checkbox" id="ck2" value="공개" > <label for="ck2">공개</label><br><br>

<button type="button" class="btn btn-default" value="취소">취소</button>
<button class="btn btn-default pull-right" >등록</button>

 </form> 
 </div>
 </div>
</body>
</html>