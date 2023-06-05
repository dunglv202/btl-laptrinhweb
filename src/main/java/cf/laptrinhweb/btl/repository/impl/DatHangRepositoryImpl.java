package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import cf.laptrinhweb.btl.constant.HinhThucThanhToan;
import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.repository.DatHangRepository;

public class DatHangRepositoryImpl implements DatHangRepository{

	@Override
	public void themDatHang(DatHang datHang) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO dat_hang (
                    hinh_thuc_thanh_toan,
                    phuong_thuc_van_chuyen,
                    trang_thai,
                    dia_chi_giao,
                    ghi_chu,
                    ngay_dat_hang,
                    ma_nguoi_dat,
                    ten_nguoi_nhan,
                    sdt_nhan
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, datHang.getHinhThucThanhToan() == HinhThucThanhToan.THANH_TOAN_KHI_NHAN ? 1 : 2);
            ps.setInt(2, datHang.getPhuongThucVanChuyen());
            ps.setInt(3, datHang.getTinhTrang());
            ps.setString(4, datHang.getDiaChiGiao());
            ps.setString(5, datHang.getNote());
            ps.setTimestamp(6, Timestamp.from(datHang.getNgayTaoDon().toInstant()));
            ps.setLong(7, datHang.getNguoiDung().getMaNguoiDung());
            ps.setString(8,datHang.getTenNguoiNhan());
            ps.setString(9, datHang.getSdtNhan());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            datHang.setMaDatHang(resultSet.getLong(1));
        } catch (Exception e) {
            throw new RuntimeException("Khong the them sp vao gio hang", e);
        }
	}
	
	@Override
	public int laySoLuong() {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                select count(*) from dat_hang
            """);
            ResultSet rs = ps.executeQuery();
            return rs.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException("Khong the them sp vao gio hang", e);
        }
	}

}
