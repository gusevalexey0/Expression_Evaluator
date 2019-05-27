package expression;

public class Variable implements CommonExpression {
    private final String name;

    public Variable(final String name) {
        this.name = name;
    }
    
    @Override
    public int evaluate(final int x) {
        return x;
    }

    @Override
    public double evaluate(final double x) {
        return x;
    }

    @Override
    public int evaluate(final int x, final int y, final int z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                return 0;
        }
    }
}
