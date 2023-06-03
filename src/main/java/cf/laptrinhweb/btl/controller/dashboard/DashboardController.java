package cf.laptrinhweb.btl.controller.dashboard;

import cf.laptrinhweb.btl.model.BanGhiDuLieu;
import cf.laptrinhweb.btl.model.DanhSachDuLieu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/quan-ly/dashboard")
public class DashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("doanhThuThang", DanhSachDuLieu.builder()
            .tenDanhSach("Thống kê doanh thu tháng")
            .danhSachDuLieu(layDuLieuDoanhThu())
            .build());
        req.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(req, resp);
    }

    private List<BanGhiDuLieu> layDuLieuDoanhThu() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate ngay = LocalDate.now().minusDays(30);
        List<BanGhiDuLieu> duLieuDoanhThu = new ArrayList<>();
        while (ngay.isBefore(LocalDate.now())) {
            duLieuDoanhThu.add(BanGhiDuLieu.of(dateFormat.format(ngay), Math.random()));
            ngay = ngay.plusDays(1);
        }
        return duLieuDoanhThu;
    }
}
