<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="cf.laptrinhweb.btl.entity.SanPhamTrongGio" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
        
     <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
     <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/dat-hang.css">
  </head>
  <body>
    <form id="thong-tin-dat-hang">
      <div class="nhieu-buoc thiet-lap-don-hang">
        <div class="buoc hien-tai thong-tin-nguoi-nhan">
          <h2 class="tieu-de-buoc">Thông tin người nhận</h2>
          <div class="noi-dung">
            <div class="truong">
              <label>Tên người nhận</label>
              <input type="text" name="tenNguoiNhan" autofocus />
            </div>
            <div class="truong">
              <label>Địa chỉ</label>
              <input type="text" name="diaChi" />
            </div>
            <div class="truong">
              <label>Số điện thoại</label>
              <input type="text" name="dienThoai" />
            </div>
          </div>
        </div>
        <div class="buoc van-chuyen">
          <h2 class="tieu-de-buoc">Phương thức vận chuyển</h2>
          <div class="noi-dung">
            <div class="box-chua">
              <label class="lua-chon">
                <input type="radio" name="phuongThucVanChuyen" value="VN_POST" checked />
                <div class="noi-dung-lua-chon">
                  <img src="http://www.vnpost.vn/Portals/0/anh%20tin%20tuc/Logo%20VietNam%20Post.jpg" />
                </div>
              </label>
              <label class="lua-chon">
                <input type="radio" name="phuongThucVanChuyen" value="VIETTEL_POST" />
                <div class="noi-dung-lua-chon">
                  <img src="https://upload.wikimedia.org/wikipedia/commons/8/80/Viettel_Post_logo.svg" />
                </div>
              </label>
              <label class="lua-chon">
                <input type="radio" name="phuongThucVanChuyen" value="GIAO_HANG_NHANH" />
                <div class="noi-dung-lua-chon">
                  <img src="https://theme.hstatic.net/200000472237/1000829412/14/logo-footer.png?v=633" />
                </div>
              </label>
            </div>
          </div>
        </div>
        <div class="buoc thanh-toan">
          <h2 class="tieu-de-buoc">Hình thức thanh toán</h2>
          <div class="noi-dung">
            <div class="box-chua">
              <label class="lua-chon">
                <input type="radio" name="hinhThucThanhToan" value="COD" checked />
                <div class="noi-dung-lua-chon">
                  <div class="radio-tuy-chinh"></div>
                  <span>Nhận tiền khi giao hàng</span>
                </div>
              </label>
              <label class="lua-chon">
                <input type="radio" name="hinhThucThanhToan" value="TAI_KHOAN_NGAN_HANG" />
                <div class="noi-dung-lua-chon">
                  <div class="radio-tuy-chinh"></div>
                  <div class="qua-tai-khoan-ngan-hang">
                    <span>Chuyển qua tài khoản ngân hàng</span>
                    <ul class="toi-gian ngan-hang-ho-tro">
                      <li class="ngan-hang">
                        <img
                          src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Vietcombank_logo_fixed.svg/1200px-Vietcombank_logo_fixed.svg.png"
                          alt="Vietcombank"
                        />
                      </li>
                      <li class="ngan-hang">
                        <img
                          src="https://upload.wikimedia.org/wikipedia/commons/7/7c/Techcombank_logo.png"
                          alt="Techcombank"
                        />
                      </li>
                      <li class="ngan-hang">
                        <img
                          src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Logo_TPBank.svg/2560px-Logo_TPBank.svg.png"
                          alt="TPBank"
                        />
                      </li>
                    </ul>
                  </div>
                </div>
              </label>
            </div>
          </div>
        </div>
      </div>
      <hr class="man-dien-thoai" />
      <div class="thong-tin-gio-hang">
        <h2 style="margin-top: 0">Danh sách sản phẩm</h2>     
        <c:forEach var = "item" items = "${danhSachSanPham}">  
	        <ul class="toi-gian danh-sach-mat-hang">
	          <li class="mat-hang">
	            <div class="anh-san-pham">
	              <img src="${(item.sanPham.anhXemTruoc == null) ? "/public/anh-trong.jpg" : item.sanPham.anhXemTruoc}"/>
	            </div>
	            <div class="chi-tiet-hang">${item.sanPham.tenSanPham}</div>
	          </li>
	        </ul>
        </c:forEach>
		<% 
            List<SanPhamTrongGio> ls = (List<SanPhamTrongGio>)request.getAttribute("danhSachSanPham");
        	int tong = 0;
        	for(SanPhamTrongGio i : ls) {
        		tong += i.getSoLuong() * i.getSanPham().getGia();
        	}       	
        %>
        <div class="so-luoc-don-hang">
          <div class="muc tong-tien-hang">
            <h2 class="ten-muc">Tổng</h2>
            
            <span class="tien-te"><%=tong%></span>
          </div>
          <div class="muc phi-van-chuyen">
            <h2 class="ten-muc">Vận chuyển</h2>
            <span>Miễn phí</span>
          </div>
        </div>
        <button type="submit" class="nut kieu-1">Đặt hàng</button>
      </div>
    </form>

    <script src="nhieu-buoc.js"></script>
  </body>
</html>
