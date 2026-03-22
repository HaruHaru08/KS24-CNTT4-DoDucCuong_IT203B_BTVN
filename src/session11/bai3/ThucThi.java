package session11.bai3;

import session11.bai1.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ThucThi {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập ID giường cần cập nhật trạng thái: ");
            int inputId = scanner.nextInt();

            conn = DBContext.getConnection();

            // SQL update statement
            String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";
            ps = conn.prepareStatement(sql);

            // Set parameters
            ps.setString(1, "Occupied");
            ps.setInt(2, inputId);

            // Execute update
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cập nhật giường thành công!");
            } else {
                System.out.println("Lỗi: Mã giường không tồn tại!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DBContext.closeConnection(conn);
            scanner.close();
        }
    }
}
