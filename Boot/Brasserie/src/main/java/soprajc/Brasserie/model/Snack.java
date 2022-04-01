package soprajc.Brasserie.model;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("Snack")

public class Snack extends Produit{

	@ManyToMany(mappedBy= "suggestions")
	private List<Biere> bieres;
	
	
	public Snack() {}
	
	public Snack(String nom, String description, double prix,  int stock) {
		super(nom, description, prix, stock);
	}
	
	public Snack(Integer id, String nom, String description, double prix,  int stock) {
		super(id, nom, description, prix, stock);
	}
	
	
	public Snack(String nom, String description, double prix,  int stock, List<Biere> bieres) {
		super(nom, description, prix, stock);
		this.bieres = bieres;
	}
	
	
	//Constructeur test
	public Snack(String nom, double prix) {
		super(nom, prix);
	}
	

	public List<Biere> getBieres() {
		return bieres;
	}

	public void setBieres(List<Biere> bieres) {
		this.bieres = bieres;
	}

		
	public List<Snack> suggestion(Biere biere){
		return null;
	}
}
