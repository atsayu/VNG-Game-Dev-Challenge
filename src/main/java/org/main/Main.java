package org.main;

import Building.Building;
import Building.MainHall;
import Building.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static int WINDOW_WIDTH = 600;
    public static int WINDOW_HEIGHT = 1000;
    public static int FIRST_LABEL_X_COOR = 100;
    public static int FIRST_LABEL_Y_COOR = 100;
    public static int LABEL_WIDTH = 150;
    public static int LABEL_HEIGHT = 20;
    public static int LABEL_SPACE = 50;

    public static int TEXT_FIELD_WIDTH = 200;
    public static int TEXT_FIELD_HEIGHT = 30;

    public static int BUTTON_WIDTH = 50;
    public static int BUTTON_HEIGHT = 20;
    public static void main(String[] args) throws InterruptedException {
        List<Building> buildings = new ArrayList<>();
        Building mainHall = new MainHall();
        buildings.add(mainHall);
        Storage goldStorage = new GoldStorage(1000, 1000);
        Mine goldMine = new Goldmine();
        buildings.add(goldStorage);
        buildings.add(goldMine);

        JFrame window = new JFrame("Chaos Text");
        window.getContentPane().setBackground(Color.BLUE);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        JLabel headingResource = addLabel(10, 10, 100, 20, "Tài nguyên", Color.BLACK , window);
//        JLabel goldAmountLabel = addLabel(20, 40, 150, 20, "",Color.WHITE,  window);
//        JLabel elixirAmountLabel = addLabel(20, 70, 150, 20, "",Color.WHITE, window);

        JTextArea resourceReportLabel = addTextArea(20, 40, 150, 40, "", Color.WHITE, window);
        JLabel headingBuilding = addLabel(10, 100, 100, 20, "Can cu", Color.BLACK, window);
        JTextArea buildingReportLabel = addTextArea(20, 130, 150, 100,"", Color.WHITE, window);



//        JLabel label1 = new JLabel("This is the first label");
//        label1.setBounds(FIRST_LABEL_X_COOR, FIRST_LABEL_Y_COOR, LABEL_WIDTH, LABEL_HEIGHT);
//        window.add(label1);

//        JLabel label2 = new JLabel("This is the second label");
//        label2.setBounds(FIRST_LABEL_X_COOR, FIRST_LABEL_Y_COOR + LABEL_SPACE, LABEL_WIDTH, LABEL_HEIGHT);
//        window.add(label2);

        JTextField commandInputField = new JTextField();
        commandInputField.setBounds( 20, 500, 300, 30);
        window.add(commandInputField);

        JButton commandButton = new JButton("Execute");
        commandButton.setBounds(350, 500, 100, 30);
        window.add(commandButton);
        commandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commandInputField.getText();
                handleCommand(command, buildings);
            }
        });
//        JButton button = new JButton("Do some thing");
//        button.setBounds(FIRST_LABEL_X_COOR, FIRST_LABEL_Y_COOR  + 3 * LABEL_SPACE, BUTTON_WIDTH, BUTTON_HEIGHT);
//        button.setBorder(new EmptyBorder(0,0,0,0));
//        window.add(button);


        window.setLayout(null);
        window.setVisible(true);
        while (true) {
            long start = System.currentTimeMillis();

            goldStorage.increaseResource(goldMine.getResourcePerSecond());

            ElixirStorage elixirStorage = null;
            ElixirDistill elixirDistill = null;
            for (Building building: buildings) {
                if (building instanceof ElixirStorage) {
                    elixirStorage = (ElixirStorage) building;
                } else if (building instanceof ElixirDistill) {
                    elixirDistill = (ElixirDistill) building;
                }
            }
            if (elixirStorage != null && elixirDistill != null) elixirStorage.increaseResource(elixirDistill.getResourcePerSecond());
//            elixirStorage.increaseResource(elixirDistill.getResourcePerSecond());
//            goldAmountLabel.setText("Gold: " + goldStorage.getResource() + "/" + goldStorage.getLimitResource());
//            elixirAmountLabel.setText("Elixir: " + elixirStorage.getResource() + "/" + elixirStorage.getLimitResource());

            StringBuilder resourceReport = new StringBuilder();
            for (Building building: buildings) {
                if (building instanceof Storage) {
                    resourceReport.append(((Storage) building).getResourceReport()).append("\n");
                }
            }
            resourceReportLabel.setText(resourceReport.toString());

            StringBuilder buildingReport = new StringBuilder();
            for (Building building: buildings) {
                buildingReport.append(building.getReport()).append("\n");
            }
            buildingReportLabel.setText(buildingReport.toString());

            long elapsed = System.currentTimeMillis() - start;
            if (elapsed < 1000) Thread.sleep(1000 - elapsed);
        }
    }

    public static JLabel addLabel(int x, int y, int w, int h,String text, Color color, JFrame mainFrame) {
        JLabel newLabel = new JLabel(text);
        newLabel.setBounds(x, y, w, h);
        newLabel.setForeground(color);
        mainFrame.add(newLabel);
        return newLabel;
    }

    public static JTextArea addTextArea(int x, int y, int w, int h,String text, Color color, JFrame mainFrame) {
        JTextArea newLabel = new JTextArea(text);
        newLabel.setBounds(x, y, w, h);
//        newLabel.setForeground(color);
        mainFrame.add(newLabel);
        return newLabel;
    }

    public static void handleCommand(String command, List<Building> buildingList) {
        GoldStorage goldStorage = null;
        MainHall mainHall = null;
        Goldmine goldmine = null;
        ElixirDistill elixirDistill = null;
        ElixirStorage elixirStorage = null;


        for (Building building: buildingList) {
            if (building instanceof MainHall) {
                mainHall = (MainHall) building;
            } else if (building instanceof ElixirStorage) {
                elixirStorage = (ElixirStorage) building;
            } else if (building instanceof ElixirDistill) {
                elixirDistill = (ElixirDistill) building;
            } else if (building instanceof Goldmine) {
                goldmine = (Goldmine) building;
            } else if (building instanceof GoldStorage) {
                goldStorage = (GoldStorage) building;
            }
        }

        String[] words = command.split(" ");
        switch (words[0]) {
            case "Upgrade":
                if (goldStorage.getResource() < 1000) {
                    System.out.println("Khong du vang nang cap");
                }
                else if (words[1].equals("TownHall")) {
                    for (Building building: buildingList) {
                        if (building instanceof MainHall) {
                            goldStorage.decreaseResource(1000);
                            String output = building.upgrade(mainHall.getLevel());
                            System.out.println(output);
                            break;
                        }
                    }
                } else if (words[1].equals("GoldMine")) {
                    if (goldmine.getLevel() < mainHall.getLevel()) {
                        goldStorage.decreaseResource(1000);
                        String output = goldmine.upgrade(mainHall.getLevel());
                        System.out.println(output);
                    }

                } else if (words[1].equals("ElixirDistill")) {
                    if (goldmine.getLevel() < mainHall.getLevel()) {
                        goldStorage.decreaseResource(1000);
                        String output = elixirDistill.upgrade(mainHall.getLevel());
                        System.out.println(output);
                    }
                } else if (words[1].equals("GoldStorage")) {
                    if (goldmine.getLevel() < mainHall.getLevel()) {
                        goldStorage.decreaseResource(1000);
                        String output = goldStorage.upgrade(mainHall.getLevel());
                        System.out.println(output);
                    }
                } else if (words[1].equals("ElixirStorage")) {
                    if (goldmine.getLevel() < mainHall.getLevel()) {
                        goldStorage.decreaseResource(1000);
                        String output = elixirStorage.upgrade(mainHall.getLevel());
                        System.out.println(output);
                    }
                }
                break;
            case "Build":
                if (words[1].equals("ElixirStorage")) {
                    buildingList.add(new ElixirStorage(0, 1000));
                    System.out.println("Xay dung thanh cong ElixirStorage");
                } else if (words[1].equals("ElixirDistill")) {
                    buildingList.add(new ElixirDistill());
                    System.out.println("Xay dung thanh cong ElixirDistill");
                }
        }
    }
}