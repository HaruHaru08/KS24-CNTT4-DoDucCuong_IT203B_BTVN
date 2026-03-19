package session08.bai5;

import java.util.List;

public class SleepModeCommand implements Command {
    private List<Command> commands;

    public SleepModeCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command c : commands) {
            c.execute();
        }
    }
}
