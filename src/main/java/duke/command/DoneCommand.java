package duke.command;

import duke.Duke;
import duke.exception.MissingParameterException;

import java.text.ParseException;
import java.util.Arrays;

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
    public String execute() throws MissingParameterException {
        if (parameters.length() <= 0) {
            throw new MissingParameterException("\u2639 OOPS!!! Please specify the index of the task to be" +
                    "marked done.");
        }

        try {
            String[] paramArr = parameters.split(" ");
            int[] intArr = Arrays.stream(paramArr).mapToInt(x -> Integer.parseInt(x)).toArray();
            return Duke.taskList.markDone(intArr);

        } catch (ArrayIndexOutOfBoundsException e) {
            return "\u2639 OOPS!!! Please specify an index within the range.";

        } catch (ClassCastException e) {
            return "\u2639 OOPS!!! Please enter integers only.";

        } catch (NumberFormatException e) {
            return "\u2639 OOPS!!! Please enter integers only.";
        }
    }
}
