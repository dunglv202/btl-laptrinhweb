<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/trang_admin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bang.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/dashboard.css"/>
  </head>
  <body>
    <jsp:include page="components/menu_admin.jsp">
      <jsp:param name="mucHienTai" value="dashboard"/>
    </jsp:include>
    <main>
      <h1 style="text-align: center">Thống kê trong 30 ngày gần nhất</h1>
      <% request.setAttribute("danhSachDuLieu", request.getAttribute("doanhThuThang")); %>
      <div id="thong-ke-30-ngay-gan-nhat">
        <jsp:include page="components/bieu_do.jsp">
          <jsp:param name="idBieuDo" value="bieu-do-doanh-thu-30-ngay"/>
        </jsp:include>
        <div class="thong-ke">
          <div>
            <h2 class="tieu-de">Tổng doanh thu</h2>
            <div class="gia-tri tien-te">100000</div>
          </div>
          <div>
            <h2 class="tieu-de">Giá trị trung bình đơn hàng</h2>
            <div class="gia-tri tien-te">1000</div>
          </div>
          <div>
            <h2 class="tieu-de">Tỉ lệ huỷ đơn</h2>
            <div class="gia-tri">5%</div>
          </div>
        </div>
      </div>
      <hr/>

      <%-- THONG KE SAN PHAM --%>
      <div id="thong-ke-khac">
        <div class="phan-thong-ke">
          <h2 class="tieu-de-bang">Sản phẩm xem nhiều</h2>
          <div class="bang-admin">
            <table class="bang">
              <thead>
              <tr>
                <th>STT</th>
                <th>Tên sản phẩm</th>
                <th>Lượt xem</th>
              </tr>
              </thead>
              <tbody>
              <%--            <c:forEach var="nguoiDung" items="${danhSachNguoiDung}">--%>
              <tr>
                <td>1</td>
                <td>
                  <a href="<%=request.getContextPath()%>/san-pham?maSanPham=1}">
                    Tên sản phẩm
                  </a>
                </td>
                <td>251</td>
              </tr>
              <%--            </c:forEach>--%>
              </tbody>
            </table>
          </div>
        </div>
        <div class="phan-thong-ke">
          <h2 class="tieu-de-bang">Top bán chạy</h2>
          <div class="bang-admin">
            <table class="bang">
              <thead>
              <tr>
                <th>STT</th>
                <th>Tên sản phẩm</th>
                <th>Số lượng đã bán</th>
              </tr>
              </thead>
              <tbody>
              <%--            <c:forEach var="nguoiDung" items="${danhSachNguoiDung}">--%>
              <tr>
                <td>1</td>
                <td>
                  <a href="<%=request.getContextPath()%>/san-pham?maSanPham=1}">
                    Tên sản phẩm
                  </a>
                </td>
                <td>251</td>
              </tr>
              <%--            </c:forEach>--%>
              </tbody>
            </table>
          </div>
        </div>
        </div>
      </div>
    </main>
  </body>
</html>
