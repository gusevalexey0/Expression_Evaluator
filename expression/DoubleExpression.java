package expression;

import expression.myExceptions.EvaluatingException;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public strictfp interface DoubleExpression {
    double evaluate(double x) throws EvaluatingException;
}
