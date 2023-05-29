package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.model.ThongTinSanPham;

public interface SanPhamRepository extends JdbcRepository<SanPham> {
    void taoMoi(ThongTinSanPham thongTinSanPham);
}
