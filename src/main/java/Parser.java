import java.text.ParseException;

public class Parser {
    protected TaskList tl;

    public Parser(TaskList tl) {
        this.tl = tl;
    }

    public String parse(String input) throws DukeException {
        if (input.equals("list")) {
            return tl.view();

        } else if (input.contains("done")) {
            int id = Integer.parseInt(input.substring(input.length() - 1));
            return tl.markDone(id);

        } else if (input.contains("todo")) {
            if (input.length() < 6) {
                throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");

            } else {
                Task t = new Todo(input.substring(5));
                return tl.add(t);
            }

        } else if (input.contains("deadline")) {
            if (input.length() < 10) {
                throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.");

            } else {
                try {
                    String[] temp = input.substring(9).split(" /by ");
                    Task t = new Deadline(temp[0], temp[1]);
                    return tl.add(t);

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
                    return tl.add(t);

                } catch (ParseException e) {
                    return "\u2639 OOPS!!! Your date is not in dd/MM/yyyy HHmm format (e.g. 2/12/2019 1800)";
                }
            }

        } else if (input.contains("delete")) {
            int id = Integer.parseInt(input.substring(input.length() - 1));
            return tl.delete(id -1);

        } else if (input.contains("find")) {
            return tl.find(input.substring(5));
        }

        return "bye";
    }
}
