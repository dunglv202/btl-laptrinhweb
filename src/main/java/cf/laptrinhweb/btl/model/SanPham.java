package cf.laptrinhweb.btl.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPham {
    private Long id;
    private Double gia;
    private int soLuong;
    private Long sanPham_id;
}
