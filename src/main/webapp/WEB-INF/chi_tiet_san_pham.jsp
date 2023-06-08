<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chi_tiet_san_pham.css">
  </head>
  <body>
    <jsp:include page="components/header.jsp"/>
    <main>
      <div id="chi-tiet-san-pham">
        <div class="anh-san-pham">
          <c:if test="${!sanPham.danhSachAnh.isEmpty()}">
            <div class="danh-sach-anh">
              <ul class="danh-sach toi-gian">
                <c:forEach var="anh" items="${sanPham.danhSachAnh}">
                  <li class="anh">
                    <img src="${anh.duongDan}" />
                  </li>
                </c:forEach>
              </ul>
            </div>
          </c:if>
          <div id="anh-hien-thi" class="anh-hien-thi">
            <img src="${(sanPham.anhXemTruoc == null) ? "/public/anh-trong.jpg" : sanPham.anhXemTruoc}" />
          </div>
        </div>
        <div class="chi-tiet-san-pham">
          <div class="noi-dung-co-ban">
            <h1 class="ten-san-pham">${sanPham.tenSanPham}</h1>
            <div class="gia">
              <span class="tien-te">${sanPham.gia}</span>
            </div>
            <table class="cac-thuoc-tinh">
              <tr>
                <th>Chất liệu</th>
                <td>${sanPham.chatLieu.tenChatLieu}</td>
              </tr>
              <tr>
                <th>Thương hiệu</th>
                <td>${sanPham.thuongHieu.tenThuongHieu}</td>
              </tr>
              <c:if test="${sanPham.kichThuoc != null}">
                <tr>
                  <th>Kích thước</th>
                  <td>${sanPham.kichThuoc}</td>
                </tr>
              </c:if>
              <c:if test="${sanPham.trongLuong != null}">
                <tr>
                  <th>Trọng lượng</th>
                  <td>${sanPham.trongLuong} gr</td>
                </tr>
              </c:if>
            </table>
          </div>
          <div class="hanh-dong">
            <form class="them-vao-gio-hang" action="<%=request.getContextPath()%>/gio-hang/them" method="POST">
              <input type="hidden" name="maSanPham" value="${sanPham.maSanPham}" />
              <div class="thay-doi-so-luong">
                <button type="button" class="giam">-</button>
                <input class="so-luong" name="soLuong" value="1" />
                <button type="button" class="tang">+</button>
              </div>
              <button id="nut-them-vao-gio-hang" class="nut kieu-1" type="submit">
                <span>Thêm vào giỏ</span>
              </button>
            </form>
          </div>
          <div class="chi-tiet">
            <div class="phan mo-ta-san-pham">
              <h2 class="tieu-de">Mô tả sản phẩm</h2>
              <div class="noi-dung">
                <div>
                  ${sanPham.moTa}
                </div>
              </div>
            </div>
            <div class="phan">
              <h2 class="tieu-de">Đánh giá</h2>
              <div class="noi-dung">
                <div>
                  <ul class="toi-gian cac-danh-gia">
                    <jsp:include page="components/danh_gia.jsp">
                      <jsp:param name="tenNguoiDanhGia" value="Lưu Văn Dũng"/>
                      <jsp:param name="thoiGian" value="2023/05/06"/>
                      <jsp:param name="noiDung" value="Không có gì cả nhé"/>
                      <jsp:param name="diemSoDanhGia" value="5"/>
                    </jsp:include>
                    <jsp:include page="components/danh_gia.jsp">
                      <jsp:param name="tenNguoiDanhGia" value="Lưu Văn Dũng"/>
                      <jsp:param name="thoiGian" value="2023/05/06"/>
                      <jsp:param name="noiDung" value="Lorem ipsum dolor sit amet consectetur, adipisicing elit. Adipisci omnis velit itaque minus quas debitis. Soluta exercitationem iusto illo sint ratione quam excepturi laborum odio doloribus. Eligendi magnam sequi velit!"/>
                      <jsp:param name="diemSoDanhGia" value="3"/>
                    </jsp:include>
                    <jsp:include page="components/danh_gia.jsp">
                      <jsp:param name="tenNguoiDanhGia" value="Lưu Văn Dũng"/>
                      <jsp:param name="thoiGian" value="2023/05/06"/>
                      <jsp:param name="diemSoDanhGia" value="4"/>
                    </jsp:include>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div id="san-pham-lien-quan">
        <%request.setAttribute("danhSachSanPham", request.getAttribute("sanPhamLienQuan"));%>
        <jsp:include page="components/danh_sach_san_pham.jsp"/>
      </div>
    </main>
    <jsp:include page="components/chan_trang.jsp"/>

    <script src="<%=request.getContextPath()%>/static/js/chi_tiet_san_pham.js"></script>
  </body>
</html>
