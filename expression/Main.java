package expression;

import expression.parser.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        try {
            System.out.println(parser.parse("1 + x * y").evaluate(2, 228, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
