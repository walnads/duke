package duke;

import duke.task.Task;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The class that loads tasks from the file and saves tasks in the file.
 */
public class Storage {
    protected String filePath;
    protected FileWriter writer;

    /**
     * Public constructor for Storage class.
     * @param filePath File path of the data file in String format.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes all the tasks in the current application to the data file.
     *
     * @param tasks An array containing all the tasks in the application thus far.
     * @throws IOException If the file path is incorrect.
     */
    public void update(List<Task> tasks) throws IOException {
        writer = new FileWriter(filePath);
        String text = "";

        for (Task t : tasks) {
            text += t.printString() + "\n";
        }

        writer.write(text);
        writer.close();
    }
}
