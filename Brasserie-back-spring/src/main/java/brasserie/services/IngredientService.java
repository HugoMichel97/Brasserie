package brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import brasserie.exception.EvenementException;

import brasserie.model.Ingredient;

import brasserie.repositories.IngredientRepository;

public class IngredientService {

	
	@Autowired
	private IngredientRepository ingredientRepository;
	

	public void create(Ingredient i) {
		
		ingredientRepository.save(i);
	}

	public void update(Ingredient i) {
		
		ingredientRepository.save(i);
	}

	public List<Ingredient> getAll() {
		return ingredientRepository.findAll();
	}

	

	

	public void delete(Ingredient i) {

		ingredientRepository.delete(i);
	}

	public Ingredient getById(Integer id) {
        return ingredientRepository.findById(id).orElseThrow(()-> {throw new EvenementException("Numero inconnu");});
    }
	
	public void deleteById(Integer id) {
        ingredientRepository.deleteById(id);
    }
	
}
