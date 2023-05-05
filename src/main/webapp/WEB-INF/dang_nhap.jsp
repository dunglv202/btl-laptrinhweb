<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>${thongBao}</div>
    <form method="POST">
        <input type="text" name="tenDangNhap" placeholder="Tên đăng nhập">
        <input type="password" name="matKhau" placeholder="Mật khẩu">
        <button type="submit">Đăng nhập</button>
    </form>
</body>
</html>
