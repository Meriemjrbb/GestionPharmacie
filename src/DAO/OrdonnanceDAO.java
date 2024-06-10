package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Métiers.Medicament;
import Métiers.Ordonnance;
import Métiers.Client;
import Métiers.Utilisateur;
import Métiers.Pharmacien;
import Métiers.Administrateur;
public class OrdonnanceDAO {

	//Affichage Ordonnances
	public ResultSet getAllOrdonnances() {
		Connection conn=SingletonConnection.getInstance();

	    try  {
	    	Statement statement = conn.createStatement();
	        return statement.executeQuery("SELECT o.idordonnance,c.idClient, c.nomClient,m.idmedicament, m.nommedicament ,o.mois "
	        		+ "FROM ordonnance o, client c, ordonnance_medicament om, medicament m "
	        		+ "WHERE o.idclient = c.idClient "
	        		+ "AND o.idordonnance = om.idordonnance "
	        		+ "AND om.idmedicament = m.idmedicament"
	        		+ " ORDER BY o.idordonnance");} 
	     
	    catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }}
	//Ajout Ordonnance

	public void addOrdonnance(Ordonnance ordonnance) {
	    Connection conn = SingletonConnection.getInstance();
	    String query = "INSERT INTO ordonnance (idordonnance, idclient, mois) VALUES (?, ?, ?)";
	    
	    try (PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, ordonnance.getId());
	        statement.setInt(2, ordonnance.getClient().getId());
	        statement.setInt(3, ordonnance.getMois());
	        
	        statement.executeUpdate();
	        
	        // Vérification si une ligne a été insérée avec succès
	        
	            }
	     catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	}

	    //ajout d'un  medicament dans ordonnance
	    public boolean addMedicamentToOrdonnance(int id, int medicamentId) {
	    	Connection conn=SingletonConnection.getInstance();
	        String instrc1 = "insert into ordonnance_medicament (idordonnance, idmedicament) values (?, ?)";
	        String instrc2="update medicament set stock=stock-1 where idmedicament=?";
	        try {
	            PreparedStatement ps = conn.prepareStatement(instrc1);
	            ps.setInt(1, id);
	            ps.setInt(2, medicamentId);
	            ps.executeUpdate();
	            
	            PreparedStatement ps1 = conn.prepareStatement(instrc2);
	            ps1.setInt(1, medicamentId);
	            ps1.executeUpdate();
	            return true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	 // Méthode pour supprimer un médicament spécifique d'une ordonnance
	    public boolean deleteMedicamentFromOrdonnance(int idOrdonnance, int idMedicament) {
	        Connection conn = SingletonConnection.getInstance();
	        String deleteOrdonnanceMedicamentQuery = "DELETE FROM ordonnance_medicament WHERE idordonnance = ? AND idmedicament = ?";
	        String increaseStockQuery = "UPDATE medicament SET stock = stock + 1 WHERE idmedicament = ?";
	        
	        try {
	            // Supprimer le médicament de l'ordonnance
	            PreparedStatement ps1 = conn.prepareStatement(deleteOrdonnanceMedicamentQuery);
	            ps1.setInt(1, idOrdonnance);
	            ps1.setInt(2, idMedicament);
	            ps1.executeUpdate();
	            
	            // Augmenter le stock du médicament
	                PreparedStatement ps2 = conn.prepareStatement(increaseStockQuery);
	                ps2.setInt(1, idMedicament);
	                ps2.executeUpdate();
	                return true; // La suppression et la mise à jour du stock ont réussi
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false; // Une erreur s'est produite lors de l'exécution des requêtes SQL
	        }
	    }

	    //Modifier une ordonnance et les médicament qu'elle contient
	    public boolean updateOrdonnance(Ordonnance ordonnance) {
	    	Connection conn=SingletonConnection.getInstance();
	        String updateinstrc = "update ordonnance set idclient = ?, mois = ? where idordonnance = ?";
	        try {
	            PreparedStatement updatePS = conn.prepareStatement(updateinstrc);
	            updatePS.setInt(1, ordonnance.getClient().getId());
	            updatePS.setInt(2, ordonnance.getMois());
	            updatePS.setInt(3, ordonnance.getId());
	            
	            
	            updatePS.executeUpdate();
	            return true;}
	            
	            
	         catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

    //Supprimer une ordonnance
	    public boolean delete(int ordonnanceId) {
	    	Connection conn=SingletonConnection.getInstance();
	    	String OrdonnanceMedicamentinstrc = "delete from ordonnance_medicament where  idordonnance= ?";
	        String Ordonnanceinstrc = "delete from ordonnance where idordonnance= ?";
	        
	        
	        try { 
	        	// Suppression des liens entre l'ordonnance et les médicaments
	            PreparedStatement OrdonnanceMedicamentPS = conn.prepareStatement(OrdonnanceMedicamentinstrc);
	            OrdonnanceMedicamentPS.setInt(1, ordonnanceId);
	            OrdonnanceMedicamentPS.executeUpdate();
	            
	            
	            // Suppression de l'ordonnance
	            PreparedStatement OrdonnancePS = conn.prepareStatement(Ordonnanceinstrc);
	            OrdonnancePS.setInt(1, ordonnanceId);
	            OrdonnancePS.executeUpdate();
	            
	           
	            return true;
	            }
	         catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
}

