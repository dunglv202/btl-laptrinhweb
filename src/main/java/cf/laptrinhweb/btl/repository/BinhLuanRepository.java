package cf.laptrinhweb.btl.repository;

import java.util.List;

import cf.laptrinhweb.btl.entity.BinhLuan;

public interface BinhLuanRepository extends JdbcRepository{
	public void themBinhLuan(BinhLuan binhLuan);
	public void xoaBinhLuan(BinhLuan binhLuan);
	public List<BinhLuan> layTatCaBinhLuan();
}
