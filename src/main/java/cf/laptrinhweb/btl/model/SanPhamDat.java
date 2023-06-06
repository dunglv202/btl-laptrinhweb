package cf.laptrinhweb.btl.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamDat {
    private Long id;
    private Double gia;
    private int soLuong;
    private Long datHang_id;
    private Long sanPham_id;
}
