package session11.bai2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeSua {
    private PreparedStatement stmt;
    ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");

    while (rs.next()) {
        System.out.println(
                "Thuốc: " + rs.getString("medicine_name") +
                        " | Tồn kho: " + rs.getInt("stock")
        );
    }

    public CodeSua() throws SQLException {
    }
}
