package session08.bai3;

public class Light implements Device {
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Đèn: Bật");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Đèn: Tắt");
    }
}
