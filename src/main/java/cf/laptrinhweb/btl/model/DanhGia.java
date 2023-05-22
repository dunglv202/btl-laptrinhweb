package cf.laptrinhweb.btl.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DanhGia {
    private Long id;
    private Boolean like;

    private Boolean check;
    private Integer vote;
    private Long sanPham_id;
}
