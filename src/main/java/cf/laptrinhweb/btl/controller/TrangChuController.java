package cf.laptrinhweb.btl.controller;

import cf.laptrinhweb.btl.constant.KhoaSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class TrangChuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("ten_nguoi_dung", req.getSession().getAttribute(KhoaSession.TEN_NGUOI_DUNG));
        req.getRequestDispatcher("/WEB-INF/trang_chu.jsp").forward(req, resp);
    }
}
