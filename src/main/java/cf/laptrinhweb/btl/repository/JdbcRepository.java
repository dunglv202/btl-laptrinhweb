package cf.laptrinhweb.btl.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public interface JdbcRepository {
    default Connection moKetNoi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//<<<<<<< HEAD
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/btl_ltw", "root", "admin");
//=======
//            return DriverManager.getConnection("jdbc:mysql://btl-ltw.cgg1solrwn4m.ap-southeast-1.rds.amazonaws.com:3306/btl_ltw", "admin", "FU5O335PdjuKZqgS");
//>>>>>>> main
        } catch (Exception e) {
            System.err.println("Không thể kết nối đến CSDL");
            throw new RuntimeException(e);
        }
    }
}
