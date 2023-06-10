package cf.laptrinhweb.btl.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BanGhiDuLieu {
    private String nhan;
    private Number giaTri;
    public static BanGhiDuLieu of(String nhan, Number giaTri) {
        BanGhiDuLieu banGhiDuLieu = new BanGhiDuLieu();
        banGhiDuLieu.nhan = nhan;
        banGhiDuLieu.giaTri = giaTri;
        return banGhiDuLieu;
    }
}
