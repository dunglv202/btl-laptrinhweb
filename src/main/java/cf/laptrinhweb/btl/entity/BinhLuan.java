package cf.laptrinhweb.btl.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinhLuan {
	private Long id;
	private String noi_dung_binh_luan;
	private SanPham san_pham;
	private Date ngay_binh_luan;
	private NguoiDung nguoi_binh_luan;
}
