import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class DoubleTest {
    @Test
    void testReturn_doubled_value_positiveValue() {

        assertEquals(20, Double.return_doubled_value(10), "it should return 20 as 10*2 = 20");

    }

    void testReturn_doubled_value_negativeValue() {
        assertEquals(-20, Double.return_doubled_value(-10), "it should return -20 as -10*2  -20");

    }

    void testReturn_doubled_value_nullValue() {
        assertEquals(0, Double.return_doubled_value(0), "it should return 0 as 0*2 = 0");

    }
}
