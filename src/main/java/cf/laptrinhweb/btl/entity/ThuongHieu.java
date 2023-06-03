package cf.laptrinhweb.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ThuongHieu {
    private Long maThuongHieu;
    private String tenThuongHieu;
}
