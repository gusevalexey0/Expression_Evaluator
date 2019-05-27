package expression;

import expression.myExceptions.EvaluatingException;
import expression.myExceptions.OverflowException;

public class Abs extends AbstractUnaryOperator {
    public Abs(expression.CommonExpression first) {
        super(first);
    }

    @Override
    protected double calc(double first) throws EvaluatingException {
        return 0;
    }

    @Override
    protected int calc(int first) throws EvaluatingException {
        check(first);
        if (first < 0) {
            return -first;
        }
        return first;
    }

    @Override
    protected void check(int first) throws EvaluatingException {
        if (first == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
    }
}
