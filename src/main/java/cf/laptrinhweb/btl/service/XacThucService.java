package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.entity.NguoiDung;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface XacThucService {
    void dangKy(Map<String, String[]> thongTinDangKy);
    NguoiDung dangNhap(String tenDangNhap, String matKhau);
    void doiMatKhau(HttpServletRequest req);
}
