import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Это элементый калькулятор");
        System.out.println("Введите ваши вычисления:");

        String input = scanner.nextLine().replaceAll(" ", ""); // Удаляем пробелы.
        checkExpression(input);

        int num1 = Integer.parseInt(input.split("[+\\-*/]")[0]);
        int num2 = Integer.parseInt(input.split("[+\\-*/]")[1]);
        char operator = input.split("\\d+")[1].charAt(0);

        int result;

        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new IllegalArgumentException("Ошибка! Деление на ноль запрещено.");
                }
            }
            default ->
                    throw new IllegalArgumentException("Неверный выбор оператора. Он должен быть одним из следующих: +, -, *, /");
        }

        System.out.println("Результат: " + result);
    }

    public static void checkExpression(String input){
        int digitCount = 0;
        int operatorCount = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if (digit >= 1 && digit <= 10) {
                    digitCount++;
                }
            } else if (c == '+'|| c == '-' || c == '/' || c == '*') {
                operatorCount++;
            }
        }
        if (digitCount != 2 || operatorCount != 1) {
                throw new IllegalArgumentException("Ошибка: строка должна содержать две цифры от 1 до 10 и один оператор.");
        }
    }
}