package session13.bai4.model;

import java.util.ArrayList;
import java.util.List;

public class BenhNhanDTO {
    private int maBenhNhan;
    private String tenBenhNhan;
    private int tuoi;
    private List<DichVu> dsDichVu;

    public BenhNhanDTO() {
        this.dsDichVu = new ArrayList<>();
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BenhNhanDTO{")
                .append("maBenhNhan=").append(maBenhNhan)
                .append(", tenBenhNhan='").append(tenBenhNhan).append('\'')
                .append(", tuoi=").append(tuoi)
                .append("}\n");
        if (dsDichVu != null && !dsDichVu.isEmpty()) {
            for (DichVu dv : dsDichVu) {
                sb.append(dv.toString()).append("\n");
            }
        } else {
            sb.append("      - (Không sử dụng dịch vụ)\n");
        }
        return sb.toString();
    }
}
