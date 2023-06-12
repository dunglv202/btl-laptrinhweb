package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.model.BanGhiDuLieu;
import cf.laptrinhweb.btl.repository.ThongKeRepository;
import cf.laptrinhweb.btl.repository.impl.ThongKeRepositoryImpl;
import cf.laptrinhweb.btl.service.DashboardService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardServiceImpl implements DashboardService {
    private final ThongKeRepository thongKeRepository = new ThongKeRepositoryImpl();

    @Override
    public Map<String, Object> layThongKeDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        List<BanGhiDuLieu> doanhThuTungNgay = layDuLieuDoanhThu(ngayBatDau, ngayKetThuc);
        Map<String, Object> thongKe = new HashMap<>();
        double tongDoanhThu = 0;
        for (BanGhiDuLieu banGhi : doanhThuTungNgay) {
            tongDoanhThu += (Double) banGhi.getGiaTri();
        }
        thongKe.put("tongDoanhThu", tongDoanhThu);
        thongKe.put("trungBinhDon", thongKeRepository.layGiaTriDonTrungBinh(ngayBatDau, ngayKetThuc));
        thongKe.put("doanhThuTungNgay", doanhThuTungNgay);
        return thongKe;
    }

    @Override
    public double tinhTiLeHuyDon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        return thongKeRepository.tinhTiLeHuyDon(ngayBatDau, ngayKetThuc);
    }

    private List<BanGhiDuLieu> layDuLieuDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        Map<LocalDate, Double> duLieuThongKeDuoc = thongKeRepository.thongKeDoanhThu(ngayBatDau, ngayKetThuc);
        List<BanGhiDuLieu> dsDuLieuDayDu = new ArrayList<>();
        LocalDate ngayHienTai = ngayBatDau;
        DateTimeFormatter dinhDangNgay = DateTimeFormatter.ofPattern("dd/MM");
        while (!ngayHienTai.isAfter(ngayKetThuc)) {
            double doanhThuCuaNgay = duLieuThongKeDuoc.getOrDefault(ngayHienTai, (double) 0);
            dsDuLieuDayDu.add(BanGhiDuLieu.of(dinhDangNgay.format(ngayHienTai), doanhThuCuaNgay));
            ngayHienTai = ngayHienTai.plusDays(1);
        }
        return dsDuLieuDayDu;
    }
}
