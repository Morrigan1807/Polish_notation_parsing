package parametrizedtests.model;

import model.ExpressionLeafDouble;
import model.ExpressionNode;
import model.OperatorModel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constant.*;

public class ExpressionNodeTest {

    @ParameterizedTest
    @CsvFileSource(resources = PATH_TO_EXPRESSION_NODE_TEST_DATA + TEST_DATA_GET_RESULT_OF_EXPRESSION)
    public void testGetResultOfExpression(String operator, double leftOperand, double rightOperand, double expected) {
        ExpressionNode expressionNode = new ExpressionNode();
        expressionNode.setRootOperator(OperatorModel.fromString(operator));
        expressionNode.setLeftOperand(new ExpressionLeafDouble(leftOperand));
        expressionNode.setRightOperand(new ExpressionLeafDouble(rightOperand));

        assertEquals(expected, expressionNode.getResultOfExpression(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = PATH_TO_EXPRESSION_NODE_TEST_DATA + TEST_DATA_GET_STRING_OF_POLISH_NOTATION)
    public void testGetStringOfPolishNotation(String operator, double leftOperand, double rightOperand, String expected) {
        ExpressionNode expressionNode = new ExpressionNode();
        expressionNode.setRootOperator(OperatorModel.fromString(operator));
        expressionNode.setLeftOperand(new ExpressionLeafDouble(leftOperand));
        expressionNode.setRightOperand(new ExpressionLeafDouble(rightOperand));

        assertEquals(expected, expressionNode.getStringOfPolishNotation());
    }


}