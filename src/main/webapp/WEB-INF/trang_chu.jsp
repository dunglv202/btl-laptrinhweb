<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Xin chào, ${nguoiDung != null ? nguoiDung.tenHienThi : "Khach"}</h1>
    <c:if test="${nguoiDung != null}">
        <ul>
            <c:forEach var="quyen" items="${nguoiDung.dsQuyen}">
                <li>${quyen.tenQuyen}</li>
            </c:forEach>
        </ul>
    </c:if>
    <form action="<%=request.getContextPath()%>/dang-xuat" method="POST">
        <button type="submit">Đăng xuất</button>
    </form>
</body>
