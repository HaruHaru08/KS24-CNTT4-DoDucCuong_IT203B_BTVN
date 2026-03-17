package session08.bai5;

public class Fan implements Observer {
    private String speed = "Tắt";

    public void low() {
        speed = "Thấp";
        System.out.println("Quạt: Chạy tốc độ thấp");
    }

    public void high() {
        speed = "Mạnh";
        System.out.println("Quạt: Chạy tốc độ mạnh");
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            high();
        }
    }

    public void status() {
        System.out.println("Quạt: " + speed);
    }
}
