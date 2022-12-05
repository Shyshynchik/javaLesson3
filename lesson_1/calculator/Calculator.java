import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Calculator {

    private Deque<String> numbers;
    private Deque<String> symbols;
    private String lastOperation;

    private static final Pattern pattern = Pattern.compile("-?\\d+|[+\\-*/]|[(\\)/]");

    public int calculate(String expression) {

        String[] expressionsElements = getExpressionElements(expression);

        numbers = new ArrayDeque<>();
        symbols = new ArrayDeque<>();

        for (String element : expressionsElements) {
            resolveElement(element);
        }

        while (!symbols.isEmpty()) {
            calculateValue();
        }

        return Integer.parseInt(numbers.pop());
    }

    private String[] getExpressionElements(String expression) {
        return pattern.matcher(expression).results().map(MatchResult::group).toArray(String[]::new);
    }

    private void resolveElement(String element) {
        if (isNumeric(element)) {
            numbers.push(element);
            return;
        }
        if (symbols.isEmpty() || element.equals("(")) {
            symbols.push(element);
            lastOperation = element;
            return;
        }
        if (element.equals(")")) {
            calculateBracket(element);
            return;
        }

        int operationPriority = getOperationPriority(element);
        int lastOperationPriority = getOperationPriority(lastOperation);
        if (operationPriority <= lastOperationPriority) {
            calculateValue();
            symbols.push(element);
            return;
        }

        symbols.push(element);
        lastOperation = element;
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private int getOperationPriority(String operation) {
        if (operation.equals("+") || operation.equals("-")) {
            return 1;
        }
        if (operation.equals("*") || operation.equals("/")) {
            return 2;
        }

        return -1;
    }

    private void calculateBracket(String symbol) {
        while (!symbol.equals("(")) {
            calculateValue();
            symbol = symbols.pop();
        }

        if (!symbols.isEmpty()) {
            lastOperation = symbols.pop();
            symbols.push(lastOperation);
        }
    }

    private void calculateValue() {
        String operation = symbols.pop();
        Integer second = Integer.parseInt(numbers.pop());
        Integer first = Integer.parseInt(numbers.pop());


        if (operation.equals("+")) {
            numbers.push(String.valueOf(first + second));
        }
        if (operation.equals("-")) {
            numbers.push(String.valueOf(first - second));
        }
        if (operation.equals("*")) {
            numbers.push(String.valueOf(first * second));
        }
        if (operation.equals("/")) {
            numbers.push(String.valueOf(first / second));
        }
    }
}
