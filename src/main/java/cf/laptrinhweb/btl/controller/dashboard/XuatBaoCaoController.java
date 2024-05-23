package cf.laptrinhweb.btl.controller.dashboard;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.model.BanGhiDuLieu;
import cf.laptrinhweb.btl.model.DanhSachDuLieu;
import cf.laptrinhweb.btl.model.GiaiDoan;
import cf.laptrinhweb.btl.service.DashboardService;
import cf.laptrinhweb.btl.service.impl.DashboardServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;

@WebServlet("/quan-ly/dashboard/xuat-bao-cao")
public class XuatBaoCaoController extends HttpServlet {
    private final DashboardService dashboardService = new DashboardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        yeuCauQuyen(req, List.of(QuyenNguoiDung.QUAN_LY));

        int nam = req.getParameter("nam") != null
                ? Integer.parseInt(req.getParameter("nam"))
                : LocalDate.now().getYear();
        int thang = req.getParameter("thang") != null
                ? Integer.parseInt(req.getParameter("thang"))
                : LocalDate.now().getMonthValue();
        GiaiDoan giaiDoan = new GiaiDoan(nam, thang);

//        req.setAttribute("doanhThuTungNgay", DanhSachDuLieu.builder()
//                .tenDanhSach("Biểu đồ doanh thu")
//                .danhSachDuLieu((List<BanGhiDuLieu>) thongKeDoanhThu.get("doanhThuTungNgay"))
//                .build());
//        req.setAttribute("topMuaNhieu",dashboardService.layTopKhachMuaNhieu(giaiDoan) );
//        req.setAttribute("topBanChay", dashboardService.layTopSanPhamBanChay(giaiDoan));
//        req.setAttribute("theLoaiBanChay", dashboardService.layTheLoaiBanChay(giaiDoan));
//        req.setAttribute("thuongHieuBanChay", dashboardService.layThuongHieuBanChay(giaiDoan));

        try (Workbook fileBaoCao = taoFileBaoCao(giaiDoan)) {
            fileBaoCao.write(resp.getOutputStream());
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=bao_cao.xlsx");
        }
    }

    private Workbook taoFileBaoCao(GiaiDoan giaiDoan) {
        Workbook fileBaoCao = new XSSFWorkbook();
        Sheet sheetTongQuan = fileBaoCao.createSheet("Tổng quan");

        Map<String, Object> thongKeDoanhThu = dashboardService.layThongKeDoanhThu(giaiDoan);
        Row hang = sheetTongQuan.createRow(0);
        hang.createCell(0).setCellValue("Tổng doanh thu");
        hang.createCell(1).setCellValue((Double) thongKeDoanhThu.get("tongDoanhThu"));

        hang = sheetTongQuan.createRow(1);
        hang.createCell(0).setCellValue("Giá trị trung bình đơn hàng");
        hang.createCell(1).setCellValue((Double) thongKeDoanhThu.get("trungBinhDon"));

        hang = sheetTongQuan.createRow(2);
        hang.createCell(0).setCellValue("Tỉ lệ huỷ đơn");
        hang.createCell(1).setCellValue(dashboardService.tinhTiLeHuyDon(giaiDoan));

        return fileBaoCao;
    }
}
