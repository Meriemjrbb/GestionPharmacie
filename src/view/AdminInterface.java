package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
public class AdminInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInterface frame = new AdminInterface();
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
	public AdminInterface() {
		setTitle("Administrateur Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setBounds(232, 148, 537, 88);
		btnNewButton.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/user (4).png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Profile2().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Gestion Clients");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GestionClient().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(232, 254, 537, 88);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/management.png")));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Gestion Médicament");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GestionMed().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(232, 362, 537, 88);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_3.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/pills (1).png")));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Déconnexion");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment Déconnecter ?","Déconnecter",JOptionPane.YES_NO_OPTION)
						==0) {
		        setVisible(false);
		        new LoginInterface().setVisible(true);
		    }
			}
		});
		btnNewButton_5.setBounds(232, 473, 537, 88);
		btnNewButton_5.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/logout.png")));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Votre Tableau De Bord comme Administrateur");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(85, 107, 47));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(32, 31, 800, 71);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Confirmez si vous voulez fermer la fenetre","fermer",JOptionPane.YES_NO_OPTION)
						==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/button.png")));
		btnNewButton_1.setBounds(843, 577, 72, 70);
		contentPane.add(btnNewButton_1);
	}
}
