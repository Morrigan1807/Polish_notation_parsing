package Model;

import lombok.Data;

@Data
public class ExpressionNode implements ExpressionTree{
    private ExpressionTree leftOperand;
    private ExpressionTree rightOperand;
    private OperatorModel rootOperator;

    public double calculate()
    {
        double res = 0;

        switch (rootOperator)
        {
            case ADDITION:
                res = leftOperand.calculate() + rightOperand.calculate();
                break;

            case SUBTRACTION:
                res = leftOperand.calculate() - rightOperand.calculate();
                break;

            case MULTIPLICATION:
                res = leftOperand.calculate() * rightOperand.calculate();
                break;

            case DIVISION:
                res = leftOperand.calculate() / rightOperand.calculate();
                break;
        }

        return res;
    }

    public String toPolishNotation()
    {
        return rootOperator.getOperatorAsChar() + " " + leftOperand.toPolishNotation() + " " + rightOperand.toPolishNotation();
    }
}
