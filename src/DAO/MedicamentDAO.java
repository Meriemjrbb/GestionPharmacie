package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Métiers.Medicament;
import Métiers.Ordonnance;
import Métiers.Client;
import Métiers.Utilisateur;
import Métiers.Pharmacien;
import Métiers.Administrateur;

public class MedicamentDAO  {
    
 // recherche d'un médicament par nom
    public Medicament findByName(String nom) {
    	Connection conn=SingletonConnection.getInstance();
        String instrc = "select * from medicament where nommedicament = ?";
        Medicament medicament=null;

        try (PreparedStatement ps = conn.prepareStatement(instrc);) {
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	int id = rs.getInt("idmedicament");
                String description = rs.getString("description");
                int stock = rs.getInt("stock");

               medicament = new Medicament( id,nom, description, stock);
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return medicament;
    }
    // afficher tous les médicaments 
   
    public List<Medicament> getAll() {
    	Connection conn=SingletonConnection.getInstance();
        List<Medicament> medicaments = new ArrayList<>();
        String instrc = "select * from medicament";

        try (PreparedStatement ps = conn.prepareStatement(instrc);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("idmedicament");
                String nom = rs.getString("nommedicament");
                String description = rs.getString("description");
                int stock = rs.getInt("stock");

                Medicament medicament = new Medicament(id,nom, description, stock);
                medicaments.add(medicament);
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return medicaments;
    }
    //afficher liste des nom des médicament
    public List<String> getAllMedicamentNom() {
        List<Medicament> medicaments = getAll();
        List<String> medicamentNames = new ArrayList<>();

        for (Medicament medicament : medicaments) {
            medicamentNames.add(medicament.getNom()); 
        }

        return medicamentNames;
    }

    //ajout medicament
    public boolean add(Medicament medicament) {
    	Connection conn=SingletonConnection.getInstance();
        String instrc = "insert into medicament (idmedicament,nommedicament, description, stock) values (?, ?, ?,?)";

        try (PreparedStatement ps = conn.prepareStatement(instrc)) {
        	ps.setInt(1,medicament.getId());
            ps.setString(2, medicament.getNom());
            ps.setString(3, medicament.getDescription());
            ps.setInt(4, medicament.getStock());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace(); 
            return false;
        }
    }
    //modifier médicament
    public boolean update(Medicament medicament) {
    	Connection conn=SingletonConnection.getInstance();
        String instrc = "update medicament set nommedicament = ?, description = ?, stock = ? where idmedicament = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(instrc)) {
            
            ps.setString(1, medicament.getNom());
            ps.setString(2, medicament.getDescription());
            ps.setInt(3, medicament.getStock());
            ps.setInt(4, medicament.getId());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Supprimer medicament
    public boolean delete(int id) {
    	Connection conn=SingletonConnection.getInstance();
        String instrc = "delete from ordonnance_medicament where idmedicament=?";
        String instrc2="delete from medicament where idmedicament = ?";
        try (PreparedStatement ps = conn.prepareStatement(instrc);
        		PreparedStatement ps2 =conn.prepareStatement(instrc2);) {
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
           ps2.setInt(1, id); 
            ps2.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}