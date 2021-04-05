package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static util.Constant.NOT_AN_OPERATOR;

@Getter
@RequiredArgsConstructor
public enum OperatorModel {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operatorAsChar;

    public static OperatorModel fromString(String string) {
        switch (string) {
            case "+":
                return OperatorModel.ADDITION;
            case "-":
                return OperatorModel.SUBTRACTION;
            case "*":
                return OperatorModel.MULTIPLICATION;
            case "/":
                return OperatorModel.DIVISION;
            default:
                throw new IllegalArgumentException(NOT_AN_OPERATOR + string);
        }
    }
}
