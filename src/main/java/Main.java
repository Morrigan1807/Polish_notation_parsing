import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Input expression:");
        String inputExpression = in.nextLine();

        ExpressionParser expressionParser = ExpressionParser.parseExpression(inputExpression);

        System.out.println("Polish notation:");
        System.out.println(expressionParser.toPolishNotation());

        System.out.println("Result of calculating:");
        System.out.println(expressionParser.calculateExpression());
    }
}
