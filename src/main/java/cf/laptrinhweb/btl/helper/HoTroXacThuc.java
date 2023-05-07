package cf.laptrinhweb.btl.helper;

import cf.laptrinhweb.btl.constant.KhoaSession;
import cf.laptrinhweb.btl.exception.xacthuc.KhongCoQuyenTruyCapException;
import cf.laptrinhweb.btl.model.NguoiDung;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HoTroXacThuc {
    public static void yeuCauQuyen(HttpServletRequest req, List<String> dsQuyenDuocPhep) {
        NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute(KhoaSession.NGUOI_DUNG);
        if (nguoiDung == null ||
            nguoiDung.getDsQuyen()
                .stream()
                .noneMatch(quyenCuaNguoiDung -> dsQuyenDuocPhep.contains(quyenCuaNguoiDung.getTenQuyen()))) {
            throw new KhongCoQuyenTruyCapException();
        }
    }
}
