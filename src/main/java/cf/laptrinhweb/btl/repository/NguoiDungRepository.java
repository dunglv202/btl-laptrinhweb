package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.model.DieuKienNguoiDung;

import java.util.List;
import java.util.Optional;

public interface NguoiDungRepository extends JdbcRepository<NguoiDung> {
    Optional<NguoiDung> timBangThongTinDangNhap(String thongTinDangNhap);
    boolean tonTaiVoiTenDangNhap(String tenDangNhap);
    boolean tonTaiVoiEmail(String email);
    boolean tonTaiVoiSoDienThoai(String soDienThoai);
    void taoMoiNguoiDung(NguoiDung nguoiDung);
    void doiMatKhau(NguoiDung nguoiDung, String matKhauMoi);
    List<NguoiDung> timTatCa(DieuKienNguoiDung dieuKien);
    void thayDoiTrangThai(Long maNguoiDung, boolean khoa);
}
