package cf.laptrinhweb.btl.mapper;

import cf.laptrinhweb.btl.model.NguoiDung;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NguoiDungMapper {
    public NguoiDung map(ResultSet resultSet) throws SQLException {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setMaNguoiDung(resultSet.getLong("ma_nguoi_dung"));
        nguoiDung.setTenHienThi(resultSet.getString("ten_hien_thi"));
        nguoiDung.setTenDangNhap(resultSet.getString("ten_dang_nhap"));
        nguoiDung.setEmail(resultSet.getString("email"));
        nguoiDung.setSoDienThoai(resultSet.getString("so_dien_thoai"));
        nguoiDung.setMatKhau(resultSet.getString("mat_khau"));
        return nguoiDung;
    }
}
