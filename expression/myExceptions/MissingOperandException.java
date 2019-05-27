package expression.myExceptions;

public class MissingOperandException extends ParsingException {
    public MissingOperandException(final int ind) {
        super("Missing operand at:" + ind);
    }
}
