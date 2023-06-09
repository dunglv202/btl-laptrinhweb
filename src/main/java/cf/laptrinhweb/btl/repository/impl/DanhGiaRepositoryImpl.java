package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cf.laptrinhweb.btl.entity.DanhGia;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import cf.laptrinhweb.btl.repository.DanhGiaRepository;

public class DanhGiaRepositoryImpl implements DanhGiaRepository{

	@Override
	public void themDanhGia(DanhGia danhGia,Long ma_san_pham_dat) {
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO danh_gia (
            		ma_nguoi_danh_gia,
                    ma_san_pham_dat,
                    diem_danh_gia,
                    noi_dung_danh_gia
                ) VALUES (?, ?, ?,?)
            """,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, danhGia.getKhachHangDanhGia().getMaNguoiDung());
            ps.setLong(2, ma_san_pham_dat);
            ps.setInt(3,danhGia.getSoDiemDanhGia());
            ps.setString(4, danhGia.getNoi_dung_danh_gia());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            danhGia.setId(rs.getLong(1));
        } catch (Exception e) {
            throw new RuntimeException("Khong the them danh gia", e);
        }
		
	}

	@Override
	public void xoaDanhGia(Long ma_danh_gia) {
		// TODO Auto-generated method stub
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                delete from danh_gia where ma_danh_gia = ?""");
            ps.setLong(1, ma_danh_gia);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Khong the xoa danh gia", e);
        }
		
		
	}

	@Override
	public List<DanhGia> layTatCaDanhGia(Long ma_san_pham) {
		List<DanhGia> ldg = new ArrayList<>();
		// TODO Auto-generated method stub
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                select * 
                from danh_gia,san_pham_dat,san_pham
                where ma_nguoi_danh_gia = ?
                """);
            ps.setLong(1, ma_san_pham);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	DanhGia a = new DanhGia();
            	a.setId(rs.getLong("ma_danh_gia"));
            	a.setKhachHangDanhGia(new NguoiDungRepositoryImpl().timNguoiDung(rs.getLong("ma_nguoi_danh_gia")));
            	a.setNoi_dung_danh_gia(rs.getString("noi_dung_danh_gia"));
            	a.setSoDiemDanhGia(rs.getInt("so_diem_danh_gia"));
            	a.setNgay_danh_gia(Date.from(rs.getTimestamp("ngay_danh_gia").toInstant()));
            	SanPhamDat spd = new SanPhamDat();
            	spd.setDatHang_id(ma_san_pham)
            	ldg.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException("Khong the xoa danh gia", e);
        }
		return ldg;
	}

}
