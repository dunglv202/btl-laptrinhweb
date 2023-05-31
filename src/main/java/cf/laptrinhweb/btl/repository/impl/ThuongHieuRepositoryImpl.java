package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.entity.TheLoai;
import cf.laptrinhweb.btl.entity.ThuongHieu;
import cf.laptrinhweb.btl.mapper.TheLoaiMapper;
import cf.laptrinhweb.btl.mapper.ThuongHieuMapper;
import cf.laptrinhweb.btl.repository.ThuongHieuRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThuongHieuRepositoryImpl implements ThuongHieuRepository {
    @Override
    public List<ThuongHieu> layTatCa() {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT * FROM thuong_hieu
            """);
            ResultSet resultSet = ps.executeQuery();
            List<ThuongHieu> dsThuongHieu = new ArrayList<>();
            ThuongHieuMapper mapper = new ThuongHieuMapper();
            while (resultSet.next()) {
                dsThuongHieu.add(mapper.map(resultSet));
            }
            return dsThuongHieu;
        } catch (Exception e) {
            throw new RuntimeException("Khong the lay danh sach the loai", e);
        }
    }
}
