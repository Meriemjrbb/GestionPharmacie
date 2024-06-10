package view;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {
	public FlowLayoutExample() {
        // Configurer le cadre (JFrame)
        setTitle("Calculatrice");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(10, 10)); // Utiliser BorderLayout avec un espacement de 10 pixels

        // Créer le panneau d'affichage et l'ajouter à la zone PAGE_START
        JTextField display = new JTextField();
        display.setEditable(true);
        display.setPreferredSize(new Dimension(400, 50));
        getContentPane().add(display, BorderLayout.PAGE_START);

        // Créer le panneau du clavier avec GridLayout 4x4
        JPanel keypadPanel = new JPanel();
        keypadPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4 lignes, 4 colonnes, espacement de 10 pixels

        // Ajouter les boutons au panneau du clavier
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            keypadPanel.add(button);
        }

        // Ajouter le panneau du clavier à la zone CENTER
        getContentPane().add(keypadPanel, BorderLayout.CENTER);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
        keypadPanel.add(chckbxNewCheckBox);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
        keypadPanel.add(rdbtnNewRadioButton);

        // Rendre le cadre visible
        setVisible(true);
    }



    public static void main(String[] args) {
        // Créer une instance de la classe BoxLayoutLineAxisExample
        new FlowLayoutExample();
    }

}