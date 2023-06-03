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
        </style>
    </head>
    <body>
        <jsp:include page="components/header.jsp"/>
        <main>
            <div id="gio-hang">
                <ul class="toi-gian danh-sach-mat-hang">
                    <li class="mat-hang">
                        <div class="hanh-dong">
                            <form method="POST" action="<%=request.getContextPath()%>/gio-hang/xoa">
                                <input type="hidden" name="maSanPham" value="1"/>
                                <button type="submit" class="chuc-nang">
                                    <span>Xoá</span>
                                </button>
                            </form>
                        </div>
                        <div class="anh-san-pham">
                            <img src="https://prestashop17.joommasters.com/yanka/45-home_default/trainers-with-broguing-slogan.jpg" />
                        </div>
                        <div class="chi-tiet">
                            <h2 class="ten-san-pham">Trainers with broguing slogan</h2>
                            <div class="tien-te don-gia">100.000</div>
                            <div class="so-luong">
                                <button class="chuc-nang giam" tabindex="-1">-</button>
                                <input type="number" class="o-nhap-so-luong" value="1" />
                                <button class="chuc-nang tang" tabindex="-1">+</button>
                            </div>
                            <div class="tien-te tong-tien">100.000</div>
                        </div>
                    </li>
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