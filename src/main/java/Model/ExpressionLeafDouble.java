package Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExpressionLeafDouble implements ExpressionTree {
    private final double leaf;

    public double calculate()
    {
        return leaf;
    }

    public String toPolishNotation()
    {
            return Double.toString(leaf);
    }
}
