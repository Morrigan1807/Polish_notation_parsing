package model;

import lombok.Data;

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
                return leftOperand.getResultOfExpression() / rightOperand.getResultOfExpression();

            default:
                throw new ArithmeticException("Wong operator type.");
        }
    }

    public String getStringOfPolishNotation() {
        return leftOperand.getStringOfPolishNotation() + " " + rightOperand.getStringOfPolishNotation() + " " + rootOperator.getOperatorAsChar();
    }
}
