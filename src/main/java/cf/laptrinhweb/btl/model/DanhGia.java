package cf.laptrinhweb.btl.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DanhGia {
    private Long id;
    private String comment;
    private Boolean like;
    private Integer vote;
    private Long sanPham_id;
}
