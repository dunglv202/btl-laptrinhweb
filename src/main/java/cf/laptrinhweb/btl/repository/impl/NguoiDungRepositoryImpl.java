package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.mapper.NguoiDungMapper;
import cf.laptrinhweb.btl.model.NguoiDung;
import cf.laptrinhweb.btl.repository.NguoiDungRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class NguoiDungRepositoryImpl implements NguoiDungRepository {
    @Override
    public Optional<NguoiDung> timBangThongTinDangNhap(String thongTinDangNhap) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT * FROM nguoi_dung WHERE ten_dang_nhap = ? OR email = ? OR so_dien_thoai = ?
            """);
            ps.setString(1, thongTinDangNhap);
            ps.setString(2, thongTinDangNhap);
            ps.setString(3, thongTinDangNhap);

            ResultSet resultSet = ps.executeQuery();
            return resultSet.next() ? Optional.of(new NguoiDungMapper().map(resultSet)) : Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
