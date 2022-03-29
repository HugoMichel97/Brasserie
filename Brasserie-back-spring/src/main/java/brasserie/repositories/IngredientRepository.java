package brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import brasserie.model.Evenement;
import brasserie.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
