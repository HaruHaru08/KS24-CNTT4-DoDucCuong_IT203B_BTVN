package session08.bai5;

public class SetACTemperatureCommand implements Command {
    private AirConditioner ac;

    public SetACTemperatureCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Điều hòa set 28°C");
        ac.setTemperature(28);
    }
}
