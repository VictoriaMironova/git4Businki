package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

class Slice {
    double value;
    Color color;

    public Slice(double value, Color color) {
        this.value = value;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

class PieChart extends JComponent {
    ArrayList<Slice> slices;

    PieChart(ArrayList<Slice> slices) {
        setVisible(true);
        this.slices = slices;

    }

    public void paint(Graphics g) {
        drawPie(g, getBounds(), slices);
    }


    void drawPie(Graphics g, Rectangle area, ArrayList<Slice> slices) {
        double total = 0.0D;
        for (Slice slice : slices) {
            total += slice.value;
        }
        double curValue = 0.0D;
        int startAngle = 0;
        for (Slice slice : slices) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slice.value * 360 / total);
            g.setColor(slice.getColor());
            g.fillArc(area.x, area.y, area.width, area.height,
                    startAngle, arcAngle);
            curValue += slice.value;
        }
    }
}

class Main extends JFrame {

    Main(String s, int w, int h) {

        super(s);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout mainLayout = new CardLayout();
        setLayout(mainLayout);
        Container container = getContentPane();
        Random rand = new Random();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1, 10, 20));
        mainPanel.setVisible(true);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        JButton addButton = new JButton("Add");
        JPanel addPanel = new JPanel(new BorderLayout());
        addPanel.add(addButton, BorderLayout.NORTH);

        JButton createButton = new JButton("Open");
        JPanel createPanel = new JPanel(new BorderLayout());
        createPanel.add(createButton, BorderLayout.NORTH);

        buttonPanel.add(addPanel);
        buttonPanel.add(createPanel);

        JTextField nameField = new JTextField(10);
        JTextField areaField = new JTextField(10);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Назва", SwingConstants.CENTER));
        namePanel.add(nameField, TOP_ALIGNMENT);

        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        areaPanel.add(new JLabel("Площа"), SwingConstants.CENTER);
        areaPanel.add(areaField, TOP_ALIGNMENT);

        mainPanel.add(namePanel);
        mainPanel.add(areaPanel);
        mainPanel.add(new JPanel());
        mainPanel.add(buttonPanel);
        add(mainPanel);

        ArrayList<Slice> slices = new ArrayList<>();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color c;
                float x = rand.nextFloat();
                float y = rand.nextFloat();
                float z = rand.nextFloat();
                c = new Color(x, y, z);
                try {
                    slices.add(new Slice(Double.parseDouble(areaField.getText()), c));
                    nameField.setText("");
                    areaField.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Main.this, "Ви ввели неправильні дані!");
                    nameField.setText("");
                    areaField.setText("");
                }
            }
        });
        PieChart pc = new PieChart(slices);
        add(pc);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainLayout.next(container);
            }
        });

        mainPanel.revalidate();
        mainPanel.repaint();

    }

    public static void main(String[] args) {

        JFrame window = new Main("Module", 400, 400);

        window.paint(window.getGraphics());
        window.revalidate();
    }

    public void paint(Graphics g) {

    }
}