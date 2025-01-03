import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class LongListTest {



    @Test
    void testTry_access_index() {

        Exception error;
        error = assertThrows(ArrayIndexOutOfBoundsException.class, () -> LongList.try_access_index(100, 101));
    }
}
