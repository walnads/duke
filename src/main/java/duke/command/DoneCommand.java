package duke.command;

import duke.Duke;
/**
 * The class handles methods involving marking a task as Done.
 */
public class DoneCommand extends Command {
    /**
     * Public constructor for DoneCommand
     * @param parameters Information needed to execute the command (i.e. index of task).
     */
    public DoneCommand(String parameters) {
        super(parameters);
    }

    @Override
    public String execute() {
        try {
            int id = Integer.parseInt(parameters);
            return Duke.taskList.markDone(id);

        } catch (ArrayIndexOutOfBoundsException e) {
            return "\u2639 OOPS!!! The task does not exist.";
        }
    }
}
