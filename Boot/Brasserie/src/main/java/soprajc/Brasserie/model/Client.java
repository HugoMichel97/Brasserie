package soprajc.Brasserie.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="client")
public class Client extends Compte {
	
	@JsonView(JsonViews.Common.class)
	@Column(length=25)
	private String nom;
	
	@JsonView(JsonViews.Common.class)
	@Column(length=25)
	private String prenom;
	
	@JsonView(JsonViews.Compte.class)
	@Column(length=12)
	private String tel;
	
	@JsonView(JsonViews.Common.class)
	private int fidelite = 0;
	
	@JsonView(JsonViews.Client.class)
	@NotNull
	@Column(name="date_naissance", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate naissance;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('vide', 'en_attente', 'validee', 'prete', 'recuperee')")
	@JsonView(JsonViews.Client.class)
	private StatutCommande statut = StatutCommande.vide;
	
	@OneToMany(mappedBy = "client")
	private List<InfoReglement> reglements;
	
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;
	
	// constructors
	public Client() {}
	
	public Client(String mail, String password, List<Achat> achats, String nom, String prenom, String tel,
			int fidelite, LocalDate naissance, List<InfoReglement> reglements, List<Reservation> reservations) {
		super(mail, password, achats);
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.fidelite = fidelite;
		this.naissance = naissance;
		this.reglements = reglements;
		this.reservations = reservations;
		if(!achats.isEmpty()) {
			this.statut = StatutCommande.en_attente;
		}
	}

	public Client(String mail, String password, String nom, String prenom, String tel, LocalDate naissance) {
		super(mail, password);
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.naissance = naissance;
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

	public LocalDate getNaissance() {
		return naissance;
	}
	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public StatutCommande getStatut() {
		return statut;
	}
	public void setStatut(StatutCommande statut) {
		this.statut = statut;
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
