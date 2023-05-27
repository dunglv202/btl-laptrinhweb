package cf.laptrinhweb.btl.controller;

import cf.laptrinhweb.btl.service.SanPhamService;
import cf.laptrinhweb.btl.service.TheLoaiService;
import cf.laptrinhweb.btl.service.impl.SanPhamServiceImpl;
import cf.laptrinhweb.btl.service.impl.TheLoaiServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class TrangChuController extends HttpServlet {
    private final SanPhamService sanPhamService = new SanPhamServiceImpl();
    private final TheLoaiService theLoaiService = new TheLoaiServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("danhSachSanPham", sanPhamService.timTatCa(null));
        req.setAttribute("danhSachTheLoai", theLoaiService.layTatCa());
        req.getRequestDispatcher("/WEB-INF/trang_chu.jsp").forward(req, resp);
    }
}
