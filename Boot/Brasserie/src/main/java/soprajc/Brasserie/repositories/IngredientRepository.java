package soprajc.Brasserie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	@Query("select i from Ingredient i left join fetch i.bieres where i.id_ingredient=:id")
	Optional<Ingredient> findByIdWithBiere(@Param("id") Integer id);
}
