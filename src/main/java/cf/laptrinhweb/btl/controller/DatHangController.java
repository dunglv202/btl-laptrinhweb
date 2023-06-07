package cf.laptrinhweb.btl.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.laptrinhweb.btl.constant.HinhThucThanhToan;
import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.*;
import cf.laptrinhweb.btl.entity.SanPhamTrongGio;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;
import cf.laptrinhweb.btl.service.*;
import cf.laptrinhweb.btl.service.impl.*;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;

import java.io.IOException;
import java.util.List;
import java.util.*;

// TODO: Dung @WebServlet thay vi viet mapping trong file web.xml
@WebServlet("/dat-hang")
public class DatHangController extends HttpServlet {
	
	 private final DatHangService datHangService = new DatHangServiceImpl();
	 private final GioHangService gioHangService = new GioHangServiceImpl();
	 private final SanPhamService sanPhamService = new SanPhamServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tra ve giao dien trang dat hang la file dat_hang.jsp trong thu muc WEB-INF
        // TODO: truyen cac tham so cua gio hang, don hang giong nhu cach sau => xem cach lay ra bien trong file .jsp
    	yeuCauQuyen(req, List.of(QuyenNguoiDung.KHACH_HANG));

        NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(req);
        List<SanPhamTrongGio> listSP = gioHangService.layTatCaCuaNguoiDung(nguoiDung);
        req.setAttribute("danhSachSanPham", listSP);
        for(SanPhamTrongGio i : listSP) {
	        if( i.getSoLuong() > i.getSanPham().getSoLuong()) {
	    		req.setAttribute("Loi", "Luong mua nhieu hon so luong con lai");
	    		req.getRequestDispatcher("WEB-INF/gio_hang.jsp").forward(req, resp);
	    		return;
	    	}
        }
        req.getRequestDispatcher("WEB-INF/dat_hang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO:  xu ly phan dat hang => goi service de tao don hang
    	yeuCauQuyen(req, List.of(QuyenNguoiDung.KHACH_HANG));

        NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(req);
        List<SanPhamTrongGio> listSP = gioHangService.layTatCaCuaNguoiDung(nguoiDung);
        DatHang dathang = new DatHang();
        List<SanPhamDat> dsDat = new ArrayList<>();
        for(SanPhamTrongGio i : listSP) {
        	SanPhamDat tmp = new SanPhamDat();
        	tmp.setGia(i.getSanPham().getGia());
        	tmp.setSoLuong(i.getSoLuong());
        	tmp.setSanPham_id(i.getSanPham().getMaSanPham());
        	dsDat.add(tmp);
        }

        dathang.setDiaChiGiao(req.getParameter("diaChi"));
        dathang.setNguoiDung(nguoiDung);
        dathang.setTenNguoiNhan(req.getParameter("tenNguoiNhan"));
        dathang.setSdtNhan(req.getParameter("dienThoai"));
        dathang.setTinhTrang(1);
        long milis = System.currentTimeMillis();
        dathang.setNgayTaoDon(new Date(milis));
        dathang.setHinhThucThanhToan(req.getParameter("hinhThucThanhToan").equals("COD")? HinhThucThanhToan.THANH_TOAN_KHI_NHAN : HinhThucThanhToan.THE_NGAN_HANG);
        dathang.setPhuongThucVanChuyen(req.getParameter("phuongThucVanChuyen").equals("VN_POST") ? 1 : 2);
        
        for(SanPhamDat sp : dsDat) {
        	sp.setDatHang(dathang);
        	sanPhamService.giamSoLuong(sp.getSanPham_id(), sp.getSoLuong());
        }
        
        
        for(SanPhamTrongGio sp : listSP) {
        	gioHangService.xoaSanPham(sp.getMaMucGioHang(), nguoiDung.getMaNguoiDung());
        }
        
        datHangService.themDatHang(dathang, dsDat);
        System.out.print("thanh Cong");
        
        
        
        // dieu huong lai ve trang lich su don hang sau khi dat hang
        //resp.sendRedirect(req.getContextPath() + "/lich-su-mua-hang");
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


