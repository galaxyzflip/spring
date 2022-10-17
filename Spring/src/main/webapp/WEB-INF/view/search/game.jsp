<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 검색 결과</title>
</head>
<body>

인기 키워드 : 

<c:forEach var="popularQuery" items="${populartQueryLists }">${popularQuery }</c:forEach>

	<form action="game.do">
	
		<c:forEach var="searchType" items="${searchTypeList }">
			<option value="${searchType.code }" <c:if test="${command.type eq searchType.code }"> selected </c:if>>${searchtype.text }</option>
		</c:forEach>
		
		<input type="text" name="query" value="${command.query }"/>
		<input type="submit" value="검색"/>
	
	</form>

검색 결과:${searchResult }

</body>
</html>