package cf.laptrinhweb.btl.repository;

import java.time.LocalDate;
import java.util.Map;

public interface ThongKeRepository extends JdbcRepository {
    Map<LocalDate, Double> thongKeDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    double layGiaTriDonTrungBinh(LocalDate ngayBatDau, LocalDate ngayKetThuc);
    double tinhTiLeHuyDon(LocalDate ngayBatDau, LocalDate ngayKetThuc);
}
