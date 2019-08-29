import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A representation of the event task.
 */
public class Event extends Task {
    protected Date at;

    /**
     * Public constructor for the Event class.
     * Creates an incomplete event task.
     *
     * @param description Description of the task.
     * @param at The start date and time of the task.
     * @throws ParseException If by is not of "dd/MM/yyyy HHmm" format.
     */
    public Event(String description, String at) throws ParseException {
        super(description);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        this.at = format.parse(at);
    }

    /**
     * Converts information about the event task to String format (for addition to the data file).
     *
     * @return Task information in String format.
     */
    @Override
    public String printString() {
        SimpleDateFormat d = new SimpleDateFormat("E, dd/MM/yyyy HH:mm");
        return String.format("E | %d | %s | %s", isDone ? 1 : 0, description, d.format(at));
    }

    /**
     * Converts information about the event task to String format (for printing to the UI).
     *
     * @return Task information in String format.
     */
    @Override
    public String toString() {
        SimpleDateFormat d = new SimpleDateFormat("E, dd/MM/yyyy HH:mm");
        return "[E]" + super.toString() + " (at: " + d.format(at) + ")";
    }
}
