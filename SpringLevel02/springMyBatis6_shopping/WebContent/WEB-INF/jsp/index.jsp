<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/shopping3-1.css">    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="body">
<h2>��ǰ ��� ȭ��</h2>
<table border="1">
	<tr>
		<th align="center" width="80">��ǰ ID</th>
		<th align="center" width="320">��ǰ��</th>
		<th align="center" width="100">����</th>
	</tr>
	<c:forEach items="${itemList}"  var="item">
		<tr class="record">
			<td align="center">${item.itemId}</td>
			<td align="center"><a href="detail.html?itemId=${item.itemId}">${item.itemName}</a></td>
			<td align="center">${item.price}</td>
		</tr>	
	</c:forEach>	
</table>
</div>
</body>
</html>











