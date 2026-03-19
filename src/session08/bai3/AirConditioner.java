package session08.bai3;

public class AirConditioner implements Device {
    private int temperature = 25; // Default temperature

    @Override
    public void turnOn() {
        System.out.println("Điều hòa: Bật làm mát.");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Điều hòa: Nhiệt độ = " + this.temperature);
    }

    public int getTemperature() {
        return temperature;
    }
}
