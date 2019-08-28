import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskListTest {
    @Test
    public void markDone_expectedBehaviour() {
        TaskList tl = new TaskList(new Storage("C:\\Users\\User\\Documents\\duke\\data\\duketest.txt"));
        tl.add(new Todo("print lecture notes"));
        tl.markDone(1);
        assertEquals("Here are the tasks in your list:\n1. [T][\u2713] print lecture notes", tl.view());
    }

    @Test
    public void markDone_exceptionThrown() {
        TaskList tl = new TaskList(new Storage("C:\\Users\\User\\Documents\\duke\\data\\duketest.txt"));
        tl.add(new Todo("print lecture notes"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            tl.markDone(0);
        });
    }

    @Test
    public void delete_exceptionThrown() {
        TaskList tl = new TaskList(new Storage("C:\\Users\\User\\Documents\\duke\\data\\duketest.txt"));
        tl.add(new Todo("print lecture notes"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            tl.delete(0);
        });
    }

    @Test
    public void view_expectedBehaviour() {
        TaskList tl = new TaskList(new Storage("C:\\Users\\User\\Documents\\duke\\data\\duketest.txt"));
        assertEquals("Here are the tasks in your list:", tl.view());
    }
}
