package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.exception.xacthuc.SaiThongTinDangNhapException;
import cf.laptrinhweb.btl.model.NguoiDung;
import cf.laptrinhweb.btl.repository.NguoiDungRepository;
import cf.laptrinhweb.btl.repository.impl.NguoiDungRepositoryImpl;
import cf.laptrinhweb.btl.service.XacThucService;

import java.util.Objects;

public class XacThucServiceImpl implements XacThucService {
    private final NguoiDungRepository nguoiDungRepository = new NguoiDungRepositoryImpl();

    @Override
    public NguoiDung dangNhap(String tenDangNhap, String matKhau) {
        Objects.requireNonNull(tenDangNhap, "Tên đăng nhập không được nhận giá trị null");
    	NguoiDung nguoiDung = nguoiDungRepository.timBangThongTinDangNhap(tenDangNhap)
            .orElseThrow(SaiThongTinDangNhapException::new);
        if (!nguoiDung.getMatKhau().equals(matKhau))
            throw new SaiThongTinDangNhapException();
        return nguoiDung;
    }
}
