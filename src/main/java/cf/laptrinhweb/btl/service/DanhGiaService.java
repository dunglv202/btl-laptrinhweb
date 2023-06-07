package cf.laptrinhweb.btl.service;

import java.util.List;

import cf.laptrinhweb.btl.entity.DanhGia;

public interface DanhGiaService {
	public void themDanhGia(DanhGia danhGia);
	public void xoaDanhGia(DanhGia danhGia);
	public List<DanhGia> layTatCaDanhGia();
}
