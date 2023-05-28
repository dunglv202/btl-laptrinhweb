package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.entity.TheLoai;
import cf.laptrinhweb.btl.model.DieuKienSanPham;
import cf.laptrinhweb.btl.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    @Override
    public List<SanPham> timTatCa(DieuKienSanPham dieuKien) {
        List<SanPham> dsSanPham = new ArrayList<>();
        TheLoai theLoai = new TheLoai(10L, "Ten the Loai");
        return dsSanPham;
    }
}
