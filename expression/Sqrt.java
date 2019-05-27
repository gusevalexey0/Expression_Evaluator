package expression;

import expression.myExceptions.EvaluatingException;
import expression.myExceptions.IllegalOperationException;

public class Sqrt extends AbstractUnaryOperator {
    public Sqrt(CommonExpression first) {
        super(first);
    }

    @Override
    protected int calc(int first) throws EvaluatingException {
        check(first);
        int l = 0;
        int r = 46340;
        while (r - l > 1) {
            int m = (l + r) >> 1;
            if (m * m <= first) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    @Override
    protected double calc(double first) throws EvaluatingException {
        return 0;
    }

    @Override
    protected void check(int first) throws EvaluatingException {
        if (first < 0) {
            throw new IllegalOperationException("Sqrt from negative");
        }
    }
}
