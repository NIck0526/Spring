<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- forEach를 사용해서 결과페이지를 작성. -->
<h2><b>+++++++++++++++++++ 검색 결과 +++++++++++++++++++++</b></h2>
<table border="2">
	<thead>
		<tr>
			<th>NO</th>
			<th>ID</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>		
	</thead>
	<tbody>
		<c:forEach items="${list}" var="bvo">
			<tr>
				<td>${bvo.id}</td>
				<td>${bvo.id}</td>
				<td>${bvo.title}</td>
				<td>${bvo.writeDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>