package cf.laptrinhweb.btl.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NguoiDung {
    private Long maNguoiDung;
    private String tenHienThi;
    private String tenDangNhap;
    private String email;
    private String soDienThoai;
    private String matKhau;
    private Date thoiGianTao;
    private boolean daKhoa;
    private List<Quyen> dsQuyen = new ArrayList<>();

    public boolean coQuyen(QuyenNguoiDung quyen) {
        return this.dsQuyen.stream().anyMatch(q -> q.getTenQuyen().equals(quyen.name()));
    }
}
