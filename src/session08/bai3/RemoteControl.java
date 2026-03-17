package session08.bai3;

import java.util.Stack;

public class RemoteControl {
    private Command[] slots;
    private Stack<Command> history;

    public RemoteControl(int numSlots) {
        slots = new Command[numSlots];
        history = new Stack<>();
    }

    public void setCommand(int slot, Command command) {
        if (slot >= 0 && slot < slots.length) {
            slots[slot] = command;
            // The desired output format in prompt is: "Đã gán LightOnCommand cho nút 1"
            // The previous implementation was close but maybe the prompt implies simpler output or exact class name?
            // "Đã gán LightOnCommand cho nút 1"
            System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + (slot + 1));
        } else {
            System.out.println("Slot không hợp lệ.");
        }
    }

    public void pressButton(int slot) {
        if (slot >= 0 && slot < slots.length) {
            if (slots[slot] != null) {
                slots[slot].execute();
                history.push(slots[slot]);
            } else {
                 System.out.println("Nút " + (slot + 1) + " chưa được gán lệnh.");
            }
        } else {
            System.out.println("Slot không hợp lệ.");
        }
    }

    public void pressUndo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        } else {
            System.out.println("Không có lệnh nào để hoàn tác.");
        }
    }
}
