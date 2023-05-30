"use strict";
import { kiemTraForm } from "./form.js";

const formSanPham = document.getElementById("form-san-pham");
formSanPham.addEventListener("submit", function(e) {
    if (!kiemTraForm(formSanPham)) {
        e.preventDefault();
    }
})