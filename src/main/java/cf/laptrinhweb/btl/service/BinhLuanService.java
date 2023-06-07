package cf.laptrinhweb.btl.service;

import java.util.List;

import cf.laptrinhweb.btl.entity.BinhLuan;

public interface BinhLuanService{
	public void themBinhLuan(BinhLuan binh_luan);
	public void xoaBinhLuan(BinhLuan binh_luan);
	public List<BinhLuan> layTatCaBinhLuan();
}
