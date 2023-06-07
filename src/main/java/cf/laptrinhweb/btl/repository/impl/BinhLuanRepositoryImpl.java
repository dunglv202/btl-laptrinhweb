package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import cf.laptrinhweb.btl.entity.BinhLuan;
import cf.laptrinhweb.btl.repository.BinhLuanRepository;

public class BinhLuanRepositoryImpl implements BinhLuanRepository{

	@Override
	public void themBinhLuan(BinhLuan binhLuan) {
		 try (Connection ketNoi = moKetNoi()) {
	            PreparedStatement ps = ketNoi.prepareStatement("""
	                INSERT INTO binh_luan (
	            		noi_dung_binh_luan,
	                    ma_nguoi_dung,
	                    ma_san_pham,
	                    ngay_binh_luan
	                ) VALUES (?, ?, ?,?)
	            """);
	            ps.setString(1, binhLuan.getNoi_dung_binh_luan());
	            ps.setLong(2, binhLuan.getNguoi_binh_luan().getMaNguoiDung());
	            ps.setLong(3, binhLuan.getSan_pham().getMaSanPham());
	            ps.setTimestamp(4,Timestamp.valueOf(binhLuan.getNgay_binh_luan().toString()));
	            ps.executeUpdate();
	        } catch (Exception e) {
	            throw new RuntimeException("Khong the them binh luan", e);
	        }
		
	}

	@Override
	public void xoaBinhLuan(BinhLuan binhLuan) {
		// TODO Auto-generated method stub
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                delete from binh_luan where ma_binh_luan = ?
            """);
            ps.setLong(1, binhLuan.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Khong the xoa", e);
        }
		
	}

	@Override
	public List<BinhLuan> layTatCaBinhLuan() {
		// TODO Auto-generated method stub
		List<BinhLuan> lbl = new ArrayList<>();
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                select * from binh_luan
            """);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	BinhLuan bl = new BinhLuan();
            	bl.setId(rs.getLong("ma_binh_luan"));
            	bl.setNgay_binh_luan(rs.getDate("ngay_binh_luan"));
            	bl.setNguoi_binh_luan(new NguoiDungRepositoryImpl().timNguoiDung(rs.getLong("ma_nguoi_dung")));
            	bl.setSan_pham(new SanPhamRepositoryImpl().timSanPham(rs.getLong("ma_san_pham")));
            	bl.setNgay_binh_luan(Timestamp.valueOf(rs.getDate("ngay_binh_luan").toString()));
            	lbl.add(bl);
            }
        } catch (Exception e) {
            throw new RuntimeException("Khong the xoa", e);
        }
		return lbl;
	}
		

}
