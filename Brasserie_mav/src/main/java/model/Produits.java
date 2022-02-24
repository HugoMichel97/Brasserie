package model;

import java.util.List;

public abstract class Produits {
	
	protected String nom;
	protected double prix;
	protected String description;
	protected int stock;
	
	// constructors
	public Produits(String nom, double prix, String description, int stock) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.stock = stock;
	}
	
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

	// toString
	@Override
	public String toString() {
		return "Produits [nom=" + nom + ", prix=" + prix + ", description=" + description
				+ ", stock=" + stock + "]";
	}
	
	// methods
	abstract public List<Produits> filtrer();
}
