import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileManagerTest {
    @Test
    void testMain() {

    }

    String filepath = "the_file.txt";

    @Test
    @DisplayName("Try to read the file the_file.txt exsiting, and check there is no error ")
    void testRead_file() {
        assertDoesNotThrow(() -> FileManager.read_file(filepath), "IO exception was thrown even if it shouldn't");
    
    }

    String non_existing_filepath = "non_existing.txt";

    @Test
    @DisplayName("Try to read the file the_file.txt that does not exsit, and check there is the generated exception error ")
    void testRead_file_non_existing() {
        Exception error;
        error = assertThrows(IOException.class, () -> FileManager.read_file(non_existing_filepath));
    }

    @Test
    @DisplayName("try write to a file and check no exception occurs")
    void testWrite_file() {
        assertDoesNotThrow(() -> FileManager.write_file(filepath), "IO exception was thrown even if it shouldn't");

    }
}
