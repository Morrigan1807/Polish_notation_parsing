package ParameterizedTests.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExpressionLeafDouble implements ExpressionTree {

    private final double leaf;

    public double getResultOfExpression() {
        return leaf;
    }

    public String getStringOfPolishNotation() {
        return Double.toString(leaf);
    }
}
