package cf.laptrinhweb.btl.entity;

import cf.laptrinhweb.btl.constant.HinhThucThanhToan;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static cf.laptrinhweb.btl.constant.HinhThucThanhToan.THANH_TOAN_KHI_NHAN;

@Getter
@Setter
public class DatHang {
    // TODO: chuyen sang tieng viet va cac lop thuc the dua vao package entity, model dung de chua cac lop dieu kien hay cac lop custom khac
    private Long maDatHang;
    private String note;
    // TODO: su dung constant cho 3 muc sau trong package constant voi ten co y nghia hon hoac tao cac enum. tham khao lop QuyenNguoiDung va LoaiLoi, KhoaSession
    private HinhThucThanhToan hinhThucThanhToan = THANH_TOAN_KHI_NHAN; // vi du ve chuyen sang enum
    private int phuongThucVanChuyen;
    private int tinhTrang;

    private NguoiDung nguoiDung; // TODO: co the dung lop NguoiDung hoac KhachHang o day thay vi dung Long maKhacHang
    private String diaChiGiao; // TODO: can nhac luu dang string cho don gian, khong can luu thanh bang rieng => neu vay can them truong ten va sdt nguoi nhan
    private Date ngayTaoDon;
    private String tenNguoiNhan;
    private String sdtNhan;
}
