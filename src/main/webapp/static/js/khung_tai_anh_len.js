const cacPhanTaiFile = Array.from(document.getElementsByClassName("tai-file-len"));

cacPhanTaiFile.forEach((phanTaiFile) => {
    let giaoDienTaiFile = phanTaiFile.querySelector(".giao-dien");
    let phanKetQua = phanTaiFile.querySelector(".ket-qua");
    let fileInput = phanTaiFile.querySelector("input[type='file']");

    giaoDienTaiFile.addEventListener("dragover", function (e) {
        giaoDienTaiFile.classList.add("dang-keo-file-vao");
    });
    giaoDienTaiFile.addEventListener("dragleave", function (e) {
        giaoDienTaiFile.classList.remove("dang-keo-file-vao");
    });
    giaoDienTaiFile.addEventListener("dragover", function (e) {
        e.preventDefault();
    });
    giaoDienTaiFile.addEventListener("drop", function (e) {
        e.preventDefault();
        giaoDienTaiFile.classList.remove("dang-keo-file-vao");
        fileInput.files = e.dataTransfer.files;
        fileInput.dispatchEvent(new Event("change"));
    });

    fileInput.addEventListener("change", function (e) {
    phanKetQua.innerHTML = "";
    for (let file of fileInput.files) {
        let theChuaAnh = document.createElement("div");
        theChuaAnh.classList.add("anh");
        let theAnh = document.createElement("img");
        theAnh.src = URL.createObjectURL(file);
        theChuaAnh.append(theAnh);
        theAnh.onload = function () {
            URL.revokeObjectURL(theAnh.src);
        };
        phanKetQua.appendChild(theChuaAnh);
    }
    });
});