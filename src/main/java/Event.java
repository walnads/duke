import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Event extends Task {
    protected Date at;

    public Event(String description, String at) throws ParseException {
        super(description);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        this.at = format.parse(at);
    }

    @Override
    public String printString() {
        SimpleDateFormat d = new SimpleDateFormat("E, dd/MM/yyyy HH:mm");
        return String.format("E | %d | %s | %s", isDone ? 1 : 0, description, d.format(at));
    }

    public String toString() {
        SimpleDateFormat d = new SimpleDateFormat("E, dd/MM/yyyy HH:mm");
        return "[E]" + super.toString() + " (at: " + d.format(at) + ")";
    }
}
