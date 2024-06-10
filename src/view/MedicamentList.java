package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.MedicamentDAO;
import Métiers.Medicament;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;

public class MedicamentList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TableModelMed1 medModel= new TableModelMed1();
    private MedicamentDAO mDAO=new MedicamentDAO();
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnNewButton;
    private MedicamentDAO medDAO;
    private JComboBox<String> medName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicamentList frame = new MedicamentList();
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
	public MedicamentList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Médicaments");
        lblNewLabel.setIcon(new ImageIcon(MedicamentList.class.getResource("/images/pills (1).png")));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 128, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(122, 0, 622, 102);
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 128, 128));
        separator.setBounds(53, 100, 856, 19);
        contentPane.add(separator);
        
        List<Medicament>medicaments=mDAO.getAll();
        medModel.loadData(medicaments);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(53, 210, 831, 371);
        contentPane.add(scrollPane);
        
        table = new JTable(medModel);
        scrollPane.setViewportView(table);
        
        btnNewButton = new JButton("Retour");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new PharmacienInterface().setVisible(true);
        	}
        });
        btnNewButton.setForeground(new Color(64, 128, 128));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton.setBounds(717, 591, 132, 39);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Nom Médicament ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(128, 0, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_1.setBounds(70, 123, 246, 52);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton_1 = new JButton("Rechercher");
        btnNewButton_1.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        	        String nomMedicament = (String) medName.getSelectedItem();
        	        if (nomMedicament != null && !nomMedicament.isEmpty()) {
        	            Medicament medicament = medDAO.findByName(nomMedicament);
        	            if (medicament != null) {
        	                // Effacer les données actuellement affichées dans le JTable
        	                medModel.clearData();
        	                // Ajouter le médicament trouvé au modèle de tableau
        	                medModel.addData(medicament);
        	            }
        	        }
        	    }
        });
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setIcon(new ImageIcon(MedicamentList.class.getResource("/images/search (1).png")));
        btnNewButton_1.setBounds(602, 132, 204, 39);
        contentPane.add(btnNewButton_1);
        medDAO=new MedicamentDAO();
        medName = new JComboBox<>(medDAO.getAllMedicamentNom().toArray(new String[0]));
        
        medName.setBounds(353, 129, 152, 37);
        contentPane.add(medName);
        
        JButton btnNewButton_2 = new JButton("Afficher tous");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<Medicament>medicaments=mDAO.getAll();
                medModel.loadData(medicaments);
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton_2.setForeground(new Color(64, 128, 128));
        btnNewButton_2.setBounds(94, 591, 222, 39);
        contentPane.add(btnNewButton_2);
        this.setSize(new Dimension(908, 692));
    }
}
