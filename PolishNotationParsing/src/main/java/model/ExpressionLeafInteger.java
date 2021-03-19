package model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExpressionLeafInteger implements ExpressionTree{
    private final int leaf;

    public double calculate()
    {
        return leaf;
    }

    public String toPolishNotation()
    {
            return Integer.toString(leaf);
    }
}
