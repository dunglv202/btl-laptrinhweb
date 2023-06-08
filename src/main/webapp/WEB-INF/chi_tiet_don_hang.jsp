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
          <span>Lưu Văn Dũng</span>
        </div>
        <div class="truong">
          <label>Số điện thoại</label>
          <span>+84 123 45 6789</span>
        </div>
        <div class="truong">
          <label>Địa chỉ</label>
          <span>Địa chỉ</span>
        </div>
        <div class="truong">
          <label>Phương thức vận chuyển</label>
          <span>Vietnam Post</span>
        </div>
        <div class="truong">
          <label>Hình thức thanh toán</label>
          <span>Thanh toán khi nhận hàng</span>
        </div>
      </div>

      <ul id="danh-sach-hang-dat" class="toi-gian">
        <li class="hang-dat">
          <div class="chi-tiet-hang-dat">
            <div class="anh">
              <img src="https://cdn.shopify.com/s/files/1/0062/5642/7093/files/demo03_02_800x.jpg" />
            </div>
            <div class="chi-tiet">
              <div class="ten-san-pham">
                <a href="#" class="lien-ket">Sản phẩm mới</a>
              </div>
              <div class="so-luong">2</div>
              <div class="thanh-tien tien-te">100000</div>
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
      </ul>
    </main>

    <jsp:include page="components/chan_trang.jsp"/>

    <script src="<%=request.getContextPath()%>/static/js/danh_gia.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/sao.js"></script>
  </body>
</html>