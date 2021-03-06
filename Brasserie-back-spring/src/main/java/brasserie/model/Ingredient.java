package brasserie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id_ingredient;
	
	@JsonView(JsonViews.Common.class)
	private String nom;
	
	@JsonView(JsonViews.Common.class)
	private int stock = 0;
	
	@ManyToMany(mappedBy= "recette")
//	@JsonView(JsonViews.Ingredient.class)
	private List<Biere> bieres;
	
	@Version
	protected int version;
	
	// contructors
	public Ingredient() {}
	
	public Ingredient(String nom, int stock) {
		this.nom = nom;
		this.stock = stock;
	}
	
	public Ingredient(String nom) {
		this.nom = nom;
	}
	
	public Ingredient(String nom, int stock, List<Biere> bieres)
	{
		this.nom = nom;
		this.stock = stock;
		this.bieres = bieres;
	}
	

	public Integer getId_ingredient() {
		return id_ingredient;
	}

	public void setId_ingredient(Integer id_ingredient) {
		this.id_ingredient = id_ingredient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Biere> getBieres() {
		return bieres;
	}

	public void setBiere(List<Biere> bieres) {
		this.bieres = bieres;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	
	// methods
	
}
