package cf.laptrinhweb.btl.controller;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;
import java.util.ArrayList;

import java.io.IOException;
import java.util.List;

import cf.laptrinhweb.btl.service.*;
import cf.laptrinhweb.btl.service.impl.*;
import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.*;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.laptrinhweb.btl.service.impl.SanPhamServiceImpl;

/**
 * Servlet implementation class LichSuMuaHang
 */
@WebServlet("/lich-su-mua-hang")
public class LichSuMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final SanPhamDatService sanPhamDatService = new SanPhamDatServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		yeuCauQuyen(request, List.of(QuyenNguoiDung.KHACH_HANG));

        NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(request);
		List<SanPhamDat> listSP = sanPhamDatService.layTatCaTheoNguoiDung(nguoiDung);
		request.setAttribute("danhSachSanPham", this.reverseList(listSP));
		request.getRequestDispatcher("WEB-INF/quan_ly_don_hang.jsp").forward(request, response);
	}
	
    private static List<SanPhamDat> reverseList(List<SanPhamDat> list) {
        // Diem neo, khi list chi co 1 phan tu
        if (list.size() <= 1) {
            return list;
        }
        List<SanPhamDat> reversed = new ArrayList<>();
        // dua phan tu cuoi list vao mot list moi
        reversed.add(list.get(list.size() - 1));
        // thuc hien de quy voi list moi
        reversed.addAll(reverseList(list.subList(0, list.size() - 1)));
        return reversed;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
