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
	
	// constructors
	public Brasseur() {}
	
	public Brasseur(String mail, String password, double recettes,
			double depenses, double tresorerie) {
		super(mail, password, null);
		this.recettes = recettes;
		this.depenses = depenses;
		this.tresorerie = tresorerie;
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
