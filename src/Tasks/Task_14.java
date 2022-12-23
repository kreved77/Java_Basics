package Tasks;

//  Практическое задание №2
//  https://lmsdo.rea.ru/mod/quiz/view.php?id=10597
/*
        Цикл for:
        Цикл while:
*/

import java.util.Scanner;

public class Task_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        byte taskNumber;
        do {
            //Выбираем номер задачи из задания №2
            System.out.println("\nЗадание №2. Введите номер задачи (варианты 1 - 6, для выхода - 0):");
            taskNumber = input.nextByte();
            switch (taskNumber) {
                case 1:
//  Даны целые числа K и N (N > 0). Вывести N раз число K.
                    System.out.println("Выполняем задачу 1.");
                    System.out.println("Введите число K:");
                    int k = input.nextInt();
                    System.out.println("Введите число N (не равное 0):");
                    int n = input.nextInt();
                    System.out.print("N раз число K: ");
                    if(n > 0) {
                        for (int i = 1; i <= n; i++) {
                            System.out.print(k + " ");
                        }
                    } else {
                        System.out.println("число N <= 0!");
                    }
                    System.out.print("\nВыполнение завершено.\n");
                    break;
                case 2:
//  Даны два целых числа A и B (A < B).
//  Вывести в порядке возрастания все целые числа, расположенные между A и B (включая сами числа A и B),
//  а также количество N этих чисел.
                    System.out.println("Выполняем задачу 2.");
                    System.out.println("Введите число A:");
                    int a = input.nextInt();
                    System.out.println("Введите число B (B больше A):");
                    int b = input.nextInt();
                    int number = 0;
                    System.out.print("Все числа диапазона [A ; B]: ");

                    if(a < b) {
                        for (int i = a ; i <= b; i++) {
                            System.out.print(i + " ");
                            number++;
                        }
                    } else {
                        System.out.print(" число A > B!");
                    }
                    System.out.printf("\nКоличество чисел диапазона [%d ; %d] равно %d", a, b, number);
                    System.out.print("\nВыполнение завершено.\n");
                    break;
                case 3:
//  Дано вещественное число — цена 1 кг конфет. Вывести стоимость 1, 2, …, 10 кг конфет.
                    System.out.println("Выполняем задачу 3.");
                    System.out.println("Введите число - цену конфет:");
                    double p = input.nextDouble();

//                    System.out.printf("\n Точность плавающей точки для PI: %.2f, %.4f, %.8f\n", PI,PI,PI);

                    for (int i = 1 ; i <= 10; i++) {
                        System.out.printf("Цена %1d кг. конфет - %2$.2f руб.\n", i, (i*p) );
                    }
                    System.out.print("Выполнение завершено.\n");
                    break;
                case 4:
//  Даны два целых числа A и B (A < B). Найти сумму всех целых чисел от A до B включительно.
                    System.out.println("Выполняем задачу 4.");
                    System.out.println("Введите число A:");
                    a = input.nextInt();
                    System.out.println("Введите число B (B больше A):");
                    b = input.nextInt();
                    int s = 0;

                    if(a < b) {
                        for (int i = a ; i <= b; i++) {
                            s += i;
                        }
                    } else {
                        System.out.print("Ошибка: число A > B!");
                        System.exit(0);
                    }
                    System.out.println("Сумма всех чисел диапазона [A ; B]: " + s);
                    System.out.print("Выполнение завершено.\n");
                    break;
                case 5:
//  Дано целое число N (> 0), являющееся некоторой степенью числа 2: N = 2^K. Найти целое число K — показатель этой степени.
                    System.out.println("Выполняем задачу 5.");
                    System.out.println("Введите число N (> 0):");
                    int numberN = input.nextInt();
                    k = 0;
/*                     while (numberN >= 2){
                        ++k;
                        numberN /= 2;
                    }*/
                    if (numberN > 0) {
                        while (numberN > 1) {
                            if (numberN % 2 != 0) { // проверка четности
                                System.out.println("Число " + numberN + " не является степенью 2!");
                                System.exit(0);
                            } else  {
                                numberN /=2;
                                k++;
                            }

                        }
                    }
                    System.out.println("K — показатель степени (N = 2^K) числа " + numberN + " это: " + k);
                    System.out.print("Выполнение завершено.\n");
                    break;
                case 6:
//  Дано целое число N (> 1). Найти наибольшее целое число K, при котором выполняется неравенство 3K < N.
                    System.out.println("Выполняем задачу 6.");
                    System.out.println("Введите число N (> 1):");
                    numberN = input.nextInt();
                    k = 0;
                    if (numberN > 1) {
                       while (numberN > 3*k) {
                            k++;
                        }
                        System.out.println("Наибольшее целое число K, при котором выполняется неравенство 3K < N: " + --k);
                    } else {
                        System.out.print("Ошибка: число N <= 1!");
                        System.exit(0);
                    }
                    System.out.print("Выполнение завершено.\n");
                    break;


                case 0:
                    System.out.println("Вы выбрали Выход.");
                    break;
                default:
                    System.out.println("Вы выбрали неверную задачу.");
                    break;
            }
        } while (taskNumber != 0); {
            System.out.println("Программа завершена.");
        }

    }
}
