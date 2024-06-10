package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;

import DAO.ClientDAO;
import Métiers.Client;
import javax.swing.JScrollBar;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listeClient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private tablemodelclient cli= new tablemodelclient();
    private ClientDAO cDAO=new ClientDAO();
    private JTable table;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    listeClient frame = new listeClient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public listeClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Liste des Clients et leurs Credits");
        lblNewLabel.setIcon(new ImageIcon(listeClient.class.getResource("/images/client.png")));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 128, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(122, 0, 622, 102);
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 128, 128));
        separator.setBounds(122, 93, 645, 19);
        contentPane.add(separator);
        
        List<Client>clients=cDAO.getAll();
        cli.loadData(clients);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(113, 112, 654, 371);
        contentPane.add(scrollPane);
        
        table = new JTable(cli);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("Retour");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new PharmacienInterface().setVisible(true);
        	}
        });
        btnNewButton.setForeground(new Color(128, 0, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton.setBounds(370, 528, 153, 39);
        contentPane.add(btnNewButton);
        this.setSize(new Dimension(908, 692));
    }
}
