public class Interpreter {
    public static void main(String args[]) {
        System.out.println("20 cộng 8 = " + interpret("20 cộng 8"));
        System.out.println("10 trừ 4 = " + interpret("10 trừ 4"));
    }

    private static int interpret(String input) {
        Expression exp = null;
        if (input.contains("cộng")) {
            exp = new AddExpression(input);
        } else if (input.contains("trừ")) {
            exp = new SubtractExpression(input);
        } else {
            throw new UnsupportedOperationException();
        }
        return exp.interpret(new InterpreterEngineContext());
    }
}
class InterpreterEngineContext {

    public int add(String input) {
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1 + num2);
    }

    public int subtract(String input) {
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1 - num2);
    }

    private String[] interpret(String input) {
        String str = input.replaceAll("[^0-9]", " ");
        str = str.replaceAll("( )+", " ").trim();
        return str.split(" ");
    }
}
interface Expression {
    int interpret(InterpreterEngineContext context);
}
class AddExpression implements Expression {

    private String expression;

    public AddExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public int interpret(InterpreterEngineContext context) {
        return context.add(expression);
    }
}
class SubtractExpression implements Expression {

    private String expression;

    public SubtractExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public int interpret(InterpreterEngineContext context) {
        return context.subtract(expression);
    }
}