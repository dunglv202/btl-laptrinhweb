package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import cf.laptrinhweb.btl.constant.HinhThucThanhToan;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import cf.laptrinhweb.btl.repository.SanPhamDatRepository;

public class SanPhamDatRepositoryImpl implements SanPhamDatRepository{
	@Override
	public void themSanPhamDat(SanPhamDat sanpham) {
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO san_pham_dat (
                    ma_san_pham,
                    don_gia,
                    so_luong,
                    ma_dat_hang
                ) VALUES (?, ?, ?, ?)
            """,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(2, sanpham.getGia());
            ps.setLong(1, sanpham.getSanPham_id());
            ps.setInt(3, sanpham.getSoLuong());
            ps.setLong(4, sanpham.getDatHang().getMaDatHang());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            sanpham.setId(resultSet.getLong(1));
        } catch (Exception e) {
            throw new RuntimeException("Khong the them sp_dat vao gio hang", e);
        }
	};
}
