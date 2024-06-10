package Métiers;

public class Client {
	private int id;
	private String nom;
    private double credit;
    
    public Client(int id ,String nom, double credit) {
    	this.id=id;
		this.nom = nom;
		this.credit = credit;
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

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", credit=" + credit + "]";
	}

}
