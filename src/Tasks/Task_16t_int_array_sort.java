package Tasks;

// Int array sorting

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task_16t_int_array_sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose array for sorting: 1 - test data, 2 - custom array (manual input), 0 - exit");
        switch (input.nextInt()){
            case 1 -> arrTestData();
            case 2 -> arrManualInput();
            default -> System.out.println("Undefined operation.");
            case 0 -> System.exit(0);
        }
        System.exit(0);
    }

    // test data
    private static void arrTestData() {
        int[] array = {22, 9, 12, 37, 5, 16, 4, 1, 26};
        int n = array.length;

        showArray(array);
        array = sortArray(array, n);
        showArrayResult(array);
    }

    // manual input
    private static void arrManualInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество элементов в одномерном массиве");
        int n = input.nextInt();
        int[] array = new int[n];
        System.out.println("Заполните массив целыми числами: ");
        for(int i = 0; i < array.length; i++)
        {
            array[i] = input.nextInt();
        }

        showArray(array);
        array = sortArray(array, n);
        showArrayResult(array);
    }

    private static void showArray(int[] array) {
        System.out.println("Заполненный массив: ");
        for(int value : array)
        {
            System.out.println(value);
        }
    }

    private static int[] sortArray(int[] array, int n) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose sorting method: \n ASC: 1 - Bubble sort, 2 - using Arrays, \n DESC: 3 - Bubble sort, 4 - using Arrays, \n 0 - exit");
        switch (input.nextInt()){
            // bubble sort ASC
            case 1:
                System.out.println("Сортировка по возрастанию методом bubble sort.");
                for(int i=0; i < n; i ++)
                {
                    for(int j = 1; j < (n-i); j++)
                    {
                        if(array[j-1] > array[j])
                        {
                            int flip = array[j-1];
                            array[j - 1] = array[j];
                            array[j] = flip;
                        }
                    }
                }
                break;
            // Arrays sort ASC
            case 2:
                System.out.println("Сортировка по возрастанию using Arrays sort.");
                Arrays.sort(array);
                break;
            // bubble sort DESC
            case 3:
                System.out.println("DESC Сортировка по убыванию методом Bubble sort.");
                for(int i=0; i < n; i ++)
                {
                    for(int j = 1; j < (n-i); j++)
                    {
                        if(array[j-1] < array[j])
                        {
                            int flip = array[j-1];
                            array[j - 1] = array[j];
                            array[j] = flip;
                        }
                    }
                }
                break;
            // Arrays sort DESC
            case 4:
                System.out.println("DESC Сортировка по убыванию using Arrays.stream().");

                int[] arrDesc = Arrays.stream(array).boxed()
                        .sorted(Collections.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();

                array = arrDesc;
                break;
            default:
                System.out.println("Undefined operation.");
                sortArray(array, n);
                break;
            case 0:
                System.exit(0);
        }
        return array;
    }

    private static void showArrayResult(int[] array) {
        System.out.println("Отсортированный массив: ");
        for(int value : array)
        {
            System.out.println(value);
        }
    }

}