import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * The class that deals with interactions with the user.
 */
public class UI {
    protected PrintStream out;

    /**
     * Public constructor for UI class.
     */
    public UI() {
        try {
            this.out = new PrintStream(System.out, true, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            return; // Will never happen in this context.
        }
    }

    /**
     * Displays the chatbot's response to the user.
     *
     * @param str The chatbot's response in String format.
     */
    public void show(String str) {
        out.println(str);
    }
}
