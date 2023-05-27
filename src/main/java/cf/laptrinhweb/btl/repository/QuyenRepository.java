package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.Quyen;

import java.util.Optional;

public interface QuyenRepository extends JdbcRepository<Quyen> {
    Optional<Quyen> timBangTen(String tenQuyen);
}
