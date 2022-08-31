import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Ticket;
import ru.netology.javaqa.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketRepositoryTest {

    private final TicketRepository repository = new TicketRepository();
    private final Ticket first = new Ticket(1, 3_500, "SVO", "KUL", 350);
    private final Ticket second = new Ticket(2, 4_000, "DPS", "SIN", 200);

    @Test
    void shouldSave() {
        repository.save(first);
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void showEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void showNotEmpty() {
        repository.save(first);
        repository.save(second);
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }


}

