package cf.laptrinhweb.btl.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Dung @WebServlet thay vi viet mapping trong file web.xml
@WebServlet("/dat-hang")
public class GioHangController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tra ve giao dien trang dat hang la file dat_hang.jsp trong thu muc WEB-INF
        // TODO: truyen cac tham so cua gio hang, don hang giong nhu cach sau => xem cach lay ra bien trong file .jsp
        req.setAttribute("tenBien", "giaTri");
        req.getRequestDispatcher("WEB-INF/dat_hang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO:  xu ly phan dat hang => goi service de tao don hang

        // dieu huong lai ve trang lich su don hang sau khi dat hang
        resp.sendRedirect(req.getContextPath() + "/lich-su-mua-hang");
    }
}
