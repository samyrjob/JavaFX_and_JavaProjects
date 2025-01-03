import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatTest {

 // 'global' instance of the Cat class
    // saves repeated instantiation in each @Test
    private final Cat testCat = new Cat("Holly", 12, 'F');

    @Test
    @DisplayName("Age Should be 12")
    void testGetAge() {
        assertEquals(12, testCat.getAge(),"Age is 12");
    }

    @Test
    @DisplayName("Gender Should be 'F'")
    void testGetGender() {
        assertEquals('F', testCat.getGender(), "Gender is 'F'");
    }

    @Test
    @DisplayName("Name Should be Holly")
    void testGetName() {
        assertEquals("Holly", testCat.getName(), "Name is Holly");
    }

    @Test
    @DisplayName("Human Years Should be 64")
    void testGetHumanYears() {
        assertEquals(64, testCat.getHumanYears(), "Human Years is 64");
    }

}
