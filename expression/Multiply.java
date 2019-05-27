package expression;

import expression.myExceptions.EvaluatingException;
import expression.myExceptions.OverflowException;

public class Multiply extends AbstractBinaryOperator{

    public Multiply(final CommonExpression first, final CommonExpression second) {
        super(first, second);
    }

    @Override
    protected int calc(final int first, final int second) throws EvaluatingException {
        check(first, second);
        return first * second;
    }

    @Override
    protected double calc(final double first, final double second) {
        return first * second;
    }

    @Override
    protected void check(final int first, final int second) throws EvaluatingException {
        if (first > 0 && second > 0 && Integer.MAX_VALUE / first < second) {
            throw new OverflowException();
        }
        if (first > 0 && second < 0 && Integer.MIN_VALUE / first > second) {
            throw new OverflowException();
        }
        if (first < 0 && second > 0 && Integer.MIN_VALUE / second > first) {
            throw new OverflowException();
        }
        if (first < 0 && second < 0 && Integer.MAX_VALUE / first > second) {
            throw new OverflowException();
        }
    }
}
