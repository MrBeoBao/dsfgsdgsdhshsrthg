package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    JTextField display;
    double num1 = 0, num2 = 0, result = 0;
    char operator;


    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        } else if (cmd.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd.charAt(0);
            display.setText("");
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(result));
        } else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
        }
    }//ddddd
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
