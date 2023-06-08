package cf.laptrinhweb.btl.service.impl;

import java.util.List;

import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import cf.laptrinhweb.btl.repository.GioHangRepository;
import cf.laptrinhweb.btl.service.DatHangService;
import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.repository.impl.*;
import cf.laptrinhweb.btl.repository.*;
import java.util.List;

public class DatHangServiceImpl implements DatHangService{
	private final DatHangRepository datHangRepository = new DatHangRepositoryImpl();
	private final SanPhamDatRepository sanPhamDatRepository = new SanPhamDatRepositoryImpl();
	
	@Override
	public void themDatHang(DatHang dathang, List<SanPhamDat> danhSachSanPham) {
		datHangRepository.themDatHang(dathang);
		for(SanPhamDat sp : danhSachSanPham) {
			sanPhamDatRepository.themSanPhamDat(sp);
		}
		// TODO Auto-generated method stub
	}

	@Override
	public List<SanPhamDat> layDonTheoMa(Long maDatHang, NguoiDung nguoiDung) {
		// TODO Auto-generated method stub
		
		return sanPhamDatRepository.layTatCaTheoMaDat(maDatHang, nguoiDung);
	}

}
