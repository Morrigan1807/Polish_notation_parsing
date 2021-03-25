import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import stringtask.StringTask;

import static org.junit.jupiter.api.Assertions.*;

public class StringTaskTest {

    final String resourceFileForTestHasNoDuplicatesInStringReturnTrueCase =
            "Test/testData_hasNoDuplicatesInStringReturnTrue_StringTask.csv";
    final String resourceFileForTestHasNoDuplicatesInStringReturnFalseCase =
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
        StringTask stringTask = new StringTask();

        assertThrows(NullPointerException.class, () -> stringTask.hasNoDuplicatesInString(null));
    }

    @Test
    public void testHasNoDuplicatesInStringEmptyStringCase() {
        StringTask stringTask = new StringTask();

        assertThrows(NullPointerException.class, () -> stringTask.hasNoDuplicatesInString(""));
    }
}