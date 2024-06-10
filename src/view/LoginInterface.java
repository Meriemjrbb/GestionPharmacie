package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;

import DAO.UtilisateurDAO;
import Métiers.Utilisateur;
import Métiers.Pharmacien;
import Métiers.Administrateur;
import javax.swing.ImageIcon;


public class LoginInterface extends JFrame {

	/**
	 * 
	 */
	
	private JTextField txt_login;
	private JPasswordField txtpasswrd;
	private JFrame fermer_Login;
	static private String password;
	public static String getPassword() {
		return password;
	}

	public static int getIntLog() {
		return intLog;
	}

	
	static private int intLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface window = new LoginInterface();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public LoginInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public int getIdentifiant() {
	    return intLog;
	}

	public String getMotDePasse() {
	    return password;
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 781, 435);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Pharmacie");
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 25, 469, 56);
		getContentPane().add(lblNewLabel);
		
		JLabel login_lbl = new JLabel("Login");
		login_lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		login_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		login_lbl.setBounds(104, 123, 128, 33);
		getContentPane().add(login_lbl);
		
		JLabel passwrd_lbl = new JLabel("Mot de passe");
		passwrd_lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		passwrd_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwrd_lbl.setBounds(50, 214, 259, 33);
		getContentPane().add(passwrd_lbl);
		
		txt_login = new JTextField();
		txt_login.setFont(new Font("Tahoma", Font.BOLD, 20));
		txt_login.setBounds(334, 134, 242, 33);
		getContentPane().add(txt_login);
		txt_login.setColumns(10);
		
		txtpasswrd = new JPasswordField();
		txtpasswrd.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpasswrd.setBounds(334, 218, 242, 33);
		getContentPane().add(txtpasswrd);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password=txtpasswrd.getText();
				String login=txt_login.getText();
				intLog = Integer.parseInt(login);
				
				UtilisateurDAO u=new UtilisateurDAO();
				if(u.seConnecter(intLog, password) instanceof Pharmacien) {
					// on ouvre l'interface Pharmacien
					setVisible(false);
					new PharmacienInterface().setVisible(true);
					
				}
				else if(u.seConnecter(intLog, password) instanceof Administrateur) {
					// on ouvre l'interface Administrateur
					setVisible(false);
					new AdminInterface().setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					txtpasswrd.setText(null);
					txt_login.setText(null);
				}
			}
		});
		btnNewButton.setBounds(39, 334, 140, 54);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_login.setText(null);
				txtpasswrd.setText(null);
			}
		});
		btnNewButton_1.setBounds(311, 334, 140, 54);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer_Login = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(fermer_Login, "Confirmez si vous voulez fermer la fenetre","Login",JOptionPane.YES_NO_OPTION)
						==0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(575, 334, 140, 54);
		getContentPane().add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 300, 666, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(39, 91, 666, 2);
		getContentPane().add(separator_1);
	}
}
