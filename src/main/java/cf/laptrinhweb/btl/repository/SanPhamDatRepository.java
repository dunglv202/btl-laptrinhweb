package cf.laptrinhweb.btl.repository;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import java.util.*;

public interface SanPhamDatRepository extends JdbcRepository{
	void themSanPhamDat(SanPhamDat sanpham);
	List<SanPhamDat> layTatCaTheoMaDat(Long maDatHang, NguoiDung nguoiDung);
	Long timMaSanPham(Long ma_san_pham_dat);
}
