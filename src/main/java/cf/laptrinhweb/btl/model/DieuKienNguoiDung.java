package cf.laptrinhweb.btl.model;

import lombok.*;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DieuKienNguoiDung extends PhanTrang {
    @Builder.Default
    private Integer kichThuoc = 15;
    private Long maNguoiDung;
    private String tuKhoa = "";

    public static DieuKienNguoiDung trichXuat(HttpServletRequest request) {
        DieuKienNguoiDung dieuKienNguoiDung = DieuKienNguoiDung.builder().tuKhoa(request.getParameter("tuKhoa")).build();
        String maNguoiDungStr = request.getParameter("maNguoiDung");
        if (maNguoiDungStr != null && !maNguoiDungStr.isBlank()) {
            dieuKienNguoiDung.setMaNguoiDung(Long.parseLong(maNguoiDungStr));
        }
        String trang = request.getParameter("trang");
        if (trang != null && !trang.isBlank() && Integer.parseInt(trang) > 0)
            dieuKienNguoiDung.setTrang(Integer.parseInt(trang) - 1);
        String kichThuoc = request.getParameter("kichThuoc");
        if (kichThuoc != null && !kichThuoc.isBlank())
            dieuKienNguoiDung.setKichThuoc(Integer.parseInt(kichThuoc));
        return dieuKienNguoiDung;
    }
}
