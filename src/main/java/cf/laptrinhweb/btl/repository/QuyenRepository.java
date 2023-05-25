package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.model.Quyen;

import java.util.Optional;

public interface QuyenRepository extends JdbcRepository<Quyen> {
    Optional<Quyen> timBangTen(String tenQuyen);
}
