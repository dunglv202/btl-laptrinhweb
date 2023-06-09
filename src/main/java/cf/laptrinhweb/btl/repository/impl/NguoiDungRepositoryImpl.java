package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import cf.laptrinhweb.btl.mapper.NguoiDungMapper;
import cf.laptrinhweb.btl.model.DieuKienNguoiDung;
import cf.laptrinhweb.btl.repository.NguoiDungRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NguoiDungRepositoryImpl implements NguoiDungRepository {
    @Override
    public Optional<NguoiDung> timBangThongTinDangNhap(String thongTinDangNhap) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT  *
                FROM    nguoi_dung
                WHERE   ten_dang_nhap = ?
                        OR email = ?
                        OR so_dien_thoai = ?
            """);
            ps.setString(1, thongTinDangNhap);
            ps.setString(2, thongTinDangNhap);
            ps.setString(3, thongTinDangNhap);

            ResultSet resultSet = ps.executeQuery();
            return resultSet.next() ? Optional.of(new NguoiDungMapper().map(resultSet)) : Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean tonTaiVoiTenDangNhap(String tenDangNhap) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT  TRUE
                FROM    nguoi_dung
                WHERE   ten_dang_nhap = ?
            """);
            ps.setString(1, tenDangNhap);
            return ps.executeQuery().next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean tonTaiVoiEmail(String email) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT  TRUE
                FROM    nguoi_dung
                WHERE   email = ?
            """);
            ps.setString(1, email);
            return ps.executeQuery().next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean tonTaiVoiSoDienThoai(String soDienThoai) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT  TRUE
                FROM    nguoi_dung
                WHERE   so_dien_thoai = ?
            """);
            ps.setString(1, soDienThoai);
            return ps.executeQuery().next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void taoMoiNguoiDung(NguoiDung nguoiDung) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO nguoi_dung (
                    ten_hien_thi,
                    ten_dang_nhap,
                    email,
                    so_dien_thoai,
                    mat_khau,
                    thoi_gian_tao)
                VALUES (?, ?, ?, ?, ?, ?)
            """, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nguoiDung.getTenHienThi());
            ps.setString(2, nguoiDung.getTenDangNhap());
            ps.setString(3, nguoiDung.getEmail());
            ps.setString(4, nguoiDung.getSoDienThoai());
            ps.setString(5, nguoiDung.getMatKhau());
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            nguoiDung.setMaNguoiDung(resultSet.getLong(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doiMatKhau(NguoiDung nguoiDung, String matKhauMoi) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                UPDATE nguoi_dung
                SET mat_khau = ?
                WHERE ma_nguoi_dung = ?
            """);
            ps.setString(1, matKhauMoi);
            ps.setLong(2, nguoiDung.getMaNguoiDung());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NguoiDung> timTatCa(DieuKienNguoiDung dieuKien) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps;
            if (dieuKien.getMaNguoiDung() == null) {
                ps = timTheoTuKhoa(ketNoi, dieuKien);
            } else {
                ps = timTheoMa(ketNoi, dieuKien.getMaNguoiDung());
            }

            ResultSet resultSet = ps.executeQuery();
            NguoiDungMapper mapper = new NguoiDungMapper();
            List<NguoiDung> dsNguoiDung = new ArrayList<>();
            while (resultSet.next()) {
                dsNguoiDung.add(mapper.map(resultSet));
            }
            return dsNguoiDung;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement timTheoTuKhoa(Connection ketNoi, DieuKienNguoiDung dieuKien) throws SQLException {
        PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT *
                FROM nguoi_dung
                WHERE
                    ten_dang_nhap LIKE ?
                    OR email LIKE ?
                    OR so_dien_thoai LIKE ?
                LIMIT ?, ?
            """);
        String tuKhoa = dieuKien.getTuKhoa()!=null ? dieuKien.getTuKhoa() + "%" : "%";
        ps.setString(1, tuKhoa);
        ps.setString(2, tuKhoa);
        ps.setString(3, tuKhoa);
        ps.setInt(4, dieuKien.getTrang() * dieuKien.getKichThuoc());
        ps.setInt(5, dieuKien.getKichThuoc());
        return ps;
    }

    private PreparedStatement timTheoMa(Connection ketNoi, Long maNguoiDung) throws SQLException {
        PreparedStatement ps = ketNoi.prepareStatement("""
            SELECT * FROM nguoi_dung WHERE ma_nguoi_dung = ?
        """);
        ps.setLong(1, maNguoiDung);
        return ps;
    }

    @Override
    public void thayDoiTrangThai(Long maNguoiDung, boolean khoa) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                UPDATE nguoi_dung
                SET da_khoa = ?
                WHERE ma_nguoi_dung = ?
            """);
            ps.setBoolean(1, khoa);
            ps.setLong(2, maNguoiDung);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public NguoiDung timNguoiDung(Long ma_nguoi_dung) {
		// TODO Auto-generated method stub
		NguoiDung customer = new NguoiDung();
		try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                select * from nguoi_dung
                WHERE ma_nguoi_dung = ?
            """);
            ps.setLong(1, ma_nguoi_dung);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	customer.setMaNguoiDung(rs.getLong("ma_nguoi_dung"));
            	customer.setTenHienThi(rs.getString("ten_hien_thi"));
            	customer.setTenDangNhap(rs.getString("ten_dang_nhap"));
            	customer.setEmail(rs.getString("email"));
            	customer.setSoDienThoai(rs.getString("so_dien_thoai"));
            	customer.setMatKhau(rs.getString("mat_khau"));
            	customer.setDaKhoa(rs.getBoolean("da_khoa"));
            	customer.setThoiGianTao(Date.from(rs.getTimestamp("thoi_gian_tao").toInstant()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		return customer;
	}
}
