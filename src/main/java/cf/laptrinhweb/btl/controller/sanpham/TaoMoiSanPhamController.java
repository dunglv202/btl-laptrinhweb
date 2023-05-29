package cf.laptrinhweb.btl.controller.sanpham;

import cf.laptrinhweb.btl.model.ThongTinSanPham;
import cf.laptrinhweb.btl.service.SanPhamService;
import cf.laptrinhweb.btl.service.impl.SanPhamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/quan-ly/san-pham/tao-moi")
public class TaoMoiSanPhamController extends HttpServlet {
    private final SanPhamService sanPhamService = new SanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/form_san_pham.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThongTinSanPham sanPhamMoi = taoThongTinSanPham(req);
        sanPhamService.taoSanPham(sanPhamMoi);
        resp.sendRedirect(req.getContextPath() + "/quan-ly/san-pham/tao-moi");
    }

    private ThongTinSanPham taoThongTinSanPham(HttpServletRequest request) {
        String kichThuoc = request.getParameter("kichThuoc").isBlank()
            ? null
            : request.getParameter("kichThuoc");
        Double trongLuong = request.getParameter("trongLuong").isBlank()
            ? null
            : Double.parseDouble(request.getParameter("trongLuong"));
        return ThongTinSanPham.builder()
            .ten(request.getParameter("tenSanPham"))
            .moTa(request.getParameter("moTa"))
            .maTheLoai(Long.parseLong(request.getParameter("theLoai")))
            .gia(Double.parseDouble(request.getParameter("gia")))
            .soLuong(Integer.parseInt(request.getParameter("soLuong")))
            .maChatLieu(Long.parseLong(request.getParameter("chatLieu")))
            .maThuongHieu(Long.parseLong(request.getParameter("thuongHieu")))
            .kichThuoc(kichThuoc)
            .trongLuong(trongLuong)
            .build();
    }
}
