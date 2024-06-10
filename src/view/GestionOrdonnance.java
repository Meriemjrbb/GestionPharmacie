package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import DAO.ClientDAO;
import DAO.OrdonnanceDAO;
import Métiers.Client;
import Métiers.Ordonnance;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GestionOrdonnance extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTable table;
private JTextField ordId;
private JTextField clientId;
private JTextField medtxt;
private JTextField moistxt;
private OrdonnanceDAO ordDAO;
private TableModelOrdonnance tab;
private JFrame fermer;
JScrollPane scrollPane = new JScrollPane();
/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				GestionOrdonnance frame = new GestionOrdonnance();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
// met à jour le modèle de tableau avec les nouvelles données
private void reloadOrdonnanceData() {
    OrdonnanceDAO ordao = new OrdonnanceDAO();
    tab.loadData(ordao.getAllOrdonnances());
    table.setModel(tab); 
}
public GestionOrdonnance() {
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1095, 681);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	
	JLabel lblNewLabel = new JLabel("Gestion Ordonnance");
	lblNewLabel.setForeground(new Color(128, 128, 192));
	lblNewLabel.setIcon(new ImageIcon(GestionOrdonnance.class.getResource("/images/prescription (1).png")));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblNewLabel.setBounds(286, 10, 404, 69);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Id Client");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_1.setBounds(234, 125, 165, 43);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Id Ordonnance");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setBounds(38, 125, 165, 43);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_1_1 = new JLabel("Mois");
	lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_1_1.setBounds(402, 134, 155, 25);
	contentPane.add(lblNewLabel_1_1);
	
	moistxt = new JTextField();
	moistxt.setFont(new Font("Tahoma", Font.BOLD, 15));
	moistxt.setColumns(10);
	moistxt.setBounds(456, 176, 57, 29);
	contentPane.add(moistxt);
	
	ordId = new JTextField();
	ordId.setFont(new Font("Tahoma", Font.BOLD, 15));
	ordId.setBounds(94, 178, 57, 27);
	contentPane.add(ordId);
	ordId.setColumns(10);
	
	clientId = new JTextField();
	clientId.setFont(new Font("Tahoma", Font.BOLD, 15));
	clientId.setBounds(286, 177, 57, 29);
	contentPane.add(clientId);
	clientId.setColumns(10);
	
	
	JButton btnNewButton = new JButton("Ajouter");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ord=Integer.parseInt(ordId.getText());
			int clid=Integer.parseInt(clientId.getText());
			int mois=Integer.parseInt(moistxt.getText());
			ClientDAO cDAO=new ClientDAO();
			Client c= cDAO.getid(clid);
			Ordonnance ordo=new Ordonnance(ord,mois,c);
			ordDAO=new OrdonnanceDAO();
			ordDAO.addOrdonnance(ordo);
			JOptionPane.showMessageDialog(null, "Ordonnance Ajouté");
				}
			}
	);
	btnNewButton.setForeground(new Color(32, 178, 170));
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnNewButton.setBounds(67, 459, 189, 43);
	contentPane.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Modifier");
	btnNewButton_1.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 
             int selectedRow = table.getSelectedRow();
             if (selectedRow != -1) {
            	 int ordonnanceId = Integer.parseInt(ordId.getText());
            	 int clientid = Integer.parseInt(clientId.getText());
            	 int mois = Integer.parseInt(moistxt.getText());
 
                 // Créer un objet Ordonnance avec les données de la ligne sélectionnée
                 ClientDAO clientDAO = new ClientDAO();
                 Client client = clientDAO.getid(clientid);
                 Ordonnance ordonnance = new Ordonnance(ordonnanceId, mois, client);
                 // Appeler la méthode updateOrdonnance dans OrdonnanceDAO pour modifier l'ordonnance
                 ordDAO=new OrdonnanceDAO();
                 boolean updated = ordDAO.updateOrdonnance(ordonnance);
                 if (updated) {
                     // Rafraîchir les données du tableau
                     reloadOrdonnanceData();
                 } else {
                     JOptionPane.showMessageDialog(null, "Erreur lors de la modification de l'ordonnance.");
                 }
             }
	}});
	btnNewButton_1.setForeground(new Color(32, 178, 170));
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnNewButton_1.setBounds(67, 520, 189, 43);
	contentPane.add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("Supprimer");
	btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int ordonnanceId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                    // Appeler la méthode delete dans OrdonnanceDAO pour supprimer l'ordonnance
                    ordDAO=new OrdonnanceDAO();
                    boolean deleted = ordDAO.delete(ordonnanceId);
                    if (deleted) {
                        // Rafraîchir les données du tableau
                        reloadOrdonnanceData();
                        // Effacer les champs après la suppression
                        ordId.setText("");
                        clientId.setText("");
                        moistxt.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erreur lors de la suppression de l'ordonnance.");
                    }
                }
            }
        });
	btnNewButton_2.setForeground(new Color(32, 178, 170));
	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnNewButton_2.setBounds(67, 573, 189, 43);
	contentPane.add(btnNewButton_2);
	
	OrdonnanceDAO ordao = new OrdonnanceDAO();
	tab = new TableModelOrdonnance();
	tab.loadData(ordao.getAllOrdonnances());
	
	
	JSeparator separator = new JSeparator();
	separator.setForeground(new Color(32, 178, 170));
	separator.setBounds(221, 93, 611, 2);
	contentPane.add(separator);
	
	JButton btnNewButton_3 = new JButton("Ajouter ce médicament");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int idord=Integer.parseInt(ordId.getText());
			int idmed=Integer.parseInt(medtxt.getText());
			OrdonnanceDAO od=new OrdonnanceDAO();
			od.addMedicamentToOrdonnance(idord, idmed);
			JOptionPane.showMessageDialog(null, "Médicament Ajouté");
			medtxt.setText("");
			
        }
    });
	btnNewButton_3.setForeground(new Color(128, 0, 255));
	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnNewButton_3.setBounds(259, 289, 306, 43);
	contentPane.add(btnNewButton_3);
	
	JLabel lblNewLabel_3 = new JLabel("Id Médicament");
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_3.setBounds(21, 314, 178, 38);
	contentPane.add(lblNewLabel_3);
	
	medtxt = new JTextField();
	medtxt.setFont(new Font("Tahoma", Font.BOLD, 15));
	medtxt.setBounds(209, 322, 40, 32);
	contentPane.add(medtxt);
	medtxt.setColumns(10);
	
	JButton btnEnregistrer = new JButton("Enregistrer");
	btnEnregistrer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			reloadOrdonnanceData();
			medtxt.setText("");
			ordId.setText("");
            clientId.setText("");
            moistxt.setText("");
			
	}});
	btnEnregistrer.setForeground(new Color(0, 255, 0));
	btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnEnregistrer.setBounds(286, 459, 189, 43);
	contentPane.add(btnEnregistrer);
	
	JButton btnExit = new JButton("Exit");
	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fermer = new JFrame("Exit");
			if(JOptionPane.showConfirmDialog(fermer, "Confirmez si vous voulez fermer la fenetre","Login",JOptionPane.YES_NO_OPTION)
					==0) {
				System.exit(0);}
		}
	});
	btnExit.setForeground(new Color(255, 0, 0));
	btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnExit.setBounds(286, 573, 189, 43);
	contentPane.add(btnExit);
	
	JButton btnNewButton_3_1 = new JButton("Supprimer ce Médicament");
	btnNewButton_3_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int idord=Integer.parseInt(ordId.getText());
			int idmed=Integer.parseInt(medtxt.getText());
			OrdonnanceDAO od=new OrdonnanceDAO();
			od.deleteMedicamentFromOrdonnance(idord, idmed);
			JOptionPane.showMessageDialog(null, "Médicament Supprimé");
			medtxt.setText("");
			
        }
	});
	btnNewButton_3_1.setForeground(new Color(128, 0, 255));
	btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnNewButton_3_1.setBounds(259, 355, 308, 43);
	contentPane.add(btnNewButton_3_1);
	
	
	scrollPane.setBounds(575, 202, 496, 395);
	contentPane.add(scrollPane);
	table = new JTable(tab);
	scrollPane.setViewportView(table);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	JButton btnNewButton_4 = new JButton("Retour");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new PharmacienInterface().setVisible(true);
		}
	});
	btnNewButton_4.setForeground(new Color(128, 128, 192));
	btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnNewButton_4.setBounds(286, 520, 189, 43);
	contentPane.add(btnNewButton_4);
    ListSelectionModel selectionModel = table.getSelectionModel();
    selectionModel.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Récupérer les données de la ligne sélectionnée et les afficher dans les champs correspondants
                    ordId.setText(table.getValueAt(selectedRow, 0).toString());
                    clientId.setText(table.getValueAt(selectedRow, 1).toString());
                    medtxt.setText(table.getValueAt(selectedRow, 3).toString());
                    moistxt.setText(table.getValueAt(selectedRow, 5).toString());
                }
            }
        }
    });
	
	
}}