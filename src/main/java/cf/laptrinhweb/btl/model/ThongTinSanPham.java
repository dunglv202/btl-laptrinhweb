package cf.laptrinhweb.btl.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ThongTinSanPham {
    private String ten;
    private String moTa;
    private String anhXemTruoc;
    private Long maTheLoai;
    private Double gia;
    private Integer soLuong;
    private Long maChatLieu;
    private Long maThuongHieu;
    private String kichThuoc;
    private Double trongLuong;
}
