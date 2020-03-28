package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.InputMismatchException;

import static java.awt.Color.*;

class sudoku extends JFrame {

    final static int sudoku1 [] [] = {
                         {1, 4, 6, 3, 9, 7, 5, 2, 8},
                         {7, 9, 3, 5, 8, 2, 4, 1, 6},
                         {8, 5, 2, 6, 1, 4, 9, 7, 3},
                         {6, 7, 1, 2, 4, 9, 3, 8, 5},
                         {9, 3, 4, 7, 5, 8, 1, 6, 2},
                         {5, 2, 8, 1, 6, 3, 7, 9, 4},
                         {3, 8, 9, 4, 2, 1, 6, 5, 7},
                         {2, 6, 7, 9, 3, 5, 8, 4, 1},
                         {4, 1, 5, 8, 7, 6, 2, 3, 9}};
    JFormattedTextField masField [] [] = new JFormattedTextField[9][9];

    JFrame frame = new JFrame("Судоку");
    Label l;
    GridBagConstraints gbc = new GridBagConstraints();
    Font f = new Font("Serif", Font.BOLD, 50);



    public sudoku() {
        frame.setLayout(new GridBagLayout());
        setPreferredSize(getSize());

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                masField [i][j] = new JFormattedTextField(NumberFormat.getIntegerInstance());
                masField [i][j].setHorizontalAlignment(JFormattedTextField.CENTER);
                masField [i][j].setFont(f);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.ipadx = 50;
                gbc.gridx = j;
                gbc.gridy = i;
                frame.add(masField[i][j], gbc);
            }
        }

        create();

        Button b1 = new Button("Перевірити результати");
        b1.setBounds(600, 600, 100, 25);
        b1.setActionCommand("Enter");
        b1.addActionListener(new ButtonClickListener());
        gbc.gridy = 9;
        gbc.gridx = 0;
        gbc.ipadx = 0;
        gbc.gridwidth = 2;
        frame.add(b1, gbc);

        Button b2 = new Button("Нова гра");
        b2.setBounds(600, 600, 100, 25);
        b2.setActionCommand("new");
        b2.addActionListener(new ButtonClickListener());
        gbc.gridy = 9;
        gbc.gridx = 7;
        gbc.ipadx = 0;
        gbc.gridwidth = 2;
        frame.add(b2, gbc);

        l = new Label("Тут будуть результати", Label.CENTER);
        l.setFont(new Font("", Font.BOLD, 15));
        gbc.gridy = 9;
        gbc.gridx = 2;
        gbc.gridwidth = 5;
        frame.add(l, gbc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setVisible(true);
    }

    public void create(){
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 3; j++) {
                int a;
                a = (int)(Math.random() * 9);
                masField [i][a].setValue(sudoku1 [i][a]);
                masField [i][a].setEditable(false);
            }
        }
    }

    public void clear(){
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                masField [i][j].setEditable(true);
                masField [i][j].setValue(null);
            }
        }
    }

    public boolean sudoku_win() {
        int count1 = 0, count2 = 0, count3 = 0;
        boolean sud = false;
        int mas[] = new int[9];
        for (int i = 0; i < 9; i++) {
            mas[i] = 0;
        }
        int sudoku2[][] = new int[9][9];
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku2[i][j] = Integer.parseInt(masField[i][j].getText());
                }
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    switch (sudoku2[i][j]) {
                        case 1:
                            mas[0]++;
                            break;
                        case 2:
                            mas[1]++;
                            break;
                        case 3:
                            mas[2]++;
                            break;
                        case 4:
                            mas[3]++;
                            break;
                        case 5:
                            mas[4]++;
                            break;
                        case 6:
                            mas[5]++;
                            break;
                        case 7:
                            mas[6]++;
                            break;
                        case 8:
                            mas[7]++;
                            break;
                        case 9:
                            mas[8]++;
                            break;
                        default:
                            break;
                    }
                }
                    for (int k = 0; k < 9; k++) {
                        if (mas[k] == i + 1)
                            count1++;
                    }

            }
            for (int i = 0; i < 9; i++) {
                mas[i] = 0;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    switch (sudoku2[j][i]) {
                        case 1:
                            mas[0]++;
                            break;
                        case 2:
                            mas[1]++;
                            break;
                        case 3:
                            mas[2]++;
                            break;
                        case 4:
                            mas[3]++;
                            break;
                        case 5:
                            mas[4]++;
                            break;
                        case 6:
                            mas[5]++;
                            break;
                        case 7:
                            mas[6]++;
                            break;
                        case 8:
                            mas[7]++;
                            break;
                        case 9:
                            mas[8]++;
                            break;
                        default:
                            break;
                    }
                }
                    for (int k = 0; k < 9; k++) {
                        if (mas[k] == i + 1)
                            count2++;
                    }
            }
            for (int i = 0; i < 9; i++) {
                mas[i] = 0;
            }
                int i = 0, j = 0;
                for (int k = 1; k < 4; k++) {
                    for (int h = 1; h < 4; h++) {
                        for (i = 3 * (k - 1); i < (3 * k); i++) {
                            for (j = 3 * (h - 1); j < (3 * h); j++) {
                                switch (sudoku2[j][i]) {
                                    case 1:
                                        mas[0]++;
                                        break;
                                    case 2:
                                        mas[1]++;
                                        break;
                                    case 3:
                                        mas[2]++;
                                        break;
                                    case 4:
                                        mas[3]++;
                                        break;
                                    case 5:
                                        mas[4]++;
                                        break;
                                    case 6:
                                        mas[5]++;
                                        break;
                                    case 7:
                                        mas[6]++;
                                        break;
                                    case 8:
                                        mas[7]++;
                                        break;
                                    case 9:
                                        mas[8]++;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            for (int o = 0; o < 9; o++) {
                                if (mas[o] == i + 1)
                                    count3++;
                            }
                        }
                    }
                }
                if (count1 == 81 && count2 == 81 && count3 == 81)
                    sud = true;
            }
        catch(NumberFormatException e)
            {
            }
            return sud;
        }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Enter"))
            {
                if(sudoku_win())
                    l.setText("Все заповнено правильно");
                else
                    l.setText("Щось заповнено не правильно");
            }
            else
            {
                clear();
                create();
            }
        }
    }
}