package cf.laptrinhweb.btl.controller.donhang;

import javax.servlet.ServletException;
import cf.laptrinhweb.btl.service.*;
import cf.laptrinhweb.btl.service.impl.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;

import java.io.IOException;

@WebServlet("/don-hang/chi-tiet")
public class ChiTietDonHangController extends HttpServlet {
	private DatHangService datHangSevice = new DatHangServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	yeuCauQuyen(req, List.of(QuyenNguoiDung.KHACH_HANG));

        NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(req);
    	List<SanPhamDat> listSP = datHangSevice.layDonTheoMa(Long.valueOf(req.getParameter("maDatHang")), nguoiDung);
    	req.setAttribute("datHang", listSP.get(0).getDatHang());
    	req.setAttribute("danhSachSanPham", listSP);
        req.getRequestDispatcher("/WEB-INF/chi_tiet_don_hang.jsp").forward(req, resp);
    }
}
