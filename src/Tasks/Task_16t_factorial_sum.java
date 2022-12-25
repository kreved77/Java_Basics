package Tasks;

import java.util.Scanner;

// программа по сложению двух факториалов
// С РЕКУРСИЕЙ и БЕЗ РЕКУРСИИ

public class Task_16t_factorial_sum {

    public static void main(String[] args) {

        System.out.println("Вас приветствует программа по сложению двух факториалов");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите первый факториал: ");
        int a = input.nextInt();
        System.out.println("Введите второй факториал: ");
        int b = input.nextInt();
        System.out.print("Сумма факториалов !" + a + " и !" + b + " = ");
        System.out.println(FactorialDifference(a) + FactorialDifference(b));
    }

    static int FactorialDifference(int factorial)
    {
// С РЕКУРСИЕЙ
        if (factorial <= 1)
        {
            return 1;
        }
        else {
            return factorial * FactorialDifference(factorial - 1);
        }

// БЕЗ РЕКУРСИИ
/*
        int resultFactorial = 1;
        for(int i = 1; i <= factorial; i++)
        {
            resultFactorial = resultFactorial * i;
        }
        return resultFactorial;
        */
    }
}