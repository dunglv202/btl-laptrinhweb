package cf.laptrinhweb.btl.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DieuKienNguoiDung extends PhanTrang {
    private Long maNguoiDung;
    private String tuKhoa = "";
}
