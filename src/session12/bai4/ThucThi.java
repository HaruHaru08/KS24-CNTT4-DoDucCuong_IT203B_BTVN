package session12.bai4;

import java.sql.PreparedStatement;

public class ThucThi {
    String sql = "INSERT INTO Results(data) VALUES(?)";

    // Khởi tạo 1 lần
    PreparedStatement pstmt = conn.prepareStatement(sql);

    // Lặp và truyền tham số
    for (TestResult tr : list) {
        pstmt.setString(1, tr.getData());
        pstmt.executeUpdate();
    }
}
