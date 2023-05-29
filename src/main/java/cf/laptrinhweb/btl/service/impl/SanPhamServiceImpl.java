package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.entity.TheLoai;
import cf.laptrinhweb.btl.model.DieuKienSanPham;
import cf.laptrinhweb.btl.model.ThongTinSanPham;
import cf.laptrinhweb.btl.repository.SanPhamRepository;
import cf.laptrinhweb.btl.repository.impl.SanPhamRepositoryImpl;
import cf.laptrinhweb.btl.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();

    @Override
    public List<SanPham> timTatCa(DieuKienSanPham dieuKien) {
        List<SanPham> dsSanPham = new ArrayList<>();
        TheLoai theLoai = new TheLoai(10L, "Ten the Loai");
        return dsSanPham;
    }

    @Override
    public void taoSanPham(ThongTinSanPham thongTinSanPham) {
        // TODO: kiem tra thong tin

        // luu san pham
        sanPhamRepository.taoMoi(thongTinSanPham);
    }
}
