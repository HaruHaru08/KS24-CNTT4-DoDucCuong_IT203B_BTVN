package session13.bai4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import session11.bai1.DBContext;
import session13.bai4.model.BenhNhanDTO;
import session13.bai4.model.DichVu;

public class ThucThi {
    // Phương thức main để chạy và test code
    public static void main(String[] args) {
        ThucThi program = new ThucThi();
        System.out.println("Đang tải dữ liệu Dashboard Cấp Cứu...");
        try {
            List<BenhNhanDTO> dashboard = program.getDashboardCapCuu();
            
            System.out.println("\n----- KẾT QUẢ DASHBOARD -----");
            if (dashboard.isEmpty()) {
                System.out.println("(Không có bệnh nhân nào trong khoa Cấp Cứu)");
            } else {
                for (BenhNhanDTO bn : dashboard) {
                    System.out.println(bn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BenhNhanDTO> getDashboardCapCuu() throws SQLException {
        // Sử dụng LinkedHashMap để giữ đúng thứ tự bệnh nhân như trong DB
        Map<Integer, BenhNhanDTO> mapBenhNhan = new LinkedHashMap<>();

        // Câu lệnh SQL: Lấy thông tin BN + DV, bổ sung trường gia_tien
        String sql = "SELECT b.ma_bn, b.ten_bn, b.tuoi, d.ma_dv, d.ten_dv, d.gia_tien " +
                     "FROM BenhNhan b " +
                     "LEFT JOIN DichVuSuDung d ON b.ma_bn = d.ma_bn " +
                     "WHERE b.khoa_dang_nam = 'CapCuu'";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maBN = rs.getInt("ma_bn");

                // Kiểm tra xem bệnh nhân này đã có trong Map chưa
                BenhNhanDTO dto = mapBenhNhan.get(maBN);

                if (dto == null) {
                    // Nếu chưa có, tạo mới và đưa vào Map
                    dto = new BenhNhanDTO();
                    dto.setMaBenhNhan(maBN);
                    dto.setTenBenhNhan(rs.getString("ten_bn"));
                    dto.setTuoi(rs.getInt("tuoi")); // Giả sử có cột tuổi
                    dto.setDsDichVu(new ArrayList<>()); // Khởi tạo list trống
                    mapBenhNhan.put(maBN, dto);
                }

                // XỬ LÝ BẪY 2: Kiểm tra dịch vụ có tồn tại không (do LEFT JOIN có thể trả về null)
                String maDV = rs.getString("ma_dv");
                if (maDV != null) {
                    // Chỉ add vào danh sách nếu thực sự có dịch vụ/thuốc
                    DichVu dv = new DichVu();
                    dv.setMaDichVu(maDV);
                    dv.setTenDichVu(rs.getString("ten_dv"));
                    // Thêm giá tiền nếu có cột này trong DB (hoặc handle SQLException nếu không có)
                    try {
                        dv.setGiaTien(rs.getDouble("gia_tien"));
                    } catch (SQLException e) {
                        // Nếu không có cột gia_tien thì bỏ qua hoặc set 0
                        dv.setGiaTien(0);
                    }
                    
                    dto.getDsDichVu().add(dv);
                }
                // Nếu maDV là null, list dsDichVu của dto vẫn là list rỗng (thỏa mãn yêu cầu hiển thị)
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Nếu lỗi kết nối, trả về list rỗng hoặc throw exception tùy logic
        }

        return new ArrayList<>(mapBenhNhan.values());
    }
}
