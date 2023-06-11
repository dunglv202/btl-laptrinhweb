package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.constant.TinhTrangDon;
import cf.laptrinhweb.btl.repository.ThongKeRepository;
import cf.laptrinhweb.btl.model.SanPhamMuaNhieu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ThongKeRepositoryImpl implements ThongKeRepository {
    @Override
    public Map<LocalDate, Double> thongKeDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT
                	DATE(ngay_dat_hang) AS ngay_dat,
                    SUM(tong_tien) AS tong_tien
                FROM dat_hang
                WHERE
                	DATE(ngay_dat_hang) >= ?
                    AND DATE(ngay_dat_hang) <= ?
                GROUP BY ngay_dat;
            """);
            ps.setDate(1, Date.valueOf(ngayBatDau));
            ps.setDate(2, Date.valueOf(ngayKetThuc));
            ResultSet resultSet = ps.executeQuery();
            Map<LocalDate, Double> cacThongKe = new HashMap<>();
            while (resultSet.next()) {
                LocalDate ngayDuocThongKe = resultSet.getDate("ngay_dat").toLocalDate();
                Double tongDoanhThu = resultSet.getDouble("tong_tien");
                cacThongKe.put(ngayDuocThongKe, tongDoanhThu);
            }
            return cacThongKe;
        } catch (Exception e) {
            throw new RuntimeException("Khong the lay du lieu thong ke doanh thu", e);
        }
    }

    @Override
    public double layGiaTriDonTrungBinh(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT
                	AVG(tong_tien) AS trung_binh_don
                FROM dat_hang
                WHERE
                	DATE(ngay_dat_hang) >= ?
                    AND DATE(ngay_dat_hang) <= ?
            """);
            ps.setDate(1, Date.valueOf(ngayBatDau));
            ps.setDate(2, Date.valueOf(ngayKetThuc));
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return resultSet.getDouble("trung_binh_don");
        } catch (Exception e) {
            throw new RuntimeException("Khong the lay du lieu thong ke doanh thu", e);
        }
    }

    @Override
    public double tinhTiLeHuyDon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT
                	COUNT(*) AS tong_so_don
                FROM dat_hang
                WHERE
                    dat_hang.trang_thai = ?
                	AND DATE(ngay_dat_hang) >= ?
                    AND DATE(ngay_dat_hang) <= ?
            """);
            ps.setInt(1, TinhTrangDon.DA_HUY);
            ps.setDate(2, Date.valueOf(ngayBatDau));
            ps.setDate(3, Date.valueOf(ngayKetThuc));
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            int tongSoDon = resultSet.getInt("tong_so_don");

            ps = ketNoi.prepareStatement("""
                SELECT
                	COUNT(*) AS tong_so_don
                FROM dat_hang
                WHERE
                	DATE(ngay_dat_hang) >= ?
                    AND DATE(ngay_dat_hang) <= ?
            """);
            ps.setDate(1, Date.valueOf(ngayBatDau));
            ps.setDate(2, Date.valueOf(ngayKetThuc));
            resultSet = ps.executeQuery();
            resultSet.next();
            int soDonHuy = resultSet.getInt("tong_so_don");

            return (double) tongSoDon / soDonHuy;
        } catch (Exception e) {
            throw new RuntimeException("Khong the tinh toan ti le huy don", e);
        }
    }
        @Override
    public List<SanPhamMuaNhieu> lietKe() {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
               SELECT 
            		sum(d.so_luong) AS so_luong_mua, s.ten_san_pham
            	FROM san_pham_dat d
            	JOIN san_pham s ON d.ma_san_pham = s.ma_san_pham
            	GROUP BY d.ma_san_pham, s.ten_san_pham
            	ORDER BY so_luong_mua DESC
            	LIMIT 3
            """);
            ResultSet resultSet = ps.executeQuery();
            List<SanPhamMuaNhieu> dsSP = new ArrayList<>();
            int dem = 1;
            while (resultSet.next()) {
                SanPhamMuaNhieu sp = new SanPhamMuaNhieu();
                sp.setStt(dem++);
                sp.setSoLuong(resultSet.getInt("so_luong_mua"));
                sp.setTenSanPham(resultSet.getString("ten_san_pham"));
                dsSP.add(sp);
            }
            return dsSP;
        } catch (Exception e) {
            throw new RuntimeException("San pham moi cap nhat", e);
        }
    }                                  
}
