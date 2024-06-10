package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Métiers.Utilisateur;
import Métiers.Pharmacien;
import Métiers.Administrateur;

public class UtilisateurDAO {
	// Se connecter à un compte selon le role indiquer dans la table && voir les cordonnées
	public Utilisateur seConnecter(int idUtilisateur, String motdepasse) {
	    Connection conn = SingletonConnection.getInstance();
	    String queryAll = "SELECT * FROM utilisateur WHERE idutilisateur = ? AND motdepasse = ?";
	    String queryPharmacien = "SELECT * FROM pharmacien WHERE idpharmacien = ?";
	    String queryAdministrateur = "SELECT * FROM administrateur WHERE idadministrateur = ?";
	    
	    try {
	        PreparedStatement ps = conn.prepareStatement(queryAll);
	        ps.setInt(1, idUtilisateur);
	        ps.setString(2, motdepasse);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            int id = rs.getInt("idutilisateur");
	            String nom = rs.getString("nomUtilisateur");
	            String mdp = rs.getString("motdepasse");
	            String mail = rs.getString("mail");
	            String adresse = rs.getString("adresse");
	            String telephone = rs.getString("telephone");
	            String role = rs.getString("role");
	            
	            // si il est pharmacien
	            if (role.equals("pharmacien")) {
	                PreparedStatement psPharmacien = conn.prepareStatement(queryPharmacien);
	                psPharmacien.setInt(1, idUtilisateur);
	                ResultSet rsPharmacien = psPharmacien.executeQuery();
	                
	                if (rsPharmacien.next()) {
	                    int annéesExperience = rsPharmacien.getInt("annéesExp");
	                    return new Pharmacien(id, nom, mdp, mail, adresse, telephone, role, annéesExperience);
	                }
	             // si administrateur 
	            } else if (role.equals("administrateur")) {
	                PreparedStatement psAdministrateur = conn.prepareStatement(queryAdministrateur);
	                psAdministrateur.setInt(1, idUtilisateur);
	                ResultSet rsAdministrateur = psAdministrateur.executeQuery();
	                
	                if (rsAdministrateur.next()) {
	                    int annéeEmb = rsAdministrateur.getInt("AnnéEmbauche");
	                    return new Administrateur(id, nom, mdp, mail, adresse, telephone, role, annéeEmb);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}}
