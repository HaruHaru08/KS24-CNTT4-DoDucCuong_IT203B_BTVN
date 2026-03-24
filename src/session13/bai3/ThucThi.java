package session13.bai3;

import session11.bai1.DBContext;
import java.sql.*;

public class ThucThi {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) throws Exception {
        Connection conn = null;
        PreparedStatement psCheck = null;
        PreparedStatement psUpdateWallet = null;
        PreparedStatement psUpdateBed = null;
        PreparedStatement psUpdatePatient = null;
        ResultSet rs = null;

        try {
            // Sửa lỗi: Thay DatabaseManager.getConnection() bằng DBContext.getConnection()
            conn = DBContext.getConnection();
            
            // BẮT ĐẦU TRANSACTION
            conn.setAutoCommit(false);

            // --- BẪY 1: KIỂM TRA SỐ DƯ (BUSINESS LOGIC) ---
            String sqlCheck = "SELECT so_du_tam_ung FROM BenhNhan WHERE ma_bn = ?";
            psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setInt(1, maBenhNhan);
            rs = psCheck.executeQuery();

            if (rs.next()) {
                double soDuHienTai = rs.getDouble("so_du_tam_ung");
                if (soDuHienTai < tienVienPhi) {
                    throw new Exception("LỖI: Số dư tạm ứng không đủ (Hiện có: " + soDuHienTai + ")");
                }
            } else {
                throw new Exception("LỖI: Không tìm thấy bệnh nhân mã " + maBenhNhan);
            }

            // --- BƯỚC 1: TRỪ TIỀN VIỆN PHÍ ---
            // Sửa logic: Lúc này mới trừ tiền.
            // Sử dụng PreparedStatement riêng để trừ tiền
            String sql1 = "UPDATE BenhNhan SET so_du_tam_ung = so_du_tam_ung - ? WHERE ma_bn = ?";
            psUpdateWallet = conn.prepareStatement(sql1);
            psUpdateWallet.setDouble(1, tienVienPhi);
            psUpdateWallet.setInt(2, maBenhNhan);
            int rowsWallet = psUpdateWallet.executeUpdate();
             if (rowsWallet == 0) {
                 throw new Exception("LỖI: Không thể trừ tiền bệnh nhân!");
             }

            // --- BƯỚC 2: GIẢI PHÓNG GIƯỜNG BỆNH ---
            // Sửa câu lệnh SQL: Bỏ điều kiện AND ma_bn_thue = NULL vì logic là set NULL
            // Nhưng câu lệnh gốc: "UPDATE GiuongBenh SET trang_thai = 'TRONG', ma_bn_thue = NULL WHERE ma_bn_thue = ?"
            // là đúng, tìm giường đang được thuê bởi BN này và giải phóng.
            String sql2 = "UPDATE GiuongBenh SET trang_thai = 'TRONG', ma_bn_thue = NULL WHERE ma_bn_thue = ?";
            psUpdateBed = conn.prepareStatement(sql2);
            psUpdateBed.setInt(1, maBenhNhan);
            int rowsBed = psUpdateBed.executeUpdate();

            // --- BẪY 2: KIỂM TRA DỮ LIỆU ẢO (ROW AFFECTED = 0) ---
            if (rowsBed == 0) {
                // Nếu không có giường nào được cập nhật, có thể mã BN sai hoặc BN không ngồi giường này
                // Có thể bệnh nhân ngoại trú không có giường?
                // Nếu bắt buộc nội trú thì throw, nếu không thì log warning.
                // Giả sử bài toán yêu cầu nội trú.
                throw new Exception("LỖI: Không thể giải phóng giường. Bệnh nhân không có giường đăng ký!");
            }

            // --- BƯỚC 3: CẬP NHẬT TRẠNG THÁI XUẤT VIỆN ---
            // Sửa câu lệnh SQL
            String sql3 = "UPDATE BenhNhan SET trang_thai = 'DA_XUAT_VIEN' WHERE ma_bn = ?";
            psUpdatePatient = conn.prepareStatement(sql3);
            psUpdatePatient.setInt(1, maBenhNhan);
            int rowsPatient = psUpdatePatient.executeUpdate();

            // KIỂM TRA BẪY 2 LẦN NỮA
            if (rowsPatient == 0) {
                throw new Exception("LỖI: Không thể cập nhật trạng thái bệnh nhân!");
            }

            // NẾU ĐẾN ĐÂY KHÔNG CÓ LỖI -> COMMIT
            conn.commit();
            System.out.println("Thanh toán và xuất viện thành công cho bệnh nhân: " + maBenhNhan);

        } catch (Exception e) {
            // NẾU CÓ BẤT KỲ LỖI NÀO (LOGIC HOẶC SQL) -> ROLLBACK NGAY LẬP TỨC
            if (conn != null) {
                try {
                    System.out.println("Đang thực hiện Rollback hệ thống do: " + e.getMessage());
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e; // Ném tiếp ra ngoài để tầng UI xử lý thông báo cho user
        } finally {
            // Giải phóng tài nguyên
            try {
                if (rs != null) rs.close();
                if (psCheck != null) psCheck.close();
                if (psUpdateWallet != null) psUpdateWallet.close();
                if (psUpdateBed != null) psUpdateBed.close();
                if (psUpdatePatient != null) psUpdatePatient.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    DBContext.closeConnection(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
