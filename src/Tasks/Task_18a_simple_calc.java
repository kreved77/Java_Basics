package Tasks;
//  Практическое задание №3 / 63207784
//  https://lmsdo.rea.ru/mod/quiz/view.php?id=10745
/*
Calculator that calls each of function from a separate method.
1.    Необходимо реализовать калькулятор с использование методов. Каждая операция калькулятора - это отдельный метод программы.
        1.Add
        2.Subtract
        3.Multiplication
        4.Division
        5.Square
        6.Power
        7.Mod operation
        8.Factorial
        0.Quit
*/

import java.time.temporal.ValueRange;
import java.util.Scanner;

public class Task_18a_simple_calc {
    public static void main(String[] args) {
        System.out.println("Калькулятор с использованием методов.");
        MainAction();
    }

    private static void MainAction() {
        int operation = 0;
        ValueRange range = ValueRange.of(0, 8);
        do {
            operation = AskAction();
//        } while (operation <= 0 || operation > 4);
        } while (!range.isValidValue(operation));
        if (operation == 0) System.exit(0);

        char symbol = 'A';
        float a = AskNumber(symbol);
        float b = 1;
//        if (operation != 5 && operation != 8 ) {
        if (!(operation == 5 || operation == 8)) {
            symbol = 'B';
            b = AskNumber(symbol);
        }

        float result = 0;
        switch (operation) {
            case 1 -> result = Sum(a, b);
            case 2 -> result = Diff(a, b);
            case 3 -> result = Mult(a, b);
            case 4 -> result = Div(a, b);
            case 5 -> result = Square(a);
            case 6 -> result = Power(a, b);
            case 7 -> result = Mod(a, b);
            case 8 -> result = Factorial(a);
//            case 0 -> System.exit(0);
//            default -> MainAction();
        }
        System.out.println("Результат вычисления: " + result);

        MainAction();
    }

    static int AskNumber(char symbol) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Введите число: %s=", symbol);
        int value = 0;
        try {
            value = input.nextInt();
            return value;
        } catch (Exception exception) {
            System.out.println("Ошибка. Введен неверный тип данных.");
            float a = AskNumber(symbol);
        }
        return value;

    }
    static int AskAction() {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите операцию калькулятора: 1(+) 2(-) 3(*) 4(/) 5(^2) 6(^) 7(%) 8(!) (0)Quit");
        int operation = 0;
        try {
            operation = input.nextInt();
        } catch (Exception exception) {
            System.out.println("Ошибка. Введен неверный тип данных.");
            MainAction();
//            return 0;
        }
        return operation;
    }

    static float Sum(float a, float b) {
        return (a + b);
    }
    static float Diff(float a, float b) {
        return (a - b);
    }
    static float Mult(float a, float b) {
        return (a * b);
    }
    static float Div(float a, float b) {
        if (b == 0) {
            System.out.println("Деление на 0 запрещено. Please, try again.");
//            System.exit(0);
            MainAction();
        }
        return (a / b);
    }

    static float Square(float a) {
        return a * a;
    }

    static float Power(float a, float b) {
        float result = 1;

        while (b != 0)
        {
            result *= a;
            --b;
        }
        return result;
    }

    static float Mod(float a, float b) {
        return (a % b);
    }

    static float Factorial(float a) {

        if (a == 1) return 1;
        float result = a;
        result = result * Factorial(a - 1);

        return result;
    }
}
