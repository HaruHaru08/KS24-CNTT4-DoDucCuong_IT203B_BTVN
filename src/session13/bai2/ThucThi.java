package session13.bai2;

import session11.bai1.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThucThi {
    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            // Thay thế DatabaseManager.getConnection() bằng DBContext.getConnection()
            conn = DBContext.getConnection();
            
            // 1. Tắt tự động lưu giao dịch
            conn.setAutoCommit(false);

            // Thao tác 1: Trừ tiền trong ví
            String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            ps1 = conn.prepareStatement(sqlDeductWallet);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            // Thao tác 2: Cập nhật trạng thái hóa đơn
            String sqlUpdateInvoice = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";
            ps2 = conn.prepareStatement(sqlUpdateInvoice);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            // 2. Xác nhận giao dịch thành công
            conn.commit();
            System.out.println("Thanh toán hoàn tất!");

        } catch (SQLException e) {
            System.err.println("Lỗi hệ thống: " + e.getMessage());

            if (conn != null) {
                try {
                    System.out.println("Đang thực hiện Rollback dữ liệu...");
                    conn.rollback(); // Khôi phục lại trạng thái ban đầu
                    System.out.println("Rollback thành công. Dữ liệu đã an toàn.");
                } catch (SQLException ex) {
                    System.err.println("Lỗi nghiêm trọng: Không thể rollback! Chi tiết: " + ex.getMessage());
                }
            }
        } finally {
            // Đảm bảo đóng kết nối để giải phóng tài nguyên
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (conn != null) {
                    conn.setAutoCommit(true); // Trả lại trạng thái mặc định cho Connection Pool
                    DBContext.closeConnection(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
