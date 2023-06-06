package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.DatHang;

public interface DatHangRepository extends JdbcRepository{
	void themDatHang(DatHang datHang);
	int laySoLuong();
}
