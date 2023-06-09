package cf.laptrinhweb.btl.service.impl;

import java.util.List;

import cf.laptrinhweb.btl.entity.BinhLuan;
import cf.laptrinhweb.btl.repository.BinhLuanRepository;
import cf.laptrinhweb.btl.repository.impl.BinhLuanRepositoryImpl;
import cf.laptrinhweb.btl.service.BinhLuanService;

public class BinhLuanServiceImpl implements BinhLuanService{
	public final BinhLuanRepository binhLuanRepository = new BinhLuanRepositoryImpl();
	@Override
	public void themBinhLuan(BinhLuan binh_luan) {
		// TODO Auto-generated method stub
		binhLuanRepository.themBinhLuan(binh_luan);
	}

	@Override
	public void xoaBinhLuan(Long ma_binh_luan,Long ma_nguoi_dung) {
		// TODO Auto-generated method stub
		binhLuanRepository.xoaBinhLuan(ma_binh_luan,ma_nguoi_dung);
		
	}

	@Override
	public List<BinhLuan> layTatCaBinhLuan(Long ma_san_pham) {
		// TODO Auto-generated method stub
		return binhLuanRepository.layTatCaBinhLuan(ma_san_pham);
	}

}
