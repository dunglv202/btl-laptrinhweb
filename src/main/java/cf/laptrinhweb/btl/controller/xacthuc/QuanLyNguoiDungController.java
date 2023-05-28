package cf.laptrinhweb.btl.controller.xacthuc;

import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.model.DieuKienNguoiDung;
import cf.laptrinhweb.btl.service.XacThucService;
import cf.laptrinhweb.btl.service.impl.XacThucServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/quan-ly/nguoi-dung")
public class QuanLyNguoiDungController extends HttpServlet {
    private XacThucService xacThucService = new XacThucServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NguoiDung> dsNguoiDung = xacThucService.timNguoiDung(taoDieuKien(req));
        req.setAttribute("danhSachNguoiDung", dsNguoiDung);
        req.getRequestDispatcher("/WEB-INF/quan_ly_nguoi_dung.jsp").forward(req, resp);
    }

    private DieuKienNguoiDung taoDieuKien(HttpServletRequest request) {
        DieuKienNguoiDung dieuKienNguoiDung = new DieuKienNguoiDung();
        dieuKienNguoiDung.setTuKhoa(request.getParameter("tuKhoa"));
        String trang = request.getParameter("trang");
        if (trang != null && Integer.parseInt(trang) > 0)
            dieuKienNguoiDung.setTrang(Integer.parseInt(trang) - 1);
        String kichThuoc = request.getParameter("kichThuoc");
        if (kichThuoc != null)
            dieuKienNguoiDung.setTrang(Integer.parseInt(kichThuoc));
        return dieuKienNguoiDung;
    }
}
