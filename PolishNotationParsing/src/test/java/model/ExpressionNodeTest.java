package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionNodeTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionNode/testData_Calculate_ExpressionNode.csv")
    public void testCalculate(String operator, double leftOperand, double rightOperand, double expected) {
        ExpressionNode expressionNode = new ExpressionNode();
        assertDoesNotThrow(() -> expressionNode.setRootOperator(OperatorModel.fromString(operator)));
        expressionNode.setLeftOperand(new ExpressionLeafDouble(leftOperand));
        expressionNode.setRightOperand(new ExpressionLeafDouble(rightOperand));

        assertEquals(expected, expressionNode.getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Test/TestExpressionNode/testData_toPolishNotation_ExpressionNode.csv")
    public void testToPolishNotation(String operator, double leftOperand, double rightOperand, String expected) {
        ExpressionNode expressionNode = new ExpressionNode();
        assertDoesNotThrow(() -> expressionNode.setRootOperator(OperatorModel.fromString(operator)));
        expressionNode.setLeftOperand(new ExpressionLeafDouble(leftOperand));
        expressionNode.setRightOperand(new ExpressionLeafDouble(rightOperand));

        assertEquals(expected, expressionNode.getStringOfPolishNotation());
    }


}