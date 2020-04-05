package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.*;

public class Main {


    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new sudoku();
            }
        });

    }
}
