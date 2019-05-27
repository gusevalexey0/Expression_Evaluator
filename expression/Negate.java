package expression;

import expression.myExceptions.EvaluatingException;
import expression.myExceptions.OverflowException;

public class Negate extends AbstractUnaryOperator {
    public Negate(final CommonExpression first) {
        super(first);
    }

    @Override
    protected double calc(double first) throws EvaluatingException {
        return 0;
    }

    @Override
    protected int calc(final int first) throws EvaluatingException {
        check(first);
        return -first;
    }

    @Override
    protected void check(final int first) throws EvaluatingException {
        if (first == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
    }
}
