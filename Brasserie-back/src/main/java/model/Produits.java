package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_produit", columnDefinition = "enum('Biere', 'Snack')")
public abstract class Produits {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produit")
	protected Integer id;
	protected String nom;
	protected String description;
	protected double prix;
	protected int stock;
	protected Integer points;
	
	@Version
	protected int version;
	
	public Produits() {}
	
	public Produits(String nom, String description, double prix, int stock, Integer points) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
		this.points = points;

	}
	
	public Produits(Integer id, String nom, String description, double prix, int stock, Integer points) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
		this.points = points;

	}
	
	public Produits(Integer id, String nom, String description, double prix, int stock) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;

	}
	
	
	//Constructeur snack (sans fid?lit?)
	public Produits(String nom, String description, double prix, int stock) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
		
	}
	
	// Constructeur test
	public Produits(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
		this.description = "";
		this.stock = 0;
	}

	// getters-setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Produits [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", stock="
				+ stock + "]";
	}
	
	// methods
	abstract public List<Produits> filtrer();
}
