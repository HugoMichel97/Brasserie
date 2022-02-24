package model;

public class Ingredients {
	
	private String ingredient;
	private int stock = 0;
	
	// contructors
	public Ingredients(String ingredient, int stock) {
		this.ingredient = ingredient;
		this.stock = stock;
	}
	
	public Ingredients(String ingredient) {
		this.ingredient = ingredient;
	}

	// getters-setters
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	// toString
	@Override
	public String toString() {
		return "Ingredients [ingredient=" + ingredient + ", stock=" + stock + "]";
	}
	
	// methods
	
}
