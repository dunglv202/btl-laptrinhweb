<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/danh_sach_the_loai.css" />

<div class="danh-sach-the-loai">
  <ul class="toi-gian">
    <c:forEach var="theLoai" items="${danhSachTheLoai}">
      <li class="the-loai">
        <div class="anh-the-loai">
          <img src="https://cdn.shopify.com/s/files/1/0062/5642/7093/files/demo03_02_800x.jpg" />
        </div>
        <div class="ten-the-loai">
          <a href="<%=request.getContextPath()%>/the-loai/${theLoai.maTheLoai}" class="lien-ket ten">
            <span>${theLoai.tenTheLoai}</span>
          </a>
        </div>
      </li>
    </c:forEach>
  </ul>
</div>
