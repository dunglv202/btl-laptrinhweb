package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.model.DieuKienSanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> timTatCa(DieuKienSanPham dieuKien);
}
