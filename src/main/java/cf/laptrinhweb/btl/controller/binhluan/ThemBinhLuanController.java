package cf.laptrinhweb.btl.controller.binhluan;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.BinhLuan;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;
import cf.laptrinhweb.btl.repository.BinhLuanRepository;
import cf.laptrinhweb.btl.repository.impl.BinhLuanRepositoryImpl;
import cf.laptrinhweb.btl.service.BinhLuanService;
import cf.laptrinhweb.btl.service.impl.BinhLuanServiceImpl;
import cf.laptrinhweb.btl.service.impl.SanPhamServiceImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@WebServlet("/them-binh-luan")
public class ThemBinhLuanController extends HttpServlet{
	private final BinhLuanService binhLuanService = new BinhLuanServiceImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("da sang");
		yeuCauQuyen(req, List.of(QuyenNguoiDung.KHACH_HANG));
		NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(req);
		BinhLuan bl = new BinhLuan();
		bl.setNoi_dung_binh_luan(req.getParameter("noi_dung_binh_luan").toString());
		bl.setNguoi_binh_luan(nguoiDung);
		bl.setSan_pham(new SanPhamServiceImpl().timTheoMa(Long.parseLong(req.getParameter("maSanPham").toString())));
		bl.setNgay_binh_luan(new Date(System.currentTimeMillis()));
		bl.setMa_binh_luan_tra_loi((long)0);
		binhLuanService.themBinhLuan(bl);
		System.out.print(req.getContextPath());
		resp.sendRedirect(req.getContextPath()+"/san-pham?maSanPham=" + req.getParameter("maSanPham"));
	}
}
