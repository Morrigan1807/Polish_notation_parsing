package ParameterizedTests.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorModelTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/OperatorModel/testDataFromStringCorrectCase.csv")
    public void testFromStringCorrectCase(String input, OperatorModel expected) {
        assertEquals(expected, OperatorModel.fromString(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/OperatorModel/testDataFromStringIncorrectCase.csv")
    public void testFromStringIncorrectCase(String input) {
        assertThrows(IllegalArgumentException.class, () -> OperatorModel.fromString(input));
    }
}