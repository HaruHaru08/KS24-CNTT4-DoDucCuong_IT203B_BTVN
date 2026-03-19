package session08.bai5;

public class FanLowCommand implements Command {
    private Fan fan;

    public FanLowCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Quạt tốc độ thấp");
        fan.low();
    }
}
