<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Xin chào, <%= Objects.requireNonNullElse(request.getAttribute("ten_nguoi_dung"), "Khách") %></h1>
</body>
