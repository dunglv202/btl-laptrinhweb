package cf.laptrinhweb.btl.repository;

import java.util.List;

import cf.laptrinhweb.btl.entity.DanhGia;

public interface DanhGiaRepository extends JdbcRepository{
	public void themDanhGia(DanhGia danhGia);
	public void xoaDanhGia(DanhGia danhGia);
	public List<DanhGia> layTatCaDanhGia();
}
