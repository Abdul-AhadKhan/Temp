/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorderPanelExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded Border Panel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JButton button1 = new JButton("Read");
            button1.setBorder(new RoundedBorder(200));

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            JPanel roundedPanel = new JPanel();
            roundedPanel.setLayout(new BorderLayout());
            roundedPanel.setBorder(new RoundedBorder(200)); // Set the rounded border with a radius of 10

            JLabel label = new JLabel("This panel has a rounded border!");
            roundedPanel.add(label, BorderLayout.CENTER);

            mainPanel.add(roundedPanel, BorderLayout.CENTER);
            roundedPanel.add(button1);
            
            frame.getContentPane().add(mainPanel);
            JPanel panel = new JPanel();
            panel.add(new JLabel());
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Custom RoundedBorder class
    static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}





