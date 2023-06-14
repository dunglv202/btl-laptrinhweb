package cf.laptrinhweb.btl.controller.taikhoan;

import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.exception.xacthuc.ThongTinDangNhapDaTonTaiException;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;
import cf.laptrinhweb.btl.service.XacThucService;
import cf.laptrinhweb.btl.service.impl.XacThucServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tai-khoan/sua-thong-tin")
public class SuaThongTinTaiKhoanController extends HttpServlet {
    private final XacThucService xacThucService = new XacThucServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NguoiDung nguoiDung = layThongTinMoi(req);
        try {
            xacThucService.doiThongTinTaiKhoan(nguoiDung);
            resp.sendRedirect(req.getContextPath() + "/tai-khoan");
        } catch (ThongTinDangNhapDaTonTaiException e) {
            e.getThongTinTrungLap().forEach(loaiThongTin -> {
                switch (loaiThongTin) {
                    case EMAIL -> req.setAttribute("trungEmail", true);
                    case SO_DIEN_THOAI -> req.setAttribute("trungSdt", true);
                    case TEN_DANG_NHAP -> req.setAttribute("trungTenDangNhap", true);
                }
            });
            req.setAttribute("nguoiDung", nguoiDung);
            req.getRequestDispatcher("/WEB-INF/thong_tin_tai_khoan.jsp").forward(req, resp);
        }
    }

    private NguoiDung layThongTinMoi(HttpServletRequest request) {
        NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(request);
        nguoiDung.setTenHienThi(request.getParameter("tenHienThi"));
        String tenDangNhap = request.getParameter("tenDangNhap");
        nguoiDung.setTenDangNhap(tenDangNhap.isBlank() ? null : tenDangNhap);
        nguoiDung.setEmail(request.getParameter("email"));
        nguoiDung.setSoDienThoai(request.getParameter("soDienThoai"));
        nguoiDung.setMatKhau("matKhau");
        return nguoiDung;
    }
}
