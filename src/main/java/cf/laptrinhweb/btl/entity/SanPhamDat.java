package cf.laptrinhweb.btl.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamDat {
    private Long id;
    private Double gia;
    private int soLuong;
    private SanPham sanPham;
}
