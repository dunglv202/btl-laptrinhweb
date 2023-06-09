package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cf.laptrinhweb.btl.entity.DanhGia;
import cf.laptrinhweb.btl.repository.DanhGiaRepository;

public class DanhGiaRepositoryImpl implements DanhGiaRepository{

	@Override
	public void themDanhGia(DanhGia danhGia) {
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO danh_gia (
            		ma_nguoi_danh_gia,
                    ma_san_pham_dat,
                    diem_danh_gia,
                    noi_dung_danh_gia
                ) VALUES (?, ?, ?,?)
            """);
            ps.setLong(1, danhGia.getKhachHangDanhGia().getMaNguoiDung());
            ps.setLong(2, danhGia.getSan_pham_dat().getId());
            ps.setInt(3,danhGia.getSoDiemDanhGia());
            ps.setString(4, danhGia.getNoi_dung_danh_gia());
            ps.executeUpdate();
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
                from danh_gia 
                where ma_nguoi_danh_gia = ?""");
            ps.setLong(1, ma_san_pham);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	DanhGia a = new DanhGia();
            	a.setId(rs.getLong("ma_danh_gia"));
            	a.setKhachHangDanhGia(new NguoiDungRepositoryImpl().timNguoiDung(rs.getLong("ma_nguoi_dung")));
            }
        } catch (Exception e) {
            throw new RuntimeException("Khong the xoa danh gia", e);
        }
		return ldg;
	}

}
