import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VATTest {
   

    @Test
    @DisplayName("Arithmetic Exception <=0 input")
    public void testCalcIncVATArithmeticException() {
        Exception error;
        error = assertThrows(ArithmeticException.class, () -> VAT.calcIncVAT((0)));
        assertEquals("Zero or less", error.getMessage());
    }

    @Test
    public void testCalcIncVATDoesntReturnInteger() {
        assertNotEquals(1,VAT.calcIncVAT(1),0.19); // here it's valid because 1 not included in [   1.2 - 0.19 , 1.2 + 0.19 ]
    }



    @ParameterizedTest
    @ValueSource(doubles = {1, 5, 10, 15, 20, 25, 30})
    @DisplayName("Param Test: Many Values")
    public void testCalcIncVatManyVals(double costs) {
        assertEquals(costs*1.2, VAT.calcIncVAT(costs));
    }



}
