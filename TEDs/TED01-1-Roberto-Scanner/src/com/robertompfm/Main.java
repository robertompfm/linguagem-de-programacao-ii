/*
TED 01 - LINGUAGEM DE PROGRAMACAO II (2020.1)
QUESTAO 01 - PROGRAMA PARA RESOLVER UMA EQUACAO DE SEGUNDO GRAU
Roberto Mendes Pereira Franca de Mendonca

resolvido usando scanner
 */

package com.robertompfm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static double calcDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static double calcRoots(double a, double b) {
        return  calcRoots(a, b, 0, true);
    }

    public static double calcRoots(double a, double b, double delta, boolean positive) {
        if (positive) {
            return (-b + Math.sqrt(delta)) / (2 * a);
        } else  {
            return (-b - Math.sqrt(delta)) / (2 * a);
        }
    }

    public static String getRootsAsString(double a, double b, double c) {
        double delta = calcDelta(a, b, c);
        if (delta > 0) {
            double root1 = calcRoots(a, b, delta, false);
            double root2 = calcRoots(a, b, delta, true);
            return root1 + ", " + root2;
        } else if (delta == 0) {
            double root = calcRoots(a, b);
            return "" + root;
        } else {
            return "None";
        }
    }

    public static void loop() {
        double a, b, c;
        System.out.println("Quadratic equation solver");
        System.out.println("Insert values for a, b and c");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("a: ");
            a = scanner.nextDouble();
            System.out.print("b: ");
            b = scanner.nextDouble();
            System.out.print("c: ");
            c = scanner.nextDouble();
            System.out.print("Roots: " + getRootsAsString(a, b, c));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. You should type numbers. Try again\n");
            loop();
        }
    }

    public static void main(String[] args) {
        loop();
    }
}
