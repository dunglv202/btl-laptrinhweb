package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.entity.NguoiDung;

public interface GioHangService {
    void themSanPham(NguoiDung nguoiDung, Long maSanPham, Integer soLuong);
}
