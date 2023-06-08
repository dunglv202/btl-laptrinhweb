<%@ page import="cf.laptrinhweb.btl.helper.HoTroRequest" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%HoTroRequest.khongCachePage(response);%>

<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Title</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bang.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/quan_ly_don_hang.css">
    </head>
    <body>
    	<jsp:include page="components/header.jsp"/>
    
<%--         <jsp:include page="components/menu_admin.jsp"> --%>
<%--             <jsp:param name="mucHienTai" value="nguoi-dung"/> --%>
<%--         </jsp:include> --%>

        <main>
            <h1 class="tieu-de-trang">
                Lịch sử mua hàng
            </h1>
<!--             <div class="bang-admin"> -->
<!--                 <div class="tuong-tac-bang"> -->
<!--                     <form class="tieu-chuan loc-du-lieu"> -->
<!--                         <div class="bo-loc"> -->
<!--                             <div class="truong"> -->
<!--                                 <div class="tim-kiem"> -->
<%--                                     <input class="o-tim-kiem" name="tuKhoa" value="${param.get("tuKhoa")}" placeholder="Từ khoá" /> --%>
<!--                                     <button class="nut kieu-1">Tìm kiếm</button> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
              <div class="phan-trang">
                  Trang
                  <input type="number" name="trang" value="${param.get("trang") != null ? param.get("trang") : 1}" min="0" />
                  của
                  <span class="tong-so-trang">10</span>
              </div>
<!--                     </form> -->
<!--                 </div> -->
                <table class="bang">
                    <thead>
                    <tr>
                        <th>Mã đơn hàng</th>
                        <th>Sản phẩm</th>
                        <th>Tổng tiền</th>
                        <th>Ngày tạo đơn</th>
                        <th>Chi tiết</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="donhang" items="${danhSachDonHang}">
                        <tr>
                            <td>${donhang.maDatHang}</td>
                            <td>
                                <ul class="toi-gian">
                                    <c:forEach var="sanpham" items="${donhang.danhSachSanPham}">
                                        <li>${sanpham.sanPham.tenSanPham} x ${sanpham.soLuong}</li>
                                    </c:forEach>
                                </ul>
                            </td>
                            <td>${donhang.tongTien}</td>
                            <td>
                                <fmt:formatDate value="${donhang.ngayTaoDon}" pattern="dd-MM-yyyy" />
                            </td>
                            <td class="hanh-dong">
                                <div class="danh-sach" style="height: 0 ;margin : 0">
                                    <form method="GET" action="<%=request.getContextPath()%>/don-hang/chi-tiet">
                                        <input type="hidden" name="maDatHang" value="${donhang.maDatHang}" />
                                        <input type="hidden" name="nguoiDung" value="${nguoiDung.maNguoiDung}" />
                                        <input type = "submit" value = "Chi Tiết"/>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
        
        <jsp:include page="components/chan_trang.jsp"/>

        <script>
            let nutChonHanhDong = document.querySelectorAll(".bang-admin .hanh-dong .chon-hanh-dong");
            Array.from(nutChonHanhDong).forEach(nut => {
                nut.addEventListener("click", function() {
                    nut.classList.toggle("da-click");
                    if (nut.classList.contains("da-click")) {
                        nut.nextElementSibling.style.height = nut.nextElementSibling.scrollHeight + "px";
                    } else {
                        nut.nextElementSibling.style.height = "0px";
                    }
                });
            })
        </script>
    </body>
</html>
