<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Title</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/gio_hang.css">
        <style>
            main {
                padding: 0 var(--le-trang);
            }
            #gio-hang .ten-san-pham a {
                text-decoration: none;
                color: initial;
            }
            #gio-hang .ten-san-pham a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <jsp:include page="components/header.jsp"/>
        <main>
            <div id="gio-hang">
                <ul class="toi-gian danh-sach-mat-hang">
                    <c:forEach var="item" items="${danhSachSanPham}">
                        <li class="mat-hang">
                            <div class="hanh-dong">
                                <form method="POST" action="<%=request.getContextPath()%>/gio-hang/xoa">
                                    <input type="hidden" name="maSanPham" value="${item.sanPham.maSanPham}"/>
                                    <button type="submit" class="chuc-nang">
                                        <span>Xoá</span>
                                    </button>
                                </form>
                            </div>
                            <div class="anh-san-pham">
                                <img src="${(item.sanPham.anhXemTruoc == null) ? "/public/anh-trong.jpg" : item.sanPham.anhXemTruoc}" />
                            </div>
                            <div class="chi-tiet">
                                <h2 class="ten-san-pham">
                                    <a href="<%=request.getContextPath()%>/san-pham?maSanPham=${item.sanPham.maSanPham}">
                                        ${item.sanPham.tenSanPham}
                                    </a>
                                </h2>
                                <div class="tien-te don-gia">${item.sanPham.gia}</div>
                                <div class="so-luong">
                                    <button class="chuc-nang giam" tabindex="-1">-</button>
                                    <input type="number" class="o-nhap-so-luong" value="${item.soLuong}" />
                                    <button class="chuc-nang tang" tabindex="-1">+</button>
                                </div>
                                <div class="tien-te tong-tien">${item.sanPham.gia * item.soLuong}</div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div>
                    <a href="#" class="lien-ket gach-chan mo-rong mua-sam-them">
                        <div class="hinh">
                            <img src="<%=request.getContextPath()%>/static/images/mui_ten.svg" />
                        </div>
                        <span>Tiếp tục mua sắm </span>
                    </a>
                </div>
                <div class="tong-quan">
                    <div class="muc">
                        <span>2 mặt hàng</span>
                        <span>200.000</span>
                    </div>
                    <div class="muc">
                        <span>Phí vận chuyển</span>
                        <span>Miễn phí</span>
                    </div>
                    <hr />
                    <a href="/dat-hang" class="nut kieu-1"> Đặt hàng </a>
                </div>
            </div>
        </main>
        <jsp:include page="components/chan_trang.jsp"/>

        <script src="<%=request.getContextPath()%>/static/js/gio_hang.js"></script>
    </body>
</html>