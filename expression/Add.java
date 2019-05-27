package expression;

import expression.myExceptions.EvaluatingException;
import expression.myExceptions.OverflowException;

public class Add extends AbstractBinaryOperator{

    public Add(final CommonExpression first, final CommonExpression second) {
        super(first, second);
    }

    @Override
    protected int calc(final int first, final int second) throws EvaluatingException {
        check(first, second);
        return first + second;
    }

    @Override
    protected double calc(final double first, final double second) throws EvaluatingException {
        return first + second;
    }

    @Override
    protected void check(final int first, final int second) throws EvaluatingException {
        if (first > 0 && Integer.MAX_VALUE - first < second) {
            throw new OverflowException();
        }
        if (first < 0 && Integer.MIN_VALUE - first > second) {
            throw new OverflowException();
        }
    }
}
