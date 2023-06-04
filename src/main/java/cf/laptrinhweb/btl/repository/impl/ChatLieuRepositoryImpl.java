package cf.laptrinhweb.btl.repository.impl;

import cf.laptrinhweb.btl.entity.ChatLieu;
import cf.laptrinhweb.btl.entity.TheLoai;
import cf.laptrinhweb.btl.mapper.ChatLieuMapper;
import cf.laptrinhweb.btl.mapper.TheLoaiMapper;
import cf.laptrinhweb.btl.repository.ChatLieuRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChatLieuRepositoryImpl implements ChatLieuRepository {
    @Override
    public List<ChatLieu> layTatCa() {
        try (Connection ketNoi = moKetNoi()) {
            PreparedStatement ps = ketNoi.prepareStatement("""
                SELECT * FROM chat_lieu
            """);
            ResultSet resultSet = ps.executeQuery();
            List<ChatLieu> dsChatLieu = new ArrayList<>();
            ChatLieuMapper mapper = new ChatLieuMapper();
            while (resultSet.next()) {
                dsChatLieu.add(mapper.map(resultSet));
            }
            return dsChatLieu;
        } catch (Exception e) {
            throw new RuntimeException("Khong the lay danh sach the loai", e);
        }
    }
}
