/*
TED 01 - LINGUAGEM DE PROGRAMACAO II (2020.1)
QUESTAO 02 - PROGRAMA PARA CALCULO DO SALARIO E TAXAS
Roberto Mendes Pereira Franca de Mendonca

resolvido usando javaswing
 */

package com.robertompfm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static double calcSalarioBruto(double salPorHora, double horas) {
        /*
        recebe o salario por hora e o numeor de horas trabalhadas no mes
        retorna o salario bruto nesse mes
         */
        return salPorHora * horas;
    }

    public static double calcIRPF(double salarioBruto) {
        /*
        recebe o valor do salario bruto no mes
        retorna o valor a ser descontado pelo Imposto de Renda no mes
         */
        return salarioBruto * .11;
    }

    public static double calcINSS(double salarioBruto) {
        /*
        recebe o valor do salario bruto no mes
        retorna o valor a ser descontado para o INSS no mes
         */
        return salarioBruto * .08;
    }

    public static double calcTaxaSindicato(double salarioBruto) {
        /*
        recebe o valor do salario bruto no mes
        retorna o valor a ser descontado para o Sindicato no mes
         */
        return salarioBruto * .05;
    }

    public static void main(String[] args) {
//        definindo as constantes
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;
        final int LABEL_WIDTH = 150;
        final int LABEL_HEIGHT = 20;
        final int FIELD_WIDTH = 100;
        final int FIELD_HEIGHT = 20;

//        criando a moldura
        JFrame frame = new JFrame("Salario e descontos");

//        criando campos e rotulos
        JLabel inputLabel = new JLabel("INPUT");
        inputLabel.setBounds(FRAME_WIDTH / 2 - 25, 10, LABEL_WIDTH, 20);
        JLabel outputLabel = new JLabel("OUTPUT");
        outputLabel.setBounds(FRAME_WIDTH / 2 - 30, FRAME_HEIGHT / 3, LABEL_WIDTH, 20);

        JLabel salPorHoraLabel = new JLabel("Salario por hora: ");
        salPorHoraLabel.setBounds(75, 40, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField salPorHoraField = new JTextField();
        salPorHoraField.setBounds(FRAME_WIDTH / 2, 40, FIELD_WIDTH, FIELD_HEIGHT);

        JLabel horasLabel = new JLabel("Horas trabalhadas: ");
        horasLabel.setBounds(59, 60, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField horasField = new JTextField();
        horasField.setBounds(FRAME_WIDTH / 2, 60, FIELD_WIDTH, FIELD_HEIGHT);

        JLabel salBrutoLabel = new JLabel("Salario bruto: ");
        salBrutoLabel.setBounds(95, FRAME_HEIGHT / 3 + 30, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField salBrutoField = new JTextField();
        salBrutoField.setBounds(FRAME_WIDTH / 2, FRAME_HEIGHT / 3 + 30, FIELD_WIDTH, FIELD_HEIGHT);
        salBrutoField.setEditable(false);

        JLabel irpfLabel = new JLabel("Imposto de renda: ");
        irpfLabel.setBounds(64, FRAME_HEIGHT / 3 + 50, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField irpfField = new JTextField();
        irpfField.setBounds(FRAME_WIDTH / 2, FRAME_HEIGHT / 3 + 50, FIELD_WIDTH, FIELD_HEIGHT);
        irpfField.setEditable(false);

        JLabel inssLabel = new JLabel("INSS: ");
        inssLabel.setBounds(152, FRAME_HEIGHT / 3 + 70, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField inssField = new JTextField();
        inssField.setBounds(FRAME_WIDTH / 2, FRAME_HEIGHT / 3 + 70, FIELD_WIDTH, FIELD_HEIGHT);
        inssField.setEditable(false);

        JLabel sindicatoLabel = new JLabel("Taxa sindicato: ");
        sindicatoLabel.setBounds(86, FRAME_HEIGHT / 3 + 90, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField sindicatoField = new JTextField();
        sindicatoField.setBounds(FRAME_WIDTH / 2, FRAME_HEIGHT / 3 + 90, FIELD_WIDTH, FIELD_HEIGHT);
        sindicatoField.setEditable(false);

        JLabel salLiquidoLabel = new JLabel("Salario liquido: ");
        salLiquidoLabel.setBounds(86, FRAME_HEIGHT / 3 + 110, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField salLiquidoField = new JTextField();
        salLiquidoField.setBounds(FRAME_WIDTH / 2, FRAME_HEIGHT / 3 + 110, FIELD_WIDTH, FIELD_HEIGHT);
        salLiquidoField.setEditable(false);

        JLabel descontosLabel = new JLabel("Total descontado: ");
        descontosLabel.setBounds(67, FRAME_HEIGHT / 3 + 130, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField descontosField = new JTextField();
        descontosField.setBounds(FRAME_WIDTH / 2, FRAME_HEIGHT / 3 + 130, FIELD_WIDTH, FIELD_HEIGHT);
        descontosField.setEditable(false);

        //        criando botoes
        JButton calcButton = new JButton("Calcular");
        calcButton.setBounds(FRAME_WIDTH / 2 + 50, 90,90, 30);
        JButton clearButton = new JButton("Limpar");
        clearButton.setBounds((FRAME_WIDTH - 90) / 2, 90,90, 30);
        JButton exitButton = new JButton("Sair");
        exitButton.setBounds(FRAME_WIDTH / 2 - 140, 90,90, 30);

//        buttons action listeners
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double salPorHora = Double.parseDouble(salPorHoraField.getText());
                    double horas = Double.parseDouble(horasField.getText());

                    double salBruto = calcSalarioBruto(salPorHora, horas);
                    double irpf = calcIRPF(salBruto);
                    double inss = calcINSS(salBruto);
                    double sindicato = calcTaxaSindicato(salBruto);
                    double descontos = irpf + inss + sindicato;
                    double salLiquido = salBruto - descontos;

                    salBrutoField.setText("" + salBruto);
                    irpfField.setText("" + irpf);
                    inssField.setText("" + inss);
                    sindicatoField.setText("" + sindicato);
                    descontosField.setText("" + descontos);
                    salLiquidoField.setText("" + salLiquido);

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "Certifique-se de que todos os campos foram preenchidos corretamente, com numeros no formato correto (ex.: 10.3)");
                }

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salPorHoraField.setText("");
                horasField.setText("");
                salBrutoField.setText("");
                irpfField.setText("");
                inssField.setText("");
                sindicatoField.setText("");
                descontosField.setText("");
                salLiquidoField.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


//        adicionando todos os elementos a moldura
        frame.add(inputLabel);
        frame.add(outputLabel);

        frame.add(salPorHoraLabel);
        frame.add(salPorHoraField);
        frame.add(horasLabel);
        frame.add(horasField);

        frame.add(calcButton);
        frame.add(clearButton);
        frame.add(exitButton);

        frame.add(salBrutoLabel);
        frame.add(salBrutoField);
        frame.add(irpfLabel);
        frame.add(irpfField);
        frame.add(inssLabel);
        frame.add(inssField);
        frame.add(sindicatoLabel);
        frame.add(sindicatoField);
        frame.add(salLiquidoLabel);
        frame.add(salLiquidoField);
        frame.add(descontosLabel);
        frame.add(descontosField);

//        sai do programa caso a janela seja fechada
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

//        ultimos ajustes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
