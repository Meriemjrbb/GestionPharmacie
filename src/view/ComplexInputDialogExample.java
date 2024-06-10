package view;

import javax.swing.*;

public class ComplexInputDialogExample {
    public static void main(String[] args) {
        // Créer un cadre (JFrame)
        JFrame frame = new JFrame("Exemple ComplexInputDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);

        // Message à afficher dans la boîte de dialogue
        Object message = "Sélectionnez une option :";

        // Titre de la boîte de dialogue
        String title = "Boîte de dialogue complexe";

        // Type de message (INFORMATION_MESSAGE)
        int messageType = JOptionPane.INFORMATION_MESSAGE;

        // Icône à afficher dans la boîte de dialogue (null pour ne pas utiliser d'icône personnalisée)
        Icon icon = null;

        // Liste des valeurs possibles
        Object[] selectionValues = { "Option 1", "Option 2", "Option 3", "Option 4" };

        // Valeur initiale (pré-sélectionnée)
        Object initialValue = "Option 2";

        // Afficher la boîte de dialogue
        Object selectedValue = JOptionPane.showInputDialog(
            frame,                   // Composant parent
            message,                 // Message
            title,                   // Titre
            messageType,             // Type de message
            icon,                    // Icône
            selectionValues,         // Liste des valeurs possibles
            initialValue             // Valeur initiale
        );

        // Vérifier si la saisie n'a pas été annulée
        if (selectedValue != null) {
            // Afficher la valeur sélectionnée par l'utilisateur
            JOptionPane.showMessageDialog(frame, "Vous avez sélectionné : " + selectedValue);
        } else {
            // Afficher un message indiquant que la saisie a été annulée
            JOptionPane.showMessageDialog(frame, "Sélection annulée.");
        }

        // Fermer le cadre après interaction
        frame.dispose();
    }
}

