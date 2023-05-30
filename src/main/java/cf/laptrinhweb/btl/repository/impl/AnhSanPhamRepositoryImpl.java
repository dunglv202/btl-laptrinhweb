package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.repository.AnhSanPhamRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class AnhSanPhamRepositoryImpl implements AnhSanPhamRepository {
    @Override
    public void themTatCaAnh(SanPham sanPham, List<String> cacDuongDan) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO anh_san_pham (ma_san_pham, duong_dan)
                VALUES (?, ?)
            """);
            for (String duongDanAnh : cacDuongDan) {
                ps.setLong(1, sanPham.getMaSanPham());
                ps.setString(2, duongDanAnh);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            throw new RuntimeException("Khong the luu cac anh vao csdl", e);
        }
    }
}
