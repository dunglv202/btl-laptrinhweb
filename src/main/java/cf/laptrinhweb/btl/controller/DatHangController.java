package cf.laptrinhweb.btl.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPhamTrongGio;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;
import cf.laptrinhweb.btl.service.GioHangService;
import cf.laptrinhweb.btl.service.impl.GioHangServiceImpl;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;

import java.io.IOException;
import java.util.List;

// TODO: Dung @WebServlet thay vi viet mapping trong file web.xml
@WebServlet("/dat-hang")
public class DatHangController extends HttpServlet {
	
	 private final GioHangService gioHangService = new GioHangServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tra ve giao dien trang dat hang la file dat_hang.jsp trong thu muc WEB-INF
        // TODO: truyen cac tham so cua gio hang, don hang giong nhu cach sau => xem cach lay ra bien trong file .jsp
    	yeuCauQuyen(req, List.of(QuyenNguoiDung.KHACH_HANG));

        NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(req);
        List<SanPhamTrongGio> listSP = gioHangService.layTatCaCuaNguoiDung(nguoiDung);
        req.setAttribute("danhSachSanPham", listSP);
        req.getRequestDispatcher("WEB-INF/dat_hang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO:  xu ly phan dat hang => goi service de tao don hang

        // dieu huong lai ve trang lich su don hang sau khi dat hang
        resp.sendRedirect(req.getContextPath() + "/lich-su-mua-hang");
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


