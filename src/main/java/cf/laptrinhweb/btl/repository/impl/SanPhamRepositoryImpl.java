package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.entity.DanhGia;
import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.mapper.SanPhamMapper;
import cf.laptrinhweb.btl.model.DieuKienSanPham;
import cf.laptrinhweb.btl.model.ThongTinSanPham;
import cf.laptrinhweb.btl.repository.SanPhamRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SanPhamRepositoryImpl implements SanPhamRepository {
    @Override
    public SanPham taoMoi(ThongTinSanPham thongTinSanPham) {
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
                    ma_thuong_hieu,
                    da_an)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """, Statement.RETURN_GENERATED_KEYS);
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
            ps.setBoolean(11, thongTinSanPham.isDaAn());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            return SanPham.builder().maSanPham(resultSet.getLong(1)).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<SanPham> timTheoMa(Long maSanPham) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT *
                FROM san_pham
                LEFT JOIN the_loai tl
                    ON san_pham.ma_the_loai = tl.ma_the_loai
                LEFT JOIN thuong_hieu th
                    ON san_pham.ma_thuong_hieu = th.ma_thuong_hieu
                LEFT JOIN chat_lieu cl
                    ON san_pham.ma_chat_lieu = cl.ma_chat_lieu
                WHERE ma_san_pham = ?
            """);
            ps.setLong(1, maSanPham);
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next() ? Optional.of(new SanPhamMapper().map(resultSet)) : Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException("Khong the tim san pham theo ma", e);
        }
    }

    @Override
    public List<SanPham> timTatCa(DieuKienSanPham dieuKien) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT *
                FROM san_pham
                LEFT JOIN the_loai tl
                    ON san_pham.ma_the_loai = tl.ma_the_loai
                LEFT JOIN thuong_hieu th
                    ON san_pham.ma_thuong_hieu = th.ma_thuong_hieu
                LEFT JOIN chat_lieu cl
                    ON san_pham.ma_chat_lieu = cl.ma_chat_lieu
                WHERE ( ? IS NUll OR da_an = ?)
            """);
            ps.setBoolean(1, dieuKien.getDaAn());
            ps.setBoolean(2, dieuKien.getDaAn());
            ResultSet resultSet = ps.executeQuery();
            List<SanPham> danhSachSanPham = new ArrayList<>();
            SanPhamMapper mapper = new SanPhamMapper();
            while (resultSet.next()) {
                danhSachSanPham.add(mapper.map(resultSet));
            }
            return danhSachSanPham;
        } catch (Exception e) {
            throw new RuntimeException("Khong the tim san pham theo ma", e);
        }
    }

	@Override
	public SanPham timSanPham(Long ma_san_pham) {
        SanPham sp = new SanPham();
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                select * from san_pham
                WHERE ma_san_pham = ?
            """);
            ps.setLong(1, ma_san_pham);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	sp.setMaSanPham(rs.getLong("ma_san_pham"));
            	sp.setAnhXemTruoc(rs.getString("anh_xem_truoc"));
            	sp.setTenSanPham(rs.getString("ten_san_pham"));
            	sp.setMoTa(rs.getString("mo_ta"));
            	sp.setGia(rs.getDouble("gia"));
            	sp.setSoLuong(rs.getInt("so_luong"));
            	sp.setSoDanhGia(rs.getInt("so_danh_gia"));
            	sp.setDiemTrungBinh(rs.getDouble("diem_trung_binh"));
            	sp.setDaAn(rs.getBoolean("da_an"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		return sp;
    }
	public void giamSoLuong(Long maSanPham, int soLuongGiam) {
		try (Connection ketNoi = moKetNoi()) {
			PreparedStatement ps = ketNoi.prepareStatement("""
                UPDATE san_pham
                SET so_luong = ?
                WHERE ma_san_pham = ?
            """);
			ps.setInt(1, this.timTheoMa(maSanPham).get().getSoLuong() - soLuongGiam);
			ps.setLong(2, maSanPham);
			ps.executeUpdate();
		}
		catch(Exception e) {
			throw new RuntimeException("Khong the giam so luong san pham", e);
		}
	}

	@Override
	public void capNhatDanhGia(DanhGia dg, Long maSanPham) {
		SanPham sp = this.timSanPham(maSanPham);
		int so_danh_gia = sp.getSoDanhGia()+1;
		double diem_danh_gia = (sp.getDiemTrungBinh()*sp.getSoDanhGia()+dg.getSoDiemDanhGia())/so_danh_gia;
		
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                update san_pham
                set so_danh_gia = ?, diem_trung_binh = ?
                where ma_san_pham = ?
            """);
            ps.setInt(1, so_danh_gia);
            ps.setDouble(2,diem_danh_gia);
            ps.setLong(3,maSanPham);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		
	}
	
}
