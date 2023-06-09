package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cf.laptrinhweb.btl.constant.HinhThucThanhToan;
import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPhamDat;
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
                    sdt_nhan,
                    tong_tien
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
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
            ps.setDouble(10, datHang.getTongTien());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            datHang.setMaDatHang(resultSet.getLong(1));
        } catch (Exception e) {
            throw new RuntimeException("Khong the them sp vao gio hang", e);
        }
	}

	@Override
	public List<DatHang> layTatCaCuaNguoiDung(NguoiDung nguoidung) {
		// TODO Auto-generated method stub
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT *
                FROM dat_hang
                WHERE ma_nguoi_dat = ?
            	ORDER BY ngay_dat_hang DESC
            """);
            ps.setLong(1, nguoidung.getMaNguoiDung());
            ResultSet resultSet = ps.executeQuery();
            List<DatHang> res = new ArrayList<>();
            while( resultSet.next() ) {
            	DatHang dh = new DatHang();
            	dh.setDiaChiGiao(resultSet.getString("dia_chi_giao"));
            	dh.setMaDatHang(resultSet.getLong("ma_dat_hang"));
            	dh.setHinhThucThanhToan(resultSet.getInt("hinh_thuc_thanh_toan") == 1 ? HinhThucThanhToan.THANH_TOAN_KHI_NHAN : HinhThucThanhToan.THE_NGAN_HANG);
            	dh.setNote(resultSet.getString("ghi_chu"));
            	dh.setPhuongThucVanChuyen(resultSet.getInt("phuong_thuc_van_chuyen"));
            	dh.setSdtNhan(resultSet.getString("sdt_nhan"));
            	dh.setNguoiDung(nguoidung);
            	dh.setTenNguoiNhan(resultSet.getString("ten_nguoi_nhan"));
            	dh.setTinhTrang(resultSet.getInt("trang_thai"));
            	dh.setNgayTaoDon(Date.from(resultSet.getTimestamp("ngay_dat_hang").toInstant()));
            	dh.setTongTien(resultSet.getDouble("tong_tien"));
            	res.add(dh);
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException("Khong the truy van dat hang", e);
        }
	}
	


}
