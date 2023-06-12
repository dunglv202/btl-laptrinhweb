package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.model.BanGhiDuLieu;
import cf.laptrinhweb.btl.model.KhachHangMuaNhieu;
import cf.laptrinhweb.btl.model.SanPhamMuaNhieu;
import cf.laptrinhweb.btl.model.TheLoaiMuaNhieu;
import cf.laptrinhweb.btl.model.ThuongHieuMuaNhieu;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DashboardService {
    Map<String, Object> layThongKeDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    double tinhTiLeHuyDon(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    List<SanPhamMuaNhieu> lietKe();
    List<KhachHangMuaNhieu> lietKe2();
    List<TheLoaiMuaNhieu> lietKe3();
    List<ThuongHieuMuaNhieu> lietKe4();
}
