import java.util.Scanner;

/**
 * The class that manages the workflow of the chatbot application.
 */
public class Duke {
    private Storage storage;
    private UI ui;
    private TaskList taskList;
    private Parser parser;

    /**
     * Public constructor for Duke class.
     * Initialises Storage, UI, TaskList, and Parser classes.
     */
    public Duke() {
        ui = new UI();
        storage = new Storage("C:\\Users\\User\\Documents\\duke\\data\\duke.txt");
        taskList = new TaskList(storage);
        parser = new Parser(taskList);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        ui.show("Hello from\n" + logo + "\n" + "Hello! I'm Duke\n" + "What can I do for you?");
    }

    /**
     * Runs the chatbot application.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);

        try {
            String parsedInput = parser.parse(sc.nextLine());

            while (!(parsedInput.equals("bye"))) {
                ui.show(parsedInput);
                parsedInput = parser.parse(sc.nextLine());
            }
            ui.show("Bye. Hope to see you again soon!");

        } catch (DukeException e) {
            ui.show(e.getMessage());
            run();
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
