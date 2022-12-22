package Geometry;

import java.util.Scanner;

public class RectangleAreaPerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Программа вычисления Площади и Периметра прямоугольника со сторонами A и B.");
        System.out.println("Введите сторону А:");
        float a = input.nextFloat();
        System.out.println("Введите сторону B:");
        float b = input.nextFloat();
        float s = a * b;
        float p = (a + b) * 2;
        System.out.println("Площать прямоугольника: " + s);
        System.out.println("Периметр прямоугольника: " + p);
    }
}

