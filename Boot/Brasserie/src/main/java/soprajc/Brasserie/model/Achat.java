package soprajc.Brasserie.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="achat")
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id_achat;
	
	@ManyToOne
	@JoinColumn(name="client_fk", foreignKey = @ForeignKey(name="achat_client_fk"))
	@JsonView(JsonViews.Achat.class)
	@NotNull
	private Client id_client;
	
	@ManyToOne
	@JoinColumn(name="produit_fk", foreignKey = @ForeignKey(name="achat_produit_fk"))
	@JsonView(JsonViews.Common.class)
	@NotNull
	private Produit id_produit;
	
	@NotNull
	@JsonView(JsonViews.Common.class)
	private Integer quantite;
	
	@Version
	private int version;
	
	public Achat() {}

	public Achat(Client id_client, Produit id_produit, Integer quantite) {
		this.id_client = id_client;
		this.id_produit = id_produit;
		this.quantite = quantite;
	}

	

	public Integer getId_achat() {
		return id_achat;
	}

	public void setId_achat(Integer id_achat) {
		this.id_achat = id_achat;
	}

	public Client getId_client() {
		return id_client;
	}

	public void setId_client(Client id_client) {
		this.id_client = id_client;
	}

	public Produit getId_produit() {
		return id_produit;
	}

	public void setId_produit(Produit id_produit) {
		this.id_produit = id_produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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
		return Objects.hash(id_achat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Achat other = (Achat) obj;
		return Objects.equals(id_achat, other.id_achat);
	}
}
