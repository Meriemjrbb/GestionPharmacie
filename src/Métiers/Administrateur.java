package Métiers;

public class Administrateur extends Utilisateur {
	private int AnnéEmbauche;
	
	public Administrateur(int id,String nomUtilisateur, String motDePasse, String mail, String adresse, String telephone,
			String role,int AnnéEmbauche) {
		super(id,nomUtilisateur,motDePasse,mail,adresse, telephone,role);
		this.AnnéEmbauche=AnnéEmbauche;
	}
	
	public int getAnnéEmbauche() {
		return AnnéEmbauche;
	}
	public void setAnnéEmbauche(int annéEmbauche) {
		AnnéEmbauche = annéEmbauche;
	}
}
