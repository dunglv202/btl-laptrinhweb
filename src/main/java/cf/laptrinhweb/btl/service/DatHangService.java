package cf.laptrinhweb.btl.service;
import cf.laptrinhweb.btl.entity.*;
import java.util.List;

public interface DatHangService {
    void themDatHang(DatHang dathang, List<SanPhamDat> danhSachSanPham, List<SanPhamTrongGio> listGio, NguoiDung nguoidung);
    List<SanPhamDat> layDonTheoMa(Long maDatHang, NguoiDung nguoiDung);
    List<DatHang> layTatCaCuaNguoiDung(NguoiDung nguoidung);
    DatHang layDatHang(Long ma_dat_hang);
}
