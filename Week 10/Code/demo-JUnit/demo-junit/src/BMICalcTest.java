import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BMICalcTest {


  
    @ParameterizedTest
    @CsvSource({
        "90, 182",
        "75, 150",
        "100,  179",
        "89, 190",
        "75, 180",
        "77, 182",
        "104, 200",
        "45, 160",

    })
 
    @DisplayName("Test different combinations of weight and height for BMI calculation")
    void testMain(float weight, float height) {

        assertEquals( (weight / Math.pow(height,2)) , BMICalc.generate_BMI(weight, height), 0.01 );

    }
}
