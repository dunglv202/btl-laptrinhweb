package cf.laptrinhweb.btl.repository;

public interface GioHangRepository extends JdbcRepository {
    void themVaoGioHang(Long maNguoiDung, Long maSanPham, Integer soLuong);
    Long timBangNguoiDungVaSanPham(Long maNguoiDung, Long maSanPham);
    void capNhatSoLuong(Long maMucGioHang, Integer soLuongMoi);
}
