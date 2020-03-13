/*
TED 01 - LINGUAGEM DE PROGRAMACAO II (2020.1)
QUESTAO 02 - PROGRAMA PARA CALCULAR SALARIO LIQUIDO E TAXAS
Roberto Mendes Pereira Franca de Mendonca

resolvido usando Scanner
 */

package com.robertompfm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static double calcIRPF(double salario) {
        return salario * .11;
    }

    public static double calcINSS(double salario) {
        return salario * .08;
    }

    public static double calcTaxaSindicato(double salario) {
        return salario * .05;
    }

    public static double calcSalarioBruto(double salPorHora, double horas) {
        return salPorHora * horas;
    }

    public static void loop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculadora de impostos");
        System.out.print("Salario por hora: ");
        try {
            double salPorHora = scanner.nextDouble();
            System.out.print("Numero de horas trabalhadas: ");
            double horas = scanner.nextDouble();

            double salarioBruto = calcSalarioBruto(salPorHora, horas);
            double inss = calcINSS(salarioBruto);
            double irpf = calcIRPF(salarioBruto);
            double sindicato = calcTaxaSindicato(salarioBruto);
            double descontos = inss + irpf + sindicato;
            double salarioLiquido = salarioBruto - descontos;

            System.out.println("Salario bruto: " + salarioBruto);
            System.out.println("INSS: " + inss);
            System.out.println("Imposto de renda: " + irpf);
            System.out.println("Taxa sindicato: " + sindicato);
            System.out.println("Salario liquido: " + salarioLiquido);
            System.out.println("Valor descontado: " + descontos);
        } catch (InputMismatchException e) {
            System.out.println("You should insert numbers. Try again\n");
            loop();
        }
    }

    public static void main(String[] args) {
        loop();
    }
}
