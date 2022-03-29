package brasserie.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Client extends Compte {
	
	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@JsonView(JsonViews.Common.class)
	private String tel;
	@JsonView(JsonViews.Common.class)
	private int fidelite;
	
	@OneToMany(mappedBy = "client")
	private List<InfoReglement> reglements;
	
	@JsonView(JsonViews.ClientWithReservation.class)
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;
	
	// constructors
	public Client() {}
	
	public Client(Integer id, String mail, String password, 
			List<Achat> achats, String nom, String prenom, String tel, int fidelite,
			List<InfoReglement> reglements, List<Reservation> reservations) {
		super(id, mail, password, achats);
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

	public List<InfoReglement> getReglements() {
		return reglements;
	}
	public void setReglements(List<InfoReglement> reglements) {
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
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	public List<Biere> recommandation(){
		return null;
	}
	
	public List<Produit> validerPanier(){
		return null;
	}
	
	public void reglerPanier(Reglement reglement) {
		
	}
	
	public void evaluer(Biere biere) {
		
	}
}
