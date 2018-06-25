<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="content">
	<form method="post">
		작성자${member.nickname}<br />
		제목<input type="text" name="title" /><br />
		내용<textarea name="content"></textarea><br />
		<input type="submit" value="작성" />
		<input type="button" id="mainbtn" value="메인" />
	</form>
	<script>
		document.getElementById("mainbtn").addEventListener("click", 
			function(){
				location.href="./";
		});
	</script>
</section>
</body>
</html>