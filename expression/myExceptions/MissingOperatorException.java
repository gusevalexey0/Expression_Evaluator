package expression.myExceptions;

public class MissingOperatorException extends ParsingException {
    public MissingOperatorException(final int ind) {
        super("Missing operator at:" + ind);
    }
}
