package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.repository.GioHangRepository;
import cf.laptrinhweb.btl.repository.impl.GioHangRepositoryImpl;
import cf.laptrinhweb.btl.service.GioHangService;

public class GioHangServiceImpl implements GioHangService {
    private final GioHangRepository gioHangRepository = new GioHangRepositoryImpl();

    @Override
    public void themSanPham(NguoiDung nguoiDung, Long maSanPham, Integer soLuong) {
        if (soLuong <= 0) throw new RuntimeException("So luong khong hop le");
        Long maItem = gioHangRepository.timBangNguoiDungVaSanPham(nguoiDung.getMaNguoiDung(), maSanPham);
        if (maItem != null) {
            gioHangRepository.capNhatSoLuong(maItem, soLuong);
        } else {
            gioHangRepository.themVaoGioHang(nguoiDung.getMaNguoiDung(), maSanPham, soLuong);
        }
    }
}
