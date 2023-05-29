"use strict";
import { kiemTraForm } from "./form.js";

const formSanPham = document.getElementById("form-admin");
formSanPham.addEventListener("submit", function(e) {
    if (!kiemTraForm(formSanPham)) {
        e.preventDefault();
    }
})