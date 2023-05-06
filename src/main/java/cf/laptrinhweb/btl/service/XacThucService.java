package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.model.NguoiDung;

import java.util.Map;

public interface XacThucService {
    void dangKy(Map<String, String[]> thongTinDangKy);
    NguoiDung dangNhap(String tenDangNhap, String matKhau);
}
