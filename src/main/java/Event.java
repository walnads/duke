public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String printString() {
        return String.format("D | %d |%s | %s", isDone ? 1 : 0, description, at);
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
