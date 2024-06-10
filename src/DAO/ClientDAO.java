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

import Métiers.Medicament;

public class ClientDAO {
	//affichge des clients
	public List<Client> getAll() {
    	Connection conn=SingletonConnection.getInstance();
        List<Client> clients = new ArrayList<>();
        String instrc = "select * from client";

        try (PreparedStatement ps = conn.prepareStatement(instrc);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	int id=rs.getInt("idClient");
                String nom = rs.getString("nomClient");
                double credit = rs.getDouble("credit");
                Client client = new Client(id,nom, credit);
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return clients;
    }
	//get by id
	public Client getid(int id) {
	    Connection conn = SingletonConnection.getInstance();
	    String instrc = "SELECT * FROM client WHERE idClient=?";

	    try (PreparedStatement ps = conn.prepareStatement(instrc)) {
	        ps.setInt(1, id); // Passer le paramètre id à la requête SQL
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                String nom = rs.getString("nomClient");
	                double credit = rs.getDouble("credit");
	                Client client = new Client(id, nom, credit);
	                return client;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	//ajout d'un Client
	public boolean add(Client client) {
    	Connection conn=SingletonConnection.getInstance();
        String instrc = "insert into client (idClient ,nomClient, credit) values (?,?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(instrc)) {
        	ps.setInt(1,client.getId());
            ps.setString(2, client.getNom());
            ps.setDouble(3, client.getCredit());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace(); 
            return false;
        }
    }
	//modifier un client
	public boolean update(Client client) {
    	Connection conn=SingletonConnection.getInstance();
        String instrc = "update client set nomClient = ?, credit = ? where idClient = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(instrc)) {
            
            ps.setString(1, client.getNom());
            ps.setDouble(2, client.getCredit());
            ps.setInt(3, client.getId());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	//Supprimer Client
	public boolean delete(Client client) {
    	Connection conn=SingletonConnection.getInstance();
        String instrc = "delete from client where idClient = ?";
        try (PreparedStatement ps = conn.prepareStatement(instrc)) {
            
            ps.setInt(1, client.getId());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
