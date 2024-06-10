package Métiers;

public class Pharmacien extends Utilisateur {
	private int annéesExp;
	
	public Pharmacien(int id,String nomUtilisateur, String motDePasse, String mail, String adresse, String telephone,
			String role,int annéesExp) {
		super(id,nomUtilisateur,motDePasse,mail,adresse, telephone,role);
		this.annéesExp=annéesExp;

	}
	public int getAnnéesExp() {
		return annéesExp;
	}
	public void setAnnéesExp(int annéesExp) {
		this.annéesExp = annéesExp;
	}    
}

