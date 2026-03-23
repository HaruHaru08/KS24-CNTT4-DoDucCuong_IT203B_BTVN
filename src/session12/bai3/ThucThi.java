package session12.bai3;

public class ThucThi {
    try {
        CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");

        // Tham số đầu vào
        cstmt.setInt(1, 505);

        // Đăng ký tham số đầu ra (vị trí 2)
        cstmt.registerOutParameter(2, java.sql.Types.DECIMAL);

        // Thực thi
        cstmt.execute();

        // Lấy kết quả
        double cost = cstmt.getDouble(2);

        System.out.println("Chi phí phẫu thuật: " + cost);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
