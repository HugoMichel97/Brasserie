package model;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("snack")

public class Snack extends Produits{

	
	public Snack() {}
	
	public Snack(String nom, String description, double prix,  int stock) {
		super(nom, description, prix, stock);
	}
	
	//Constructeur test
	public Snack(String nom, double prix) {
		super(nom, prix);
	}
	
	
	@Override
	public List<Produits> filtrer() {
		return null;
	}
	
	public List<Snack> suggestion(Biere biere){
		return null;
	}
}
