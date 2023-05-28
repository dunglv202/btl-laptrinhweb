package cf.laptrinhweb.btl.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DanhGia {
    private Long id;
    // TODO: danh gia chi can cac truong: khachHangDanhGia, soDiemDanhGia(1-5) va noiDungDanhGia khong qua 256 ky tu chang han
    private Boolean like;
    private Boolean check;
    private Integer vote;

    // TODO: danh gia duoc gan voi MatHangDat (xem ben nhanh cua Hieu), khong phai gan voi san pham
    private Long sanPham_id;
}
