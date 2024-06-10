package Métiers;

public class Medicament {
	private int id;
	private String nom;
	private String description;
    private int stock;
	public Medicament(int id,String nom, String description, int stock) {
		this.id=id;
 		this.nom = nom;
 		this.description = description;
 		this.stock = stock;
 	}
     public int getId() {
 		return id;
 	}
 	public void setId(int id) {
 		this.id = id;
 	}
 	public String getNom() {
 		return nom;
 	}
 	public void setNom(String nom) {
 		this.nom = nom;
 	}
 	public String getDescription() {
 		return description;
 	}
 	public void setDescription(String description) {
 		this.description = description;
 	}
 	public int getStock() {
 		return stock;
 	}
 	public void setStock(int stock) {
 		this.stock = stock;
 	}
 	@Override
	public String toString() {
		return "Medicament [nom=" + nom + ", description=" + description + ", stock=" + stock + ", id=" + id + "]";
	}
 	
}
