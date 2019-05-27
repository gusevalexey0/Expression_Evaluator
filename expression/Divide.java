package expression;

import expression.myExceptions.EvaluatingException;
import expression.myExceptions.IllegalOperationException;
import expression.myExceptions.OverflowException;

public class Divide extends AbstractBinaryOperator{

    public Divide(final CommonExpression first, final CommonExpression second) {
        super(first, second);
    }

    @Override
    protected int calc(final int first, final int second) throws EvaluatingException{
        check(first, second);
        return first / second;
    }

    @Override
    protected double calc(final double first, final double second) throws EvaluatingException{
        return first / second;
    }

    @Override
    protected void check(final int first, final int second) throws EvaluatingException {
        if (second == 0) {
            throw new IllegalOperationException("Division by zero");
        }
        if (first == Integer.MIN_VALUE && second == -1) {
            throw new OverflowException();
        }
    }
}
