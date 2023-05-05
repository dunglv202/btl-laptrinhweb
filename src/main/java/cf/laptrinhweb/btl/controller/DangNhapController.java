package cf.laptrinhweb.btl.controller;

import cf.laptrinhweb.btl.constant.KhoaSession;
import cf.laptrinhweb.btl.exception.xacthuc.SaiThongTinDangNhapException;
import cf.laptrinhweb.btl.model.NguoiDung;
import cf.laptrinhweb.btl.service.XacThucService;
import cf.laptrinhweb.btl.service.impl.XacThucServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dang-nhap")
public class DangNhapController extends HttpServlet {
    private final XacThucService xacThucService = new XacThucServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/dang_nhap.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenDangNhap = req.getParameter("tenDangNhap");
        String matKhau = req.getParameter("matKhau");
        try {
            NguoiDung nguoiDung = xacThucService.dangNhap(tenDangNhap, matKhau);
            req.getSession().setAttribute(KhoaSession.TEN_NGUOI_DUNG, nguoiDung.getTenHienThi());
        } catch (SaiThongTinDangNhapException e) {
            req.setAttribute("thongBao", e.getMessage());
            req.getRequestDispatcher("WEB-INF/dang_nhap.jsp").forward(req, resp);
        }
        resp.sendRedirect(req.getContextPath());
    }
}
