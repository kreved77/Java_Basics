package Tasks;

//  Практическое задание №1
//  https://lmsdo.rea.ru/mod/quiz/view.php?id=10381

import java.util.Scanner;

public class Task_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        byte taskNumber = 1;
        while (taskNumber != 0) {
        //Выбираем номер задачи из задания №1
        System.out.println("Задание №1. Введите номер задачи (варианты 1 - 6, для выхода - 0):");
        taskNumber = input.nextByte();
            switch (taskNumber) {

    //          Задача 1. Дано целое число.
    //          • Если оно является положительным, то прибавить к нему 1;
    //          • в противном случае не изменять его.
    //          Вывести полученное число.
                case 1:
                    System.out.println("Выполняем задачу 1.");
                    System.out.println("Введите целое число:");
                    int x = input.nextInt();
                    if (x > 0) {
                        x++;
                        System.out.println("Число увеличено на 1: " + x);
                    } else {
                        System.out.println("Число не изменилось: " + x);
                    }
                    break;

    //          Задача 2. Дано целое число.
    //          • Если оно является положительным, то прибавить к нему 1;
    //          • если отрицательным, то вычесть из него 2;
    //          • если нулевым, то заменить его на 10.
    //          Вывести полученное число.
                case 2:
                    System.out.println("Выполняем задачу 2.");
                    System.out.println("Введите целое число:");
                    x = input.nextInt();
                    if (x > 0) x +=1;
                        else if (x < 0) x -=2;
                        else x = 10;
                    System.out.println("Теперь число: " + x);
                    break;

    //          Задача 3. Даны три переменные вещественного типа: A, B, C.
    //          • Если их значения упорядочены по возрастанию, то удвоить их;
    //          • в противном случае заменить значение каждой переменной на противоположное.
    //          Вывести новые значения переменных A, B, C
                case 3:
                    System.out.println("Выполняем задачу 3.");
                    System.out.println("Введите число A:");
                    float a = input.nextFloat();
                    System.out.println("Введите число B:");
                    float b = input.nextFloat();
                    System.out.println("Введите число C:");
                    float c = input.nextFloat();
                    if (a <= b && b <= c) {
                        a *= 2;
                        b *= 2;
                        c *= 2;
                        System.out.println("Вы ввели переменные по возрастанию. Мы их удвоили: A=" + a + ", B=" + b + ", C=" + c);
                    } else {
                        a *= -1;
                        b *= -1;
                        c *= -1;
                        System.out.println("Переменные изменены на противоположные: A=" + a + ", B=" + b + ", C=" + c);
                    }
                    break;

    //          Задача 4.
    //          Единицы массы пронумерованы следующим образом: 1 — килограмм, 2 — миллиграмм, 3 — грамм, 4 — тонна, 5 — центнер.
    //          Дан номер единицы массы (целое число в диапазоне 1–5) и масса тела в этих единицах (вещественное число).
    //          Найти массу тела в килограммах.
                case 4:
                    System.out.println("Выполняем задачу 4.");
                    System.out.println("Введите массу тела:");
                    float mass = input.nextFloat();
                    System.out.println("Введите единицу массы\n(1 — килограмм,\n2 — миллиграмм,\n3 — грамм,\n4 — тонна,\n5 — центнер):");
//                    int massType = input.nextInt();
                    switch (input.nextInt()) {
                        case 1 -> System.out.printf("Масса тела равна %f килограмм.\n", mass);
                        case 2 -> System.out.println("Масса тела равна " + mass * 0.000001 + " килограмм.");
                        case 3 -> System.out.println("Масса тела равна " + mass * 0.001 + " килограмм.");
                        case 4 -> System.out.println("Масса тела равна " + mass * 1000 + " килограмм.");
                        case 5 -> System.out.println("Масса тела равна " + mass * 100 + " килограмм.");
                        default -> System.out.println("Вы выбрали неверную Единицу массы. Расчет завершен.");
/*                        case 1:
                            System.out.println("Масса тела равна " + mass + " килограмм.");
                            break;
                        case 2:
                            System.out.println("Масса тела равна " + mass * 0.000001 + " килограмм.");
                            break;
                        case 3:
                            System.out.println("Масса тела равна " + mass * 0.001 + " килограмм.");
                            break;
                        case 4:
                            System.out.println("Масса тела равна " + mass * 1000 + " килограмм.");
                            break;
                        case 5:
                            System.out.println("Масса тела равна " + mass * 100 + " килограмм.");
                            break;
                        default:
                            System.out.println("Выбрана неверна единицу массы. Расчет завершен.");
                            break;*/
                    }
                    break;

    //          Задача 5. Необходимо реализовать консольный калькулятор со всеми основными арифметическими операциями.
    //          • Пользователь вводит 2 числа с клавиатуры
    //          • и выбирает операцию из списка.
    //          • Если пользователь выбрал не существующую операцию необходимо вывести соответствующее сообщение.
    //          Вывести полученный результат.
                case 5:
                    System.out.println("Выполняем задачу 5.");
                    System.out.println("Введите число A:");
                    a = input.nextInt();
                    System.out.println("Введите число B:");
                    b = input.nextInt();
                    System.out.println("Выберите тип операции: 1(+), 2(-), 3(*), 4(/)");
                    switch (input.nextByte()) {
                        case 1:
                            System.out.println("A+B=" + (a+b));
                            break;
                        case 2:
                            System.out.println("A-B=" + (a-b));
                            break;
                        case 3:
                            System.out.println("A*B=" + (a*b));
                            break;
                        case 4:
                            System.out.println("A+B=" + (a/b));
                            break;
                        default:
                            System.out.println("Неверный Тип операции. Расчет завершен.");
                            break;
                    }
                    break;

    //          Задача 6. Дано целое число в диапазоне 1–7.
    //          Вывести строку — название дня недели, соответствующее данному числу (1 — «понедельник», 2 — «вторник» и т. д.).
                case 6:
                    System.out.println("Выполняем задачу 6.");
                    System.out.println("Выберите день недели:\n(1 — ПН,\n2 — ВТ,\n3 — СР,\n4 — ЧТ,\n5 — ПТ,\n6 — СБ,\n7 — ВС):");
                    int day = input.nextInt();
                    switch (day) {
                        case 1:
                            System.out.println("Сегодня ПН");
                            break;
                        case 2:
                            System.out.println("Сегодня ВТ");
                            break;
                        case 3:
                            System.out.println("Сегодня СР");
                            break;
                        case 4:
                            System.out.println("Сегодня ЧТ");
                            break;
                        case 5:
                            System.out.println("Сегодня ПТ");
                            break;
                        case 6:
                            System.out.println("Сегодня СБ");
                            break;
                        case 7:
                            System.out.println("Сегодня ВС");
                            break;
                        default:
                            System.out.println("Неверный День недели. Вывод завершен.");
                    }
                    break;

    //          Выход
                case 0:
    //                System.out.println("Программа завершена.");
                    break;

    //          Исключения
                default:
                    System.out.println("Выбран неверный номер задачи. Повторите попытку.");
                    break;
            }
        }
        System.out.println("Программа завершена.");

    }
}
