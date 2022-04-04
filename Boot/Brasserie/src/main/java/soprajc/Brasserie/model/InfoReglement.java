package soprajc.Brasserie.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
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
	@JsonView(JsonViews.InfoReglement.class)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="client_fk", foreignKey = @ForeignKey(name="reglement_client_fk"))
	@NotNull
	@JsonView(JsonViews.InfoReglement.class)
	private Client client;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('CB', 'PayPal')")
	@NotNull
	@JsonView(JsonViews.InfoReglement.class)
	private Reglement mode;

	@NotNull
	@JsonView(JsonViews.InfoReglement.class)
	@Column(length=16)
	private String num;

	@NotNull
	@JsonView(JsonViews.InfoReglement.class)
	@Column(length=50)
	private String nom;

	@NotNull
	@JsonView(JsonViews.InfoReglement.class)
	@Column(length=5)
	private String dateValid;

	@NotNull
	@JsonView(JsonViews.InfoReglement.class)
	@Column(length=100)
	private String identifiant_paypal;

	@Version
	private int version;

	public InfoReglement() {}

	public InfoReglement(Client client, String num, String nom, String dateValid) {
		this.client = client;
		this.mode = Reglement.CB;
		this.num = num;
		this.nom = nom;
		this.dateValid = dateValid;
		this.identifiant_paypal = "";
	}

	public InfoReglement(Client client, String identifiant_paypal) {
		this.client = client;
		this.mode = Reglement.PayPal;
		this.num = "";
		this.nom = "";
		this.dateValid = "";
		this.identifiant_paypal = identifiant_paypal;
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

	public String getIdentifiant_paypal() {
		return identifiant_paypal;
	}

	public void setIdentifiant_paypal(String identifiant_paypal) {
		this.identifiant_paypal = identifiant_paypal;
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
		InfoReglement other = (InfoReglement) obj;
		return Objects.equals(id, other.id);
	}
}
