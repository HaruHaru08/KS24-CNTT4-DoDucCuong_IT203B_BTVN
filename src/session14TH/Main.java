package session14TH;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/db_ss14th";
    private static final String USER = "root";
    private static final String PASS = "Cuong250806@";

    public static void main(String[] args) {
        int senderId=1;
        int receiverId=2;
        double amount=500;

        Connection conn=null;
        try {
            conn= DriverManager.getConnection(URL,USER,PASS);
            conn.setAutoCommit(false);
            if (!checkAccount(conn, senderId, amount)) {
                throw new Exception("Tài khoản không tồn tại hoặc không đủ số dư!");
            }

            CallableStatement callStmt = conn.prepareCall("{CALL sp_UpdateBalance(?, ?)}");

            // Trừ tiền tài khoản A
            callStmt.setInt(1, senderId);
            callStmt.setDouble(2, -amount);
            callStmt.executeUpdate();

            // Cộng tiền tài khoản B
            callStmt.setInt(1, receiverId);
            callStmt.setDouble(2, amount);
            callStmt.executeUpdate();

            // 4. Commit nếu mọi thứ OK
            conn.commit();
            System.out.println("Chuyển khoản thành công!");

            // 5. Hiển thị kết quả
            showAccounts(conn, senderId, receiverId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean checkAccount(Connection conn, int accountId, double amount) throws SQLException {

        String sql = "SELECT balance FROM accounts WHERE account_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, accountId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            double balance = rs.getDouble("balance");
            return balance >= amount;
        }
        return false;
    }
    private static void showAccounts(Connection conn, int acc1, int acc2) throws SQLException {

        String sql = "SELECT * FROM accounts WHERE account_id IN (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, acc1);
        ps.setInt(2, acc2);

        ResultSet rs = ps.executeQuery();

        System.out.println("\n===== Kết Quả Sau Giao Dịch =====");
        System.out.printf("%-10s %-15s\n", "Account", "Balance");

        while (rs.next()) {
            System.out.printf("%-10d %-15.2f\n",
                    rs.getInt("account_id"),
                    rs.getDouble("balance"));
        }
    }
}
