package Tasks;
// Практическое задание №3
// Поиск максимального, минимального и среднего значения элементов массива


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.*;

public class Task_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Поиск максимального, минимального и среднего значения элементов массива.\nВведите размер массива:");
        int n = input.nextInt();
        Integer[] array = new Integer[n];
        float sum = 0;

        System.out.println("Введите значения элементов массива:");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            sum += array[i];
        }

        System.out.println("Все элементы массива: ");
        for (int element : array) {
            System.out.print(element + " ");
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
// v1
//        for (int element : array) {
//            max = Math.max(max, element);
//            min = Math.min(min, element);
//        }

// v2
//        for (int i = 0; i < array.length; i++) {
//            max = max > array[i] ? max : array[i];
//            min = min < array[i] ? min : array[i];
//        }

// v3
        min = Collections.min(Arrays.asList(array));
        max = Collections.max(Arrays.asList(array));

        System.out.print("\n• максимальное значение: " + max);
        System.out.print("\n• минимальное значение: " + min);
        System.out.print("\n• середина диапазона: " + (max + min) / 2);
        System.out.print("\n• среднее значение (сумма/количество): " + sum / array.length);


// https://stackoverflow.com/questions/51578393
/*
        Integer[] num = { 2, 11, 55, 99 };
        int min2 = Collections.min(Arrays.asList(num));
        int max2 = Collections.max(Arrays.asList(num));
        System.out.println("\nMinimum number of array is : " + min2);
        System.out.println("Maximum number of array is : " + max2);
*/
    }
}
