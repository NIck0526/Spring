<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	
	function deleteBoard() {
		
		var d=confirm("삭제 하시겠습니까?");
			if(d)
				location.href="delete.do?no=${bvo.no}"; //Controller에서 기능으로 연결..
	
						
	}
	
	function updateBoard() {
		var d=confirm("수정 하시겠습니까?");
		if(d)
			/* location.href="board/update.jsp?no=${bvo.no}&&content=${bvo.content}"; //Controller에서 기능으로 연결.. */
			location.href="updateView.do?no=${bvo.no}"
	}
	
	
</script>
</head>
<body>
	<table cellpadding="5">
		<tr>
		   <td>
		   	    <table width="550">
					<tr>
						<td><b>글번호 : ${requestScope.bvo.no} |
							   타이틀 : ${requestScope.bvo.title}</b>
						<hr style="color: #6691BC; border-style: dotted; margin: 0">
						</td>
					</tr>
					<tr>
						<td>작성자 :  ${requestScope.bvo.memberVO.name} |
							작성일시 : ${bvo.writeDate}
							
							Count : ${requestScope.bvo.count}
						</td>
					</tr>
					<tr>
						<td>
						<hr style="color: #6691BC; margin: 0">
						<pre>${requestScope.bvo.content}</pre>					
						</td>
					</tr>
					<tr>
						<td align="middle">
						<a href="list.do"><img alt="목록" src="../img/list_btn.jpg"></a>
					
						<c:if test="${sessionScope.mvo.id==bvo.memberVO.id}">
							<img alt="수정" src="../img/modify_btn.jpg" onclick="updateBoard()">
							<img alt="삭제" src="../img/delete_btn.jpg" onclick="deleteBoard()">
						</c:if>
						
						</td>
					</tr>
				</table> 	
			</td>
		</tr>
	</table>	
</body>
</html>






























