package cf.laptrinhweb.btl.controller.xacthuc;

import cf.laptrinhweb.btl.constant.KhoaSession;
import cf.laptrinhweb.btl.constant.LoaiHanhDong;
import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.exception.xacthuc.SaiThongTinDangNhapException;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.exception.xacthuc.TaiKhoanBiKhoaException;
import cf.laptrinhweb.btl.model.thongbao.ThongBaoSaiThongTinDangNhap;
import cf.laptrinhweb.btl.model.thongbao.ThongBaoTkBiKhoa;
import cf.laptrinhweb.btl.service.LichSuHanhDongService;
import cf.laptrinhweb.btl.service.XacThucService;
import cf.laptrinhweb.btl.service.impl.LichSuHanhDongServiceImpl;
import cf.laptrinhweb.btl.service.impl.XacThucServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/dang-nhap")
public class DangNhapController extends HttpServlet {
    private final XacThucService xacThucService = new XacThucServiceImpl();
    private final LichSuHanhDongService lichSuHanhDongService = new LichSuHanhDongServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trangTruoc = req.getHeader("Referer");
        if (trangTruoc!=null
            && !trangTruoc.matches("^.*://.*/dang-nhap(\\?.*)?")
            && !trangTruoc.matches("^.*://.*/(\\?.*)?")) {
            // trang truoc khong phai trang dang nhap hoac trang chu -> dieu huong sau dang nhap
            req.setAttribute("trangTruoc", trangTruoc);
        }
        req.getRequestDispatcher("WEB-INF/dang_nhap.jsp").forward(req, resp);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenDangNhap = req.getParameter("tenDangNhap");
        String matKhau = req.getParameter("matKhau");
        try {
            NguoiDung nguoiDung = xacThucService.dangNhap(tenDangNhap, matKhau);
            req.getSession().setAttribute(KhoaSession.NGUOI_DUNG, nguoiDung);
            ((Set<Long>) req.getServletContext().getAttribute(KhoaSession.BUOC_DANG_XUAT)).remove(nguoiDung.getMaNguoiDung());
            String diaChiDieuHuong = layDiaChiDieuHuong(req, nguoiDung);
            lichSuHanhDongService.themLichSu(req, LoaiHanhDong.DANG_NHAP, true);
            resp.sendRedirect(diaChiDieuHuong);
        } catch (SaiThongTinDangNhapException e) {
            if (e.getMaNguoiDung() != null)
                lichSuHanhDongService.themLichSu(req, e.getMaNguoiDung(), LoaiHanhDong.DANG_NHAP, false);
            req.setAttribute("thongBao", new ThongBaoSaiThongTinDangNhap());
            req.getRequestDispatcher("WEB-INF/dang_nhap.jsp").forward(req, resp);
        } catch (TaiKhoanBiKhoaException e) {
            if (e.getMaNguoiDung() != null)
                lichSuHanhDongService.themLichSu(req, e.getMaNguoiDung(), LoaiHanhDong.DANG_NHAP, false);
            req.setAttribute("thongBao", new ThongBaoTkBiKhoa());
            req.getRequestDispatcher("WEB-INF/dang_nhap.jsp").forward(req, resp);
        }
    }

    private String layDiaChiDieuHuong(HttpServletRequest request, NguoiDung nguoiDung) {
        String diaChiDieuHuong = request.getParameter("dieuHuong");
        if (diaChiDieuHuong != null) {
            return diaChiDieuHuong;
        } else if (nguoiDung.coQuyen(QuyenNguoiDung.ADMIN)) {
            diaChiDieuHuong = "/quan-ly/nguoi-dung";
        } else if (nguoiDung.coQuyen(QuyenNguoiDung.QUAN_LY)) {
            diaChiDieuHuong = "/quan-ly/san-pham/tao-moi";
        } else {
            diaChiDieuHuong = "/";
        }
        return request.getContextPath() + diaChiDieuHuong;
    }
}
