package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import soprajc.Brasserie.exception.InfoReglementException;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.InfoReglement;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.model.Reglement;
import soprajc.Brasserie.model.StatutCommande;
import soprajc.Brasserie.services.InfoReglementService;


@RestController
@RequestMapping("/api/infoReglement")
@CrossOrigin(origins = "*")
public class InfoReglementRestController {
	@Autowired 
	InfoReglementService infoReglementService;

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

	@PatchMapping("/{id}")
	@JsonView(JsonViews.InfoReglement.class)
	public InfoReglement partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		InfoReglement infoReg = infoReglementService.getById(id);
		fields.forEach((key, value) -> {
			if (key.equals("mode")){
				infoReg.setMode(Reglement.valueOf((String) value));
			} else {
				Field field = ReflectionUtils.findField(InfoReglement.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, infoReg, value);
			}
		});
		return infoReglementService.save(infoReg);
	}
}
