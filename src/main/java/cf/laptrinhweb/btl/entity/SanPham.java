package cf.laptrinhweb.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SanPham {
    private Long maSanPham;
    private String tenSanPham;
    private String moTa;
    private TheLoai theLoai;
    private Double gia;
    private Integer soLuong;
}
