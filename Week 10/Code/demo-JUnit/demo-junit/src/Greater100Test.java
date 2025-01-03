import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;



public class Greater100Test {

   



    @Test
    void testGreater_or_not() {
        double around_100 = 100.0000000000078;
        for (int i =0; i<100; i++){
            assertTrue(Greater100.greater_or_not( around_100+= 0.00005));
        }
    }


    

    @Test
    void testGreater_or_not_false() {
        double around_100 = 99.0000000000078;
        for (int i =0; i<100; i++){
            assertFalse(Greater100.greater_or_not( around_100+= 0.00005));
        }
    }
}
