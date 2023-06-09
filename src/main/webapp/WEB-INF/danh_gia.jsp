<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var = "item" items = "${tat_ca_danh_gia}">
		<form action = "<%=request.getContextPath()%>/xoa-danh-gia" method = "GET">
			<input name = "ma_danh_gia" value = "${item.id}"/>
			<input name = "ma_san_pham" value = "1">
			<p>ok</p>
			<button type = "submit"> delete </button>
		</form>
	</c:forEach>
</body>
</html>