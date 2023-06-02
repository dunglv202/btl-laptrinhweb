<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css" />
</head>
<body>
    <jsp:include page="components/header.jsp"/>
    <jsp:include page="components/danh_sach_the_loai.jsp"/>
    <jsp:include page="components/danh_sach_san_pham.jsp"/>
    <jsp:include page="components/chan_trang.jsp"/>
    <jsp:include page="components/thong_bao.jsp"/>
</body>
