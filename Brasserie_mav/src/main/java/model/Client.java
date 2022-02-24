package model;

import java.util.List;

public class Client extends Compte {
	
	private String nom;
	private String prenom;
	private String tel;
	private int fidelite;
	private List<Reglement> reglements;
	private List<Reservation> reservations;
	
	// constructors
	public Client(Integer id, String mail, String password, 
			List<Produits> catalogue, String nom, String prenom, String tel, int fidelite,
			List<Reglement> reglements, List<Reservation> reservations) {
		super(id, mail, password, catalogue);
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.fidelite = fidelite;
		this.reglements = reglements;
		this.reservations = reservations;
	}
	
	public Client(String mail, String password) {
		super(mail, password);
	}

	// getters-setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getFidelite() {
		return fidelite;
	}
	public void setFidelite(int fidelite) {
		this.fidelite = fidelite;
	}

	public List<Reglement> getReglements() {
		return reglements;
	}
	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	// toString
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", fidelite=" + fidelite
				+ ", reglements=" + reglements + ", reservations=" + reservations + "]";
	}

	// methods
	public List<Biere> recommandation(){
		return null;
	}
	
	public List<Produits> validerPanier(){
		return null;
	}
	
	public void reglerPanier(Reglement reglement) {
		
	}
	
	public void evaluer(Biere biere) {
		
	}
}
