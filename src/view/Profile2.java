package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UtilisateurDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtMail;
	private JTextField txtAdresse;
	private JTextField txtTelephone;
	private JTextField txtRole;
	private UtilisateurDAO userDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile2 frame = new Profile2();
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
	public Profile2() {
		setTitle("Profile Pharmacien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setBounds(202, 211, 182, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1_1.setBounds(202, 135, 182, 44);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Adresse");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_1_2.setBounds(202, 291, 182, 44);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Téléphone");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(128, 0, 128));
		lblNewLabel_1_3.setBounds(202, 369, 182, 44);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Role");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setForeground(new Color(128, 0, 128));
		lblNewLabel_1_4.setBounds(202, 445, 182, 44);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Profile");
		lblNewLabel_1_3_2.setIcon(new ImageIcon(Profile.class.getResource("/images/user (4).png")));
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1_3_2.setBounds(398, 35, 282, 70);
		contentPane.add(lblNewLabel_1_3_2);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtNom.setHorizontalAlignment(SwingConstants.LEFT);
		txtNom.setBounds(669, 135, 336, 44);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setEditable(false);
		txtMail.setHorizontalAlignment(SwingConstants.LEFT);
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtMail.setColumns(10);
		txtMail.setBounds(669, 211, 336, 44);
		contentPane.add(txtMail);
		
		txtAdresse = new JTextField();
		txtAdresse.setEditable(false);
		txtAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdresse.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(669, 291, 336, 44);
		contentPane.add(txtAdresse);
		
		txtTelephone = new JTextField();
		txtTelephone.setEditable(false);
		txtTelephone.setHorizontalAlignment(SwingConstants.LEFT);
		txtTelephone.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(669, 369, 336, 44);
		contentPane.add(txtTelephone);
		
		txtRole = new JTextField();
		txtRole.setEditable(false);
		txtRole.setHorizontalAlignment(SwingConstants.LEFT);
		txtRole.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtRole.setColumns(10);
		txtRole.setBounds(669, 445, 336, 44);
		contentPane.add(txtRole);
		
		userDAO=new UtilisateurDAO();
		int id=LoginInterface.getIntLog();
		String mdp=LoginInterface.getPassword();
		txtNom.setText(userDAO.seConnecter(id, mdp).getNomUtilisateur());
		txtMail.setText(userDAO.seConnecter(id, mdp).getMail());
		txtAdresse.setText(userDAO.seConnecter(id, mdp).getAdresse());
		txtTelephone.setText(userDAO.seConnecter(id, mdp).getTelephone());
		txtRole.setText(userDAO.seConnecter(id, mdp).getRole());
		
		
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminInterface().setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(98, 645, 207, 44);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Confirmez si vous voulez fermer la fenetre","fermer",JOptionPane.YES_NO_OPTION)
						==0) {
					System.exit(0);
				}
			}
		});
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBounds(716, 645, 207, 44);
		contentPane.add(btnExit);
	}
}
