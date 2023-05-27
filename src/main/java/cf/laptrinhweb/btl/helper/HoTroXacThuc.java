package cf.laptrinhweb.btl.helper;

import cf.laptrinhweb.btl.constant.KhoaSession;
import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.exception.xacthuc.KhongCoQuyenTruyCapException;
import cf.laptrinhweb.btl.model.NguoiDung;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HoTroXacThuc {
    public static void yeuCauQuyen(HttpServletRequest req, List<QuyenNguoiDung> dsQuyenDuocPhep) {
        NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute(KhoaSession.NGUOI_DUNG);
        List<String> cacQuyenDuocPhep = dsQuyenDuocPhep.stream().map(QuyenNguoiDung::name).toList();
        if (nguoiDung == null ||
            nguoiDung.getDsQuyen()
                .stream()
                .noneMatch(quyenCuaNguoiDung -> cacQuyenDuocPhep.contains(quyenCuaNguoiDung.getTenQuyen()))) {
            throw new KhongCoQuyenTruyCapException();
        }
    }

    public static void yeuCauDangNhap(HttpServletRequest req) {
        if (req.getSession().getAttribute(KhoaSession.NGUOI_DUNG) == null) {
            throw new KhongCoQuyenTruyCapException();
        }
    }

    public static NguoiDung nguoiDungHienTai(HttpServletRequest req) {
        return (NguoiDung) req.getSession().getAttribute(KhoaSession.NGUOI_DUNG);
    }
}
