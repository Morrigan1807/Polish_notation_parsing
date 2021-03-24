import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import stringtask.StringTask;

import static org.junit.jupiter.api.Assertions.*;

class StringTaskTest {

    final String resourceFileForTestHasNoDuplicatesInStringReturnTrueCase =
            "Test/testData_hasNoDuplicatesInStringReturnTrue_StringTask.csv";
    final String resourceFileForTestHasNoDuplicatesInStringReturnFalseCase =
            "Test/testData_hasNoDuplicatesInStringReturnFalse_StringTask.csv";

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestHasNoDuplicatesInStringReturnTrueCase)
    void testHasNoDuplicatesInStringReturnTrueCase(String input) {
        assertTrue(new StringTask().hasNoDuplicatesInString(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = resourceFileForTestHasNoDuplicatesInStringReturnFalseCase)
    void testHasNoDuplicatesInStringReturnFalseCase(String input) {
        assertFalse(new StringTask().hasNoDuplicatesInString(input));
    }

    @Test
    void testHasNoDuplicatesInStringNullCase() {
        StringTask stringTask = new StringTask();

        assertThrows(NullPointerException.class, () -> stringTask.hasNoDuplicatesInString(null));
    }

    @Test
    void testHasNoDuplicatesInStringEmptyStringCase() {
        StringTask stringTask = new StringTask();

        assertThrows(NullPointerException.class, () -> stringTask.hasNoDuplicatesInString(""));
    }
}