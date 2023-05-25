package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.mapper.QuyenMapper;
import cf.laptrinhweb.btl.model.Quyen;
import cf.laptrinhweb.btl.repository.PhanQuyenRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhanQuyenRepositoryImpl implements PhanQuyenRepository {
    private final QuyenMapper quyenMapper = new QuyenMapper();

    @Override
    public void themQuyenChoNguoiDung(Long maNguoiDung, List<Long> quyenDuocPhan) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                INSERT INTO phan_quyen (ma_nguoi_dung, ma_quyen)
                VALUES (?, ?)
            """);
            for (long maQuyen : quyenDuocPhan) {
                ps.setLong(1, maNguoiDung);
                ps.setLong(2, maQuyen);
                ps.addBatch();
            }
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Quyen> timBangMaNguoiDung(Long maNguoiDung) {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT *
                FROM phan_quyen pq
                JOIN quyen q on pq.ma_quyen = q.ma_quyen
                WHERE ma_nguoi_dung = ?
            """);
            ps.setLong(1, maNguoiDung);
            ResultSet dsKetQua = ps.executeQuery();
            List<Quyen> dsQuyen = new ArrayList<>();
            while (dsKetQua.next()) {
                dsQuyen.add(quyenMapper.map(dsKetQua));
            }
            return dsQuyen;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
