package expression.parser;

import expression.myExceptions.IllegalConstantException;
import expression.myExceptions.MissingOperandException;
import expression.myExceptions.MissingOperatorException;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class myTokenizer {
    private static final Map<String, Token> IDENTIFIERS = new HashMap<>();
    private final String expr;
    private int i;
    private Token curToken;
    private int balance;
    private int curValue;
    private String varName;
    private static final Set<Token> OPERATIONS = EnumSet.of(Token.ADD, Token.DIV, Token.MUL, Token.NEGATE, Token.SUB, Token.ABS, Token.SQRT);

    static {
        IDENTIFIERS.put("x", Token.VAR);
        IDENTIFIERS.put("y", Token.VAR);
        IDENTIFIERS.put("sqrt", Token.SQRT);
        IDENTIFIERS.put("abs", Token.ABS);
    }

    public myTokenizer(final String expr) {
        this.expr = expr;
        this.i = 0;
        this.balance = 0;
        this.curToken = Token.START;
    }

    public Token getNextToken() throws Exception {
        nextToken();
        return curToken;
    }

    public Token getCurrentToken() {
        return curToken;
    }

    private void checkOperand(final int i) throws MissingOperandException {
        if (OPERATIONS.contains(curToken) || curToken == Token.OBRACE) {
            throw new MissingOperandException(i);
        }
    }

    private void checkOperator(final int i) throws MissingOperatorException {
        if (curToken == Token.CONST || curToken == Token.VAR || curToken == Token.CBRACE) {
            throw new MissingOperatorException(i);
        }
    }

    private void nextToken() throws Exception {
        skipWhitespace();
        if (i >= expr.length()) {
            checkOperand(i);
            curToken = Token.END;
            return;
        }
        switch (expr.charAt(i)) {
            case '+':
                checkOperand(i);
                curToken = Token.ADD;
                break;
            case '-':
                if (curToken == Token.CONST || curToken == Token.VAR || curToken == Token.CBRACE){
                    curToken = Token.SUB;
                } else {
                    if (expr.length() <= i + 1) {
                        throw new MissingOperandException(i);
                    } else {
                        if (Character.isDigit(expr.charAt(i + 1))) {
                            ++i;
                            curValue = -getNumber();
                            curToken = Token.CONST;
                        } else {
                            curToken = Token.SUB;
                        }
                    }
                }
                break;
            case '*':
                checkOperand(i);
                curToken = Token.MUL;
                break;
            case '/':
                checkOperand(i);
                curToken = Token.DIV;
                break;
            case '(':
                checkOperator(i);
                ++balance;
                curToken = Token.OBRACE;
                break;
            case ')':
                if (curToken == Token.OBRACE || OPERATIONS.contains(curToken)) {
                    throw new MissingOperandException(i);
                } else {
                    if (--balance < 0) {
                        throw new Exception("brackets");
                    }
                    curToken = Token.CBRACE;
                    break;
                }
            default:
                if (!Character.isDigit(expr.charAt(i))) {
                    String identifier = getIdentifier();
                    checkOperator(i);
                    curToken = IDENTIFIERS.get(identifier);
                    if (curToken == Token.VAR) {
                        varName = identifier;
                    }
                } else {
                    checkOperator(i);
                    curValue = getNumber();
                    curToken = Token.CONST;
                }
        }
        ++i;
    }

    private String getIdentifier() {
        int st = i;
        while (i < expr.length() && Character.isLetterOrDigit(expr.charAt(i))) {
            ++i;
        }
        int en = i;
        --i;
        return expr.substring(st, en);
    }

    private int getNumber() throws IllegalConstantException {
        int st = i;
        while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
            ++i;
        }
        int en = i;
        int res;
        --i;
        try {
            res = Integer.parseInt(expr.substring(st, en));
        } catch (NumberFormatException e) {
            throw new IllegalConstantException(i - en - st + 1);
        }
        return res;
    }

    private void skipWhitespace() {
        while (i < expr.length() && Character.isWhitespace(expr.charAt(i))) {
            ++i;
        }
    }

    public int getValue() {
        return curValue;
    }

    public String getName() {
        return varName;
    }
}
