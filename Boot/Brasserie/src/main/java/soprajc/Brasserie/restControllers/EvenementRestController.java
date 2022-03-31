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

import soprajc.Brasserie.exception.EvenementException;
import soprajc.Brasserie.model.Evenement;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.services.EvenementService;

@RestController
@RequestMapping("/api/evenement")
public class EvenementRestController {
	
	@Autowired 
	EvenementService evenementService;
	
	@JsonView(JsonViews.Evenement.class)
	@GetMapping("")
	public List<Evenement> getAll() {
		return evenementService.getAll();
	}

	@JsonView(JsonViews.Evenement.class)
	@GetMapping("/{id}")
	public Evenement getById(@PathVariable Integer id) {
		return evenementService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		evenementService.deleteById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Evenement.class)
	public Evenement create(@Valid @RequestBody Evenement evenement, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return save(evenement, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Evenement.class)
	public Evenement update(@PathVariable Integer id, @Valid @RequestBody Evenement evenement, BindingResult br) {
		evenement.setId(id);
		return save(evenement, br);
	}

	private Evenement save(Evenement evenement, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return evenementService.save(evenement);
	}
	
	
}
