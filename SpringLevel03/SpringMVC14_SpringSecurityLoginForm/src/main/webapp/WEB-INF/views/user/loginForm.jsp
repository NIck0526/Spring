<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  
 ���Ȱ��� �α����� 4.XXX ����
 1.action="j_spring_security_check"
 2.�޼ҵ� ����� �翬�� post��
 3.�̶����� hidden�� �̿��ؼ� ���� ����
   ${_csrf.parameterName}, ${_csrf.token} 
 4.<form-login>���� login-processing-url �Ӽ��� �⺻���� /j_spring_security_check���� POST /login����,
   username-parameter �Ӽ��� �⺻���� j_username���� username����,
   password-parameter �Ӽ��� �⺻���� J_password���� password��,
   authentication-failure-url �Ӽ��� �⺻���� /login?error=1���� ����Ǿ���.
-->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Login Form</h1>
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
	ID : <input type="text" name="username"><br><br>
	PASSWORD : <input type="password" name="password"><br><br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><br><br>
	<input type="submit" value="LOGIN">
</form>
</body>
</html>













