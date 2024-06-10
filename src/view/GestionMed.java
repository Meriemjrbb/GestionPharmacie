package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.ClientDAO;
import DAO.MedicamentDAO;
import DAO.OrdonnanceDAO;
import Métiers.Client;
import Métiers.Medicament;
import Métiers.Ordonnance;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionMed extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idmed;
	private JTextField nomMed;
	private JTextField stockMed;
	private JTextField descMed;
	private JTable table;
	private MedicamentDAO meddao;
	private TableModelMed1 modelMed;
	private JButton btnNewButton;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnRetour;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionMed frame = new GestionMed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// met à jour le modèle de tableau avec les nouvelles données
	private void reloadMedicamentData() {
	    meddao = new MedicamentDAO();
	    modelMed.loadData(meddao.getAll());
	    table.setModel(modelMed); 
	}
	/**
	 * Create the frame.
	 */
	public GestionMed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Médicament");
		lblNewLabel.setIcon(new ImageIcon(GestionMed.class.getResource("/images/pills (1).png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(307, 33, 451, 80);
		contentPane.add(lblNewLabel);
		
		idmed = new JTextField();
		idmed.setBounds(101, 181, 96, 33);
		contentPane.add(idmed);
		idmed.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 123, 879, 370);
		contentPane.add(scrollPane);
		
		meddao = new MedicamentDAO();
		modelMed=new TableModelMed1();
		modelMed.loadData(meddao.getAll());
		
		
		table = new JTable(modelMed);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom Médicament");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(64, 128, 128));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(58, 243, 213, 33);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID Médicament");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(64, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(58, 123, 213, 33);
		contentPane.add(lblNewLabel_1);
		
		nomMed = new JTextField();
		nomMed.setColumns(10);
		nomMed.setBounds(101, 295, 96, 33);
		contentPane.add(nomMed);
		
		JLabel lblNewLabel_1_2 = new JLabel("Stock");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(64, 128, 128));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(58, 349, 213, 33);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Description");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(64, 128, 128));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(58, 469, 213, 33);
		contentPane.add(lblNewLabel_1_3);
		
		stockMed = new JTextField();
		stockMed.setColumns(10);
		stockMed.setBounds(101, 405, 96, 33);
		contentPane.add(stockMed);
		
		descMed = new JTextField();
		descMed.setBounds(101, 512, 441, 33);
		contentPane.add(descMed);
		descMed.setColumns(10);
		
		btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int medId=Integer.parseInt(idmed.getText());
				String nomMe=nomMed.getText();
				String desc=descMed.getText();
				int stock=Integer.parseInt(stockMed.getText());
				meddao=new MedicamentDAO();
				Medicament med=new Medicament (medId,nomMe,desc,stock);
				meddao.add(med);
				JOptionPane.showMessageDialog(null, "Médicament Ajouté");
				reloadMedicamentData();
				idmed.setText("");
				nomMed.setText("");
				descMed.setText("");
				stockMed.setText("");	
					}
		});
		btnNewButton.setForeground(new Color(147, 112, 219));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(726, 518, 131, 33);
		contentPane.add(btnNewButton);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int medId=Integer.parseInt(idmed.getText());
				meddao=new MedicamentDAO();
				if (meddao.delete(medId))
				{JOptionPane.showMessageDialog(null, "Médicament Supprimé");}
				else {
                    JOptionPane.showMessageDialog(null, "Erreur lors de la Suppression de médicament.");}
				reloadMedicamentData();
				idmed.setText("");
				nomMed.setText("");
				descMed.setText("");
				stockMed.setText("");	
			}
		});
		btnSupprimer.setForeground(new Color(147, 112, 219));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSupprimer.setBounds(807, 561, 131, 33);
		contentPane.add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int medId=Integer.parseInt(idmed.getText());
				String nomMe=nomMed.getText();
				String desc=descMed.getText();
				int stock=Integer.parseInt(stockMed.getText());
				meddao=new MedicamentDAO();
				Medicament med=new Medicament (medId,nomMe,desc,stock);
				meddao.update(med);
				JOptionPane.showMessageDialog(null, "Médicament Modifié");
				reloadMedicamentData();
				idmed.setText("");
				nomMed.setText("");
				descMed.setText("");
				stockMed.setText("");	
					}
		});
		btnModifier.setForeground(new Color(147, 112, 219));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnModifier.setBounds(890, 518, 149, 33);
		contentPane.add(btnModifier);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminInterface().setVisible(true);
			}
		});
		btnRetour.setForeground(new Color(34, 139, 34));
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRetour.setBounds(24, 625, 131, 33);
		contentPane.add(btnRetour);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Confirmez si vous voulez fermer la fenetre","fermer",JOptionPane.YES_NO_OPTION)
						==0) {
					System.exit(0);
				}
			}
		});
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(1043, 625, 131, 33);
		contentPane.add(btnExit);
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            if (!e.getValueIsAdjusting()) {
	                int selectedRow = table.getSelectedRow();
	                if (selectedRow != -1) {
	                    // Récupérer les données de la ligne sélectionnée et les afficher dans les champs correspondants
	                	idmed.setText(table.getValueAt(selectedRow, 0).toString());
	                    nomMed.setText(table.getValueAt(selectedRow, 1).toString());
	                    descMed.setText(table.getValueAt(selectedRow, 2).toString());
	                    stockMed.setText(table.getValueAt(selectedRow, 3).toString());
	                }
	            }
	        }
	    });
	}
}
