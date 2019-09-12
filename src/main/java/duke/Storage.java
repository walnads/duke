package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class that loads tasks from the file and saves tasks in the file.
 */
public class Storage {
    private String filePath;
    private FileWriter writer;
    private BufferedReader reader;

    /**
     * Public constructor for Storage class.
     */
    public Storage() {
        this.filePath = String.format("%s%s", System.getProperty("user.dir"), "\\data\\duke.txt");
    }

    /**
     * Writes all the tasks in the current application to the data file.
     *
     * @param tasks An array containing all the tasks in the application thus far.
     * @throws IOException If the file path is incorrect.
     */
    public void update(List<Task> tasks) throws IOException {
        writer = new FileWriter(filePath);
        StringBuilder text = new StringBuilder();

        for (Task t : tasks) {
            text.append(String.format("%s\n", t.printToTxtFile()));
        }

        writer.write(text.toString());
        writer.close();
    }

    public List<Task> load() {
        try {
            String line;
            List<Task> list = new ArrayList<>();

            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                list.add(parse(line));
            }
            return list;

        } catch (Exception e) {
            return new ArrayList<Task>();
        }
    }

    private Task parse(String line) {
        String[] lineArr = line.split(String.format(" %s ", "\\|"));
        try {
            if (lineArr[0].equals("T")) {
                Task todo = new Todo(lineArr[2]);
                if (lineArr[1].equals("1")) {
                    todo.markAsDone();
                }
                return todo;

            } else if (lineArr[0].equals("D")) {
                Task deadline = new Deadline(lineArr[2], lineArr[3]);
                if (lineArr[1].equals("1")) {
                    deadline.markAsDone();
                }
                return deadline;

            } else {
                Task event = new Event(lineArr[2], lineArr[3]);
                if (lineArr[1].equals("1")) {
                    event.markAsDone();
                }
                return event;
            }

        } catch (Exception e) {
            assert false;
            return null;
        }
    }
}
