package cf.laptrinhweb.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnhSanPham {
    private Long maAnh;
    private SanPham sanPham;
    private String duongDan;
}
