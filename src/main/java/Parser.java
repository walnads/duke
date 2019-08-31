import java.text.ParseException;

/**
 * The class that makes sense of user input.
 */
public class Parser {
    protected TaskList taskList;

    /**
     * Public constructor for Parser class.
     *
     * @param taskList TaskList object containing all the methods for creating, getting, and retrieving all the tasks.
     */
    public Parser(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Parses the user's input.
     *
     * @param input User input to be parsed.
     * @return The chatbot's response based on the parsed input in String format.
     * @throws DukeException If the user input is incomplete (i.e. does not contain the task description or date).
     */
    public String parse(String input) throws DukeException {
        if (input.equals("list")) {
            return taskList.view();

        } else if (input.contains("done")) {
            int id = Integer.parseInt(input.substring(input.length() - 1));
            return taskList.markDone(id);

        } else if (input.contains("todo")) {
            if (input.length() < 6) {
                throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");

            } else {
                Task t = new Todo(input.substring(5));
                return taskList.add(t);
            }

        } else if (input.contains("deadline")) {
            if (input.length() < 10) {
                throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.");

            } else {
                try {
                    String[] temp = input.substring(9).split(" /by ");
                    Task t = new Deadline(temp[0], temp[1]);
                    return taskList.add(t);

                } catch (ParseException e) {
                    return "\u2639 OOPS!!! Your date is not in dd/MM/yyyy HHmm format (e.g. 2/12/2019 1800)";
                }
            }

        } else if (input.contains("event")) {
            if (input.length() < 7) {
                throw new DukeException("\u2639 OOPS!!! The description of a event cannot be empty.");

            } else {
                try {
                    String[] temp = input.substring(6).split(" /at ");
                    Task t = new Event(temp[0], temp[1]);
                    return taskList.add(t);

                } catch (ParseException e) {
                    return "\u2639 OOPS!!! Your date is not in dd/MM/yyyy HHmm format (e.g. 2/12/2019 1800)";
                }
            }

        } else if (input.contains("delete")) {
            int id = Integer.parseInt(input.substring(input.length() - 1));
            return taskList.delete(id);

        } else if (input.contains("find")) {
            return taskList.find(input.substring(5));

        } else if (input.equals("bye")) {
            return input;

        }  else {
            return "\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(";
        }
    }
}
