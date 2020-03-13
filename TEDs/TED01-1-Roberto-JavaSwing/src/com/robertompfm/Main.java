/*
TED 01 - LINGUAGEM DE PROGRAMACAO II (2020.1)
QUESTAO 01 - PROGRAMA PARA RESOLVER UMA EQUACAO DE SEGUNDO GRAU
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
    public static double calculateDelta(double a, double b, double c) {
        /*
        returns the value of delta
         */
        return b * b - 4 * a * c;
    }

    public static Double calculateRoot(double a, double b, double delta, boolean plus) {
        /*
        returns a double equivalent to one of the roots of the equation
         */
        if (plus) {
            return (-b + Math.sqrt(delta)) / (2 * a);
        } else {
            return (-b - Math.sqrt(delta)) / (2 * a);
        }
    }

    public static Double calculateRoot(double a, double b) {
        /*
        returns a double equivalent to the only root of the equation
        this should be used when delta is equal to zero
         */
        return -b / (2 * a);
    }

    public static String getRootsAsString(double a, double b, double c) {
        /*
        returns a string with the roots of the given equation
        in case the equation does not have a root the String "None" is returned
         */
        double delta = calculateDelta(a, b, c);
        System.out.println(delta);
        String result;
        if (delta > 0) {
            double root1 = calculateRoot(a, b, delta, false);
            double root2 = calculateRoot(a, b, delta, true);
            result = root1 + " and " + root2;
        } else if (delta == 0) {
            double root = calculateRoot(a, b);
            result = "" + root;
        } else {
            result = "None";
        }
        return result;
    }

    public static void main(String[] args) {
//        defining the constants
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 300;
        final int LABEL_WIDTH = 20;
        final int LABEL_HEIGHT = 20;
        final int FIELD_WIDTH = 80;
        final int FIELD_HEIGHT = 20;

//        creating the frame
        JFrame frame = new JFrame("Quadratic Equation Solver");

//        creating fields and labels
        JLabel titleLabel = new JLabel("Quadratic Equation Solver");
        titleLabel.setBounds(60, 10, 300, 20);
        JLabel instructionLabel = new JLabel("Insert values for a, b and c");
        instructionLabel.setBounds(55, 50, 300, 20);
        JLabel equationLabel = new JLabel("ax^2 + bx + c = 0");
        equationLabel.setBounds(90, 70, 150, 20);

        JLabel aLabel = new JLabel("a: ");
        aLabel.setBounds((FRAME_WIDTH - FIELD_WIDTH) / 2 - LABEL_WIDTH, 100, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField aField = new JTextField();
        aField.setBounds((FRAME_WIDTH - FIELD_WIDTH) / 2, 100, FIELD_WIDTH, FIELD_HEIGHT);

        JLabel bLabel = new JLabel("b: ");
        bLabel.setBounds((FRAME_WIDTH - FIELD_WIDTH) / 2 - LABEL_WIDTH, 130, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField bField = new JTextField();
        bField.setBounds((FRAME_WIDTH - FIELD_WIDTH) / 2, 130, FIELD_WIDTH, FIELD_HEIGHT);

        JLabel cLabel = new JLabel("c: ");
        cLabel.setBounds((FRAME_WIDTH - FIELD_WIDTH) / 2 - LABEL_WIDTH, 160, LABEL_WIDTH, LABEL_HEIGHT);
        JTextField cField = new JTextField();
        cField.setBounds((FRAME_WIDTH - FIELD_WIDTH) / 2, 160, FIELD_WIDTH, FIELD_HEIGHT);

//        creating buttons
        JButton solveButton = new JButton("Solve");
        solveButton.setBounds(FRAME_WIDTH / 2 + 50, 200,90, 30);
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds((FRAME_WIDTH - 90) / 2, 200,90, 30);
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(FRAME_WIDTH / 2 - 140, 200,90, 30);

//        buttons action listeners
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(aField.getText());
                    double b = Double.parseDouble(bField.getText());
                    double c = Double.parseDouble(cField.getText());
                    String result = getRootsAsString(a, b, c);
                    JOptionPane.showMessageDialog(frame, "The roots are:\n" + result);

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "Make sure all fields are filled with numbers in the correct format (e.g. 2.3)");
                }

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aField.setText("");
                bField.setText("");
                cField.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


//        adding all elements to the frame

        frame.add(titleLabel);
        frame.add(equationLabel);
        frame.add(instructionLabel);

        frame.add(aField);
        frame.add(bField);
        frame.add(cField);
        frame.add(aLabel);
        frame.add(bLabel);
        frame.add(cLabel);

        frame.add(solveButton);
        frame.add(clearButton);
        frame.add(exitButton);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
