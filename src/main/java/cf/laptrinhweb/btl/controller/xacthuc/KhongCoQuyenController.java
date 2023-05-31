package cf.laptrinhweb.btl.controller.xacthuc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/khong-co-quyen")
public class KhongCoQuyenController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403);
        req.getRequestDispatcher("/WEB-INF/khong_tim_thay.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403);
        req.getRequestDispatcher("/WEB-INF/khong_tim_thay.jsp").forward(req, resp);
    }
}
