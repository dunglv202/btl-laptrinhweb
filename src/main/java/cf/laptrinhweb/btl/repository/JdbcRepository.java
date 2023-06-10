package cf.laptrinhweb.btl.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public interface JdbcRepository {
    default Connection moKetNoi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "root", "123456");
        } catch (Exception e) {
            System.err.println("Không thể kết nối đến CSDL");
            throw new RuntimeException(e);
        }
    }
}
