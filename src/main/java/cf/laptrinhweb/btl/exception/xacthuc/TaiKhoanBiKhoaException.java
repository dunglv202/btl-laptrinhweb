package cf.laptrinhweb.btl.exception.xacthuc;

public class TaiKhoanBiKhoaException extends RuntimeException {
    public TaiKhoanBiKhoaException() {
        super("Tài khoản của bạn đã bị khoá. Liên hệ quản trị viên để biết thêm chi tiết");
    }
}
