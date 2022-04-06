package soprajc.Brasserie.restControllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import soprajc.Brasserie.exception.ClientException;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.services.AchatService;
import soprajc.Brasserie.services.ClientService;
import soprajc.Brasserie.services.InfoReglementService;
import soprajc.Brasserie.services.ReservationService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired 
	ClientService clientService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Client> getAll() {
		return clientService.getAll();
	}

	@JsonView(JsonViews.ClientWithReservation.class)
	@GetMapping("/getResa")
	public List<Client> getAllWithResa(){
		return clientService.getAllWithResa();
	}

	@JsonView(JsonViews.ClientWithAchat.class)
	@GetMapping("/getAchat")
	public List<Client> getAllWithAchat(){
		return clientService.getAllWithAchat();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Client getById(@PathVariable Integer id) {
		return clientService.getById(id);
	}

	@JsonView(JsonViews.ClientWithReservation.class)
	@GetMapping("/{id}/getResa")
	public Client getByIdWithResa(@PathVariable Integer id) {
		return clientService.getByIdWithReservation(id);
	}

	@JsonView(JsonViews.ClientWithAchat.class)
	@GetMapping("/{id}/getAchat")
	public Client getByIdWithAchat(@PathVariable Integer id) {
		return clientService.getByIdWithAchat(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clientService.deleteById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		return save(client, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Client update(@PathVariable Integer id, @Valid @RequestBody Client client, BindingResult br) {
		client.setId(id);
		return save(client, br);
	}

	private Client save(Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		return clientService.save(client);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Client partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Client client = clientService.getById(id);
		fields.forEach((key, value) -> {
			if(key.equals("password")) {
				client.setPassword(passwordEncoder.encode((String) value));
			} else if (key.equals("naissance")) {
				List<Integer> dateRecup = (List<Integer>) value;
				client.setNaissance(LocalDate.of(dateRecup.get(0), dateRecup.get(1), dateRecup.get(2)));
			} else {
				Field field = ReflectionUtils.findField(Client.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, client, value);
			} // pour les modif des listes achats, reglements et reservations on passera par les restController concernés
		});
		return clientService.save(client);
	}

}
