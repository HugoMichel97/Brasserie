package model;

import java.util.List;

public class Snack extends Produits{

	// constructors
	public Snack(String nom, double prix, String description, int stock) {
		super(nom, prix, description, stock);
	}
	
	public Snack(String nom, double prix) {
		super(nom, prix);
	}
	
	// methods
	@Override
	public List<Produits> filtrer() {
		return null;
	}
	
	public List<Snack> suggestion(Biere biere){
		return null;
	}
}
