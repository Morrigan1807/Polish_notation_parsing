package model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExpressionLeafInteger implements ExpressionTree {

    private final int leaf;

    public double getResultOfExpression() {
        return leaf;
    }

    public String getStringOfPolishNotation() {
        return Integer.toString(leaf);
    }
}
