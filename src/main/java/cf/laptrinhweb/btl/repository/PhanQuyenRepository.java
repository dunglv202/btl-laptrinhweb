package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.PhanQuyen;
import cf.laptrinhweb.btl.entity.Quyen;

import java.util.List;

public interface PhanQuyenRepository extends JdbcRepository<PhanQuyen> {
    void themQuyenChoNguoiDung(Long maNguoiDung, List<Long> quyenDuocPhan);
    List<Quyen> timBangMaNguoiDung(Long maNguoiDung);
}
