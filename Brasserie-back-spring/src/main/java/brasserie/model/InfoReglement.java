package brasserie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="info_reglement")
public class InfoReglement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Reservation.class)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="client_fk")
	@NotNull
	@JsonView(JsonViews.Reservation.class)
	private Client client;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('CB', 'PayPal')")
	@NotNull
	@JsonView(JsonViews.Reservation.class)
	private Reglement mode;
	
	@NotNull
	@JsonView(JsonViews.Reservation.class)
	private String num;
	@NotNull
	@JsonView(JsonViews.Reservation.class)
	private String nom;
	@NotNull
	@JsonView(JsonViews.Reservation.class)
	private String dateValid;
	
	@Version
	private int version;
	
	public InfoReglement() {
		
	}

	public InfoReglement(Client client, String num, String nom, String dateValid) {
		this.client = client;
		this.mode = Reglement.CB;
		this.num = num;
		this.nom = nom;
		this.dateValid = dateValid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Reglement getMode() {
		return mode;
	}

	public void setMode(Reglement mode) {
		this.mode = mode;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateValid() {
		return dateValid;
	}

	public void setDateValid(String dateValid) {
		this.dateValid = dateValid;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "InfoReglement [id=" + id + ", client=" + client + ", mode=" + mode + ", num=" + num + ", nom=" + nom
				+ ", dateValid=" + dateValid + "]";
	}	
}
