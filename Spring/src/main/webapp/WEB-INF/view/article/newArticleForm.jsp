<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
</head>
<body>


게시글 스기 입력 폼 : 

<form method="post">

	<input type="hidden" name="parentId" value="0">
	제목 : <input type="text" name="title"><br>
	내용 : <textarea name="content"></textarea>
	<input type="submit" value="작성">
</form>

</body>
</html>