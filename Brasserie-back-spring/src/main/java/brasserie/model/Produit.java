package brasserie.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_produit", columnDefinition = "enum('Biere', 'Snack')")
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(value=Biere.class, name="biere"),
	@Type(value=Snack.class, name="snack") 
})
public abstract class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produit")
	@JsonView(JsonViews.Common.class)
	protected Integer id;
	
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	protected String nom;
	
	@JsonView(JsonViews.Common.class)
	protected String description;
	
	@NotNull
	@JsonView(JsonViews.Common.class)
	protected Double prix;
	
	@NotNull
	@JsonView(JsonViews.Common.class)
	protected Integer stock;
	
	@JsonView(JsonViews.Common.class)
	protected int points;
	
	@Version
	protected int version;
	
	public Produit() {}
	
	public Produit(String nom, String description, Double prix, Integer stock, Integer points) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
		this.points = points;

	}
	
	public Produit(Integer id, String nom, String description, Double prix, Integer stock, Integer points) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
		this.points = points;

	}
	
	public Produit(Integer id, String nom, String description, Double prix, Integer stock) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;

	}
	
	
	//Constructeur snack (sans fidélité)
	public Produit(String nom, String description, Double prix, Integer stock) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
		
	}
	
	// Constructeur test
	public Produit(String nom, Double prix) {
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

	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
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
	public void setStock(Integer stock) {
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
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produits [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", stock="
				+ stock + "]";
	}
	
	
}
