package expression;

import expression.myExceptions.EvaluatingException;

public abstract class AbstractBinaryOperator implements CommonExpression {
    private final CommonExpression first;
    private final CommonExpression second;

    //Pre: first != null && second != null
    public AbstractBinaryOperator(CommonExpression first, CommonExpression second) {
        this.first = first;
        this.second = second;
    }
    //Post: op1 == first && op2 == second

    @Override
    public int evaluate(final int x) throws EvaluatingException{
        return calc(first.evaluate(x), second.evaluate(x));
    }

    @Override
    public double evaluate(final double x) throws EvaluatingException{
        return calc(first.evaluate(x), second.evaluate(x));
    }

    @Override
    public int evaluate(final int x, final int y, final int z) throws EvaluatingException{
        return calc(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    protected abstract int calc(final int first, final int second) throws EvaluatingException;
    protected abstract double calc(final double first, final double second) throws EvaluatingException;
    protected abstract void check(final int first, final int second) throws EvaluatingException;
}
