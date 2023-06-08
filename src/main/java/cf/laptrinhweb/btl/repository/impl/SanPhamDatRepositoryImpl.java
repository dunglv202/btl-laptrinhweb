package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import cf.laptrinhweb.btl.constant.HinhThucThanhToan;
import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import cf.laptrinhweb.btl.mapper.SanPhamMapper;
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
            ps.setLong(1, sanpham.getSanPham().getMaSanPham());
            ps.setInt(3, sanpham.getSoLuong());
            ps.setLong(4, sanpham.getDatHang().getMaDatHang());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            sanpham.setId(resultSet.getLong(1));
        } catch (Exception e) {
            throw new RuntimeException("Khong the them sp_dat vao gio hang", e);
        }
	}

	@Override
	public List<SanPhamDat> layTatCaNguoiDung(NguoiDung nguoiDung) {
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT *
                FROM san_pham_dat, dat_hang
                WHERE ma_nguoi_dat = ?
            		    AND san_pham_dat.ma_dat_hang = dat_hang.ma_dat_hang
            """);
            ps.setLong(1, nguoiDung.getMaNguoiDung());
            ResultSet resultSet = ps.executeQuery();
            List<SanPhamDat> res = new ArrayList<>();
            while( resultSet.next() ) {
            	SanPhamDat tmp = new SanPhamDat();
            	tmp.setGia(resultSet.getDouble("don_gia"));
            	tmp.setId(resultSet.getLong("ma_san_pham_dat"));
            	tmp.setSoLuong(resultSet.getInt("so_luong"));
            	tmp.setSanPham(new SanPhamRepositoryImpl().timTheoMa(resultSet.getLong("ma_san_pham")).get());
            	DatHang dh = new DatHang();
            	dh.setDiaChiGiao(resultSet.getString("dia_chi_giao"));
            	dh.setMaDatHang(resultSet.getLong("ma_dat_hang"));
            	dh.setHinhThucThanhToan(resultSet.getInt("hinh_thuc_thanh_toan") == 1 ? HinhThucThanhToan.THANH_TOAN_KHI_NHAN : HinhThucThanhToan.THE_NGAN_HANG);
            	dh.setNote(resultSet.getString("ghi_chu"));
            	dh.setPhuongThucVanChuyen(resultSet.getInt("phuong_thuc_van_chuyen"));
            	dh.setSdtNhan(resultSet.getString("sdt_nhan"));
            	dh.setNguoiDung(nguoiDung);
            	dh.setTenNguoiNhan(resultSet.getString("ten_nguoi_nhan"));
            	dh.setTinhTrang(resultSet.getInt("trang_thai"));
            	dh.setNgayTaoDon(Date.from(resultSet.getTimestamp("ngay_dat_hang").toInstant()));
            	tmp.setDatHang(dh);
            	res.add(tmp);
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException("Khong the tim san pham theo ma", e);
        }
	}

	@Override
	public List<SanPhamDat> layTatCaTheoMaDat(Long maDatHang, NguoiDung nguoidung) {
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT *
                FROM san_pham_dat, dat_hang
                WHERE san_pham_dat.ma_dat_hang = ?
            		    AND san_pham_dat.ma_dat_hang = dat_hang.ma_dat_hang
            """);
            ps.setLong(1, maDatHang);
            ResultSet resultSet = ps.executeQuery();
            List<SanPhamDat> res = new ArrayList<>();
            while( resultSet.next() ) {
            	SanPhamDat tmp = new SanPhamDat();
            	tmp.setGia(resultSet.getDouble("don_gia"));
            	tmp.setId(resultSet.getLong("ma_san_pham_dat"));
            	tmp.setSoLuong(resultSet.getInt("so_luong"));
            	tmp.setSanPham(new SanPhamRepositoryImpl().timTheoMa(resultSet.getLong("ma_san_pham")).get());
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
            	tmp.setDatHang(dh);
            	res.add(tmp);
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException("Khong the tim san pham theo ma", e);
        }
	}
}
