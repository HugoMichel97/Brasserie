package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
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
public class BrasseurRestController {
	
	@Autowired
	private BrasseurService brasseurService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
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
	@JsonView(JsonViews.Common.class)
	public Brasseur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Brasseur brasseur = brasseurService.getById(id);
		fields.forEach((key, value) -> {
			if(key.equals("password")) {
				brasseur.setPassword(passwordEncoder.encode((String) value));
			} else {
				Field field = ReflectionUtils.findField(Brasseur.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, brasseur, value);
			}
		});
		return brasseurService.save(brasseur);
	}

}
