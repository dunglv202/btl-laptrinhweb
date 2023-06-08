package cf.laptrinhweb.btl.service.impl;

import java.util.List;

import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.SanPhamDat;
import cf.laptrinhweb.btl.entity.SanPhamTrongGio;
import cf.laptrinhweb.btl.repository.GioHangRepository;
import cf.laptrinhweb.btl.service.DatHangService;
import cf.laptrinhweb.btl.entity.DatHang;
import cf.laptrinhweb.btl.repository.impl.*;
import cf.laptrinhweb.btl.repository.*;
import java.util.List;

public class DatHangServiceImpl implements DatHangService{
	private final DatHangRepository datHangRepository = new DatHangRepositoryImpl();
	private final SanPhamDatRepository sanPhamDatRepository = new SanPhamDatRepositoryImpl();
	private final SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();
	private final GioHangRepository gioHangRepository = new GioHangRepositoryImpl();
	

	@Override
	public List<SanPhamDat> layDonTheoMa(Long maDatHang, NguoiDung nguoiDung) {
		// TODO Auto-generated method stub
		
		return sanPhamDatRepository.layTatCaTheoMaDat(maDatHang, nguoiDung);
	}

	@Override
	public void themDatHang(DatHang dathang, List<SanPhamDat> danhSachSanPham, List<SanPhamTrongGio> listGio,
			NguoiDung nguoidung) {
		// TODO Auto-generated method stub
		if(listGio.size() == 0)
			return;
		for (SanPhamTrongGio i : listGio) {
			if(i.getSoLuong() > i.getSanPham().getSoLuong())
				return;
		}
        for(SanPhamDat sp : danhSachSanPham) {
        	sp.setDatHang(dathang);
        	sanPhamRepository.giamSoLuong(sp.getSanPham().getMaSanPham(), sp.getSoLuong());
        }
           
        for(SanPhamTrongGio sp : listGio) {
        	gioHangRepository.xoaGioHang(sp.getMaMucGioHang(), nguoidung.getMaNguoiDung());
        }
        
		datHangRepository.themDatHang(dathang);
		for(SanPhamDat sp : danhSachSanPham) {
			sanPhamDatRepository.themSanPhamDat(sp);
		}
		
	}

	@Override
	public List<DatHang> layTatCaCuaNguoiDung(NguoiDung nguoidung) {
		// TODO Auto-generated method stub
		List<DatHang> listDH = datHangRepository.layTatCaCuaNguoiDung(nguoidung);
		for(DatHang i : listDH) {
			i.setDanhSachSanPham(sanPhamDatRepository.layTatCaTheoMaDat(i.getMaDatHang(), nguoidung));
			i.capNhatTongTien();
		}
		return listDH;
	}

}
