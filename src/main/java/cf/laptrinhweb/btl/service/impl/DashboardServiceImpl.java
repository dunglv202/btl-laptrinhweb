package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.entity.TheLoai;
import cf.laptrinhweb.btl.model.BanGhiDuLieu;
import cf.laptrinhweb.btl.model.KhachHangMuaNhieu;
import cf.laptrinhweb.btl.model.SanPhamMuaNhieu;
import cf.laptrinhweb.btl.model.TheLoaiMuaNhieu;
import cf.laptrinhweb.btl.model.ThuongHieuMuaNhieu;
import cf.laptrinhweb.btl.repository.TheLoaiRepository;
import cf.laptrinhweb.btl.repository.ThongKeRepository;
import cf.laptrinhweb.btl.repository.impl.TheLoaiRepositoryImpl;
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
    
  

    @Override
    public List<SanPhamMuaNhieu> lietKe() {
        return thongKeRepository.lietKe();
    }
    
    @Override
    public List<KhachHangMuaNhieu> lietKe2() {
        return thongKeRepository.lietKe2();
    }
    
    @Override
    public List<TheLoaiMuaNhieu> lietKe3() {
    	return thongKeRepository.lietKe3(); 
    }
    @Override
    public List<ThuongHieuMuaNhieu> lietKe4() {
    	return thongKeRepository.lietKe4(); 
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
