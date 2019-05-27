package expression;

import expression.myExceptions.EvaluatingException;

public interface Expression {
    //Pre: x == int
    int evaluate(int x) throws EvaluatingException;
    //Post: Expr calculated
}
