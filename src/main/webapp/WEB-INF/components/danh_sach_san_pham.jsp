<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/danh_sach_san_pham.css" />

<ul class="toi-gian danh-sach-san-pham">
  <c:forEach var="sanPham" items="${danhSachSanPham}" >
    <li class="san-pham ${sanPham.soLuong == 0 ? 'het-hang' : ''}">
      <div class="anh-san-pham">
        <a href="<%=request.getContextPath()%>/san-pham/${sanPham.maSanPham}">
          <img class="anh" src="https://prestashop17.joommasters.com/yanka/34-home_default/printed-dress.jpg"  alt=""/>
        </a>E
      </div>
      <div class="chi-tiet">
        <a class="ten-danh-muc" href="<%=request.getContextPath()%>/the-loai/${sanPham.theLoai.maTheLoai}">${sanPham.theLoai.tenTheLoai}</a>
        <a class="ten-san-pham" href="<%=request.getContextPath()%>/san-pham/${sanPham.maSanPham}">${sanPham.tenSanPham}</a>
        <div class="hanh-dong">
          <form class="form-them-gio-hang" method="POST" action="<%=request.getContextPath()%>/them-vao-gio-hang">
            <input type="hidden" name="maSanPham" value="${sanPham.maSanPham}" />
            <button class="them-gio-hang">Thêm vào giỏ hàng</button>
          </form>
          <div class="gia">$${sanPham.gia}</div>
        </div>
      </div>
    </li>
  </c:forEach>
</ul>
