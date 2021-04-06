package model;

import lombok.Data;

import static util.Constant.SPACE;
import static util.Constant.WRONG_OPERATOR_TYPE;

@Data
public class ExpressionNode implements ExpressionTree {

    private ExpressionTree leftOperand;
    private ExpressionTree rightOperand;
    private OperatorModel rootOperator;

    public double getResultOfExpression() {
        switch (rootOperator) {
            case ADDITION:
                return leftOperand.getResultOfExpression() + rightOperand.getResultOfExpression();

            case SUBTRACTION:
                return leftOperand.getResultOfExpression() - rightOperand.getResultOfExpression();

            case MULTIPLICATION:
                return leftOperand.getResultOfExpression() * rightOperand.getResultOfExpression();

            case DIVISION:
                if (rightOperand.getResultOfExpression() == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return leftOperand.getResultOfExpression() / rightOperand.getResultOfExpression();

            default:
                throw new ArithmeticException(WRONG_OPERATOR_TYPE);
        }
    }

    public String getStringOfPolishNotation() {
        return leftOperand.getStringOfPolishNotation() + SPACE + rightOperand.getStringOfPolishNotation() + SPACE + rootOperator.getOperatorAsChar();
    }
}
