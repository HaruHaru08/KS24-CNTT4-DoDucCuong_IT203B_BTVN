package session08.bai5;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Tắt đèn");
        light.off();
    }
}
