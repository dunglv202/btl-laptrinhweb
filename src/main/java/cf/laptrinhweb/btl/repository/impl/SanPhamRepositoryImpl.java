package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.mapper.QuyenMapper;
import cf.laptrinhweb.btl.model.ThongTinSanPham;
import cf.laptrinhweb.btl.repository.SanPhamRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class SanPhamRepositoryImpl implements SanPhamRepository {
    @Override
    public void taoMoi(ThongTinSanPham thongTinSanPham) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO san_pham (
                    ten_san_pham,
                    anh_xem_truoc,
                    mo_ta,
                    gia,
                    so_luong,
                    kich_thuoc,
                    trong_luong,
                    ma_the_loai,
                    ma_chat_lieu,
                    ma_thuong_hieu)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """);
            ps.setString(1, thongTinSanPham.getTen());
            ps.setString(2, thongTinSanPham.getAnhXemTruoc());
            ps.setString(3, thongTinSanPham.getMoTa());
            ps.setDouble(4, thongTinSanPham.getGia());
            ps.setInt(5, thongTinSanPham.getSoLuong());
            ps.setString(6, thongTinSanPham.getKichThuoc());
            ps.setObject(7, thongTinSanPham.getTrongLuong()); // dung setObject de tranh truong hop loi khi trong luong null
            ps.setLong(8, thongTinSanPham.getMaTheLoai());
            ps.setLong(9, thongTinSanPham.getMaChatLieu());
            ps.setLong(10, thongTinSanPham.getMaThuongHieu());
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
