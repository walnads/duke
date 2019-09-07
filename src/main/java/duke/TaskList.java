package duke;

import duke.task.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * The class that contains the task list.
 */
public class TaskList {
    protected List<Task> tasks;
    protected Storage storage;

    /**
     * Public constructor for Tasklist class.
     *
     * @param storage Storage object containing all the methods for writing and retrieving from the data file.
     */
    public TaskList(Storage storage) {
        this.tasks = new ArrayList<>();
        this.storage = storage;
    }

    /**
     * Updates the tasks list in the data file.
     */
    private void update() {
        try {
            storage.update(tasks);

        } catch (Exception e) {
            return;
        }
    }

    /**
     * Iterates through all the tasks in the task list.
     * Creates a String containing information about all the tasks.
     *
     * @return String containing information about all the tasks.
     */
    public String view() {
        if (tasks.size() > 0) {
            StringBuilder str = new StringBuilder();
            str.append("Here are the tasks in your list:\n");
            for (int i = 0; i < tasks.size(); i++) {
                str.append(String.format("%d. %s\n", (i + 1), tasks.get(i)));
            }
            str.deleteCharAt(str.length() - 1);
            return str.toString();

        } else {
            return "You have no tasks in your list";
        }
    }

    /**
     * Adds a Task to the task list.
     *
     * @param t The Task object to be added.
     * @return The chatbot's response in String format.
     */
    public String add(Task t) {
        tasks.add(t);
        update();
        return String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.",
                tasks.get(tasks.size() - 1), tasks.size());
    }

    /**
     * Deletes a Task from the task list.
     *
     * @param i The index of the Task object to be deleted.
     * @return The chatbot's response in String format.
     */
    public String delete(int i) throws IndexOutOfBoundsException {
        String str = tasks.get(i - 1).toString();
        tasks.remove(i - 1);
        update();
        return String.format("Noted. I've removed this task:\n  %s\nNow you have %d tasks in the list",
                str, tasks.size());
    }

    /**
     * Finds a matching task given the String input.
     *
     * @param input The matching String input.
     * @return The chatbot's response in String format.
     */
    public String find(String input) {
        StringBuilder str = new StringBuilder();
        str.append("Here are the matching tasks in your list:\n");

        int num = 1;
        for (Task t : tasks) {
            if (t.getDescription().contains(input)) {
                str.append(String.format("%d. %s\n", num, t));
                num++;
            }
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    /**
     * Marks a Task in a task list as done.
     *
     * @param i The index of the Task object to be modified.
     * @return The chatbot's response in String format.
     */
    public String markDone(int i) throws IndexOutOfBoundsException {
        tasks.get(i - 1).markAsDone();
        update();
        return "Nice! I've marked this task as done:\n  " + tasks.get(i - 1);
    }
}
