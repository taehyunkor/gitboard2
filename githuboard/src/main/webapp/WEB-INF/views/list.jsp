<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="content">
	<table align="center" border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="map" items="${list}">
			<tr>
			<td>${map.NUM}</td>
			<td>${map.TITLE}</td>
			<td>${map.NICKNAME}</td>
			<td>${map.WRITEDATE}</td>
			<td>${map.READCNT}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				<a href="./">[메인]</a>
				<a href="write">[글쓰기]</a>	
			</td>
		</tr>		
	</table>

</body>
</html>