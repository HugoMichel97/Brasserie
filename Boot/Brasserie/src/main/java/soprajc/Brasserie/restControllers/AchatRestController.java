package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
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

import soprajc.Brasserie.exception.AchatException;
import soprajc.Brasserie.exception.ReservationException;
import soprajc.Brasserie.model.Achat;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.services.AchatService;
import soprajc.Brasserie.services.ClientService;

@RestController
@RequestMapping("/api/achat")
@CrossOrigin(origins = "*")
public class AchatRestController {

	@Autowired
	AchatService achatService;
	@Autowired
	ClientService clientService;

	@JsonView(JsonViews.Achat.class)
	@GetMapping("")
	public List<Achat> getAll() {
		return achatService.getAll();
	}

	@JsonView(JsonViews.Achat.class)
	@GetMapping("/{id}")
	public Achat getById(@PathVariable Integer id) {
		return achatService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		achatService.deleteById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Produit.class)
	public Achat create(@Valid @RequestBody Achat achat, BindingResult br) {
		if (br.hasErrors()) {
			throw new AchatException();
		}
		return save(achat, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Achat.class)
	public Achat update(@PathVariable Integer id, @Valid @RequestBody Achat achat, BindingResult br) {
		achat.setId_achat(id);
		return save(achat, br);
	}

	private Achat save(Achat achat, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return achatService.save(achat);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Achat.class)
	public Achat partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Achat achat = achatService.getById(id);
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Achat.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, achat, value);
		});
		return achatService.save(achat);
	}

}
