package cf.laptrinhweb.btl.controller.dashboard;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.model.BanGhiDuLieu;
import cf.laptrinhweb.btl.model.DanhSachDuLieu;
import cf.laptrinhweb.btl.service.DashboardService;
import cf.laptrinhweb.btl.service.impl.DashboardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;

@WebServlet("/quan-ly/dashboard")
public class DashboardController extends HttpServlet {
    private final DashboardService dashboardService = new DashboardServiceImpl();

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        yeuCauQuyen(req, List.of(QuyenNguoiDung.QUAN_LY));

        LocalDate ngayBatDau = LocalDate.now().minusDays(30);
        LocalDate ngayKetThuc = LocalDate.now();
        int soNgayThongKe = Period.between(ngayBatDau, ngayKetThuc).getDays();
        if (soNgayThongKe > 30) {
            throw new RuntimeException("Chi duoc thong ke toi da 30 ngay");
        }
        Map<String, Object> thongKeDoanhThu = dashboardService.layThongKeDoanhThu(ngayBatDau, ngayKetThuc);
        req.setAttribute("tongDoanhThu", thongKeDoanhThu.get("tongDoanhThu"));
        req.setAttribute("trungBinhDon", thongKeDoanhThu.get("trungBinhDon"));
        req.setAttribute("doanhThuTungNgay", DanhSachDuLieu.builder()
            .tenDanhSach("Biểu đồ doanh thu")
            .danhSachDuLieu((List<BanGhiDuLieu>) thongKeDoanhThu.get("doanhThuTungNgay"))
            .build());
        req.setAttribute("tiLeHuyDon", dashboardService.tinhTiLeHuyDon(ngayBatDau, ngayKetThuc));
        req.setAttribute("topMuaNhieu",dashboardService.lietKe2() );
        req.setAttribute("topBanChay", dashboardService.lietKe());
        req.setAttribute("theLoaiBanChay", dashboardService.lietKe3());
        req.setAttribute("thuongHieuBanChay", dashboardService.lietKe4());
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
