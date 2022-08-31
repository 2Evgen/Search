import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Ticket;
import ru.netology.javaqa.TicketManager;
import ru.netology.javaqa.TicketRepository;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    private TicketManager manager;
    private final Ticket first = new Ticket(1, 3_500,"SVO", "KUL", 350);
    private final Ticket second = new Ticket(2, 4_000, "DPS", "SIN", 200);
    private final Ticket third = new Ticket(3, 4_700, "SVO", "KUL", 300);
    private final Ticket fourth = new Ticket(4, 1_500, "SIN", "KUL", 150);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(new TicketRepository());
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

    }

    @Test
    void showOffers() {
        Ticket[] expected = new Ticket[]{fourth, first, second, third,};
        assertArrayEquals(expected, manager.showOffers());
    }

    @Test
    void shouldSearchIfExists() {
        Ticket[] expected = new Ticket[]{first, third};
        assertArrayEquals(expected, manager.findAll("SVO", "KUL"));
    }

    @Test
    void shouldSearchIfNotExists() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("DPS", "SVO"));
    }
}