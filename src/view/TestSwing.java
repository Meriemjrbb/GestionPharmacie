package view;

import javax.swing.*;
public class TestSwing {
private static void createUI() {
JFrame w = new JFrame();
w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JButton b = new JButton("click me!");
b.addActionListener( e -> System.out.println("click!"));
w.getContentPane().add(b);
w.pack();
w.setVisible(true);
}
public static void main(String[] args) {
SwingUtilities.invokeLater( () -> createUI());
}
} 
