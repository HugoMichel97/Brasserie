package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.Brasserie.exception.BrasseurException;
import soprajc.Brasserie.model.Brasseur;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.services.BrasseurService;

@RestController
@RequestMapping("/api/brasseur")
@CrossOrigin(origins = "*")
public class BrasseurRestController {

	@Autowired
	BrasseurService brasseurService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@JsonView(JsonViews.Compte.class)
	@GetMapping("/{id}")
	public Brasseur getById(@PathVariable Integer id) {
		return brasseurService.getById(id);
	}
	
	@JsonView(JsonViews.Compte.class)
	@GetMapping("/mail/{mail}")
	public Brasseur getByMail(@PathVariable String mail) {
		return brasseurService.getByMail(mail);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Compte.class)
	public Brasseur update(@PathVariable Integer id, @Valid @RequestBody Brasseur brasseur, BindingResult br) {
		brasseur.setId(id);
		return save(brasseur, br);
	}

	private Brasseur save(Brasseur brasseur, BindingResult br) {
		if (br.hasErrors()) {
			throw new BrasseurException();
		}
		return brasseurService.save(brasseur);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Compte.class)
	public Brasseur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Brasseur brasseur = brasseurService.getById(id);
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Brasseur.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, brasseur, value);
		});
		return brasseurService.save(brasseur);
	}

}
