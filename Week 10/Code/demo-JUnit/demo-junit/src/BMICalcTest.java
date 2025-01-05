import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BMICalcTest {


  
    @ParameterizedTest
    @CsvSource({
        "90, 1,82",
        "75, 1,50",
        "100,  1,79",
        "89, 1,90",
        "75, 1,80",
        "77, 1,82",
        "104, 2,00",
        "45, 1,60",

    })
 
    @DisplayName("Test different combinations of weight and height for BMI calculation")
    void testMain(float weight, float height) {

        assertEquals( (weight / Math.pow(height,2)) , BMICalc.generate_BMI(weight, height), 0.01 );

    }
}
