<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">FileUpload & Download Test...</h2>
<!-- 파일 업로드 하기위한 main 페이지의 조건
 1. a tag(앵커태그) 는 안됨. Form 태그를 사용하자. (post방식으로 보낼 수 없고 3. 도 넣을수가 없음.)
 
 2. method="post"로 지정
 
 3. enctype 속성을 주고 값으로는 multipart/form-data를 준다
 4. input type="file"
 5. 4번일때 폼의 이름을 반드시 잘 기억.
 ::
 파일 업로드 만큼은 Controller를 작성하기 전에
 VO를 먼저 작성할 필요가 있다.
 MultipartFile 을 알아야 한다.
 -->
<form method="post" action="fileUpload.do" enctype="multipart/form-data"> 
사용자명 : <input type="text" name="userName"><br><br>
<input type="file" name="uploadFile"><p>
<input type="submit" value="FileUpload">
</form>
</body>
</html>