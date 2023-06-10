package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.constant.KhoaSession;
import cf.laptrinhweb.btl.constant.LoaiThongTinDangNhap;
import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.exception.xacthuc.MatKhauKhongDungException;
import cf.laptrinhweb.btl.exception.xacthuc.TaiKhoanBiKhoaException;
import cf.laptrinhweb.btl.exception.xacthuc.ThongTinDangNhapDaTonTaiException;
import cf.laptrinhweb.btl.exception.chung.ThongTinKhongHopLeException;
import cf.laptrinhweb.btl.exception.xacthuc.SaiThongTinDangNhapException;
import cf.laptrinhweb.btl.helper.HoTroRequest;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.entity.Quyen;
import cf.laptrinhweb.btl.model.DieuKienNguoiDung;
import cf.laptrinhweb.btl.repository.NguoiDungRepository;
import cf.laptrinhweb.btl.repository.PhanQuyenRepository;
import cf.laptrinhweb.btl.repository.QuyenRepository;
import cf.laptrinhweb.btl.repository.impl.NguoiDungRepositoryImpl;
import cf.laptrinhweb.btl.repository.impl.PhanQuyenRepositoryImpl;
import cf.laptrinhweb.btl.repository.impl.QuyenRepositoryImpl;
import cf.laptrinhweb.btl.service.XacThucService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static cf.laptrinhweb.btl.constant.Patterns.*;
import static cf.laptrinhweb.btl.constant.QuyenNguoiDung.KHACH_HANG;

public class XacThucServiceImpl implements XacThucService {
    private final NguoiDungRepository nguoiDungRepository = new NguoiDungRepositoryImpl();
    private final QuyenRepository quyenRepository = new QuyenRepositoryImpl();
    private final PhanQuyenRepository phanQuyenRepository = new PhanQuyenRepositoryImpl();

    @Override
    public void dangKy(Map<String, String[]> thongTinDangKy) {
        NguoiDung nguoiDung = taoNguoiDung(thongTinDangKy);
        kiemTraThongTin(nguoiDung);
        nguoiDungRepository.taoMoiNguoiDung(nguoiDung);
        themQuyenChoNguoiDung(nguoiDung, Set.of(KHACH_HANG));
    }

    private void kiemTraThongTin(NguoiDung nguoiDung) {
        if (nguoiDung.getTenHienThi().isBlank()
            || !nguoiDung.getTenDangNhap().matches(TEN_DANG_NHAP.pattern())
            || !nguoiDung.getMatKhau().matches(MAT_KHAU.pattern())
            || !nguoiDung.getEmail().matches(EMAIL.pattern())
            || !nguoiDung.getSoDienThoai().matches(SO_DIEN_THOAI.pattern())) {
            throw new ThongTinKhongHopLeException();
        }
        Set<LoaiThongTinDangNhap> thongTinTrungLap = new HashSet<>();
        if (nguoiDungRepository.tonTaiVoiTenDangNhap(nguoiDung.getTenDangNhap()))
            thongTinTrungLap.add(LoaiThongTinDangNhap.TEN_DANG_NHAP);
        if (nguoiDungRepository.tonTaiVoiEmail(nguoiDung.getEmail()))
            thongTinTrungLap.add(LoaiThongTinDangNhap.EMAIL);
        if (nguoiDungRepository.tonTaiVoiSoDienThoai(nguoiDung.getSoDienThoai()))
            thongTinTrungLap.add(LoaiThongTinDangNhap.SO_DIEN_THOAI);
        if (!thongTinTrungLap.isEmpty())
            throw new ThongTinDangNhapDaTonTaiException(thongTinTrungLap);
    }

    private NguoiDung taoNguoiDung(Map<String, String[]> thongTinDangKy) {
        return NguoiDung.builder()
            .tenDangNhap(thongTinDangKy.get("tenDangNhap")[0])
            .matKhau(thongTinDangKy.get("matKhau")[0])
            .email(thongTinDangKy.get("email")[0])
            .soDienThoai(thongTinDangKy.get("soDienThoai")[0])
            .tenHienThi(thongTinDangKy.get("ten")[0])
            .build();
    }

    @Override
    public NguoiDung dangNhap(String tenDangNhap, String matKhau) {
        Objects.requireNonNull(tenDangNhap, "Tên đăng nhập không được nhận giá trị null");
    	NguoiDung nguoiDung = nguoiDungRepository.timBangThongTinDangNhap(tenDangNhap)
            .orElseThrow(SaiThongTinDangNhapException::new);
        if (nguoiDung.isDaKhoa())
            throw new TaiKhoanBiKhoaException(nguoiDung.getMaNguoiDung());
        if (!nguoiDung.getMatKhau().equals(matKhau)) {
            nguoiDungRepository.tangCoGangDangNhap(nguoiDung);
            if (nguoiDung.getCoGangDangNhap() >= 4) {
                doiTrangThaiTaiKhoan(nguoiDung.getMaNguoiDung(), true);
                throw new TaiKhoanBiKhoaException(nguoiDung.getMaNguoiDung());
            }
            throw new SaiThongTinDangNhapException(nguoiDung.getMaNguoiDung());
        }
        List<Quyen> dsQuyen = phanQuyenRepository.timBangMaNguoiDung(nguoiDung.getMaNguoiDung());
        nguoiDung.setDsQuyen(dsQuyen);
        nguoiDungRepository.resetCoGangDangNhap(nguoiDung.getMaNguoiDung());
        return nguoiDung;
    }

    @Override
    public void doiMatKhau(HttpServletRequest req) {
        String matKhauCu = req.getParameter("matKhauCu");
        String matKhauMoi = req.getParameter("matKhauMoi");
        if (matKhauMoi == null || matKhauCu == null || matKhauCu.isBlank() || matKhauMoi.isBlank()) {
            throw new ThongTinKhongHopLeException();
        }

        // kiem tra mat khau cu chinh xac hay khong
        NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(req);
        if (!nguoiDung.getMatKhau().equals(matKhauCu)) {
            throw new MatKhauKhongDungException();
        }
        // doi mat khau moi
        nguoiDungRepository.doiMatKhau(nguoiDung, matKhauMoi);
    }

    @Override
    public List<NguoiDung> timNguoiDung(DieuKienNguoiDung dieuKien) {
        List<NguoiDung> dsNguoiDung = nguoiDungRepository.timTatCa(dieuKien);
        dsNguoiDung.forEach(nguoiDung -> {
            List<Quyen> dsQuyen = phanQuyenRepository.timBangMaNguoiDung(nguoiDung.getMaNguoiDung());
            nguoiDung.setDsQuyen(dsQuyen);
        });
        return dsNguoiDung;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void doiTrangThaiTaiKhoan(Long maNguoiDung, boolean khoa) {
        nguoiDungRepository.thayDoiTrangThai(maNguoiDung, khoa);
        if (khoa) {
            ((Set<Long>) HoTroRequest.servletContext.getAttribute(KhoaSession.BUOC_DANG_XUAT)).add(maNguoiDung);
        } else {
            nguoiDungRepository.resetCoGangDangNhap(maNguoiDung);
        }
    }

    @Override
    public void phanQuyen(NguoiDung nguoiDung, Set<QuyenNguoiDung> quyenDuocChon) {
        Set<QuyenNguoiDung> quyenDeThem = new HashSet<>();
        quyenDuocChon.forEach(quyen -> {
            if (!nguoiDung.coQuyen(quyen)) quyenDeThem.add(quyen);
        });
        themQuyenChoNguoiDung(nguoiDung, quyenDeThem);

        Set<QuyenNguoiDung> quyenDeHuy = new HashSet<>();
        for (Quyen quyen : nguoiDung.getDsQuyen()) {
            QuyenNguoiDung quyenSanCo = QuyenNguoiDung.valueOf(quyen.getTenQuyen());
            if (!quyenDuocChon.contains(quyenSanCo)) { // quyen duoc chon khong chua quyen hien dang co
                quyenDeHuy.add(quyenSanCo);
            }
        }
        huyQuyenNguoiDung(nguoiDung, quyenDeHuy);
    }

    private void themQuyenChoNguoiDung(NguoiDung nguoiDung, Set<QuyenNguoiDung> quyenDuocPhan) {
        if (quyenDuocPhan.isEmpty()) return;
        phanQuyenRepository.themQuyenChoNguoiDung(nguoiDung.getMaNguoiDung(), layDanhSachMaQuyen(quyenDuocPhan));
    }

    private void huyQuyenNguoiDung(NguoiDung nguoiDung, Set<QuyenNguoiDung> quyenDeHuy) {
        if (quyenDeHuy.isEmpty()) return;
        phanQuyenRepository.huyQuyenNguoiDung(nguoiDung.getMaNguoiDung(), layDanhSachMaQuyen(quyenDeHuy));
    }

    private List<Long> layDanhSachMaQuyen(Set<QuyenNguoiDung> dsQuyen) {
        return dsQuyen.stream().map(tenQuyen -> {
            Quyen quyen = quyenRepository.timBangTen(tenQuyen.name())
                .orElseThrow(() -> new RuntimeException("Quyen khong ton tai : " + tenQuyen));
            return quyen.getMaQuyen();
        }).toList();
    }
}
