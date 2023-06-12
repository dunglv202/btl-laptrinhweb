package cf.laptrinhweb.btl.repository;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import java.util.*;

public interface SanPhamDatRepository extends JdbcRepository{
	void themSanPhamDat(DatHang dathang);
	List<SanPhamDat> layTatCaTheoMaDat(Long maDatHang, NguoiDung nguoiDung);
	public List<SanPhamDat> layTatCaTheoMaDatBoiQuanLy(Long maDatHang);
}
