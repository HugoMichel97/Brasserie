package brasserieFront.restcontrollers;

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

import brasserie.exception.InfoReglementException;
import brasserie.model.InfoReglement;
import brasserie.model.JsonViews;
import brasserie.services.InfoReglementService;


@RestController
@RequestMapping("/api/infoReglement")
public class InfoReglementRestController {
	@Autowired 
	InfoReglementService infoReglementService;

	@JsonView(JsonViews.InfoReglement.class)
	@GetMapping("")
	public List<InfoReglement> getAll() {
		return infoReglementService.getAll();
	}

	@JsonView(JsonViews.InfoReglement.class)
	@GetMapping("/{id}")
	public InfoReglement getById(@PathVariable Integer id) {
		return infoReglementService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		infoReglementService.deleteById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.InfoReglement.class)
	public InfoReglement create(@Valid @RequestBody InfoReglement infoReglement, BindingResult br) {
		if (br.hasErrors()) {
			throw new InfoReglementException();
		}
		return save(infoReglement, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.InfoReglement.class)
	public InfoReglement update(@PathVariable Integer id, @Valid @RequestBody InfoReglement infoReglement, BindingResult br) {
		infoReglement.setId(id);
		return save(infoReglement, br);
	}

	private InfoReglement save(InfoReglement infoReglement, BindingResult br) {
		if (br.hasErrors()) {
			throw new InfoReglementException();
		}
		return infoReglementService.save(infoReglement);
	}
}
