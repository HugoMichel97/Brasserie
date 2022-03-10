package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("biere")

public class Biere extends Produits {
	
	@OneToMany(mappedBy = "biere")
	private List<Note> notes;
	
	@OneToMany(mappedBy = "biere")
	private List<Commentaire> commentaires;
	
	@ManyToMany
	@JoinTable(name = "suggestions", joinColumns = @JoinColumn(name="id_biere"), inverseJoinColumns = @JoinColumn(name="id_snack"))
	private List<Snack> suggestions;
	
	@ManyToMany
	@JoinTable(name = "recettes", joinColumns = @JoinColumn(name="id_biere"), inverseJoinColumns = @JoinColumn(name="id_ingredient"))
	private List<Ingredient> recette;
	
	
	public Biere() {}
	
	public Biere(String nom, double prix, String description, int stock, int pts_produit,
			List<Note> notes, List<Commentaire> commentaires, List<Snack> suggestions,
			List<Ingredient> recette) {
		super(nom, description, prix, stock, pts_produit);
		this.notes = notes;
		this.commentaires = commentaires;
		this.suggestions = suggestions;
		this.recette = recette;
	}
	
	//Constructeur test
	public Biere(String nom, double prix) {
		super(nom, prix);
		
	}
	
	public Biere(String nom, String description, double prix,  int stock, Integer pts_produit)
	{
		super(nom, description, prix, stock, pts_produit);
	}
	
	// getters-setters
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Snack> getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(List<Snack> suggestions) {
		this.suggestions = suggestions;
	}

	public List<Ingredient> getRecette() {
		return recette;
	}
	public void setRecette(List<Ingredient> recette) {
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