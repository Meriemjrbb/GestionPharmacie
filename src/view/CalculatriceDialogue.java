package view;

import javax.swing.JOptionPane;
public class CalculatriceDialogue{
public static void main(String[] args) {
JOptionPane.showMessageDialog(null, "Bienvenue", "Jeu",

JOptionPane.INFORMATION_MESSAGE);

String[] sexe = {"masculin", "féminin"};
int rang = JOptionPane.showOptionDialog(null,
"Veuillez indiquer votre sexe !",
"Boite",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE,
null,
sexe,
sexe[1]);
JOptionPane.showMessageDialog(null, "Votre sexe est " + sexe[rang], "Etat civil",

JOptionPane.INFORMATION_MESSAGE);

double nombre1 = 0, nombre2 = 0, resultat = 0;
String s1 = JOptionPane.showInputDialog(null, "Entrez un premier nombre");
try {
if (s1 != null) {
nombre1 = Double.parseDouble(s1);
}
} catch (NumberFormatException e) {
nombre1 = Double.parseDouble(JOptionPane.showInputDialog(null,

"Veuillez entrer un nombre valide pour le premier nombre !"));

}
String s2 = JOptionPane.showInputDialog(null, "Entrez un second nombre");
try {
if (s2 != null) {
nombre2 = Double.parseDouble(s2);
}
} catch (NumberFormatException e) {
nombre2 = Double.parseDouble(JOptionPane.showInputDialog(null,

"Veuillez entrer un nombre valide pour le second nombre !"));

}
String[] operateurs = new String[] { "+", "-", "*", "/" };
String operateur = (String) JOptionPane.showInputDialog(null, "Choississez un opérateur",
"Opérateur", JOptionPane.QUESTION_MESSAGE, null, operateurs, operateurs[0]);
if(operateur !=null)
switch(operateur){
case "+" -> resultat = nombre1 + nombre2;
case "-" -> resultat = nombre1 - nombre2;
case "*" -> resultat = nombre1 * nombre2;
case "/" -> resultat = nombre1 / nombre2;
default -> resultat = nombre1 + nombre2;
}

JOptionPane.showMessageDialog(null, nombre1 + " " + operateur + " " + nombre2 + " = " + resultat);
int reponse = JOptionPane.showConfirmDialog(null, "Êtes-vous satisfait de ceprogramme ?", "Satisfaction", JOptionPane.YES_NO_OPTION);
if (reponse == JOptionPane.YES_OPTION) {
JOptionPane.showMessageDialog(null, "Parfait");
} else if (reponse == JOptionPane.NO_OPTION) {
JOptionPane.showMessageDialog(null, "Dommage");
}
}
}