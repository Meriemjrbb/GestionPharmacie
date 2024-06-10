package view;

import javax.swing.*;

public class InputDialogExample {
    public static void main(String[] args) {
        // Créer un cadre (JFrame)
        JFrame frame = new JFrame("Exemple InputDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);

        // Afficher une boîte de dialogue de saisie avec une valeur initiale
        String initialSelectionValue = "Valeur par défaut";
        String input = JOptionPane.showInputDialog(frame, "Entrez une valeur :", initialSelectionValue);

        // Vérifier si la saisie n'a pas été annulée
        if (input != null) {
            // Afficher la valeur saisie par l'utilisateur
            JOptionPane.showMessageDialog(frame, "Vous avez entré : " + input);
        } else {
            // Afficher un message indiquant que la saisie a été annulée
            JOptionPane.showMessageDialog(frame, "Saisie annulée.");
        }

        // Fermer le cadre après interaction
        frame.dispose();
    }
}
