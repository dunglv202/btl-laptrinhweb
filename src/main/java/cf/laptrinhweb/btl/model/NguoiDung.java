package cf.laptrinhweb.btl.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDateTime thoiGianTao;
    private List<Quyen> dsQuyen = new ArrayList<>();
}
