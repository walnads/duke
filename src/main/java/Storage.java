import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Storage {
    protected String filePath;
    protected FileWriter fw;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void update(List<Task> tasks) throws IOException {
        fw = new FileWriter(filePath);
        String text = "";

        for (Task t : tasks) {
            text += t.printString() + "\n";
        }

        fw.write(text);
        fw.close();
    }
}
