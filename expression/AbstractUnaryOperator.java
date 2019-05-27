package expression;

import expression.myExceptions.EvaluatingException;

public abstract class AbstractUnaryOperator implements CommonExpression{
    private final CommonExpression first;

    public AbstractUnaryOperator(final CommonExpression first) {
        this.first = first;
    }

    @Override
    public double evaluate(final double x) throws EvaluatingException {
        return calc(first.evaluate(x));
    }

    protected abstract double calc(final double first) throws EvaluatingException;
    protected abstract int calc(final int first) throws EvaluatingException;
    protected abstract void check(final int first) throws EvaluatingException;

    @Override
    public int evaluate(final int x) throws EvaluatingException {
        return calc(first.evaluate(x));
    }

    @Override
    public int evaluate(final int x, final int y, final int z) throws EvaluatingException {
        return calc(first.evaluate(x, y, z));
    }
}
