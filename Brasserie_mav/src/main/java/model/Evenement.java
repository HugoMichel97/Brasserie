package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Evenement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evenement")
	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	private String libelle;
	private double prix;
	private int ptsRequis = 0;
	private String description;
	
	//@ManyToOne
	@JoinColumn(name="brasseur_fk")
	private Brasseur brasseur;
	
	//@OneToMany(mappedBy = "evt")
	private transient List<Reservation>reservations;

	public Evenement() {
		
	}
	
	public Evenement(LocalDate date, LocalTime heure, String libelle, double prix, int ptsRequis, String description,
			Brasseur brasseur, List<Reservation> reservations) {
		super();
		this.date = date;
		this.heure = heure;
		this.libelle = libelle;
		this.prix = prix;
		this.ptsRequis = ptsRequis;
		this.description = description;
		this.brasseur = brasseur;
		this.reservations = reservations;
	}

	
	
	 public Integer getId() {
	        return id;
	    }


	    public void setId(Integer id) {
	        this.id = id;
	    }
	    
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getPtsRequis() {
		return ptsRequis;
	}

	public void setPtsRequis(int ptsRequis) {
		this.ptsRequis = ptsRequis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brasseur getBrasseur() {
		return brasseur;
	}

	public void setBrasseur(Brasseur brasseur) {
		this.brasseur = brasseur;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", date=" + date + ", heure=" + heure + ", libelle=" + libelle + ", prix=" + prix
				+ ", ptsRequis=" + ptsRequis + ", description=" + description + ", brasseur=" + brasseur
				+ ", reservations=" + reservations + "]";
	}

	
	
	
	
	
	
	
}
