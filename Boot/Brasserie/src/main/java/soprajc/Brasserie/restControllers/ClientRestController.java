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

import soprajc.Brasserie.exception.ClientException;
import soprajc.Brasserie.model.Achat;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.InfoReglement;
import soprajc.Brasserie.model.JsonViews;
import soprajc.Brasserie.model.Reservation;
import soprajc.Brasserie.model.StatutCommande;
import soprajc.Brasserie.services.AchatService;
import soprajc.Brasserie.services.ClientService;
import soprajc.Brasserie.services.InfoReglementService;
import soprajc.Brasserie.services.ReservationService;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientRestController {

	@Autowired 
	ClientService clientService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	AchatService achatService;
	@Autowired
	InfoReglementService infoRegService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@JsonView(JsonViews.Client.class)
	@GetMapping("")
	public List<Client> getAll() {
		return clientService.getAll();
	}

	@JsonView(JsonViews.Client.class)
	@GetMapping("/{id}")
	public Client getById(@PathVariable Integer id) {
		return clientService.getById(id);
	}
	
	@JsonView(JsonViews.Compte.class)
	@GetMapping("/mail/{mail}")
	public Client getByMail(@PathVariable String mail) {
		return clientService.getByMail(mail);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/getInfoReg/{id}")
	public List<InfoReglement> getInfoReg(@PathVariable Integer id){
		return infoRegService.getByClient(clientService.getById(id));
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}/getAchat")
	public List<Achat> getAchats(@PathVariable Integer id){
		return achatService.getByClient(clientService.getById(id));
	}
	
	@JsonView(JsonViews.ReservationEvt.class)
	@GetMapping("/{id}/getResa")
	public List<Reservation> getResa(@PathVariable Integer id){
		return reservationService.getByClient(clientService.getById(id));
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clientService.deleteById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Client.class)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException(""+br.getAllErrors()+"");
		}
		return clientService.create(client);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Client.class)
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
	@JsonView(JsonViews.Client.class)
	public Client partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Client client = clientService.getById(id);
		fields.forEach((key, value) -> {
			if (key.equals("naissance")) {
				client.setNaissance(LocalDate.parse((String) value));
			} else if (key.equals("statut")){
				client.setStatut(StatutCommande.valueOf((String) value));
			}else if (key.equals("password")) {
				client.setPassword(passwordEncoder.encode((String) value));
			} else {
				Field field = ReflectionUtils.findField(Client.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, client, value);
			} // pour les modif des listes achats, reglements et reservations on passera par les restController concern??s
		});
		return clientService.save(client);
	}

}
