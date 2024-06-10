package Métiers;

import java.util.ArrayList;
import java.util.List;

public class Ordonnance {
    private int id;
	private Client client;
	private int mois;
	private List<Medicament> medicaments=new ArrayList<Medicament>();
	
	public Ordonnance(int id,  int mois, Client c) {
		this.id = id;
		this.mois = mois;
		this.client=c;}
	
	public List<Medicament> getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getMois() {
		return mois;
	}
	public void setDate(int mois) {
		this.mois =mois;
	}
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Ordonnance [id=" + id + ", client=" + client + ", mois=" + mois + ", medicaments=" + medicaments + "]";
	}

	
}
