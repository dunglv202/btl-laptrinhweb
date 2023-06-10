package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.DatHang;
import java.util.List;
import cf.laptrinhweb.btl.entity.*;

public interface DatHangRepository extends JdbcRepository{
	void themDatHang(DatHang datHang);
	List<DatHang> layTatCaCuaNguoiDung(NguoiDung nguoidung);
	DatHang layDonTheoMaDatHang(Long maDatHang, NguoiDung nguoidung);
	List<DatHang> layDonTheoTrangThai(int trang_thai, int gioiHan);
	List<DatHang> layDonTheoTrangThaiVaNgayDat(int trangThai, int gioiHan);
	List<DatHang> layDonTheoTrangThaiVaTongTien(int trangThai, int gioiHan);
	List<DatHang> layDonKhongDieuKien(int gioiHan);
	void thayDoiTrangThai(Long maDatHang, int trang_thai_moi);
}
