<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="son" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

	<div id="header">
		<h1>작은 티모</h1>

		<div class="gnb">
			<ul>
				<li><a href="main.do">메인으로</a></li>
				<son:login/>
			</ul>
		</div>
	</div>

	<div id="wrapper">

		<div id="content">
			<son:write type="msg"/>
		</div>

		<div id="main">
			<h2>글 목록보기</h2>
			<c:forEach var="v" items="${datas}">
				<c:set var="b" value="${v.boardVO}" />
				<h3>[${b.mid}] ${b.msg} [ <son:fav bid="${b.bid}" fav="${b.favcnt}"/> | 댓글 ${b.rcnt} ] <son:delete bmid="${b.mid}" bbid="${b.bid}" type="bdel"/></h3>
				<div class="reply">
					<ul>
						<c:forEach var="r" items="${v.rList}">
							<li>[${r.mid}] ${r.rmsg}<son:delete type="rdel" rid="${r.rid}" rmid="${r.mid}" rbid="${r.bid}"/></li>
						</c:forEach>
					</ul>
				</div>

				<div class="reply">
					<son:write type="rmsg" bbid="${b.bid}"/>
				</div>
			</c:forEach>
		</div>
		<c:if test="${more==true}">
		<a href="main.do?cnt=${cnt+2}">더보기&gt;&gt;</a>
		</c:if>

	</div>

	<div id="footer">
		회사소개 | 이용약관 | <strong>개인정보처리방침</strong> | 보호정책 | 고객센터 <strong>ⓒ
			Corp.</strong>
	</div>

</body>
</html>