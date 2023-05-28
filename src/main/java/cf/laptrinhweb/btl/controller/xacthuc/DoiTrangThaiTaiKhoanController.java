package cf.laptrinhweb.btl.controller.xacthuc;

import cf.laptrinhweb.btl.constant.KhoaSession;
import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.service.XacThucService;
import cf.laptrinhweb.btl.service.impl.XacThucServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;

@WebServlet("/tai-khoan/doi-trang-thai")
public class DoiTrangThaiTaiKhoanController extends HttpServlet {
    private final XacThucService xacThucService = new XacThucServiceImpl();

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        yeuCauQuyen(req, List.of(QuyenNguoiDung.ADMIN));

        boolean khoa = Boolean.parseBoolean(req.getParameter("khoa"));
        Long maNguoiDung = Long.parseLong(req.getParameter("maNguoiDung"));
        xacThucService.doiTrangThaiTaiKhoan(maNguoiDung, khoa);
        if (khoa) {
            ((Set<Long>) req.getServletContext().getAttribute(KhoaSession.BI_KHOA)).add(maNguoiDung);
        } else {
            ((Set<Long>) req.getServletContext().getAttribute(KhoaSession.BI_KHOA)).remove(maNguoiDung);
        }
        resp.sendRedirect(req.getContextPath() + "/quan-ly/nguoi-dung");
    }
}