package cf.laptrinhweb.btl.controller;

import cf.laptrinhweb.btl.exception.chung.ThongTinDangNhapDaTonTaiException;
import cf.laptrinhweb.btl.service.XacThucService;
import cf.laptrinhweb.btl.service.impl.XacThucServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dang-ky")
public class DangKyController extends HttpServlet {
    private final XacThucService xacThucService = new XacThucServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/dang_ky.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            xacThucService.dangKy(req.getParameterMap());
            resp.sendRedirect(req.getContextPath() + "/dang-nhap");
        } catch (ThongTinDangNhapDaTonTaiException e) {
            e.getThongTinTrungLap().forEach(loaiThongTin -> {
                switch (loaiThongTin) {
                    case EMAIL -> req.setAttribute("trungEmail", true);
                    case SO_DIEN_THOAI -> req.setAttribute("trungSdt", true);
                    case TEN_DANG_NHAP -> req.setAttribute("trungTenDangNhap", true);
                }
            });
            req.getParameterMap().forEach((key, val) -> {
                req.setAttribute(key, val[0]);
            });
            req.getRequestDispatcher("/WEB-INF/dang_ky.jsp").forward(req, resp);
        }
    }
}
