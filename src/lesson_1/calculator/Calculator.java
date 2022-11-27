package lesson_1.calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private Deque<String> numbers;
    private Deque<String> symbols;
    private String lastOperation;

    public int calculate(String expression) {

        String[] expressionsElements = this.getExpressionElements(expression);

        this.numbers = new ArrayDeque<>();
        this.symbols = new ArrayDeque<>();

        for (String element : expressionsElements) {
            this.parseElement(element);
        }

        while (!this.symbols.isEmpty()) {
            this.calculateValue(this.numbers.pop(), this.numbers.pop(), this.symbols.pop());
        }

        return Integer.parseInt(numbers.pop());
    }

    private String[] getExpressionElements(String expression) {
        Pattern pattern = Pattern.compile("\\d+|[+\\-*/]|[(\\)/]");

        Matcher matcher = pattern.matcher(expression);

        return matcher.results().map(MatchResult::group).toArray(String[]::new);
    }

    private void parseElement(String element) {
        if (this.isNumeric(element)) {
            this.numbers.push(element);
            return;
        }
        if (this.symbols.isEmpty() || element.equals("(")) {
            this.symbols.push(element);
            this.lastOperation = element;
            return;
        }
        if (element.equals(")")) {
            this.calculateBracket();
            return;
        }

        int operationPriority = this.getOperationPriority(element);
        int lastOperationPriority = this.getOperationPriority(lastOperation);
        if (operationPriority <= lastOperationPriority) {
            this.calculateValue(numbers.pop(), numbers.pop(), symbols.pop());
            this.symbols.push(element);
            return;
        }

        this.symbols.push(element);
        this.lastOperation = element;
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

    private void calculateBracket() {
        String symbol = this.symbols.pop();
        while (!symbol.equals("(")) {
            calculateValue(this.numbers.pop(), this.numbers.pop(), symbol);
            symbol = this.symbols.pop();
        }

        if (!this.symbols.isEmpty()) {
            lastOperation = this.symbols.pop();
            this.symbols.push(lastOperation);
        }
    }

    private void calculateValue(String secondValue, String firstValue, String operation) {
        Integer first = Integer.parseInt(firstValue);
        Integer second = Integer.parseInt(secondValue);

        if (operation.equals("+")) {
            this.numbers.push(String.valueOf(first + second));
        }
        if (operation.equals("-")) {
            this.numbers.push(String.valueOf(first - second));
        }
        if (operation.equals("*")) {
            this.numbers.push(String.valueOf(first * second));
        }
        if (operation.equals("/")) {
            this.numbers.push(String.valueOf(first / second));
        }
    }
}
