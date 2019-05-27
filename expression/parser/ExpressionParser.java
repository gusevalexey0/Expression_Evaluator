package expression.parser;

import expression.*;

public class ExpressionParser implements Parser{
    private myTokenizer tokenizer;
    @Override
    public CommonExpression parse(String expression) throws Exception{
        tokenizer = new myTokenizer(expression);
        return AddSub();
    }

    private CommonExpression AddSub() throws Exception {
        CommonExpression res = MulDiv();
        for (;;) {
            switch (tokenizer.getCurrentToken()) {
                case ADD:
                    res = new Add(res, MulDiv());
                    break;
                case SUB:
                    res = new Subtract(res, MulDiv());
                    break;
                default:
                    return res;
            }
        }
    }

    private CommonExpression MulDiv() throws Exception {
        CommonExpression res = elementary();
        for (;;) {
            switch (tokenizer.getCurrentToken()) {
                case MUL:
                    res = new Multiply(res, elementary());
                    break;
                case DIV:
                    res = new Divide(res, elementary());
                default:
                    return res;
            }
        }
    }

    private CommonExpression elementary() throws Exception {
        CommonExpression res = null;
        switch (tokenizer.getNextToken()) {
            case CONST:
                res = new Const(tokenizer.getValue());
                tokenizer.getNextToken();
                break;
            case VAR:
                res = new Variable(tokenizer.getName());
                tokenizer.getNextToken();
                break;
            case NEGATE:
                res = new Negate(elementary());
                break;
            case ABS:
                res = new Abs(elementary());
                break;
            case SQRT:
                res = new Sqrt(elementary());
                break;
            case OBRACE:
                res = AddSub();
                tokenizer.getNextToken();
                break;
        }
        return res;
    }
}
