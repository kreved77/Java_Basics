package Tasks;

//  Практическое задание №1
//  https://lmsdo.rea.ru/mod/quiz/view.php?id=10381

import java.util.Scanner;

public class Task_11_sorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    //          Задача 3. Даны три переменные вещественного типа: A, B, C.
    //          • Если их значения упорядочены по возрастанию, то удвоить их;
    //          • в противном случае заменить значение каждой переменной на противоположное.
    //          Вывести новые значения переменных A, B, C

    //    ВАРИАНТ с сортировкой по возрастанию.
                    System.out.println("Задание №1. Выполняем задачу 3. ВАРИАНТ с сортировкой по возрастанию.");
                    System.out.println("Введите число A:");
                    float a = input.nextFloat();
                    System.out.println("Введите число B:");
                    float b = input.nextFloat();
                    System.out.println("Введите число C:");
                    float c = input.nextFloat();
                    // a<b<c +
                    if (a <= b && b <= c) {
                        a *= 2;
                        b *= 2;
                        c *= 2;
                        System.out.println("Вы ввели переменные по возрастанию. Мы их удвоили: A=" + a + ", B=" + b + ", C=" + c);
                    }
                    // a<c<b +
                    else if (a <= c && c <= b) {
                        float z = c;
                        c = b;
                        b = z;
                        System.out.println("Переставлены B и C. Новые значения переменных по возрастанию: A=" + a + ", B=" + b + ", C=" + c);
                    }
                    // b<a<c +
                    else if (b <= a && a <= c) {
                        float z = b;
                        b = a;
                        a = z;
                        System.out.println("Переставлены A и B. Новые значения переменных по возрастанию: A=" + a + ", B=" + b + ", C=" + c);
                    }
                    // b<c<a +
                    else if (b <= c && c <= a) {
                        float z = b;
                        b = c;
                        c = a;
                        a = z;
                        System.out.println("Переставлена A перед B и C. Новые значения переменных по возрастанию: A=" + a + ", B=" + b + ", C=" + c);
                    }
                    // c<a<b +
                    else if (c <= a && a <= b) {
                        float z = c;
                        c = b;
                        b = a;
                        a = z;
                        System.out.println("Переставлена C после A и B. Новые значения переменных по возрастанию: A=" + a + ", B=" + b + ", C=" + c);
                    }
                    // c<b<a +
                    else if (c <= b && b <= a) {
                        float z = c;
                        c = a;
                        a = z;
                        System.out.println("Переставлены A и C. Новые значения переменных по возрастанию: A=" + a + ", B=" + b + ", C=" + c);
                    }
        System.out.println("Программа завершена.");

    }
}
