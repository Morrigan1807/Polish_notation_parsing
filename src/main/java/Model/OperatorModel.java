package Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OperatorModel {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operatorAsChar;

    public static OperatorModel fromString(String string)
    {
        switch (string)
        {
            case "+":
                return OperatorModel.ADDITION;
            case "-":
                return OperatorModel.SUBTRACTION;
            case "*":
                return OperatorModel.MULTIPLICATION;
            case "/":
                return OperatorModel.DIVISION;
            default:
                throw new IllegalArgumentException("Not an operator: " + string);
        }
    }
}
