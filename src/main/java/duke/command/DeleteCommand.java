package duke.command;

import duke.Duke;
import duke.exception.MissingParameterException;
/**
 * The class that handles all the methods involving deleting a task.
 */
public class DeleteCommand extends Command {
    /**
     * Public constructor for DeleteCommand.
     * @param parameters Information needed to execute the command (i.e. the index of the task to be deleted).
     */
    public DeleteCommand(String parameters) {
        super(parameters);
    }

    /**
     * Executes the Delete command (i.e. deletes the task from the task list).
     * @return Duke's response during/after deleting the task.
     * @throws MissingParameterException if there are missing parameters.
     */
    public String executeCommand() throws MissingParameterException {
        if (parameters.length() <= 0) {
            throw new MissingParameterException("\u2639 OOPS!!! Please specify the index of the task to be deleted.");

        } else {
            try {
                int id = Integer.parseInt(parameters);
                return Duke.taskList.delete(id);

            } catch (IndexOutOfBoundsException e) {
                return "\u2639 OOPS!!! A task with this index does not exist.";
            }
        }
    }
}
