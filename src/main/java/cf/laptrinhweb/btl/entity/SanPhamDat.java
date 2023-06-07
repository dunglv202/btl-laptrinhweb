package cf.laptrinhweb.btl.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamDat {
    private Long id;
    private Double gia;
    private int soLuong;
    private DatHang datHang; // TODO: tuong tu, can nhac dung kieu la lop DatHang thay vi Long
    private SanPham sanPham;
}
