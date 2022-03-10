package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_achat;
	
	@ManyToOne
	@JoinColumn(name="client_fk")
	private Client id_client;
	
	@ManyToOne
	private Produits id_produit;
	private int quantite;
	
	@Version
	private int version;
	
	public Achat() {}

	public Achat(Client id_client, Produits id_produit, int quantite) {
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

	public Produits getId_produit() {
		return id_produit;
	}

	public void setId_produit(Produits id_produit) {
		this.id_produit = id_produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
