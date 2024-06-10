package Métiers;

public class Utilisateur {
	private int id;
	private String nomUtilisateur;
	private String motDePasse;
	private String mail;
	private String adresse;
	private String telephone;
	private String role;
	
	public Utilisateur(int id,String nomUtilisateur, String motDePasse, String mail, String adresse, String telephone,
			String role) {
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.role = role;
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nomUtilisateur=" + nomUtilisateur + ", motDePasse=" + motDePasse + ", mail="
				+ mail + ", adresse=" + adresse + ", telephone=" + telephone + ", role=" + role + "]";}
	

}