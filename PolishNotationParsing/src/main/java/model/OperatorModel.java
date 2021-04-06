package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static util.Constant.*;

@Getter
@RequiredArgsConstructor
public enum OperatorModel {

    ADDITION(ADDITION_AS_STRING),
    SUBTRACTION(SUBTRACTION_AS_STRING),
    MULTIPLICATION(MULTIPLICATION_AS_STRING),
    DIVISION(DIVISION_AS_STRING);

    private final String operatorAsChar;

    public static OperatorModel fromString(String string) {
        switch (string) {
            case ADDITION_AS_STRING:
                return OperatorModel.ADDITION;
            case SUBTRACTION_AS_STRING:
                return OperatorModel.SUBTRACTION;
            case MULTIPLICATION_AS_STRING:
                return OperatorModel.MULTIPLICATION;
            case DIVISION_AS_STRING:
                return OperatorModel.DIVISION;
            default:
                throw new IllegalArgumentException(NOT_AN_OPERATOR + string);
        }
    }
}
