package cf.laptrinhweb.btl.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public interface JdbcRepository {
    default Connection moKetNoi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://containers-us-west-128.railway.app:6886/railway", "root", "8LdOh1XvR77n25yJjnXK");
        } catch (Exception e) {
            System.err.println("Không thể kết nối đến CSDL");
            throw new RuntimeException(e);
        }
    }
}
