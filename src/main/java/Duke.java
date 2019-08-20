import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\n" + "Hello! I'm Duke" + "\n" + "What can I do for you?");

        String input = sc.nextLine();
        while (!(input.equals("bye"))) {
            if (input.equals("list")) {
                for (int i = 0; i < strings.size(); i++) {
                    System.out.println((i+1) + ". " + strings.get(i));
                }

            } else {
                strings.add(input);
                System.out.println("added: " + input);
            }

            input = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
