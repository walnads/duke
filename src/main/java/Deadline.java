import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected Date by;

    public Deadline(String description, String by) throws ParseException {
        super(description);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        this.by = format.parse(by);
    }

    @Override
    public String toString() {
        SimpleDateFormat d = new SimpleDateFormat("E, dd/MM/yyyy HH:mm");
        return "[D]" + super.toString() + " (by: " + d.format(by) + ")";
    }
}
