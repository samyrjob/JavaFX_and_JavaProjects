

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EnergyConvTest {
    @ParameterizedTest
    @ValueSource(doubles = {180.5,1500,5400.22,9670,14850.45,64500,1204500.25})
    void testConvert_from_joules_to_watts_per_hour(double value_joule) {
        assertEquals((value_joule/3600), EnergyConv.convert_from_joules_to_watts_per_hour(value_joule));
    }
}
