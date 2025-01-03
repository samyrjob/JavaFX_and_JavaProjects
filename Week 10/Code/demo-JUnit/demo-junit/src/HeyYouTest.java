import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeyYouTest {


    @ParameterizedTest
    @ValueSource(strings = { "Robert", "Jack", "Ashley"})
    void testMain(String name) {

        assertEquals( "Hey " + " " + name , HeyYou.printmessage_name(name));

    }

}
