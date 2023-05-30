package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.entity.TheLoai;
import cf.laptrinhweb.btl.helper.HoTroLuuTru;
import cf.laptrinhweb.btl.model.DieuKienSanPham;
import cf.laptrinhweb.btl.model.ThongTinSanPham;
import cf.laptrinhweb.btl.repository.AnhSanPhamRepository;
import cf.laptrinhweb.btl.repository.SanPhamRepository;
import cf.laptrinhweb.btl.repository.impl.AnhSanPhamRepositoryImpl;
import cf.laptrinhweb.btl.repository.impl.SanPhamRepositoryImpl;
import cf.laptrinhweb.btl.service.SanPhamService;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();
    private final AnhSanPhamRepository anhSanPhamRepository = new AnhSanPhamRepositoryImpl();

    @Override
    public List<SanPham> timTatCa(DieuKienSanPham dieuKien) {
        List<SanPham> dsSanPham = new ArrayList<>();
        TheLoai theLoai = new TheLoai(10L, "Ten the Loai");
        return dsSanPham;
    }

    @Override
    public void taoSanPham(ThongTinSanPham thongTinSanPham, List<Part> dsAnh) {
        // TODO: kiem tra thong tin truoc khi luu gom thong tin san pham & dinh dang file anh
        // luu san pham va anh
        List<String> dsDuongDan = dsAnh.stream().map(HoTroLuuTru::luuFile).toList();
        if (!dsAnh.isEmpty()) thongTinSanPham.setAnhXemTruoc(dsDuongDan.get(0));
        SanPham sanPham = sanPhamRepository.taoMoi(thongTinSanPham);
        anhSanPhamRepository.themTatCaAnh(sanPham, dsDuongDan);
    }
}
