package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.model.BanGhiDuLieu;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DashboardService {
    Map<String, Object> layThongKeDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    double tinhTiLeHuyDon(LocalDate ngayBatDau, LocalDate ngayKetThuc);
}
