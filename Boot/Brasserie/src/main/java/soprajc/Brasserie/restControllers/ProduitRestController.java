package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.Brasserie.exception.ProduitException;
import soprajc.Brasserie.model.Biere;
import soprajc.Brasserie.model.Ingredient;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.model.Produit;
import soprajc.Brasserie.model.Snack;
import soprajc.Brasserie.services.IngredientService;
import soprajc.Brasserie.services.ProduitService;



@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	ProduitService produitService;
	@Autowired
	IngredientService ingredientService;
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("")
	public List<Produit> getAll() {
		return produitService.getAll();
	}
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("/biere")
	public List<Biere> getAllBeers() {
		return produitService.getAllBeers();
	}
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("/snack")
	public List<Snack> getAllSnacks() {
		return produitService.getAllSnacks();
	}
	
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("/{id}")
	public Produit getById(@PathVariable Integer id) {
		return produitService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		produitService.deleteById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Produit.class)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		return save(produit, br);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Produit.class)
	public Produit update(@PathVariable Integer id, @Valid @RequestBody Produit produit, BindingResult br) {
		produit.setId(id);
		return save(produit, br);
	}
	
	private Produit save(Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProduitException();
		}
		return produitService.save(produit);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Produit.class)
	public Produit partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Produit produit = produitService.getById(id);
		fields.forEach((key, value) -> {
			if(key.equals("points")) {
				if(produit instanceof Biere) {
					produit.setPoints((Integer) value);
				} else {
					throw new ProduitException("Les snacks ne donnent pas de points de fidélité.");
				}
			} else {
				Field field = ReflectionUtils.findField(Produit.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, produit, value);
			}
		});
		return produitService.save(produit);
	}
}
