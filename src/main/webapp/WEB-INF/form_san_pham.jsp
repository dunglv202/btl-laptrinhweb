<%@ page import="cf.laptrinhweb.btl.helper.HoTroRequest" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% HoTroRequest.khongCachePage(response); %>

<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Title</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/trang_admin.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/form_admin.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/form_san_pham.css">
    </head>
    <body>
        <jsp:include page="components/menu_admin.jsp">
            <jsp:param name="mucHienTai" value="danh-muc"/>
        </jsp:include>

        <main>
            <h1 class="tieu-de-trang">
                Thêm mới sản phẩm
            </h1>
            <form id="form-san-pham" class="tieu-chuan form-admin" method="POST" enctype="multipart/form-data">
                <div class="truong">
                    <label>Ảnh sản phẩm</label>
                    <jsp:include page="components/khung_tai_anh_len.jsp">
                        <jsp:param name="tenTruongAnh" value="anh" />
                    </jsp:include>
                </div>
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
                        <c:forEach var="theLoai" items="${danhSachTheLoai}">
                            <option value="${theLoai.maTheLoai}">
                                ${theLoai.tenTheLoai}
                            </option>
                        </c:forEach>
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
                        <c:forEach var="chatLieu" items="${danhSachChatLieu}">
                            <option value="${chatLieu.maChatLieu}">
                                    ${chatLieu.tenChatLieu}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="truong">
                    <label>Thương hiệu</label>
                    <select name="thuongHieu">
                        <c:forEach var="thuongHieu" items="${danhSachThuongHieu}">
                            <option value="${thuongHieu.maThuongHieu}">
                                ${thuongHieu.tenThuongHieu}
                            </option>
                        </c:forEach>
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