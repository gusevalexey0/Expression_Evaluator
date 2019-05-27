package expression;

public class Const implements CommonExpression {
    private final Number value;

    public Const(final int value) {
        this.value = value;
    }

    @Override
    public int evaluate(final int x) {
        return value.intValue();
    }

    @Override
    public double evaluate(final double x) {
        return value.doubleValue();
    }

    @Override
    public int evaluate(final int x, final int y, final int z) {
        return value.intValue();
    }
}
