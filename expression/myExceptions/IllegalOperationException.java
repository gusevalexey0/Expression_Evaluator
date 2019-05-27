package expression.myExceptions;

public class IllegalOperationException extends EvaluatingException {
    public IllegalOperationException(String message) {
        super(message);
    }
}
