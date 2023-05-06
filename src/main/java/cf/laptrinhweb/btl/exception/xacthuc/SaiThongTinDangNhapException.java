package cf.laptrinhweb.btl.exception.xacthuc;

public class SaiThongTinDangNhapException extends RuntimeException {
    public SaiThongTinDangNhapException() {
        super("Tên đăng nhập hoặc mật khẩu không đúng");
    }
}
