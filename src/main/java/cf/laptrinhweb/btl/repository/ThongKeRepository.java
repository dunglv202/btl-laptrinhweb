package cf.laptrinhweb.btl.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import cf.laptrinhweb.btl.model.KhachHangMuaNhieu;
import cf.laptrinhweb.btl.model.SanPhamMuaNhieu;
import cf.laptrinhweb.btl.model.TheLoaiMuaNhieu;
import cf.laptrinhweb.btl.model.ThuongHieuMuaNhieu;

public interface ThongKeRepository extends JdbcRepository {
    Map<LocalDate, Double> thongKeDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    double layGiaTriDonTrungBinh(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    double tinhTiLeHuyDon(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    List<SanPhamMuaNhieu> layTopSanPhamBanChay(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    List<KhachHangMuaNhieu> layTopKhachMuaNhieu(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    List<TheLoaiMuaNhieu> layTheLoaiBanChay(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    List<ThuongHieuMuaNhieu> layThuongHieuBanChay(LocalDate ngayBatDau, LocalDate ngayKetThuc);
}
