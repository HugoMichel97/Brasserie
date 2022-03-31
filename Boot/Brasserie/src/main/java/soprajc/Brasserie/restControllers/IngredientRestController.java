package soprajc.Brasserie.restControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.Brasserie.exception.IngredientException;
import soprajc.Brasserie.model.Ingredient;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.services.IngredientService;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientRestController {
	
	@Autowired 
   IngredientService ingredientService;
	
	@JsonView(JsonViews.Ingredient.class)
	@GetMapping("")
	public List<Ingredient> getAll() {
		return ingredientService.getAll();
	}

	@JsonView(JsonViews.Ingredient.class)
	@GetMapping("/{id}")
	public Ingredient getById(@PathVariable Integer id) {
		return ingredientService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		ingredientService.deleteById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Ingredient.class)
	public Ingredient create(@Valid @RequestBody Ingredient ingredient, BindingResult br) {
		if (br.hasErrors()) {
			throw new IngredientException();
		}
		return save(ingredient, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Ingredient.class)
	public Ingredient update(@PathVariable Integer id, @Valid @RequestBody Ingredient ingredient, BindingResult br) {
		ingredient.setId_ingredient(id);
		return save(ingredient, br);
	}

	private Ingredient save(Ingredient ingredient, BindingResult br) {
		if (br.hasErrors()) {
			throw new IngredientException();
		}
		return ingredientService.save(ingredient);
	}
	
	
}