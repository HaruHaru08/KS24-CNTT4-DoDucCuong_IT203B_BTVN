package session13.bai4.model;

public class DichVu {
    private String maDichVu;
    private String tenDichVu;
    private double giaTien;

    // Getters and Setters
    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "      - " + tenDichVu + " (" + String.format("%,.0f", giaTien) + " VNĐ)";
    }
}
