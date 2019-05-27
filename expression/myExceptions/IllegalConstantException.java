package expression.myExceptions;

public class IllegalConstantException extends ParsingException {
    public IllegalConstantException(int ind) {
        super("Illegal constant at:" + ind);
    }
}
