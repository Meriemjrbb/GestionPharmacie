package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PharmacienInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PharmacienInterface frame = new PharmacienInterface();
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
	public PharmacienInterface() {
		setTitle("Pharmacien");
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setBounds(100, 430, 309, 109);
		btnNewButton.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/user (4).png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Profile().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clients");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new listeClient().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(100, 152, 309, 109);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/users-alt.png")));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gestion Ordonnance");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GestionOrdonnance().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(227, 288, 537, 109);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/prescription (1).png")));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Médicaments");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MedicamentList().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(512, 152, 335, 109);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_4.setIcon(new ImageIcon(PharmacienInterface.class.getResource("/images/pills (1).png")));
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Déconnexion");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment Déconnecter ?","Déconnecter",JOptionPane.YES_NO_OPTION)
						==0) {
		        setVisible(false);
		        new LoginInterface().setVisible(true);
		    }}
		});
		btnNewButton_5.setBounds(512, 430, 335, 109);
		btnNewButton_5.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/logout.png")));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Votre Tableau De Bord comme pharmacien");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(85, 107, 47));
		lblNewLabel.setBounds(56, 42, 817, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Confirmez si vous voulez fermer la fenetre","fermer",JOptionPane.YES_NO_OPTION)
						==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(PharmacienInterface.class.getResource("/images/button.png")));
		btnNewButton_3.setBounds(427, 563, 68, 70);
		contentPane.add(btnNewButton_3);
	}}
