package parametrizedtests.model;

import model.OperatorModel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constant.TEST_DATA_FROM_STRING_CORRECT_CASE;
import static util.Constant.TEST_DATA_FROM_STRING_INCORRECT_CASE;

public class OperatorModelTest {

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_FROM_STRING_CORRECT_CASE)
    public void testFromStringCorrectCase(String input, OperatorModel expected) {
        assertEquals(expected, OperatorModel.fromString(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = TEST_DATA_FROM_STRING_INCORRECT_CASE)
    public void testFromStringIncorrectCase(String input) {
        assertThrows(IllegalArgumentException.class, () -> OperatorModel.fromString(input));
    }
}