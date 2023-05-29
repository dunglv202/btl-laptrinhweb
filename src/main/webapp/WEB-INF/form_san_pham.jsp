<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/trang_admin.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/form_admin.css">
<%--        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/quan_ly_nguoi_dung.css">--%>
    </head>
    <body>
        <jsp:include page="components/menu_admin.jsp">
            <jsp:param name="mucHienTai" value="danh-muc"/>
        </jsp:include>

        <main>
            <h1 class="tieu-de-trang">
                Thêm mới sản phẩm
            </h1>
            <form id="form-admin" class="tieu-chuan" method="POST">
                <div class="truong bat-buoc" data-dieu-kien="batBuoc">
                    <label>Tên sản phẩm</label>
                    <input type="text" name="tenSanPham" />
                </div>
                <div class="truong">
                    <label>Mô tả</label>
                    <textarea name="moTa"></textarea>
                </div>
                <div class="truong">
                    <label>Phân loại</label>
                    <select name="theLoai">
                        <option value="1">Phân loại 1</option>
                        <option value="2">Phân loại 2</option>
                    </select>
                </div>
                <div class="truong bat-buoc" data-dieu-kien="batBuoc khongAm">
                    <label>Giá sản phẩm</label>
                    <input type="number" step="any" name="gia" />
                </div>
                <div class="truong bat-buoc" data-dieu-kien="batBuoc khongAm">
                    <label>Số lượng</label>
                    <input type="number" name="soLuong" />
                </div>
                <div class="truong">
                    <label>Chất liệu</label>
                    <select name="chatLieu">
                        <option value="1">Inox</option>
                        <option value="2">Nhựa</option>
                    </select>
                </div>
                <div class="truong">
                    <label>Thương hiệu</label>
                    <select name="thuongHieu">
                        <option value="1">Không tên</option>
                        <option value="2">Mới nổi</option>
                    </select>
                </div>
                <div class="truong">
                    <label>Kích thước</label>
                    <input type="text" name="kichThuoc" />
                </div>
                <div class="truong" data-dieu-kien="khongAm">
                    <label>Trọng lượng</label>
                    <input type="number" step="any" name="trongLuong" />
                </div>
                <div class="truong">
                    <label>Ẩn</label>
                    <label>
                        <input type="checkbox" name="an" />
                        <span class="checkbox-tu-tao"></span>
                    </label>
                </div>
                <div class="hanh-dong">
                    <button class="nut kieu-1" type="submit">Lưu</button>
                </div>
            </form>
        </main>

        <script type="module" src="<%=request.getContextPath()%>/static/js/form.js"></script>
        <script type="module" src="<%=request.getContextPath()%>/static/js/form_san_pham.js"></script>
    </body>
</html>