<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Trang không tồn tại hoặc bạn không có quyền truy cập tài nguyên này
    <c:if test="${!daDangNhap}">
        <a href="<%=request.getContextPath()%>/dang-nhap">
            Đăng nhập
        </a>
    </c:if>
</body>
</html>
