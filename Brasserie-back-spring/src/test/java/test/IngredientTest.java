package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import brasserie.config.SpringConfig;
import brasserie.model.Ingredient;
import brasserie.model.Ingredient;
import brasserie.services.IngredientService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class IngredientTest {

	@Autowired
	IngredientService ingredientService;
	
	@Test
	@Transactional
	@Commit
	void creationIngredientTest() {
		Ingredient i=new Ingredient ("Cerise", 1005);
		
		
	ingredientService.create(i);
			
	}
	
	@Test
	void deleteIngredientTest() {
		
		ingredientService.deleteById(4);
	}
	
	@Test
	void updateIngredientTest() {
        Ingredient i = ingredientService.getById(8);
        i.setNom("nouveau libelle");
        ingredientService.update(i);
    }
	
	@Test
	void getByIdIngredientTest()
	{
		ingredientService.getById(6);
	}
	
	@Test
	void getAllIngredientTest()
	{
		ingredientService.getAll();
	}

}
