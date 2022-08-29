<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="login.do" method="post">
<input type="hidden" name="cnt" value="${param.cnt}">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mpw" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
<a href='ctrlB.jsp?action=main'>돌아가기</a>


</body>
</html>