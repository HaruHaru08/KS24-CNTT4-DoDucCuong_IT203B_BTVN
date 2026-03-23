package session12.bai1;

public class ThucThi {
    String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";

    PreparedStatement pstmt = conn.prepareStatement(sql);

    // Gán giá trị vào dấu ?
    pstmt.setString(1, code);
    pstmt.setString(2, pass);

    // Thực thi
    ResultSet rs = pstmt.executeQuery();

    if (rs.next()) {
        System.out.println("Đăng nhập thành công!");
    } else {
        System.out.println("Sai tài khoản hoặc mật khẩu!");
    }
}
