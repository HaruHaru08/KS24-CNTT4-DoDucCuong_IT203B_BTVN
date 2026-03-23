package session12.bai2;

public class ThucThi {
    String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ?, blood_pressure = ? " +
            "WHERE p_id = ?";

    PreparedStatement pstmt = conn.prepareStatement(sql);

    // Gán giá trị
    pstmt.setDouble(1, temp);
    pstmt.setInt(2, heartRate);
    pstmt.setString(3, bloodPressure);
    pstmt.setInt(4, patientId);

    // Thực thi
    int rows = pstmt.executeUpdate();

    if (rows > 0) {
        System.out.println("Cập nhật thành công!");
    } else {
        System.out.println("Không tìm thấy bệnh nhân!");
    }
}
