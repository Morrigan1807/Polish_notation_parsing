package Model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorModelTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testData_fromString_OperatorModel.csv")
    void testFromString(String input, OperatorModel expected) {
        assertEquals(expected, OperatorModel.fromString(input));
    }
}