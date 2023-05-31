<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/slide.css" />

<div class="khung-chua-slide">
  <div class="slide hien-tai">
    <div class="anh-nen">
      <img
        src="https://images.pexels.com/photos/2325446/pexels-photo-2325446.jpeg?auto=compress&cs=tinysrgb&w=1600"
      />
    </div>
    <div class="noi-dung truot-sang-trai">
      <h2>Tiêu đề</h2>
      <p>Một vài dòng mô tả cho slide</p>
      <div class="hanh-dong">
        <a class="nut kieu-1">Khám phá ngay</a>
      </div>
    </div>
  </div>
  <div class="slide">
    <div class="anh-nen">
      <img
        src="https://images.pexels.com/photos/2356045/pexels-photo-2356045.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
      />
    </div>
    <div class="noi-dung truot-len">
      <h2>Khác</h2>
      <p>Không có mô tả gì</p>
      <div class="hanh-dong">
        <a class="nut kieu-1">Khám phá ngay</a>
      </div>
    </div>
  </div>
  <div class="slide">
    <div class="anh-nen">
      <img
        src="https://images.pexels.com/photos/8797307/pexels-photo-8797307.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
      />
    </div>
    <div class="noi-dung truot-xuong">
      <h2>Slide cuối</h2>
      <p>Chưa nghĩ ra mô tả</p>
      <div class="hanh-dong">
        <a class="nut kieu-1">Khám phá ngay</a>
      </div>
    </div>
  </div>

  <div class="thanh-trang-thai">
    <div class="trang-thai hien-tai"></div>
    <div class="trang-thai"></div>
    <div class="trang-thai"></div>
  </div>
</div>

<script src="<%=request.getContextPath()%>/static/js/slide.js"></script>