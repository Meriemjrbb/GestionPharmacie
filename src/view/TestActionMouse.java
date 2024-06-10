package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestActionMouse implements ActionListener {
JButton ButOK, ButAnnuler;
JLabel label;
public TestActionMouse() {
JFrame f = new JFrame("Interface Principale");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ButOK = new JButton("OK");
ButAnnuler = new JButton("Annuler");
label = new JLabel();
ButOK.addActionListener(this);
ButAnnuler.addActionListener(this);
ButOK.addMouseListener(new MyMouseListener());
f.getContentPane().setLayout(new FlowLayout());
f.getContentPane().add(ButOK);
f.getContentPane().add(ButAnnuler);
f.getContentPane().add(label);
f.setSize(300, 100);
f.setLocationRelativeTo(null);
f.setVisible(true);
}
public static void main(String[] args) {
new TestActionMouse();
}
public void actionPerformed(ActionEvent e) {
if (e.getSource() == ButOK)
label.setText("OK");
else if (e.getSource() == ButAnnuler)
label.setText("Annuler");

}
class MyMouseListener extends MouseAdapter {
public void mouseClicked(MouseEvent e) {
System.out.println("Clic de souris");
}
}
}