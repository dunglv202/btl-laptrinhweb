package cf.laptrinhweb.btl.service;
import cf.laptrinhweb.btl.entity.*;
import java.util.List;

public interface DatHangService {
    void themDatHang(DatHang dathang, List<SanPhamDat> danhSachSanPham);
    List<SanPhamDat> layDonTheoMa(Long maDatHang, NguoiDung nguoiDung);
}
