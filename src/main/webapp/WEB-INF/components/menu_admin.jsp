<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/menu_admin.css" />

<nav>
  <ul id="menu">
    <li class="muc logo">
      <div class="hien-thi">
        <a href="lien-ket" class="lien-ket">
          <div class="anh">
            <img src="<%=request.getContextPath()%>/static/images/logo_trang.svg" />
          </div>
          <div class="ten-muc" style="display: none">
            <span>Trang chính</span>
          </div>
        </a>
      </div>
    </li>
    <li class="muc">
      <div class="hien-thi">
        <a href="lien-ket" class="lien-ket">
          <div class="anh">
            <img src="<%=request.getContextPath()%>/static/images/thong_ke.svg" />
          </div>
          <div class="ten-muc">
            <span>Dashboard</span>
          </div>
        </a>
      </div>
    </li>
    <li class="muc">
      <div class="hien-thi">
        <a href="lien-ket" class="lien-ket">
          <div class="anh">
            <img src="<%=request.getContextPath()%>/static/images/gio-hang-trang.svg" />
          </div>
          <div class="ten-muc">
            <span>Đơn hàng</span>
          </div>
        </a>
      </div>
    </li>
    <li class="muc co-menu-con">
      <div class="hien-thi">
        <div class="anh">
          <img src="<%=request.getContextPath()%>/static/images/khach_hang.svg" />
        </div>
        <div class="ten-muc">
          <span>Khách hàng</span>
        </div>
      </div>
      <ul class="menu-con">
        <li>
          <a href="#" class="lien-ket gach-chan mo-rong sang-phai">
            <span>Quản lý thông tin</span>
          </a>
        </li>
        <li>
          <a href="#" class="lien-ket gach-chan mo-rong sang-phai">
            <span>Đang hoạt động</span>
          </a>
        </li>
        <li>
          <a href="#" class="lien-ket gach-chan mo-rong sang-phai">
            <span>Đăng nhập với vai trò khách hàng</span>
          </a>
        </li>
      </ul>
    </li>
    <li class="muc co-menu-con">
      <div class="hien-thi">
        <div class="anh">
          <img src="<%=request.getContextPath()%>/static/images/san_pham.svg" />
        </div>
        <div class="ten-muc">
          <span>Danh mục</span>
        </div>
      </div>
      <ul class="menu-con">
        <li>
          <a href="#" class="lien-ket gach-chan mo-rong sang-phai">
            <span>Quản lý sản phẩm</span>
          </a>
        </li>
        <li>
          <a href="#" class="lien-ket gach-chan mo-rong sang-phai">
            <span>Quản lý phân loại</span>
          </a>
        </li>
      </ul>
    </li>
    <li class="muc hien-tai">
      <div class="hien-thi">
        <a href="lien-ket" class="lien-ket">
          <div class="anh">
            <img src="<%=request.getContextPath()%>/static/images/quan_ly_nguoi_dung.svg" />
          </div>
          <div class="ten-muc">
            <span>Quản lý người dùng</span>
          </div>
        </a>
      </div>
    </li>
    <li class="muc">
      <div class="hien-thi">
        <form action="<%=request.getContextPath()%>/dang-xuat" method="post">
          <button id="nut-dang-xuat" type="submit">
            <div class="anh">
              <img src="<%=request.getContextPath()%>/static/images/dang_xuat.svg" />
            </div>
            <div class="ten-muc">
              <span>Đăng xuất</span>
            </div>
          </button>
        </form>
      </div>
    </li>
  </ul>
</nav>

<script src="<%=request.getContextPath()%>/static/js/menu_admin.js"></script>
