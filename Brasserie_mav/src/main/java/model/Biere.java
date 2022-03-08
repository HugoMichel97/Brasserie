package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("biere")

public class Biere extends Produits {
	
	@OneToMany
	private transient List<Double> notes;
	
	@OneToMany
	private transient List<String> commentaires;
	
	@ManyToMany
	private transient List<Snack> suggestions;
	
	@ManyToMany
	private transient List<Ingredients> recette;
	
	public Biere() {}
	
	public Biere(String nom, double prix, String description, int stock, int pts_produit,
			List<Double> notes, List<String> commentaires, List<Snack> suggestions,
			List<Ingredients> recette) {
		super(nom, description, prix, stock, pts_produit);
		this.notes = notes;
		this.commentaires = commentaires;
		this.suggestions = suggestions;
		this.recette = recette;
	}
	
	//Constructeur test
	public Biere(String nom, double prix, List<Double> notes) {
		super(nom, prix);
		this.notes = notes;
	}
	
	// getters-setters
	public List<Double> getNotes() {
		return notes;
	}
	public void setNotes(List<Double> notes) {
		this.notes = notes;
	}

	public List<String> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<String> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Snack> getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(List<Snack> suggestions) {
		this.suggestions = suggestions;
	}

	public List<Ingredients> getRecette() {
		return recette;
	}
	public void setRecette(List<Ingredients> recette) {
		this.recette = recette;
	}

	// toString
	@Override
	public String toString() {
		return "Biere [notes=" + notes + ", commentaires=" + commentaires + ", suggestions=" + suggestions + "]";
	}

	// methods
	@Override
	public List<Produits> filtrer() {
		return null;
	}
}
