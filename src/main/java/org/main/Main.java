package org.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static int WINDOW_WIDTH = 600;
    public static int WINDOW_HEIGHT = 400;
    public static int FIRST_LABEL_X_COOR = 100;
    public static int FIRST_LABEL_Y_COOR = 100;
    public static int LABEL_WIDTH = 150;
    public static int LABEL_HEIGHT = 20;
    public static int LABEL_SPACE = 50;

    public static int TEXT_FIELD_WIDTH = 200;
    public static int TEXT_FIELD_HEIGHT = 30;

    public static int BUTTON_WIDTH = 50;
    public static int BUTTON_HEIGHT = 20;
    public static void main(String[] args) {
        JFrame window = new JFrame("VNG Game Dev Challenge Day");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        JLabel label1 = new JLabel("This is the first label");
        label1.setBounds(FIRST_LABEL_X_COOR, FIRST_LABEL_Y_COOR, LABEL_WIDTH, LABEL_HEIGHT);
        window.add(label1);

        JLabel label2 = new JLabel("This is the second label");
        label2.setBounds(FIRST_LABEL_X_COOR, FIRST_LABEL_Y_COOR + LABEL_SPACE, LABEL_WIDTH, LABEL_HEIGHT);
        window.add(label2);

        JTextField textInputField = new JTextField();
        textInputField.setBounds( FIRST_LABEL_X_COOR,FIRST_LABEL_Y_COOR + 2 * LABEL_SPACE, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
        window.add(textInputField);

        JButton button = new JButton("Do some thing");
        button.setBounds(FIRST_LABEL_X_COOR, FIRST_LABEL_Y_COOR  + 3 * LABEL_SPACE, BUTTON_WIDTH, BUTTON_HEIGHT);
        button.setBorder(new EmptyBorder(0,0,0,0));
        window.add(button);


        window.setLayout(null);
        window.setVisible(true);
    }
}