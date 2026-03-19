package session08.bai3;


public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl(3);

        System.out.println("Gán nút 1: Bật đèn");
        LightOnCommand lightOn = new LightOnCommand(light);
        remote.setCommand(0, lightOn);

        System.out.println("Nhấn nút 1");
        remote.pressButton(0);

        System.out.println("\nGán nút 2: Tắt đèn");
        LightOffCommand lightOff = new LightOffCommand(light);
        remote.setCommand(1, lightOff);

        System.out.println("Nhấn nút 2");
        remote.pressButton(1);

        System.out.println("Nhấn Undo");
        remote.pressUndo();

        System.out.println("\nGán nút 3: Set điều hòa 26°C");
        ACSetTemperatureCommand ac26 = new ACSetTemperatureCommand(ac, 26);
        remote.setCommand(2, ac26);

        System.out.println("Nhấn nút 3");
        remote.pressButton(2);

        System.out.println("Nhấn Undo");
        remote.pressUndo();
    }
}
