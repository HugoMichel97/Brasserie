package soprajc.Brasserie.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="brasseur")
public class Brasseur extends Compte{

	@JsonView(JsonViews.Common.class)
	private double recettes;
	
	@JsonView(JsonViews.Common.class)
	private double depenses;
	
	@JsonView(JsonViews.Common.class)
	private double tresorerie;
	
	private transient List<Client> clients;
	private transient List<Evenement> evenements;
	private transient List<Ingredient> stock;
	
	// constructors
	public Brasseur() {}
	
	public Brasseur(Integer id, String mail, String password, double recettes,
			double depenses, double tresorerie, List<Client> clients, List<Evenement> evenements,
			List<Ingredient> stock) {
		super(id, mail, password, null);
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
	
	// methods
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
		Brasseur other = (Brasseur) obj;
		return Objects.equals(id, other.id);
	}
	
	public List<Biere> recommandation(Client c){
		return null;
	}
	
	public void preparerCommande(Client c) {
		
	}
	
}
