import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class Duke {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        List<Task> tasks = new ArrayList<>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo + "\n" + "Hello! I'm Duke\n" + "What can I do for you?");

        String input = sc.nextLine();
        while (!(input.equals("bye"))) {
            try {
                if (input.equals("list")) {
                    out.println("Here are the tasks in your list: ");
                    for (int i = 0; i < tasks.size(); i++) {
                        out.println((i + 1) + ". " + tasks.get(i));
                    }

                } else if (input.contains("done")) {
                    int id = Integer.parseInt(input.substring(input.length() - 1));
                    tasks.get(id - 1).markAsDone();
                    out.println("Nice! I've marked this task as done:\n    " + tasks.get(id - 1));

                } else if (input.contains("todo")) {
                    if (input.length() < 6) {
                        throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");

                    } else {
                        tasks.add(new Todo(input.substring(4)));
                        out.println(String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.",
                                tasks.get(tasks.size() - 1), tasks.size()));
                    }

                } else if (input.contains("deadline")) {
                    if (input.length() < 10) {
                        throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.");

                    } else {
                        String[] temp = input.substring(8).split(" /by ");
                        tasks.add(new Deadline(temp[0], temp[1]));
                        out.println(String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.",
                                tasks.get(tasks.size() - 1), tasks.size()));
                    }

                } else if (input.contains("event")) {
                    if (input.length() < 7) {
                        throw new DukeException("\u2639 OOPS!!! The description of a event cannot be empty.");

                    } else {
                        String[] temp = input.substring(5).split(" /at ");
                        tasks.add(new Event(temp[0], temp[1]));
                        out.println(String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.",
                                tasks.get(tasks.size() - 1), tasks.size()));
                    }

                } else if (input.contains("delete")) {
                    int id = Integer.parseInt(input.substring(input.length() - 1));
                    String str = tasks.get(id - 1).toString();
                    tasks.remove(id -1);

                    out.println(String.format("Noted. I've removed this task:\n  %s\nNow you have %d tasks in the list",
                            str, tasks.size()));

                } else {
                    throw new DukeException("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
                }

            } catch (DukeException e){
                out.println(e.getMessage());
            }

            input = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
