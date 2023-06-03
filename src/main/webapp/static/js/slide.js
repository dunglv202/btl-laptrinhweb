const THOI_GIAN_CHUYEN_SLIDE = 3000;

const khungSlide = document.querySelector(".khung-chua-slide");
const dsSlide = Array.from(khungSlide.querySelectorAll(".slide"));
const dsNutChuyenSlide = Array.from(khungSlide.querySelectorAll(".trang-thai"));

let soThuTuSlideHienTai = 0;
let chuTrinhChuyenSlide = setInterval(toiSlideTiep, THOI_GIAN_CHUYEN_SLIDE);

dsNutChuyenSlide.forEach((nut, soThuTu) => {
  nut.addEventListener("click", function () {
    chuyenSlide(soThuTu);
    clearInterval(chuTrinhChuyenSlide);
    chuTrinhChuyenSlide = setInterval(toiSlideTiep, THOI_GIAN_CHUYEN_SLIDE);
  });
});

function chuyenSlide(soThuTu) {
  dsNutChuyenSlide.forEach((n) => n.classList.remove("hien-tai"));
  dsNutChuyenSlide[soThuTu].classList.add("hien-tai");
  dsSlide.forEach((s) => {
    s.classList.remove("truoc");
    if (s.classList.contains("hien-tai")) {
      s.classList.add("truoc");
      s.classList.remove("hien-tai");
    }
  });
  dsSlide[soThuTu].classList.add("hien-tai");
}

function toiSlideTiep() {
  soThuTuSlideHienTai = (soThuTuSlideHienTai + 1) % dsSlide.length;
  chuyenSlide(soThuTuSlideHienTai);
}
