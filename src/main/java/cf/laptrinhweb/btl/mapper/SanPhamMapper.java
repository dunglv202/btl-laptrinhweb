package cf.laptrinhweb.btl.mapper;

import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.entity.TheLoai;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SanPhamMapper {
    public SanPham map(ResultSet resultSet) throws SQLException {
        return SanPham.builder()
            .maSanPham(resultSet.getLong("ma_san_pham"))
            .tenSanPham(resultSet.getString("ten_san_pham"))
            .anhXemTruoc(resultSet.getString("anh_xem_truoc"))
            .moTa(resultSet.getString("mo_ta"))
            .gia(resultSet.getDouble("gia"))
            .soLuong(resultSet.getInt("so_luong"))
            .trongLuong((Double) resultSet.getObject("trong_luong"))
            .kichThuoc(resultSet.getString("kich_thuoc"))
            .theLoai(new TheLoaiMapper().map(resultSet))
            .thuongHieu(new ThuongHieuMapper().map(resultSet))
            .chatLieu(new ChatLieuMapper().map(resultSet))
            .build();
    }
}
