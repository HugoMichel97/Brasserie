package model;

import java.util.List;

public class Brasseur extends Compte{

	private double recettes;
	private double depenses;
	private double tresorerie;
	private List<Client> clients;
	private List<Evenement> evenements;
	private List<Ingredient> stock;
	
	// constructors
	public Brasseur(Integer id, String mail, String password, List<Produits> catalogue, double recettes,
			double depenses, double tresorerie, List<Client> clients, List<Evenement> evenements,
			List<Ingredient> stock) {
		super(id, mail, password, catalogue);
		this.recettes = recettes;
		this.depenses = depenses;
		this.tresorerie = tresorerie;
		this.clients = clients;
		this.evenements = evenements;
		this.stock = stock;
	}

	public Brasseur(String mail, String password) {
		super(mail, password);
	}

	// getters-setters
	public double getRecettes() {
		return recettes;
	}
	public void setRecettes(double recettes) {
		this.recettes = recettes;
	}

	public double getDepenses() {
		return depenses;
	}
	public void setDepenses(double depenses) {
		this.depenses = depenses;
	}

	public double getTresorerie() {
		return tresorerie;
	}
	public void setTresorerie(double tresorerie) {
		this.tresorerie = tresorerie;
	}

	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}
	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public List<Ingredient> getStock() {
		return stock;
	}
	public void setStock(List<Ingredient> stock) {
		this.stock = stock;
	}

	// toString
	@Override
	public String toString() {
		return "Brasseur [recettes=" + recettes + ", depenses=" + depenses + ", tresorerie=" + tresorerie + ", clients="
				+ clients + ", evenements=" + evenements + ", stock=" + stock + "]";
	}
	
	// methods
	public List<Biere> recommandation(Client c){
		return null;
	}
	
	public void preparerCommande(Client c) {
		
	}
	
}
