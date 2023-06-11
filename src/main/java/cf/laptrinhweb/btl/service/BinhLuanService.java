package cf.laptrinhweb.btl.service;

import java.util.List;

import cf.laptrinhweb.btl.entity.BinhLuan;

public interface BinhLuanService{
	public void themBinhLuan(BinhLuan binh_luan);
	public void xoaBinhLuan(Long ma_binh_luan,Long ma_nguoi_dung);
	public List<BinhLuan> layTatCaBinhLuan(Long ma_san_pham);
	public List<BinhLuan> layTatCaBinhLuanTraLoi(Long ma_binh_luan);
}
