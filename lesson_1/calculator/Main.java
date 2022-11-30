public class Main {

    public static void main(String[] args) {
        String str = "(26 - 14) + -2 * 4 * -15 - (2 + 6)";

        Calculator calculator = new Calculator();

        System.out.println(calculator.calculate(str));

    }
}