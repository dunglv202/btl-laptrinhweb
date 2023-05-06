package cf.laptrinhweb.btl.exception.chung;

import cf.laptrinhweb.btl.constant.LoaiThongTinDangNhap;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class ThongTinDangNhapDaTonTaiException extends RuntimeException {
    private final Set<LoaiThongTinDangNhap> thongTinTrungLap;

    public ThongTinDangNhapDaTonTaiException(Set<LoaiThongTinDangNhap> thongTinTrungLap) {
        this.thongTinTrungLap = thongTinTrungLap;
    }
}
