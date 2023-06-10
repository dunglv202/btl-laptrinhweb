package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.DatHang;
import java.util.List;
import cf.laptrinhweb.btl.entity.*;

public interface DatHangRepository extends JdbcRepository{
	void themDatHang(DatHang datHang);
	List<DatHang> layTatCaCuaNguoiDung(NguoiDung nguoidung);
	DatHang layDonTheoMaDatHang(Long maDatHang, NguoiDung nguoidung);
}
