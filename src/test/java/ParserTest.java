import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    @Test
    public void parser_exceptionThrown() throws DukeException {
        Parser p = new Parser(new TaskList(new Storage("C:\\Users\\User\\Documents\\duke\\data\\duketest.txt")));

        //test case 1
        assertThrows(DukeException.class, () -> {
           p.parse("todo");
        });

        //test case 2
        assertThrows(DukeException.class, () -> {
            p.parse("event");
        });

        //test case 3
        assertThrows(DukeException.class, () -> {
            p.parse("deadline");
        });
    }
}
