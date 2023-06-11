package cf.laptrinhweb.btl.repository.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	                    ngay_binh_luan,
	                    ma_binh_luan_tra_loi
	                ) VALUES (?, ?, ?,?,?)
	            """, Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, binhLuan.getNoi_dung_binh_luan());
	            ps.setLong(2, binhLuan.getNguoi_binh_luan().getMaNguoiDung());
	            ps.setLong(3, binhLuan.getSan_pham().getMaSanPham());
	            ps.setTimestamp(4,Timestamp.from(binhLuan.getNgay_binh_luan().toInstant()));
	            ps.setLong(5, binhLuan.getMa_binh_luan_tra_loi());
	            ps.executeUpdate();
	            ResultSet rs = ps.getGeneratedKeys();
	            rs.next();
	            binhLuan.setId(rs.getLong(1));
	        } catch (Exception e) {
	            throw new RuntimeException("Khong the them binh luan", e);
	        }
		
	}

	@Override
	public void xoaBinhLuan(Long ma_binh_luan,Long ma_nguoi_dung) {
		// TODO Auto-generated method stub
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                delete 
                from binh_luan 
                where ma_binh_luan = ?
                and ma_nguoi_dung = ?
            """);
            ps.setLong(1,ma_binh_luan);
            ps.setLong(2,ma_nguoi_dung);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Khong the xoa", e);
        }
		
	}

	@Override
	public List<BinhLuan> layTatCaBinhLuan(Long ma_san_pham) {
		// TODO Auto-generated method stub
		List<BinhLuan> lbl = new ArrayList<>();
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                select * 
                from binh_luan 
                where ma_san_pham = ?
                ORDER BY ngay_binh_luan DESC 
            """);
            ps.setLong(1, ma_san_pham);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	BinhLuan bl = new BinhLuan();
            	bl.setId(rs.getLong("ma_binh_luan"));
            	bl.setNoi_dung_binh_luan(rs.getString("noi_dung_binh_luan"));
            	bl.setNguoi_binh_luan(new NguoiDungRepositoryImpl().timNguoiDung(rs.getLong("ma_nguoi_dung")));
            	bl.setSan_pham(new SanPhamRepositoryImpl().timTheoMa(rs.getLong("ma_san_pham")).get());
            	bl.setNgay_binh_luan(Date.from(rs.getTimestamp("ngay_binh_luan").toInstant()));
            	bl.setMa_binh_luan_tra_loi(rs.getLong("ma_binh_luan_tra_loi"));
            	lbl.add(bl);
            }
        } catch (Exception e) {
            throw new RuntimeException("Khong the xoa", e);
        }
		return lbl;
	}

	@Override
	public List<BinhLuan> latTatCaBinhLuanTraLoi(Long ma_binh_luan) {
		List<BinhLuan> lbl = new ArrayList<>();
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                select * 
                from binh_luan 
                where ma_binh_luan_tra_loi = ?
                ORDER BY ngay_binh_luan DESC 
            """);
            ps.setLong(1, ma_binh_luan);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	BinhLuan bl = new BinhLuan();
            	bl.setId(rs.getLong("ma_binh_luan"));
            	bl.setNoi_dung_binh_luan(rs.getString("noi_dung_binh_luan"));
            	bl.setNguoi_binh_luan(new NguoiDungRepositoryImpl().timNguoiDung(rs.getLong("ma_nguoi_dung")));
            	bl.setSan_pham(new SanPhamRepositoryImpl().timTheoMa(rs.getLong("ma_san_pham")).get());
            	bl.setNgay_binh_luan(Date.from(rs.getTimestamp("ngay_binh_luan").toInstant()));
            	bl.setMa_binh_luan_tra_loi(rs.getLong("ma_binh_luan_tra_loi"));
            	System.out.println(1);
            	System.out.print(bl.getMa_binh_luan_tra_loi());
            	lbl.add(bl);
            }
        } catch (Exception e) {
            throw new RuntimeException("Khong the lay tra loi", e);
        }
		return lbl;
		
	}
		

}