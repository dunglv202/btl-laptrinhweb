<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<%@page import="cf.laptrinhweb.btl.entity.DatHang" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/sao.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chi_tiet_don_hang.css">
  </head>
  <body>
    <jsp:include page="components/header.jsp"/>

    <main>
      <h1 id="tieu-de-trang">Chi tiết đơn hàng <span class="ma-don-hang">01</span></h1>

      <div id="thong-tin-don-hang">
        <div class="truong">
          <label>Tên người nhận</label>
          <span>${datHang.tenNguoiNhan}</span>
        </div>
        <div class="truong">
          <label>Số điện thoại</label>
          <span>${datHang.sdtNhan}</span>
        </div>
        <div class="truong">
          <label>Địa chỉ</label>
          <span>${datHang.diaChiGiao }</span>
        </div>
        <div class="truong">
          <label>Phương thức vận chuyển</label>
          <%
          String ptvc = "";
          if (((DatHang)request.getAttribute("datHang")).getPhuongThucVanChuyen() == 1)
        	  ptvc = "VIETNAM_POST";
          else if(((DatHang)request.getAttribute("datHang")).getPhuongThucVanChuyen() == 2)
        	  ptvc = "VIETTEL_POST";
          else
        	  ptvc = "GIAO_HANG_NHANH";
          %>
          <span><%=ptvc %></span>
        </div>
        <div class="truong">
          <label>Hình thức thanh toán</label>
          <span>${datHang.hinhThucThanhToan}</span>
        </div>
      </div>

      <ul id="danh-sach-hang-dat" class="toi-gian">
      	<c:forEach var = "sanpham" items = "${danhSachSanPham}">
        <li class="hang-dat">
          <div class="chi-tiet-hang-dat">
            <div class="anh">
              <img src="${(sanpham.sanPham.anhXemTruoc == null) ? "/public/anh-trong.jpg" : sanpham.sanPham.anhXemTruoc}" />
            </div>
            <div class="chi-tiet">
              <div class="ten-san-pham">
                <a href="<%=request.getContextPath()%>/san-pham?maSanPham=${sanpham.sanPham.maSanPham}" class="lien-ket">${sanpham.sanPham.tenSanPham }</a>
              </div>
              <div class="so-luong">${sanpham.soLuong}</div>
              <div class="thanh-tien tien-te">${sanpham.gia}</div>
            </div>
          </div>
          <form class="form-danh-gia" method="post" action="/danh-gia">
            <input type="hidden" name="maSanPhamMua" value="1" />
            <div class="diem-danh-gia">
              <span>Đánh giá: </span>
              <div class="danh-gia-sao danh-gia-cua-toi chua-danh-gia"></div>
            </div>
            <div class="binh-luan">
              <textarea name="binhLuan" placeholder="Bạn nghĩ sao về sản phẩm này?"></textarea>
            </div>
            <div class="hanh-dong">
              <button type="submit" class="nut kieu-1 nut-danh-gia" disabled>Xác nhận</button>
            </div>
          </form>
        </li>
        </c:forEach>
      </ul>
    </main>

    <jsp:include page="components/chan_trang.jsp"/>

    <script src="<%=request.getContextPath()%>/static/js/danh_gia.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/sao.js"></script>
  </body>
</html>