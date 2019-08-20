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
        out.println("Hello from\n" + logo + "\n" + "Hello! I'm Duke" + "\n" + "What can I do for you?");

        String input = sc.nextLine();
        while (!(input.equals("bye"))) {
            if (input.equals("list")) {
                out.println("Here are the tasks in your list: ");
                for (int i = 0; i < tasks.size(); i++) {
                    out.println((i+1) + ". " + tasks.get(i));
                }

            } else if (input.contains("done")) {
                int id = Integer.parseInt(input.substring(input.length() - 1));
                tasks.get(id - 1).markAsDone();
                out.println("Nice! I've marked this task as done: " + "\n    " + tasks.get(id - 1));

            } else {
                tasks.add(new Task(input));
                out.println("added: " + input);
            }

            input = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
