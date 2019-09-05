package duke.command;

import duke.exception.MissingParameterException;
/**
 * The class handles all the methods involving ending the chat session with Duke.
 */
public class ExitCommand extends Command {
    /**
     * Public constructor for ExitCommand.
     */
    public ExitCommand() {
        super();
    }

    /**
     * Executes the Exit command.
     * @return Duke's goodbye message in String format.
     */
    @Override
    public String execute() {
        return "Bye. Hope to see you again soon!";
    }
}
