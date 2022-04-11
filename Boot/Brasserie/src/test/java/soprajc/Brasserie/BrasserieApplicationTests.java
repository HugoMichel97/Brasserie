package soprajc.Brasserie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import soprajc.Brasserie.model.Achat;
import soprajc.Brasserie.model.Biere;
import soprajc.Brasserie.model.Brasseur;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Evenement;
import soprajc.Brasserie.model.InfoReglement;
import soprajc.Brasserie.model.Ingredient;
import soprajc.Brasserie.model.Note;
import soprajc.Brasserie.model.Reservation;
import soprajc.Brasserie.model.Snack;
import soprajc.Brasserie.model.StatutCommande;
import soprajc.Brasserie.model.StatutResa;
import soprajc.Brasserie.repositories.BrasseurRepository;
import soprajc.Brasserie.services.AchatService;
import soprajc.Brasserie.services.ClientService;
import soprajc.Brasserie.services.EvenementService;
import soprajc.Brasserie.services.InfoReglementService;
import soprajc.Brasserie.services.IngredientService;
import soprajc.Brasserie.services.NoteService;
import soprajc.Brasserie.services.ProduitService;
import soprajc.Brasserie.services.ReservationService;

@SpringBootTest
class BrasserieApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private BrasseurRepository brasseurRepo;
	@Autowired
	private ClientService clientService;
	@Autowired
	private AchatService achatService;
	@Autowired
	private EvenementService evtService;
	@Autowired
	private InfoReglementService infoRegService;
	@Autowired
	private IngredientService ingredientService;
	@Autowired
	private NoteService noteService;
	@Autowired
	private ProduitService produitService;
	@Autowired
	private ReservationService resaService;
	
	@Test
	//@Disabled
	@Transactional
	@Commit
	void createBDD() {
		// Brasseur
		Brasseur b = new Brasseur("arthur@aminagomo.fr", passwordEncoder.encode("brasseur"));
		b.setTresorerie(1000);
		b.setDepenses(150);
		b.setRecettes(200);
		brasseurRepo.save(b);
		
		// Evt
		Evenement evt1 = new Evenement(LocalDate.now(), LocalTime.now(), "Inauguration", 2.0, 0,
				"Inauguration de la merveilleuse brasserie Aminagomo");
		evt1.setNbPlaces(3);
		Evenement evt2 = new Evenement(LocalDate.of(2022, 5, 1), LocalTime.of(18, 0), "Degustation", 30.0, 10,
				"Degustation de bières de la brasserie acompagnées de fromages locaux");
		evt2.setNbPlaces(4);
		evtService.create(evt1);
		evtService.create(evt2);
		
		// Ingrédients
		Ingredient i1 = new Ingredient("Malt d'orge bio", 100);
		Ingredient i2 = new Ingredient("Blé cru bio", 100);
		Ingredient i3 = new Ingredient("Purée de fruits rouge bios", 100);
		ingredientService.create(i1);
		ingredientService.create(i2);
		ingredientService.create(i3);
		List<Ingredient> iList = new ArrayList();
		Collections.addAll(iList, i1, i2, i3);
		
		
		// Produits
		Snack snack = new Snack("Moelleux au citron", "Bouchée acidulée et fondante", 4.5, 15);
		produitService.create(snack);
		List<Snack> sList = new ArrayList();
		sList.add(snack);
		
		Biere biere = new Biere("Mirador", "Bière aux fruits rouge", 9.0, 500, 10);
		biere.setRecette(iList);
		biere.setSuggestions(sList);
		produitService.create(biere);
		
		List<Biere> bList = new ArrayList();
		bList.add(biere);
		i1.setBiere(bList);
		i2.setBiere(bList);
		i3.setBiere(bList);
		ingredientService.update(i1);
		ingredientService.update(i2);
		ingredientService.update(i3);
		
		// Clients
		Client c1 = new Client("hugo@michel", passwordEncoder.encode("hugo"), "Michel", "Hugo", null,
				LocalDate.of(1997, 1, 1));
		c1.setFidelite(10);
		Reservation r2 = new Reservation(c1, evt2);
		r2.setStatut(StatutResa.validee);
		List<Reservation> rListc1 = new ArrayList<Reservation>();
		rListc1.add(r2);
		c1.setReservations(rListc1);
		Achat a5 = new Achat(c1, biere, 3);
		List<Achat> aListc1 = new ArrayList<Achat>();
		aListc1.add(a5);
		c1.setAchats(aListc1);
		Note n1 = new Note(c1, biere, 3.0);
		clientService.create(c1);
		noteService.create(n1);
		resaService.create(r2);
		achatService.create(a5);
		
		Client c2 = new Client("amine@berrada", passwordEncoder.encode("amine"), "Berrada", "Amine", "0643675489",
				LocalDate.of(1997, 1, 1));
		c2.setFidelite(5000);
		Reservation r1 = new Reservation(c2, evt1);
		Reservation r6 = new Reservation(c2, evt2);
		r6.setStatut(StatutResa.validee);
		List<Reservation> rListc2 = new ArrayList<Reservation>();
		Collections.addAll(rListc2, r1, r6);
		c2.setReservations(rListc2);
		Achat a2 = new Achat(c2, snack, 10);
		Achat a3 = new Achat(c2, biere, 5);
		List<Achat> aListc2 = new ArrayList<Achat>();
		Collections.addAll(aListc2, a2, a3);
		c2.setAchats(aListc2);
		Note n2 = new Note(c2, biere, 5.0, "Très bonne bière");
		clientService.create(c2);
		noteService.create(n2);
		resaService.create(r1);
		resaService.create(r6);
		achatService.create(a2);
		achatService.create(a3);
		
		Client c3 = new Client("mohamed@khamassi", passwordEncoder.encode("mohamed"), "Khamassi", "Mohamed", "0642424242",
				LocalDate.of(1997, 1, 1));
		c3.setFidelite(50);
		InfoReglement ir1 = new InfoReglement(c3, "4242424242424242", "Khamassi", "03/23");
		List<InfoReglement> irList = new ArrayList<InfoReglement>();
		irList.add(ir1);
		c3.setReglements(irList);
		Reservation r3 = new Reservation(c3, evt2);
		r3.setStatut(StatutResa.validee);
		List<Reservation> rListc3 = new ArrayList<Reservation>();
		rListc3.add(r3);
		c3.setReservations(rListc3);
		Achat a1 = new Achat(c3, snack, 2);
		List<Achat> aListc3 = new ArrayList<Achat>();
		aListc3.add(a1);
		c3.setAchats(aListc3);
		c3.setStatut(StatutCommande.en_attente);
		clientService.create(c3);
		resaService.create(r3);
		infoRegService.create(ir1);
		achatService.create(a1);
		
		Client c4 = new Client("anais@lharidon", passwordEncoder.encode("anais"), "L'Haridon", "Anaïs", "0687945632",
				LocalDate.of(1997, 5, 1));
		c4.setFidelite(10);
		InfoReglement ir2 = new InfoReglement(c4, "anais@lharidon");
		List<InfoReglement> irListc4 = new ArrayList<InfoReglement>();
		irListc4.add(ir2);
		c4.setReglements(irListc4);
		Reservation r4 = new Reservation(c4, evt2);
		Reservation r5 = new Reservation(c4, evt1, 2);
		r4.setStatut(StatutResa.validee);
		List<Reservation> rListc4 = new ArrayList<Reservation>();
		Collections.addAll(rListc4, r4, r5);
		c4.setReservations(rListc4);
		Achat a4 = new Achat(c4, biere, 2);
		List<Achat> aListc4 = new ArrayList<Achat>();
		aListc4.add(a4);
		c4.setAchats(aListc4);
		c4.setStatut(StatutCommande.prete);
		clientService.create(c4);
		resaService.create(r4);
		resaService.create(r5);
		infoRegService.create(ir2);
		achatService.create(a4);
		
		List<Reservation> rListevt1 = new ArrayList<Reservation>();
		Collections.addAll(rListevt1, r1, r5);
		evt1.setReservations(rListevt1);
		List<Reservation> rListevt2 = new ArrayList<Reservation>();
		Collections.addAll(rListevt2, r2, r3, r4, r6);
		evt2.setReservations(rListevt2);
		evtService.update(evt1);
		evtService.update(evt2);
		
		List<Note> nList = new ArrayList<Note>();
		Collections.addAll(nList, n1, n2);
		biere.setNotes(nList);
		produitService.update(biere);
	}

}
