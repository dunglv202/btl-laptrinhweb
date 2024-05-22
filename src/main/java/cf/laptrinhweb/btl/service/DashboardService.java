package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.model.*;

import java.util.List;
import java.util.Map;

public interface DashboardService {
    double tinhTiLeHuyDon(GiaiDoan giaiDoan);
    List<SanPhamMuaNhieu> layTopSanPhamBanChay(GiaiDoan giaiDoan);
    List<KhachHangMuaNhieu> layTopKhachMuaNhieu(GiaiDoan giaiDoan);
    List<TheLoaiMuaNhieu> layTheLoaiBanChay(GiaiDoan giaiDoan);
    List<ThuongHieuMuaNhieu> layThuongHieuBanChay(GiaiDoan giaiDoan);
    Map<String, Object> layThongKeDoanhThu(GiaiDoan giaiDoan);
}
