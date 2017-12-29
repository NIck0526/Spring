<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		document.getElementById("logoutFrm").submit();
	}

</script>
</head>
<body>
<h2>Spring Security 디비 인증 연결 IV.</h2>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.name"/>님 환영합니다.
	<!-- authentication 의 getPrincipa().getName() 과 같다.
		Principal은 MemberAuthenticationProvider의 Authentication에 넣어준 첫번째 인자값
		(생성자 첫번째 매개변수)
	 -->
	 <sec:authentication property="principal.email"/>
	 <sec:authentication property="principal"/><!-- userType은 null로 나올 것이다. -->
</sec:authorize>

<!-- 인증이 안되었다면 -->	 
	 <sec:authorize access="isAnonymous()"><!-- isAuthenticated() 로 비교해도됨. -->
	 <li><a href="${pageContext.request.contextPath}/loginForm">로그인 폼</a></li>
	  <li><a href="${pageContext.request.contextPath}/member/joinForm">회원 가입 폼</a></li>
	 
	 </sec:authorize>
	
<!-- 
	인증이 되었는데,
		일반 회원인 경우에 접근해야 되는 페이지 | 관리자 경우가
 --> 
 <sec:authorize access="isAuthenticated()"> <!-- 인즈이 된 경우 -->
 	
 	<!-- 관리자인 경우 -->
 	<sec:authorize access="hasRole('ROLE_ADMIN')">
 		<li><a href="${pageContext.request.contextPath}/admin/main">ADMIN 메인 페이지</a></li>
 	</sec:authorize>
 	
 	<!-- 일반 회원이거나 관리자인 경우 모두 이곳으로... ::  hasAnyRole() :: 2개 이상의 권한을 비교 -->
 	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')">
 		<li><a href="${pageContext.request.contextPath}/member/main">MEMBER 메인 페이지</a></li>
 	</sec:authorize>
 	
 	<li><a href="javascript:logout()">로그아웃</a></li>
 </sec:authorize>
 <p>
 
 <!-- 로그아웃은 스프링 4 버젼 부터는 post방식으로 이동 
 	  _csrf값을 요청해야만 한다.
 -->
 <form action="${pageContext.request.contextPath}/member/logout" method="post" id="logoutFrm">
 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>
</body>
</html>

















