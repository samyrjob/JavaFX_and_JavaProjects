import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class IntAdderTest {
    @Test
    void testAddPositiveNumber() {

        assertEquals(20, IntAdder.add(10,10));
    }
    void testAddNegativeNumber() {

        assertEquals(-20, IntAdder.add(-10,-10));
        
    }

    @Test
    void testMain() {

    }
}
