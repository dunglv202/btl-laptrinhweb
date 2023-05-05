package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.model.NguoiDung;

import java.util.Optional;

public interface NguoiDungRepository extends JdbcRepository<NguoiDung> {
    Optional<NguoiDung> timBangThongTinDangNhap(String thongTinDangNhap);
}
