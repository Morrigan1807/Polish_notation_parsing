package Model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorModelTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/OperatorModel/testData_fromString_OperatorModel.csv")
    void testFromString(String input, OperatorModel expected) {
        assertEquals(expected, OperatorModel.fromString(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/OperatorModel/testData_fromString_OperatorModel_IncorrectCase.csv")
    void testFromString_IncorrectCase(String input) {
        assertThrows(IllegalArgumentException.class, ()->OperatorModel.fromString(input));
    }
}