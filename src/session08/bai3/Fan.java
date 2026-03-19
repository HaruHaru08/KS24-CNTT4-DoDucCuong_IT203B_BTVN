package session08.bai3;

public class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Quạt: Bật quay.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Tắt.");
    }
}
