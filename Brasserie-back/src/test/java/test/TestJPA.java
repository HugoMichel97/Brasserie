package test;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import model.Achat;
import model.Biere;
import model.Brasseur;
import model.Client;
import model.Commentaire;
import model.Evenement;
import model.InfoReglement;
import model.Ingredient;
import model.Note;
import model.Reservation;
import model.Snack;

public class TestJPA {

	public static void main(String[] args) {
		
		Biere b1 = new Biere("Biere du test ", 3.5);
		
		// Test gestion notes
		List<Note> notes = new ArrayList();
		Note n1 = new Note(b1, 8.0);
		Note n2 = new Note(b1, 4.5);
		
		Collections.addAll(notes, n1, n2);
		
		b1.setNotes(notes);
		
		// Test gestion ingrédients
		Ingredient i1 = new Ingredient("Houblon", 50);
		Ingredient i2 = new Ingredient("Levure", 3);
		
		List<Ingredient> recette1 = new ArrayList();
		Collections.addAll(recette1, i1, i2);
		b1.setRecette(recette1);
		
		// Test snack
		Snack s1 = new Snack("Snack du test", 2.0);
		Snack s2 = new Snack("Moelleux au citron", 6.0);
		
		List<Snack> sugg1 = new ArrayList();
		Collections.addAll(sugg1, s1, s2);
		b1.setSuggestions(sugg1);
		
		// Test commentaires 
		Commentaire c1 = new Commentaire(b1, "Superbe biere");
		Commentaire c2 = new Commentaire(b1, "Atroce" );
		
		List<Commentaire> coms = new ArrayList();
		Collections.addAll(coms, c1, c2);
		b1.setCommentaires(coms);
 		
		Brasseur ptitBrasseur = new Brasseur("Arthur@test", "brasseur");
		ptitBrasseur.setDepenses(5);
		ptitBrasseur.setRecettes(15);
		ptitBrasseur.setTresorerie(10);
		
		Client client1 = new Client("Jonh.Doe@client", "client1");
		client1.setTel("0654205987");
		client1.setFidelite(5);
		
		Evenement evt1 = new Evenement(LocalDate.now(), LocalTime.now(), "test", 13.8, 0, null, ptitBrasseur, null);
		Reservation resa = new Reservation(client1, evt1);
		List<Reservation> resaList = new ArrayList<Reservation>();
		resaList.add(resa);
		client1.setReservations(resaList);
		
		Client client2 = new Client("Hugo@Michel", "client2");
		client2.setFidelite(20);
		Achat a1 = new Achat(client2, s2, 1);
		Achat a2 = new Achat(client2, b1, 2);
		List<Achat> panier = new ArrayList<Achat>();
		Collections.addAll(panier, a1, a2);
		client2.setAchats(panier);
		
		InfoReglement ir1 = new InfoReglement(client2, "123", "Hugo", "06/24");
		List<InfoReglement> regList = new ArrayList<InfoReglement>();
		regList.add(ir1);
		client2.setReglements(regList);
		
		Reservation resa2 = new Reservation(client2, evt1);
		List<Reservation> resaList2 = new ArrayList<Reservation>();
		resaList2.add(resa);
		client2.setReservations(resaList2);
		
		Collections.addAll(resaList, resa2);
		evt1.setReservations(resaList);
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("brasserie");
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(n1);
		em.persist(n2);
		
		em.persist(i1);
		em.persist(i2);
		
		em.persist(s1);
		em.persist(s2);
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(b1);
		
		em.persist(a1);
		em.persist(a2);
		
		em.persist(ptitBrasseur);
		
		em.persist(client1);
		em.persist(client2);
		
		em.persist(evt1);
		
		em.persist(ir1);
		
		em.persist(resa);
		em.persist(resa2);
		
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
