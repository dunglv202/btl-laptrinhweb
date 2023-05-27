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
          <div class="danh-sach-anh">
            <ul class="danh-sach toi-gian">
              <li class="anh hien-tai">
                <img src="https://prestashop17.joommasters.com/yanka/34-large_default/printed-dress.jpg" />
              </li>
              <li class="anh">
                <img src="https://prestashop17.joommasters.com/yanka/37-large_default/printed-dress.jpg" />
              </li>
              <li class="anh">
                <img src="https://prestashop17.joommasters.com/yanka/36-large_default/printed-dress.jpg" />
              </li>
            </ul>
          </div>
          <div id="anh-hien-thi" class="anh-hien-thi">
            <img src="https://prestashop17.joommasters.com/yanka/34-large_default/printed-dress.jpg" />
          </div>
        </div>
        <div class="chi-tiet-san-pham">
          <div class="noi-dung-co-ban">
            <h1 class="ten-san-pham">Tên sản phẩm</h1>
            <div class="gia">
              <span class="tien-te">50,000</span>
            </div>
            <table class="cac-thuoc-tinh">
              <tr>
                <th>Tên thuộc tính</th>
                <td>Giá trị thuộc tính</td>
              </tr>
            </table>
          </div>
          <div class="hanh-dong">
            <form class="them-vao-gio-hang" action="<%=request.getContextPath()%>/them-vao-gio-hang" method="POST">
              <input type="hidden" name="maSanPham" value="1" />
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
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corporis eligendi cumque nisi voluptate
                  fugiat vel laboriosam, optio eos? Magnam, quibusdam.
                </div>
              </div>
            </div>
            <div class="phan">
              <h2 class="tieu-de">Đánh giá</h2>
              <div class="noi-dung">
                <div>
                  <ul class="toi-gian cac-danh-gia">
                    <li class="muc-danh-gia">
                      <div class="diem-danh-gia">
                        <jsp:include page="components/danh_gia_sao.jsp">
                          <jsp:param name="saoDanhGia" value="5"/>
                        </jsp:include>
                      </div>
                      <div class="thong-tin-danh-gia">
                        <span class="ten-nguoi-danh-gia"> DungLV </span>
                        <span> vào </span>
                        <span class="thoi-gian-danh-gia"> 11 Tháng 3, 2022 </span>
                      </div>
                      <p class="noi-dung">
                        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Blanditiis earum mollitia facere qui
                        velit ullam rem voluptas quas officiis excepturi.
                      </p>
                    </li>
                    <li class="muc-danh-gia">
                      <div class="diem-danh-gia">
                        <jsp:include page="components/danh_gia_sao.jsp">
                          <jsp:param name="saoDanhGia" value="2"/>
                        </jsp:include>
                      </div>
                      <div class="thong-tin-danh-gia">
                        <span class="ten-nguoi-danh-gia"> DungLV </span>
                        <span> vào </span>
                        <span class="thoi-gian-danh-gia"> 11 Tháng 3, 2022 </span>
                      </div>
                      <p class="noi-dung">
                      </p>
                    </li>
                    <li class="muc-danh-gia">
                      <div class="diem-danh-gia">
                        <jsp:include page="components/danh_gia_sao.jsp">
                          <jsp:param name="saoDanhGia" value="3"/>
                        </jsp:include>
                      </div>
                      <div class="thong-tin-danh-gia">
                        <span class="ten-nguoi-danh-gia"> DungLV </span>
                        <span> vào </span>
                        <span class="thoi-gian-danh-gia"> 11 Tháng 3, 2022 </span>
                      </div>
                      <p class="noi-dung">
                      </p>
                    </li>
                    <li class="muc-danh-gia">
                      <div class="diem-danh-gia">
                        <jsp:include page="components/danh_gia_sao.jsp">
                          <jsp:param name="saoDanhGia" value="4"/>
                        </jsp:include>
                      </div>
                      <div class="thong-tin-danh-gia">
                        <span class="ten-nguoi-danh-gia"> DungLV </span>
                        <span> vào </span>
                        <span class="thoi-gian-danh-gia"> 11 Tháng 3, 2022 </span>
                      </div>
                      <p class="noi-dung">
                        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Blanditiis earum mollitia facere qui
                        velit ullam rem voluptas quas officiis excepturi.
                      </p>
                    </li>
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
