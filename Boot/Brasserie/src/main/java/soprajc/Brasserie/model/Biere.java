package soprajc.Brasserie.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Biere")
public class Biere extends Produit {

	@OneToMany(mappedBy = "biere")
	private List<Note> notes;

	@JsonView(JsonViews.Produit.class) // à tester !!
	@ManyToMany
	@JoinTable(
			name = "suggestions",
			joinColumns = @JoinColumn(name="id_biere", foreignKey = @ForeignKey(name="suggestions_biere_fk")),
			inverseJoinColumns = @JoinColumn(name="id_snack", foreignKey = @ForeignKey(name="suggestions_snack_fk")))
	private List<Snack> suggestions;

	@JsonView(JsonViews.Produit.class) // à tester !!
	@ManyToMany
	@JoinTable(
			name = "recettes",
			joinColumns = @JoinColumn(name="id_biere", foreignKey = @ForeignKey(name="recettes_biere_fk")),
			inverseJoinColumns = @JoinColumn(name="id_ingredient", foreignKey = @ForeignKey(name="recettes_ingredient_fk")))
	private List<Ingredient> recette;


	public Biere() {}

	public Biere(String nom, double prix, String description, int stock, Integer points,
			List<Note> notes, List<Snack> suggestions,
			List<Ingredient> recette) {
		super(nom, description, prix, stock, points);
		this.notes = notes;
		this.suggestions = suggestions;
		this.recette = recette;
	}

	public Biere(String nom, String description, double prix, int stock) {
		super(nom, description, prix, stock);
	}

	//Constructeur test
	public Biere(String nom, double prix) {
		super(nom, prix);

	}

	public Biere(String nom, String description, double prix,  int stock, Integer points)
	{
		super(nom, description, prix, stock, points);
	}

	public Biere(Integer id, String nom, String description, double prix,  int stock, Integer points)
	{
		super(id, nom, description, prix, stock, points);
	}

	public Biere(Integer id, String nom, String description, double prix,  int stock)
	{
		super(id, nom, description, prix, stock);
	}

	// getters-setters
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
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
}
