<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSON 테스트</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
	var xmlhttp;
	$(document)
			.ready(
					function() {
						if (window.XMLHttpRequest) {
							xmlhttp = new XMLHttpRequest();
						} else {
							xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
						}
						xmlhttp.onreadystatechange = function() {
							if (xmlhttp.readyState == 4) {
								document.getElementById('loadedJson').innerHTML = xmlhttp.responseText;
							}
						}
						xmlhttp.open("GET", "json.do", true);
						xmlhttp.setRequestHeader("Content-Type",
								"application/x-www-form-urlencoded");
						xmlhttp.setRequestHeader("Accept", "application/json");
						xmlhttp.send(null);
					});
</script>
</head>
<body>
	<div id="loadedJson"></div>
</body>
</html>