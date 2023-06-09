const cacPhanNhieuBuoc = document.getElementsByClassName("nhieu-buoc");

Array.from(cacPhanNhieuBuoc).forEach((theNhieuBuoc) => {
  let cacBuoc = Array.from(theNhieuBuoc.querySelectorAll(".buoc"));

  cacBuoc.forEach((buoc) => {
    let tieuDe = buoc.querySelector(".tieu-de-buoc");
    let noiDung = buoc.querySelector(".noi-dung");

    if (buoc.classList.contains("hien-tai")) {
      noiDung.style.height = noiDung.scrollHeight + "px";
    } else {
      noiDung.style.height = "0px";
    }

    tieuDe.addEventListener("click", function () {
      if (buoc.classList.contains("hien-tai")) return;
      let buocHienTai = cacBuoc.find((b) => b.classList.contains("hien-tai"));
      buocHienTai.classList.remove("hien-tai");
      buocHienTai.querySelector(".noi-dung").style.height = "0px";

      buoc.classList.add("hien-tai");
      noiDung.style.height = noiDung.scrollHeight + "px";
    });
  });
});
