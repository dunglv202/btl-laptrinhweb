package cf.laptrinhweb.btl.controller.sanpham;

import cf.laptrinhweb.btl.entity.*;
import cf.laptrinhweb.btl.service.SanPhamService;
import cf.laptrinhweb.btl.service.impl.SanPhamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/san-pham")
public class ChiTietSanPhamController extends HttpServlet {
    private final SanPhamService sanPhamService = new SanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sanPham", new SanPham(
            1L,
            "Sản phẩm không có tên",
            "https://prestashop17.joommasters.com/yanka/34-large_default/printed-dress.jpg",
            "Mộ vài mô tả cho sản phẩm",
            new TheLoai(1L, "Đồ gia dụng"),
            100.0,
            10,
            List.of(
//                new AnhSanPham(2L, null, "https://prestashop17.joommasters.com/yanka/37-large_default/printed-dress.jpg"),
                new AnhSanPham(1L, null, "https://prestashop17.joommasters.com/yanka/34-large_default/printed-dress.jpg"),
                new AnhSanPham(3L, null, "https://prestashop17.joommasters.com/yanka/36-large_default/printed-dress.jpg")
            ),
            new ChatLieu(1L, "Inox"),
            new ThuongHieu(1L, "NEW SUN"),
            null,
            1000.0
        ));
        req.setAttribute("sanPhamLienQuan", sanPhamService.timTatCa(null));
        req.getRequestDispatcher("/WEB-INF/chi_tiet_san_pham.jsp").forward(req, resp);
    }
}
