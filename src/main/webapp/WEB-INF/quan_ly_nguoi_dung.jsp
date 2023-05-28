<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        <div class="truong">
                            <div class="tim-kiem">
                                <input class="o-tim-kiem" placeholder="Từ khoá" />
                                <button class="nut kieu-1">Tìm kiếm</button>
                            </div>
                        </div>
                        <div class="truong">
                            <div class="bo-loc"></div>
                        </div>
                    </form>
                    <form class="phan-trang">
                        Trang
                        <input type="number" value="1" min="0" />
                        của
                        <span>10</span>
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
                    <tr>
                        <td>dunglv202</td>
                        <td>dunglv202@gmail.com</td>
                        <td>0123456789</td>
                        <td>
                            ADMIN, NGUOI_DUNG, KHACH_HANG
                        </td>
                        <td>21/02/2012</td>
                        <td>
                            <label>
                                <input type="checkbox" class="chon" checked disabled />
                                <div class="checkbox-tu-tao"></div>
                            </label>
                        </td>
                        <td class="hanh-dong">
                            <a href="#">Xem</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div style="height: 1000px"></div>
        </main>
    </body>
</html>
