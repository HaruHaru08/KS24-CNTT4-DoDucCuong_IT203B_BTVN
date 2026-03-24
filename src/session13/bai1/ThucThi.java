package session13.bai1;

import session11.bai1.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThucThi {
    public void capPhatThuoc(int medicineId, int patientId) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            // Sử dụng DBContext để lấy kết nối
            conn = DBContext.getConnection();

            conn.setAutoCommit(false);

            // Thao tác 1: Trừ thuốc
            String sqlUpdateInventory =
                    "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
            ps1 = conn.prepareStatement(sqlUpdateInventory);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            // Giả lập lỗi để test transaction rollback
            // int x = 10 / 0;

            // Thao tác 2: Ghi lịch sử
            // Lưu ý: GETDATE() là hàm của SQL Server. Nếu dùng MySQL thì dùng NOW() hoặc CURRENT_TIMESTAMP
            String sqlInsertHistory =
                    "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
            ps2 = conn.prepareStatement(sqlInsertHistory);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Cấp phát thuốc thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Đã rollback transaction.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }

            System.out.println("Có lỗi xảy ra: " + e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                DBContext.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
