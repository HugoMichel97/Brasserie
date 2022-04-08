package soprajc.Brasserie.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@Table(name="evenement")
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evenement")
	@JsonView(JsonViews.Common.class)
	private Integer id;

	@NotNull
	@JsonView(JsonViews.Common.class)
	private LocalDate date;

	@NotNull
	@JsonView(JsonViews.Common.class)
	private LocalTime heure;

	@NotEmpty
	@JsonView(JsonViews.Common.class)
	@Column(length=25)
	private String libelle;

	@NotNull
	@JsonView(JsonViews.Common.class)
	private Double prix;

	@JsonView(JsonViews.Common.class)
	private int ptsRequis = 0;

	@JsonView(JsonViews.Common.class)
	@Column(length=300)
	private String description;

	@OneToMany(mappedBy = "evt")
	private List<Reservation> reservations;

	@Version
	private int version;

	public Evenement() {

	}

	public Evenement(LocalDate date, LocalTime heure, String libelle, Double prix, int ptsRequis, String description,
			List<Reservation> reservations) {
		this.date = date;
		this.heure = heure;
		this.libelle = libelle;
		this.prix = prix;
		this.ptsRequis = ptsRequis;
		this.description = description;
		this.reservations = reservations;
	}

	public Evenement(LocalDate date, LocalTime heure, String libelle, Double prix, int ptsRequis, String description) {
		this.date = date;
		this.heure = heure;
		this.libelle = libelle;
		this.prix = prix;
		this.ptsRequis = ptsRequis;
		this.description = description;
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	// method
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
		Evenement other = (Evenement) obj;
		return Objects.equals(id, other.id);
	}
}
