package expression.myExceptions;

public class OverflowException extends EvaluatingException{
    public OverflowException() {
        super("Overflow error");
    }
}
