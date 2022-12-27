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
    //    5.Square
    //    6.Power
    //    7.Mod operation
    //    8.Factorial
    //    0.Quit
*/

import java.util.Scanner;

public class Task_18a_simple_calc {
    public static void main(String[] args) {
        System.out.println("Калькулятор с использованием методов.");
        MainAction();
    }

    private static void MainAction() {
        char symbol = 'A';
        float a = AskNumber(symbol);
        symbol = 'B';
        float b = AskNumber(symbol);
        int operation = 0;
        do {
            operation = AskAction();
        } while (operation <= 0 || operation > 4);
        float result = 0;
        switch (operation) {
            case 1 -> result = Sum(a, b);
            case 2 -> result = Diff(a, b);
            case 3 -> result = Mult(a, b);
            case 4 -> result = Div(a, b);
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
        System.out.println("Выберите операцию калькулятора: 1(+) 2(-) 3(*) 4(/)");
        int operation = 0;
        try {
            operation = input.nextInt();
        } catch (Exception exception) {
            System.out.println("Ошибка. Введен неверный тип данных.");
            return 0;
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
}
