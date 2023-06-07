package cf.laptrinhweb.btl.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamDat {
    private Long id;
    private Double gia;
    private int soLuong;
    private Long datHang_id; // TODO: tuong tu, can nhac dung kieu la lop DatHang thay vi Long
    private Long sanPham_id;
}
