import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class StringTaskTest {
    @ParameterizedTest
    @CsvFileSource(resources = "Test/testData_hasNoDuplicatesInStringReturnTrue_StringTask.csv")
    public void test_HasNoDuplicatesInString_ReturnTrueCase(String input) {
        assertTrue(new StringTask().hasNoDuplicatesInString(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Test/testData_hasNoDuplicatesInStringReturnFalse_StringTask.csv")
    public void test_HasNoDuplicatesInString_ReturnFalseCase(String input) {
        assertFalse(new StringTask().hasNoDuplicatesInString(input));
    }

    @Test
    public void test_HasNoDuplicatesInString_NullCase() {
        assertThrows(NullPointerException.class, () -> new StringTask().hasNoDuplicatesInString(null));
    }

    @Test
    public void test_HasNoDuplicatesInString_EmptyStringCase() {
        assertThrows(NullPointerException.class, () -> new StringTask().hasNoDuplicatesInString(""));
    }
}