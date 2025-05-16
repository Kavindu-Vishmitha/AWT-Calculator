package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Close extends WindowAdapter {

    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}

class Cal implements ActionListener {

    TextField tf;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18,
            b19, b20, b21, b22, b23, b24;
    String fv, sv, op;
    Double fdv, sdv, tot;

    Cal() {

        Frame f = new Frame();
        f.addWindowListener(new Close());
        f.setBackground(Color.GRAY);
        f.setTitle("Calculator");
        f.setResizable(false);
        f.setSize(500, 550);
        f.setLocationRelativeTo(null);

        Font f1 = new Font("Lucida Fax", Font.BOLD, 30);
        Font f2 = new Font("Microsoft New Tai Lue", Font.BOLD, 30);
        Font f3 = new Font("MV Boli", Font.BOLD, 40);

        Panel p1 = new Panel();
        Panel p2 = new Panel();
        GridLayout gl = new GridLayout(6, 4, 4, 4);
        p2.setLayout(gl);
        p2.setBackground(Color.black);

        tf = new TextField(15);
        tf.setFont(f3);
        tf.setEditable(true);
        tf.setForeground(Color.black);
        tf.setBackground(Color.white);
        tf.setText("0");

        p1.add(tf);

        b1 = new Button("%");
        b2 = new Button("CE");
        b3 = new Button("C");
        b4 = new Button("X");
        b5 = new Button("1/x");
        b6 = new Button("χ2");
        b7 = new Button("√");
        b8 = new Button("÷");
        b9 = new Button("7");
        b10 = new Button("8");
        b11 = new Button("9");
        b12 = new Button("×");
        b13 = new Button("4");
        b14 = new Button("5");
        b15 = new Button("6");
        b16 = new Button("-");
        b17 = new Button("1");
        b18 = new Button("2");
        b19 = new Button("3");
        b20 = new Button("+");
        b21 = new Button("+/-");
        b22 = new Button("0");
        b23 = new Button(".");
        b24 = new Button("=");

        Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24};
        for (Button button : buttons) {
            button.setPreferredSize(new Dimension(60, 60));
            button.setFont(f1);
            button.addActionListener(this);
            p2.add(button);
        }

        b1.setBackground(Color.CYAN);
        b2.setBackground(Color.ORANGE);
        b3.setBackground(Color.ORANGE);
        b4.setBackground(Color.RED);
        b5.setBackground(Color.CYAN);
        b6.setBackground(Color.CYAN);
        b7.setBackground(Color.CYAN);
        b8.setBackground(Color.CYAN);
        b9.setBackground(Color.white);
        b9.setForeground(Color.gray);
        b10.setBackground(Color.white);
        b10.setForeground(Color.gray);
        b11.setBackground(Color.white);
        b11.setForeground(Color.gray);
        b12.setBackground(Color.CYAN);
        b13.setBackground(Color.white);
        b13.setForeground(Color.gray);
        b14.setBackground(Color.white);
        b14.setForeground(Color.gray);
        b15.setBackground(Color.white);
        b15.setForeground(Color.gray);
        b16.setBackground(Color.CYAN);
        b17.setBackground(Color.white);
        b17.setForeground(Color.gray);
        b18.setBackground(Color.white);
        b18.setForeground(Color.gray);
        b19.setBackground(Color.white);
        b19.setForeground(Color.gray);
        b20.setBackground(Color.CYAN);
        b21.setBackground(Color.CYAN);
        b22.setBackground(Color.white);
        b22.setForeground(Color.gray);
        b23.setBackground(Color.CYAN);
        b24.setBackground(Color.LIGHT_GRAY);

        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.SOUTH);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent d) {
        if (tf.getText().equals("0")) {
            tf.setText("");
        }
        Object o = d.getSource();

        try {
            if (o.equals(b9) || o.equals(b10) || o.equals(b11) || o.equals(b13) || o.equals(b14) || o.equals(b15) || o.equals(b17) || o.equals(b18) || o.equals(b19) || o.equals(b22)) {
                Button b = (Button) o;
                tf.setText(tf.getText() + b.getLabel());
            } else if (o.equals(b20)) { // +
                fv = tf.getText();
                op = b20.getLabel();
                tf.setText("");
            } else if (o.equals(b16)) { // -
                fv = tf.getText();
                op = b16.getLabel();
                tf.setText("");
            } else if (o.equals(b8)) { // ÷
                fv = tf.getText();
                op = b8.getLabel();
                tf.setText("");
            } else if (o.equals(b12)) { // ×
                fv = tf.getText();
                op = b12.getLabel();
                tf.setText("");
            } else if (o.equals(b24)) { // =
                sv = tf.getText();
                if (sv.isEmpty()) {
                    tf.setText("");
                    return;
                }
                try {
                    sdv = Double.parseDouble(sv);
                } catch (NullPointerException e) {
                    tf.setText("0");
                    return;
                }
                try {
                    fdv = Double.parseDouble(fv);
                } catch (NullPointerException e) {
                    tf.setText("0");
                    return;
                }
                tf.setText("");

                switch (op) {
                    case "+":
                        tot = fdv + sdv;
                        break;
                    case "-":
                        tot = fdv - sdv;
                        break;
                    case "÷":
                        if (sdv == 0) {
                            tf.setText("0");
                            return;
                        }
                        tot = fdv / sdv;
                        break;
                    case "×":
                        tot = fdv * sdv;
                        break;
                    default:
                        tf.setText("0");
                        return;
                }
                tf.setText(String.valueOf(tot));
            } else if (o.equals(b2)) { // CE
                tf.setText("0");
            } else if (o.equals(b3)) { // C
                tf.setText("0");
                fv = sv = op = null;
                fdv = sdv = tot = 0.0;
            } else if (o.equals(b23)) { // .
                if (!tf.getText().contains(".")) {
                    tf.setText(tf.getText() + ".");
                }
            } else if (o.equals(b21)) { // +/-
                double value = Double.parseDouble(tf.getText());
                value *= -1;
                tf.setText(Double.toString(value));
            } else if (o.equals(b1)) { // %
                fdv = Double.parseDouble(tf.getText());
                fdv /= 100;
                tf.setText(fdv.toString());
            } else if (o.equals(b5)) { // 1/x
                fdv = Double.parseDouble(tf.getText());
                if (fdv == 0) {
                    tf.setText("0");
                } else {
                    fdv = 1 / fdv;
                    tf.setText(fdv.toString());
                }
            } else if (o.equals(b6)) { // x^2
                fdv = Double.parseDouble(tf.getText());
                fdv = Math.pow(fdv, 2);
                tf.setText(fdv.toString());
            } else if (o.equals(b7)) { // sqrt
                fdv = Double.parseDouble(tf.getText());
                fdv = Math.sqrt(fdv);
                tf.setText(fdv.toString());
            } else if (o.equals(b4)) { // Backspace (X)
                String text = tf.getText();
                if (text.length() > 0) {
                    tf.setText(text.substring(0, text.length() - 1));
                }
                if (tf.getText().equals("")) {
                    tf.setText("0");
                }
            }
        } catch (NumberFormatException e) {
            tf.setText("0");
        }
    }

}

public class Calculator {

    public static void main(String[] args) {
        new Cal();
    }
}
