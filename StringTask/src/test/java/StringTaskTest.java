import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class StringTaskTest {
    private final String resourceFileForTestHasNoDuplicatesInStringReturnTrueCase =
            "Test/testData_hasNoDuplicatesInStringReturnTrue_StringTask.csv";
    private final String resourceFileForTestHasNoDuplicatesInStringReturnFalseCase =
            "Test/testData_hasNoDuplicatesInStringReturnFalse_StringTask.csv";

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestHasNoDuplicatesInStringReturnTrueCase)
    public void testHasNoDuplicatesInStringReturnTrueCase(String input) {
        assertTrue(new StringTask().hasNoDuplicatesInString(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestHasNoDuplicatesInStringReturnFalseCase)
    public void testHasNoDuplicatesInStringReturnFalseCase(String input) {
        assertFalse(new StringTask().hasNoDuplicatesInString(input));
    }

    @Test
    public void testHasNoDuplicatesInStringNullCase() {
        assertThrows(NullPointerException.class, () -> new StringTask().hasNoDuplicatesInString(null));
    }

    @Test
    public void testHasNoDuplicatesInStringEmptyStringCase() {
        assertThrows(NullPointerException.class, () -> new StringTask().hasNoDuplicatesInString(""));
    }
}