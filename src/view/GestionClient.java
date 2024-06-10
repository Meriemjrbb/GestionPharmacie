package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.ClientDAO;
import DAO.MedicamentDAO;
import Métiers.Client;
import Métiers.Medicament;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idclient;
	private JTextField nomtxt;
	private JTextField credittxt;
	private JTable table;
	private ClientDAO clidao;
	private tablemodelclient modelCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionClient frame = new GestionClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void reloadClientData() {
	    clidao = new ClientDAO();
	    modelCli.loadData(clidao.getAll());
	    table.setModel(modelCli); 
	}

	/**
	 * Create the frame.
	 */
	public GestionClient() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Client");
		lblNewLabel.setIcon(new ImageIcon(GestionClient.class.getResource("/images/client.png")));
		lblNewLabel.setForeground(new Color(135, 206, 235));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(404, 51, 337, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Client");
		lblNewLabel_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(74, 158, 110, 39);
		contentPane.add(lblNewLabel_1);
		
		idclient = new JTextField();
		idclient.setBounds(74, 207, 96, 32);
		contentPane.add(idclient);
		idclient.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom Client");
		lblNewLabel_1_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(336, 158, 130, 39);
		contentPane.add(lblNewLabel_1_1);
		
		nomtxt = new JTextField();
		nomtxt.setColumns(10);
		nomtxt.setBounds(348, 207, 96, 32);
		contentPane.add(nomtxt);
		
		credittxt = new JTextField();
		credittxt.setColumns(10);
		credittxt.setBounds(621, 207, 96, 32);
		contentPane.add(credittxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" Credit");
		lblNewLabel_1_1_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(611, 158, 130, 39);
		contentPane.add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 260, 684, 303);
		contentPane.add(scrollPane);
		
		clidao = new ClientDAO();
		modelCli=new tablemodelclient();
		modelCli.loadData(clidao.getAll());
		
		table = new JTable(modelCli);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cliId=Integer.parseInt(idclient.getText());
				String nomcli=nomtxt.getText();
				double credit=Double.parseDouble(credittxt.getText());
				clidao=new ClientDAO();
				Client cli=new Client (cliId,nomcli,credit);
				if (clidao.add(cli)) {
					JOptionPane.showMessageDialog(null, "Client Ajouté");
					reloadClientData();
				}
				else {
					JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du Client.");
				}
				idclient.setText("");
				nomtxt.setText("");
				credittxt.setText("");	
					}
		});
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(839, 269, 145, 39);
		contentPane.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cliId=Integer.parseInt(idclient.getText());
				String nomcli=nomtxt.getText();
				double credit=Double.parseDouble(credittxt.getText());
				clidao=new ClientDAO();
				Client cli=new Client (cliId,nomcli,credit);
				if (clidao.update(cli)) {
					JOptionPane.showMessageDialog(null, "Client Modifié");
					reloadClientData();
				}
				else {
					JOptionPane.showMessageDialog(null, "Erreur lors de la modification du Client.");
				}
				idclient.setText("");
				nomtxt.setText("");
				credittxt.setText("");	
					}
		});
		btnModifier.setForeground(new Color(139, 0, 0));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnModifier.setBounds(839, 332, 145, 39);
		contentPane.add(btnModifier);
		
		JButton btnEnregistrer = new JButton("Supprimer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cliId=Integer.parseInt(idclient.getText());
				String nomcli=nomtxt.getText();
				double credit=Double.parseDouble(credittxt.getText());
				clidao=new ClientDAO();
				Client cli=new Client (cliId,nomcli,credit);
				if (clidao.delete(cli)) {
					JOptionPane.showMessageDialog(null, "Client Supprimé");
					reloadClientData();
				}
				else {
					JOptionPane.showMessageDialog(null, "Erreur lors du Suppression du Client.");
				}
				idclient.setText("");
				nomtxt.setText("");
				credittxt.setText("");	
					}
		});
		btnEnregistrer.setForeground(new Color(139, 0, 0));
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEnregistrer.setBounds(839, 400, 145, 39);
		contentPane.add(btnEnregistrer);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminInterface().setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(34, 139, 34));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(39, 581, 131, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Confirmez si vous voulez fermer la fenetre","fermer",JOptionPane.YES_NO_OPTION)
						==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(867, 581, 117, 39);
		contentPane.add(btnNewButton_1_1);
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            if (!e.getValueIsAdjusting()) {
	                int selectedRow = table.getSelectedRow();
	                if (selectedRow != -1) {
	                    // Récupérer les données de la ligne sélectionnée et les afficher dans les champs correspondants
	                	idclient.setText(table.getValueAt(selectedRow, 0).toString());
	                	nomtxt.setText(table.getValueAt(selectedRow, 1).toString());
	                	credittxt.setText(table.getValueAt(selectedRow, 2).toString());
	                }
	            }
	        }
	    });
	}

}
