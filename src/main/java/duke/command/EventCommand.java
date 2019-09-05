package duke.command;

import duke.Duke;
import duke.exception.MissingParameterException;
import duke.task.Task;
import duke.task.Event;
import java.text.ParseException;

/**
 * The class handles methods involving creating an Event task.
 */
public class EventCommand extends Command {

    /**
     * Public constructor for EventCommand.
     * @param parameters Information needed for executing the command (i.e. description and date).
     */
    public EventCommand(String parameters) {
        super(parameters);
    }

    /**
     * Executes the Event command (i.e. creates the Event task object).
     * @return Duke's response during/after creating the Event task object.
     * @throws MissingParameterException if there are missing parameters in the command.
     */
    public String execute() throws MissingParameterException {
        if (parameters.length() <= 0) {
            throw new MissingParameterException("\u2639 OOPS!!! The description and date of a event cannot be empty.");

        } else if (!(parameters.contains("/at"))) {
            throw new MissingParameterException("\u2639 OOPS!!! The date of a event cannot be empty.");

        } else {
            try {
                String[] temp = parameters.split(" /at ");
                Task t = new Event(temp[0], temp[1]);
                return Duke.taskList.add(t);

            } catch (ParseException e) {
                return "\u2639 OOPS!!! Your date is not in dd/MM/yyyy HHmm format (e.g. 2/12/2019 1800)";
            }
        }
    }
}
