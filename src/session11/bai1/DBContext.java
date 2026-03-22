package session11.bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    // ===== HẰNG SỐ CẤU HÌNH =====
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital_DB";
    private static final String USER = "admin";
    private static final String PASSWORD = "med123";

    // ===== LẤY CONNECTION =====
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ===== ĐÓNG CONNECTION AN TOÀN =====
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
