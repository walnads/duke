import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\n" + "Hello! I'm Duke" + "\n" + "What can I do for you?");

        String input = sc.nextLine();
        while (!(input.equals("bye"))) {
            System.out.println(input);
            input = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
