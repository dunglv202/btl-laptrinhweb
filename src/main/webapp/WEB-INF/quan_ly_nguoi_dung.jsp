<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/trang_admin.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bang.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/quan_ly_nguoi_dung.css">
    </head>
    <body>
        <jsp:include page="components/menu_admin.jsp" />

        <main>
            <h1 class="tieu-de-trang">
                Quản lý người dùng
            </h1>
            <div class="bang-admin">
                <div class="tuong-tac-bang">
                    <form class="tieu-chuan loc-du-lieu">
                        <div class="bo-loc">
                            <div class="truong">
                                <div class="tim-kiem">
                                    <input class="o-tim-kiem" name="tuKhoa" value="${param.get("tuKhoa")}" placeholder="Từ khoá" />
                                    <button class="nut kieu-1">Tìm kiếm</button>
                                </div>
                            </div>
                        </div>
                        <div class="phan-trang">
                            Trang
                            <input type="number" name="trang" value="${param.get("trang") != null ? param.get("trang") : 1}" min="0" />
                            của
                            <span class="tong-so-trang">10</span>
                        </div>
                    </form>
                </div>
                <table class="bang">
                    <thead>
                    <tr>
                        <th>Tên đăng nhập</th>
                        <th>Email</th>
                        <th>Số điện thoại</th>
                        <th>Quyền được cấp</th>
                        <th>Ngày tạo tài khoản</th>
                        <th>Đã khoá</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="nguoiDung" items="${danhSachNguoiDung}">
                        <tr>
                            <td>${nguoiDung.tenDangNhap}</td>
                            <td>${nguoiDung.email}</td>
                            <td>${nguoiDung.soDienThoai}</td>
                            <td>
                                <ul class="toi-gian">
                                    <c:forEach var="quyen" items="${nguoiDung.dsQuyen}">
                                        <li>${quyen.tenQuyen}</li>
                                    </c:forEach>
                                </ul>
                            </td>
                            <td>
                                <fmt:formatDate value="${nguoiDung.thoiGianTao}" pattern="dd-MM-yyyy" />
                            </td>
                            <td>
                                <label>
                                    <input type="checkbox" class="chon" ${nguoiDung.daKhoa ? 'checked' : ''} disabled />
                                    <div class="checkbox-tu-tao"></div>
                                </label>
                            </td>
                            <td class="hanh-dong">
                                <a href="#">Xem</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </body>
</html>
