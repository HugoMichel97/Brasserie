package model;

import java.util.List;

public class Biere extends Produits {
	
	private List<Double> notes;
	private List<String> commentaires;
	private List<Snack> suggestions;
	private List<Ingredients> recette;
	
	// constructors
	public Biere(String nom, double prix, String description, int stock,
			List<Double> notes, List<String> commentaires, List<Snack> suggestions,
			List<Ingredients> recette) {
		super(nom, prix, description, stock);
		this.notes = notes;
		this.commentaires = commentaires;
		this.suggestions = suggestions;
		this.recette = recette;
	}

	public Biere(String nom, double prix, List<Ingredients> recette) {
		super(nom, prix);
		this.recette = recette;
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
