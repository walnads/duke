import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class UI {
    protected PrintStream out;

    public UI() {
        try {
            this.out = new PrintStream(System.out, true, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            return; // bro will nvr happen
        }
    }

    public void show(String str) {
        out.println(str);
    }
}
